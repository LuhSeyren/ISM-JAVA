package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ISM.Apolice;





/**
 * Servlet implementation class ApoliceServlet
 */
@WebServlet("/ApoliceServlet")
public class ApoliceServlet extends HttpServlet {
	private int MODALIDADE_DETERMINADO = 0;
	private int MODALIDADE_REFERENCIADO = 1;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApoliceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// enviarCondicaoApolice
		String[] informacoes = new String[5];
		
		
		informacoes[0] = request.getParameter("tipoApolice");
		informacoes[1] = request.getParameter("tipoFranquia");
		informacoes[2] = request.getParameter("modalidadeValor");
		informacoes[3] = request.getParameter("valorAcessorios");
		informacoes[4] = request.getParameter("vigencia");
		
		Apolice apolice = new Apolice();
		
		apolice.setTipo(Integer.valueOf(informacoes[1]));
		apolice.setModalidadeDeValor(Integer.valueOf(informacoes[2]));
		apolice.setValorAcessorios(Integer.valueOf(informacoes[3]));
		apolice.setVigencia(convertDate(informacoes[4]));
		
		//Salvar Apolice na sessao
		HttpSession session = request.getSession();
		session.setAttribute("apolice", apolice);
		
		
		if(apolice.getModalidadeDeValor() == MODALIDADE_DETERMINADO){
			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/solicitarValorVeiculo.jsp");
			requestDispatcher.forward(request, response);
		}
		
		
	}
	
	protected Date convertDate(String informacao){
		Date date = null;
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		try {
			date = formato.parse(informacao);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return date;
		
	}

}
