package ISM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CorretorDAO {

  private Connection connection;

	public CorretorDAO() {
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

  public ArrayList<Corretor> listarTodos() throws SQLException {
		Statement statement = null;
		ArrayList<Corretor> listaCorretor = new ArrayList<Corretor>();

		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Corretor");

			while(resultSet.next()){
				Corretor corretor = Corretor.construirCorretor(resultSet);
				listaCorretor.add(corretor);
			}
		}
		catch (SQLException e){
			e.printStackTrace();
		} finally {

		}
		return listaCorretor;
	}

  public Corretor buscarCorretor(int matricula) throws SQLException {
		Statement statement = null;
		String query = "SELECT * FROM Corretor WHERE Matricula=" + Integer.toString(matricula);
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next()){
				Corretor corretor = Corretor.construirCorretor(resultSet);
				return corretor;
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		return null;
	}

  public Corretor registrarCorretor(String[] informacoes) {
		Statement statement = null;
		String query = "INSERT INTO Corretor (Matricula,Nome,CPF) VALUES ("
				+ informacoes[0] + ", \"" + informacoes[1] + "\", \""
				+ informacoes[2] + "\")";
		try {
			statement = connection.createStatement();
			statement.executeUpdate(query);
			Corretor corretor = new Corretor();
			corretor.setMatricula(Integer.parseInt(informacoes[0]));
			corretor.setNome(informacoes[1]);
      corretor.setCpf(informacoes[2]);
			return corretor;
		} catch (SQLException e){
			e.printStackTrace();
		}
		return null;
	}

}
