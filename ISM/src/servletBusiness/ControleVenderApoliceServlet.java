package servletBusiness;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ISM.Apolice;

/**
 * Servlet implementation class ControleVenderApoliceServlet
 */
@WebServlet("/ControleVenderApoliceServlet")
public class ControleVenderApoliceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int OBRIGATORIA = 1;
	private int MAJORADA = 2;
	private int REDUZIDA = 3;
	
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
		else if (op.equals("calcular")){
			calcular(request, response);
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
	
	protected void calcular(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		Apolice apolice = (Apolice) session.getAttribute("apolice");
		
		int tipo = apolice.getTipo();
		int valorVeiculo = apolice.getValorVeiculo();
		double fatorFranquiaCasco = 0.06;
		double fatorPremioCasco = 0.03;
		
		//Acrescentar dado idade do cliente
		//Fator
		if (tipo == REDUZIDA){
			fatorFranquiaCasco = 0.06;
			fatorPremioCasco = 0.05;
		}
		else if (tipo == MAJORADA){
			fatorFranquiaCasco = 0.10;
			fatorPremioCasco = 0.02;
		}
		else if (tipo == OBRIGATORIA){
			fatorFranquiaCasco = 0.08;
			fatorPremioCasco = 0.05;
		}
		
		
		apolice.setFranquiaCasco((int)(valorVeiculo*fatorFranquiaCasco));
		apolice.setFranquiaAcessorios((int) (apolice.getValorAcessorios() * 0.15));
		
		//calculo do premio
		double premioLiquido = 	fatorPremioCasco*valorVeiculo 
						 	  + 0.05 * apolice.getValorAcessorios()
						 	  + 0.05 * valorVeiculo; //danos materiais e corporais
		
		double premioTotal = premioLiquido * 1.0738; //Acrescimo do IOF
		
		apolice.setPremioLiquido((int)premioLiquido);
		apolice.setPremio((int)(premioTotal));
		
		
		//Armazenar Apólice
		session.setAttribute("apolice", apolice);
		
		request.setAttribute("apolice", apolice);
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/mostrarApolice.jsp");
		requestDispatcher.forward(request, response);
		
	}

}
