package servletApresentacao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ISM.Apolice;
import ISM.Cliente;
import DAO.ApoliceDAO;
import ISM.Corretor;
import DAO.CorretorDAO;
import ISM.TabelaFipe;
import ISM.Veiculo;





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
		String op = request.getParameter("op");
		
		if (op.equals("veiculo")){
			inserirValorVeiculo(request, response);
		}else if (op.equals("confirma")){
			confirmaApolice(request, response);
		}else if (op.equals("rejeita")){
			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/telaVenderApolice/telaFalhaConfirmacao.jsp");
			requestDispatcher.forward(request, response);
		}
		
		
		
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
		

		if (informacoes[1].equals("Obrigatória")) {
			informacoes[1] = "1";
		} else if (informacoes[1].equals("Majorada")) {
			informacoes[1] = "2";
		} else {
			informacoes[1] = "3";
		}
		if (informacoes[2].equals("Determinado")) {
			informacoes[2] ="0";
		} else {
			informacoes[2] ="1";
		}
		Calendar cal = Calendar.getInstance();
		Date today = cal.getTime();
		if (informacoes[4].equals("1 Ano")) {
			cal.add(Calendar.YEAR, 1);
			Date nextYear = cal.getTime();
			String newstring = new SimpleDateFormat("yyyy-MM-dd").format(nextYear);
			informacoes[4] = newstring;
		} else {
			cal.add(Calendar.YEAR, 2);
			Date nextYear = cal.getTime();
			String newstring = new SimpleDateFormat("yyyy-MM-dd").format(nextYear);
			informacoes[4] = newstring;
		}
		
		Apolice apolice = new Apolice();
		
		apolice.setTipo(Integer.valueOf(informacoes[1]));
		apolice.setModalidadeDeValor(Integer.valueOf(informacoes[2]));
		apolice.setValorAcessorios(Integer.valueOf(informacoes[3]));
		apolice.setVigencia(convertDate(informacoes[4]));
		
		
		
		
		if(apolice.getModalidadeDeValor() == MODALIDADE_DETERMINADO){
			//Salvar Apolice na sessao
			HttpSession session = request.getSession();
			session.setAttribute("apolice", apolice);
			
			
			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/telaVenderApolice/solicitarValorVeiculo.jsp");
			requestDispatcher.forward(request, response);
		}
		else if(apolice.getModalidadeDeValor() == MODALIDADE_REFERENCIADO){
			HttpSession session = request.getSession();
			Veiculo veiculo = (Veiculo) session.getAttribute("veiculo");
			
			int valorVeiculo = TabelaFipe.buscarValorVeiculo(veiculo);
			
			apolice.setValorVeiculo(valorVeiculo);
			
			session.setAttribute("apolice", apolice);
			
			response.sendRedirect(request.getContextPath() + "/ControleVenderApoliceServlet?op=calcular");
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
	
	protected void inserirValorVeiculo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//InserirValorVeiculo
				int valorVeiculo = Integer.valueOf(request.getParameter("valor"));
				
				HttpSession session = request.getSession();
				Apolice apolice = (Apolice) session.getAttribute("apolice");
				
				apolice.setValorVeiculo(valorVeiculo);
				
				session.setAttribute("apolice", apolice);
				
				//calcular_franquia no servlet ControleVenderApoliceServlet
				response.sendRedirect(request.getContextPath() + "/ControleVenderApoliceServlet?op=calcular");
	
	}
	
	
	
	protected void confirmaApolice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		Apolice apolice = (Apolice) session.getAttribute("apolice");
		
		ApoliceDAO apoliceDAO = new ApoliceDAO();
		int numeroApolice = apoliceDAO.gerarNumeroApolice();
		apolice.setNumero(numeroApolice);
		
		//set corretor
		CorretorDAO corretorDAO = new CorretorDAO();
		Corretor corretor = corretorDAO.buscarCorretor(1);
		int matricula = corretor.getMatricula();
		apolice.setCorretorResponsavel(matricula);
		
		//set corretora
		String infCorretora = "Informações da corretora.";
		apolice.setInformacoesDaCorretora(infCorretora);
		
		apolice.setStatus("Pendente");
		
		
		//set Cliente e veiculo
		Cliente cliente =  (Cliente) session.getAttribute("cliente");
		apolice.setCliente(cliente);
		Veiculo veiculo = (Veiculo) session.getAttribute("veiculo");
		apolice.setVeiculo(veiculo);
		
		apoliceDAO.registrarApolice(apolice);
		apoliceDAO.registrarContrato(apolice);
		
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/telaVenderApolice/telaSucessoVenda.jsp");
		requestDispatcher.forward(request, response);
		
	}

}
