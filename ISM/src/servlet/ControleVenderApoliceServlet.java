package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ControleVenderApoliceServlet
 */
@WebServlet("/ControleVenderApoliceServlet")
public class ControleVenderApoliceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControleVenderApoliceServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		
		if(op == null){
			return;
		}
		else if (op.equals("venda")){
			inicioVenda(request, response);
		}
		else if(op.equals("veiculo")){
			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/solicitarVeiculo.jsp");
			requestDispatcher.forward(request, response);
		}
		else if(op.equals("apolice")){
			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/solicitarCondicaoApolice.jsp");
			requestDispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	protected void inicioVenda(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		
		//setting session to expiry in 30 mins
		session.setMaxInactiveInterval(30*60);
		
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/solicitarCliente.jsp");
		requestDispatcher.forward(request, response);
	}

}
