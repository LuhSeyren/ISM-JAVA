package ISM;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Cliente {
	String cpf;
	String nome;
	char sexo;
	int perfilDeUso;
	
	public Cliente(String cpf, String nome, char sexo, int perfil) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.sexo = sexo;
		this.perfilDeUso = perfil;
	}
	
	public Cliente() {
		super();
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public int getPerfilDeUso() {
		return perfilDeUso;
	}
	public void setPerfilDeUso(int perfilDeUso) {
		this.perfilDeUso = perfilDeUso;
	}
	
	public static Cliente construirCliente(ResultSet resultSet) {
		Cliente cliente = new Cliente();
		try {
			cliente.setCpf(resultSet.getString("CPF"));
			cliente.setNome(resultSet.getString("Nome"));
			cliente.setSexo(resultSet.getString("Sexo").charAt(0));
			cliente.setPerfilDeUso(resultSet.getInt("PerfilDeUso"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cliente;
	}

}
