package ISM;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Veiculo {
	int renavam;
	String placa;
	String modelo;
	int ano;
	String cor;
	
	public Veiculo(int renavam, String placa, String modelo, int ano, String cor) {
		super();
		this.renavam = renavam;
		this.placa = placa;
		this.modelo = modelo;
		this.ano = ano;
		this.cor = cor;
	}
	
	public Veiculo() {
		super();
	}

	public int getRenavam() {
		return renavam;
	}
	public void setRenavam(int renavam) {
		this.renavam = renavam;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}

	public static Veiculo construirVeiculo(ResultSet resultSet) {
		Veiculo veiculo = new Veiculo();
		try {
			veiculo.setRenavam(resultSet.getInt("Renavam"));
			veiculo.setPlaca(resultSet.getString("Placa"));
			veiculo.setModelo(resultSet.getString("Modelo"));
			veiculo.setAno(resultSet.getInt("Ano"));
			veiculo.setCor(resultSet.getString("Cor"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return veiculo;
	}
	
}
