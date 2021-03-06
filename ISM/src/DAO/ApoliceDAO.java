package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import ISM.Apolice;
import ISM.Cliente;

public class ApoliceDAO {
	
	private Connection connection;

	public ApoliceDAO() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://143.107.102.7:3306/t1g7","t1g7","x$Hk_?rX");
			this.connection = conn;
		}
		catch (ClassNotFoundException e){
			e.printStackTrace();
		}
		catch (SQLException e){
			e.printStackTrace();
		}
	}

  public ArrayList<Apolice> listarTodos() throws SQLException {
		Statement statement = null;
		ArrayList<Apolice> listaApolice = new ArrayList<Apolice>();

		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Apolice");

			while(resultSet.next()){
				Apolice apolice = Apolice.construirApolice(resultSet);
				listaApolice.add(apolice);
			}
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		return listaApolice;
	}

  public Apolice buscarApolice(int matricula) {
		Statement statement = null;
		Statement statement2 = null;
		String query = "SELECT * FROM Apolice WHERE Numero=" + Integer.toString(matricula);
		try {
			statement = connection.createStatement();
			statement2 = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next()){
				Apolice apolice = Apolice.construirApolice(resultSet);
				String query2 = "Select Cliente.* from Apolice, Contrato, Cliente where "
						+ "Apolice.Numero = Contrato.Numero and Cliente.CPF = Contrato.CPF and Apolice.Numero=" + Integer.toString(matricula);
				ResultSet resultSet2 = statement2.executeQuery(query2);
				resultSet2.next();
				Cliente cliente = Cliente.construirCliente(resultSet2);
				apolice.setCliente(cliente);
				return apolice;
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		return null;
	}

  public Apolice registrarApolice(String[] informacoes) {
		Statement statement = null;
		String query = "INSERT INTO Apolice (Numero,Vigencia,Tipo,ModalidadeValor,ValorVeiculo,ValorAcessorios,"
				+ "Status,FranquiaCasco,FranquiaAcessorios,Premio,InformacoesCorretora) VALUES ("
				+ informacoes[0] + ", DATE(\"" + informacoes[1] + "\"), "
				+ informacoes[2] + "," + informacoes[3] + ","
				+ informacoes[4] + "," + informacoes[5] + ", \""
				+ informacoes[6] + "\" ," + informacoes[7] + ","
				+ informacoes[8] + "," + informacoes[9] + ", \"" + informacoes[10] + "\")";
		try {
			statement = connection.createStatement();
			statement.executeUpdate(query);
			Apolice apolice = new Apolice();
			apolice.setNumero(Integer.parseInt(informacoes[0]));
			SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
			try {
				Date data = formato.parse(informacoes[1]);
				apolice.setVigencia(data);
			} catch (ParseException e) {
				e.printStackTrace();
				apolice.setVigencia(null);
			}
			apolice.setTipo(Integer.parseInt(informacoes[2]));
			apolice.setModalidadeDeValor(Integer.parseInt(informacoes[3]));
			apolice.setValorVeiculo(Integer.parseInt(informacoes[4]));
			apolice.setValorAcessorios(Integer.parseInt(informacoes[5]));
			apolice.setStatus(informacoes[6]);
			apolice.setFranquiaCasco(Integer.parseInt(informacoes[7]));
			apolice.setFranquiaAcessorios(Integer.parseInt(informacoes[8]));
			apolice.setPremio(Integer.parseInt(informacoes[9]));
			apolice.setInformacoesDaCorretora(informacoes[10]);
			return apolice;
		} catch (SQLException e){
			e.printStackTrace();
		}
		return null;
	}
  
  public ArrayList<Apolice> buscarPorData(String data_inicial, String data_final) {
		Statement statement = null;
		Statement statement2 = null;
		ArrayList<Apolice> listaApolice = new ArrayList<Apolice>();
		try {
			statement = connection.createStatement();
			statement2 = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Apolice WHERE Vigencia BETWEEN DATE(\"" 
					+ data_inicial + "\") AND DATE(\"" + data_final + "\")");

			while(resultSet.next()){			
				Apolice apolice = Apolice.construirApolice(resultSet);
				ResultSet resultSet2 = statement2.executeQuery("Select Cliente.* from Apolice, Contrato, Cliente "
						+ "where Apolice.Numero = Contrato.Numero and Cliente.CPF = Contrato.CPF "
						+ "and Apolice.Numero =" + Integer.toString(apolice.getNumero()));
				resultSet2.next();
				Cliente cliente = Cliente.construirCliente(resultSet2);
				apolice.setCliente(cliente);
				listaApolice.add(apolice);
			}
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		return listaApolice;
	}
  
  public void registrarContrato(Apolice apolice) {
	  Statement statement = null;
	  try {
			statement = connection.createStatement();
			String numero = Integer.toString(apolice.getNumero());
			String cpf = apolice.getCliente().getCpf();
			String renavam = Integer.toString(apolice.getVeiculo().getRenavam());
			statement.executeUpdate("INSERT INTO Contrato (Numero,CPF,Renavam,Matricula) VALUES ("+ numero + ",\"" + cpf + "\"," + renavam + ",1)");
		}
		catch (SQLException e){
			e.printStackTrace();
		}
  }
  
  public int gerarNumeroApolice() {
	  Statement statement = null;
	  int m = 1;
	  
	  
	  try{
		  	statement = connection.createStatement();
		  	ResultSet resultSet = statement.executeQuery("SELECT Numero FROM Apolice");
		  	
		  	
		  	while(resultSet.next()){
				  int numero = resultSet.getInt("Numero");
				  if (numero != m)
					  break;
				  m++;
				}
		  	
	  }catch (SQLException e){
			e.printStackTrace();
		}
	  
	  
	  
	  
	  return m;
  }
  
  public int registrarApolice(Apolice apolice) {
	  String [] informacoes = new String[11];
	  informacoes[0] = Integer.toString(apolice.getNumero());
	  
	  DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	  informacoes[1] = df.format(apolice.getVigencia());
	  
	  informacoes[2] = Integer.toString(apolice.getTipo());
	  informacoes[3] = Integer.toString(apolice.getModalidadeDeValor());
	  informacoes[4] = Integer.toString(apolice.getValorVeiculo());
	  informacoes[5] = Integer.toString(apolice.getValorAcessorios());
	  informacoes[6] = apolice.getStatus();
	  informacoes[7] = Integer.toString(apolice.getFranquiaCasco());
	  informacoes[8] = Integer.toString(apolice.getFranquiaAcessorios());
	  informacoes[9] = Integer.toString(apolice.getPremio());
	  informacoes[10] = apolice.getInformacoesDaCorretora();
	  
		Statement statement = null;
		String query = "INSERT INTO Apolice (Numero,Vigencia,Tipo,ModalidadeValor,ValorVeiculo,ValorAcessorios,"
				+ "Status,FranquiaCasco,FranquiaAcessorios,Premio,InformacoesCorretora) VALUES ("
				+ informacoes[0] + ", DATE(\"" + informacoes[1] + "\"), "
				+ informacoes[2] + "," + informacoes[3] + ","
				+ informacoes[4] + "," + informacoes[5] + ", \""
				+ informacoes[6] + "\" ," + informacoes[7] + ","
				+ informacoes[8] + "," + informacoes[9] + ", \"" + informacoes[10] + "\")";
		try {
			statement = connection.createStatement();
			statement.executeUpdate(query);
			return 1;
		} catch (SQLException e){
			e.printStackTrace();
		}
		return 0;
	}
  
  public int alterarStatusApolice(Apolice apolice, String status) {
	  Statement statement = null;
	  try {
			statement = connection.createStatement();
			String numero = Integer.toString(apolice.getNumero());
			statement.executeUpdate("UPDATE Apolice SET Status = \"" + status + "\" WHERE Numero =" + numero +";") ;
		}
		catch (SQLException e){
			e.printStackTrace();
		}
	  return 0;
	  
  }

}
