package servletBusiness;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ApoliceDAO;
import ISM.Apolice;

/**
 * Servlet implementation class ControleAlterarStatusServlet
 */
@WebServlet("/ControleAlterarStatusServlet")
public class ControleAlterarStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int OK = 1;
	private int ERROR = 0;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControleAlterarStatusServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		
		if(op == null){
			return;
		}
		else if(op.equals("status")){
			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/telaAlterarStatus/solicitarNumeroApolice.jsp");
			requestDispatcher.forward(request, response);
		}
		else if(op.equals("numeroApolice")){
			mostrarStatusApolice(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//novo status enviado
		String status  = request.getParameter("status");
		
		HttpSession session = request.getSession();
		Apolice apolice = (Apolice) session.getAttribute("apolice");
		
		if(verificarConsistenciaStatus(apolice, status) == false){
			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/telaAlterarStatus/statusInconsistente.jsp");
			requestDispatcher.forward(request, response);
			return;
		}
		
		
		apolice.setStatus(status);
		ApoliceDAO apoliceDAO = new ApoliceDAO();
		
		apoliceDAO.alterarStatusApolice(apolice, status);
		
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/telaAlterarStatus/alteracaoSucesso.jsp");
		requestDispatcher.forward(request, response);
	}
	
	protected void mostrarStatusApolice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ApoliceDAO apoliceDAO = new ApoliceDAO();
		
		int numeroApolice = Integer.valueOf(request.getParameter("numeroApolice"));
		
		Apolice apolice = apoliceDAO.buscarApolice(numeroApolice);
		
		if (apolice == null){
			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/telaAlterarStatus/apoliceNaoEncontrada.jsp");
			requestDispatcher.forward(request, response);
		}
		
		HttpSession session = request.getSession();
		//setting session to expiry in 30 mins
		session.setMaxInactiveInterval(30*60);
		
		session.setAttribute("apolice", apolice);
		
		request.setAttribute("apolice", apolice);
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/telaAlterarStatus/mostrarStatusApolice.jsp");
		requestDispatcher.forward(request, response);
		
	
	}
	
	private boolean verificarConsistenciaStatus(Apolice apolice, String status){
		if(status.equals("Ativo")){
			Calendar cal = Calendar.getInstance();
			Date today = cal.getTime();
			
			Date vigencia = apolice.getVigencia();
			
			if(today.after(vigencia))
				return false;
			else
				return true;
		}if(status.equals("Vencido")){
			Calendar cal = Calendar.getInstance();
			Date today = cal.getTime();
			
			Date vigencia = apolice.getVigencia();
			
			if(today.before(vigencia))
				return false;
			else
				return true;
		}
		if(status.equals("Pendente") | status.equals("Inativo") | status.equals("Cancelado") ){
			return true;
		}else
			return false;
	}

}
