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
import DAO.VeiculoDAO;
import ISM.Cliente;
import ISM.Veiculo;


/**
 * Servlet implementation class VeiculoServlet
 */
@WebServlet("/VeiculoServlet")
public class VeiculoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VeiculoServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return;
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] informacoes = new String[5];
		
		
		informacoes[0] = request.getParameter("renavam");
		informacoes[1] = request.getParameter("placa");
		informacoes[2] = request.getParameter("modelo");
		informacoes[3] = request.getParameter("ano");
		informacoes[4] = request.getParameter("cor");
		
		VeiculoDAO veiculoDAO = new VeiculoDAO();
		
		//busca veiculo no BD
		Veiculo veiculo = veiculoDAO.buscarVeiculo(Integer.valueOf(informacoes[0]));
		
		if(veiculo==null){
			veiculo = veiculoDAO.registrarVeiculo(informacoes);
		}
		
		//Salvar Veiculo na sessao
		HttpSession session = request.getSession();
		session.setAttribute("veiculo", veiculo);
		
		
		request.setAttribute("veiculo", veiculo);
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/DetalheVeiculo.jsp");
		requestDispatcher.forward(request, response);
	}

}
