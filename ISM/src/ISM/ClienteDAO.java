package ISM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ClienteDAO {

	private Connection connection;

	public ClienteDAO() {
		Connection conn = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://143.107.102.7:3306/t1g7","t1g7","x$Hk_?rX");
			//conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ISM","root","");
			this.connection = conn;
		}
		catch (ClassNotFoundException e){
			e.printStackTrace();
		}
		catch (SQLException e){
			e.printStackTrace();
		}
	}

	public ArrayList<Cliente> listarTodos() throws SQLException {
		Statement statement = null;
		ArrayList<Cliente> listaCliente = new ArrayList<Cliente>();

		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Cliente");

			while(resultSet.next()){
				Cliente cliente = Cliente.construirCliente(resultSet);
				listaCliente.add(cliente);
			}
		}
		catch (SQLException e){
			e.printStackTrace();
		} finally {

		}
		return listaCliente;
	}
	
	public Cliente buscarCliente(String cpf) {
		Statement statement = null;
		
		try {
			String query = "SELECT * FROM Cliente WHERE CPF=" + cpf;
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next()){
				Cliente cliente = Cliente.construirCliente(resultSet);
				return cliente;
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		return null;
	}
	
	public Cliente registrarCliente(String[] informacoes) {
		Statement statement = null;
		if (informacoes[2].equals("Masculino")) {
			informacoes[2] = "M";
		} else {
			informacoes[2] = "F";
		}
		if (informacoes[3].equals("Trabalho")) {
			informacoes[3]="1";
		} else if (informacoes[3].equals("Lazer")) {
			informacoes[3]="2";
		} else {
			informacoes[3]="3";
		}
		String query = "INSERT INTO Cliente (CPF,Nome,Sexo,PerfilDeUso) VALUES (\""
				+ informacoes[0] + "\", \"" + informacoes[1] + "\", \""
				+ informacoes[2] + "\", "   + informacoes[3] + ")";
		try {
			statement = connection.createStatement();
			statement.executeUpdate(query);
			Cliente cliente = new Cliente();
			cliente.setCpf(informacoes[0]);
			cliente.setNome(informacoes[1]);
			cliente.setSexo(informacoes[2].charAt(0));
			cliente.setPerfilDeUso(Integer.parseInt(informacoes[3]));
			return cliente;
		} catch (SQLException e){
			e.printStackTrace();
		}
		return null;
	}
}
