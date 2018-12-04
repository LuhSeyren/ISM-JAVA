package servletBusiness;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ApoliceDAO;
import ISM.Apolice;

/**
 * Servlet implementation class ControleGerarRelatorioServlet
 */
@WebServlet("/ControleGerarRelatorioServlet")
public class ControleGerarRelatorioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int OK = 1;
	private int ERROR = 0;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControleGerarRelatorioServlet() {
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
		else if(op.equals("relatorio")){
			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/telaGerarRelatorio/solicitarPeriodo.jsp");
			requestDispatcher.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String data_inicial  = request.getParameter("data_inicial");
		String data_final  = request.getParameter("data_final");
		
		//print, para debug
		System.out.println(data_inicial);
		System.out.println(data_final);
		
		int consistencia = verificarConsistenciaPeriodo( data_inicial, data_final);
		if(consistencia == ERROR){
			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/telaGerarRelatorio/periodoInvalido.jsp");
			requestDispatcher.forward(request, response);
		}
		
		ApoliceDAO apoliceDAO = new ApoliceDAO();
		ArrayList<Apolice> apoliceList =  apoliceDAO.buscarPorData(data_inicial, data_final);
		
		System.out.println(apoliceList.size());
		if(apoliceList.size()==0){
			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/telaGerarRelatorio/apoliceNaoEncontrada.jsp");
			requestDispatcher.forward(request, response);
		}
		
		request.setAttribute("apoliceList", apoliceList);
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/telaGerarRelatorio/mostrarRelatorio.jsp");
		requestDispatcher.forward(request, response);
		
	}
	
	protected int verificarConsistenciaPeriodo(String data_inicial, String data_final){
		
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		Date inicio, fim;
		
		try {
			inicio = formato.parse(data_inicial);
			fim = formato.parse(data_final);
		} catch (ParseException e) {
			e.printStackTrace();
			return ERROR;
		}
		
		if(inicio.after(fim))
			return ERROR;
		else
			return OK;
	}

}
