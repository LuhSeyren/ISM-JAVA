package ISM;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VeiculoController
 */
@WebServlet("/VeiculoController")
public class VeiculoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Veiculo> listaVeiculo;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VeiculoController() {
        super();
        try {
        	VeiculoDAO veiculoDAO = new VeiculoDAO();
        	this.listaVeiculo = veiculoDAO.listarTodos();
        	ApoliceDAO apoliceDAO = new ApoliceDAO();
        }
        catch (SQLException e){
			e.printStackTrace();
		}
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String renavam = request.getParameter("renavam");
		int array_position = -1;
		
		if(renavam == null) {
			request.setAttribute("lista", listaVeiculo);
			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/ListaVeiculo.jsp");
			requestDispatcher.forward(request, response);
		}
		else {
			int renavam_int = Integer.parseInt(renavam);
			
			for(int i = 0; i < listaVeiculo.size(); i++) {
				if (listaVeiculo.get(i).getRenavam() == renavam_int) {
					array_position = i;
					break;
				};
			}
			if (array_position != -1) {
				Veiculo veiculo = listaVeiculo.get(array_position);
				request.setAttribute("veiculo", veiculo);
				
				RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/DetalheVeiculo.jsp");
				requestDispatcher.forward(request, response);
			}
			else {
				response.getWriter().append("ID Não Encontrado");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
