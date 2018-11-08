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
	
	public Cliente buscarVeiculo(String cpf) throws SQLException {
		Statement statement = null;
		String query = "SELECT * FROM Veiculo WHERE Renavam=" + cpf;
		try {
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
	
	public Cliente registrarVeiculo(String[] informacoes) {
		Statement statement = null;
		String query = "INSERT INTO Veiculo (CPF,Nome,Sexo,PerfilDeUso) VALUES (\""
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
