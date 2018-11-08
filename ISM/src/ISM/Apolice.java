package ISM;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Apolice {
	int numero;
	Date vigencia;
	int tipo;
	int modalidadeDeValor;
	int corretorResponsavel;
	int valorVeiculo;
	int valorAcessorios;
	String status;
	int franquiaCasco;
	int franquiaAcessorios;
	int premio;
	String informaçõesDaCorretora;
	Veiculo veiculo;
//	Cliente cliente;
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public Date getVigencia() {
		return vigencia;
	}
	public void setVigencia(Date vigencia) {
		this.vigencia = vigencia;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public int getModalidadeDeValor() {
		return modalidadeDeValor;
	}
	public void setModalidadeDeValor(int modalidadeDeValor) {
		this.modalidadeDeValor = modalidadeDeValor;
	}
	public int getCorretorResponsavel() {
		return corretorResponsavel;
	}
	public void setCorretorResponsavel(int corretorResponsavel) {
		this.corretorResponsavel = corretorResponsavel;
	}
	public int getValorVeiculo() {
		return valorVeiculo;
	}
	public void setValorVeiculo(int valorVeiculo) {
		this.valorVeiculo = valorVeiculo;
	}
	public int getValorAcessorios() {
		return valorAcessorios;
	}
	public void setValorAcessorios(int valorAcessorios) {
		this.valorAcessorios = valorAcessorios;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getFranquiaCasco() {
		return franquiaCasco;
	}
	public void setFranquiaCasco(int franquiaCasco) {
		this.franquiaCasco = franquiaCasco;
	}
	public int getFranquiaAcessorios() {
		return franquiaAcessorios;
	}
	public void setFranquiaAcessorios(int franquiaAcessorios) {
		this.franquiaAcessorios = franquiaAcessorios;
	}
	public int getPremio() {
		return premio;
	}
	public void setPremio(int premio) {
		this.premio = premio;
	}
	public String getInformaçõesDaCorretora() {
		return informaçõesDaCorretora;
	}
	public void setInformaçõesDaCorretora(String informaçõesDaCorretora) {
		this.informaçõesDaCorretora = informaçõesDaCorretora;
	}
	
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
//	public Cliente getCliente() {
//		return cliente;
//	}
//	public void setCliente(Cliente cliente) {
//		this.cliente = cliente;
//	}
	
	public static Apolice construirApolice(ResultSet resultSet) {
		Apolice apolice = new Apolice();
		try {
			apolice.setNumero(resultSet.getInt("Numero"));
			apolice.setVigencia(resultSet.getDate("Vigencia"));
			apolice.setTipo(resultSet.getInt("Tipo"));
			apolice.setModalidadeDeValor(resultSet.getInt("ModalidadeValor"));
			apolice.setValorVeiculo(resultSet.getInt("ValorVeiculo"));
			apolice.setValorAcessorios(resultSet.getInt("ValorAcessorios"));
			apolice.setStatus(resultSet.getString("Status"));
			apolice.setFranquiaCasco(resultSet.getInt("FranquiaCasco"));
			apolice.setFranquiaAcessorios(resultSet.getInt("FranquiaAcessorios"));
			apolice.setPremio(resultSet.getInt("Premio"));
			apolice.setInformaçõesDaCorretora(resultSet.getString("InformacoesCorretora"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return apolice;
	}
	
}
