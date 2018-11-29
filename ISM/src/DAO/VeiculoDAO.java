package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ISM.Veiculo;

public class VeiculoDAO {
	
	private Connection connection;
	
	public VeiculoDAO() {
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
	
	public ArrayList<Veiculo> listarTodos() throws SQLException {
		Statement statement = null;
		ArrayList<Veiculo> listaVeiculos = new ArrayList<Veiculo>();
		
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Veiculo");
			
			while(resultSet.next()){
				Veiculo veiculo = Veiculo.construirVeiculo(resultSet);
				listaVeiculos.add(veiculo);
			}
		}
		catch (SQLException e){
			e.printStackTrace();
		} finally {
			
		}
		return listaVeiculos;
	}
	
	public Veiculo buscarVeiculo(int renavam) {
		Statement statement = null;
		
		try {
			String query = "SELECT * FROM Veiculo WHERE Renavam=" + Integer.toString(renavam);
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next()){
				Veiculo veiculo = Veiculo.construirVeiculo(resultSet);
				return veiculo;
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		return null;
	}
	
	public Veiculo registrarVeiculo(String[] informacoes) {
		Statement statement = null;
		String query = "INSERT INTO Veiculo (Renavam,Placa,Modelo,Ano,Cor) VALUES ("
				+ informacoes[0] + ", \"" + informacoes[1] + "\", \""
				+ informacoes[2] + "\", " + informacoes[3] + ", \""
				+ informacoes[4] + "\")";
		try {
			statement = connection.createStatement();
			statement.executeUpdate(query);
			Veiculo veiculo = new Veiculo();
			veiculo.setRenavam(Integer.parseInt(informacoes[0]));
			veiculo.setPlaca(informacoes[1]);
			veiculo.setModelo(informacoes[2]);
			veiculo.setAno(Integer.parseInt(informacoes[3]));
			veiculo.setCor(informacoes[4]);
			return veiculo;
		} catch (SQLException e){
			e.printStackTrace();
		}
		return null;
		
	}

}
