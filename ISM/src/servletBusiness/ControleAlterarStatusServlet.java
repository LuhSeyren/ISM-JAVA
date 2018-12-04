package servletBusiness;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ApoliceDAO;

/**
 * Servlet implementation class ControleAlterarStatusServlet
 */
@WebServlet("/ControleAlterarStatusServlet")
public class ControleAlterarStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void mostrarStatusApolice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ApoliceDAO apoliceDao = 
	
	}

}
