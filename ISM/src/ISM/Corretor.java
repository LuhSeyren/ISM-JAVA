package ISM;

import java.sql.ResultSet;
import java.sql.SQLException;


public class Corretor {
  int matricula;
  String nome;
  String cpf;

  public Corretor() {
    super();
  }

  public Corretor(int matricula, String nome, String cpf){
    super();
    this.matricula = matricula;
    this.nome = nome;
    this.cpf = cpf;
  }

  public int getMatricula() {
    return matricula;
  }
  public void setMatricula(int matricula){
    this.matricula = matricula;
  }
  public String getNome(){
    return nome;
  }
  public void setNome(String nome) {
    this.nome = nome;
  }
  public String getCpf() {
    return cpf;
  }
  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public static Corretor construirCorretor(ResultSet resultSet) {
    Corretor corretor = new Corretor();
    try {
      corretor.setMatricula(resultSet.getInt("Matricula"));
      corretor.setNome(resultSet.getString("Nome"));
      corretor.setCpf(resultSet.getString("CPF"));
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return corretor;
  }
}
