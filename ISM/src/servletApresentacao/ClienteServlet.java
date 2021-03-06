package servletApresentacao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ClienteDAO;
import ISM.Cliente;

/**
 * Servlet implementation class ClienteServlet
 */
@WebServlet("/ClienteServlet")
public class ClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClienteServlet() {
        super();
      
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    //buscar Cliente
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cpf = request.getParameter("cpf");
		
		if(cpf == null) {
			return;
		}
		else {
			ClienteDAO clienteDAO = new ClienteDAO();
			Cliente cliente = clienteDAO.buscarCliente(cpf);
				
			if(cliente != null){
				//Salvar Cliente na Sess�o
				HttpSession session = request.getSession();
				session.setAttribute("cliente", cliente);
				
				
				
				request.setAttribute("cliente", cliente);
				RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/telaVenderApolice/mostrarCliente.jsp");
				requestDispatcher.forward(request, response);
			}
			else {
				RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/telaVenderApolice/solicitarDadosCliente.jsp");
				requestDispatcher.forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] informacoes = new String[4];
		
		
		informacoes[0] = request.getParameter("cpf");
		informacoes[1] = request.getParameter("nome");
		informacoes[2] = request.getParameter("sexo");
		informacoes[3] = request.getParameter("perfilDeUso");
		
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.registrarCliente(informacoes);
		
		
		//Salvar Cliente na Sess�o
		HttpSession session = request.getSession();
		session.setAttribute("cliente", cliente);
		
		
		
		request.setAttribute("cliente", cliente);
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/telaVenderApolice/mostrarCliente.jsp");
		requestDispatcher.forward(request, response);
		
		
	}

}
