package model;
 
import java.io.Serializable;
import java.sql.Date;
 
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
 
@Entity
public class Avaliacao implements Serializable {
	private static final long serialVersionUID = 1L;
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idAvaliacao;
	
	private Date dataAvaliacao;
	private String diagnostico;
	private int pontuacao;
	private String nivelAderencia;
	
	public Avaliacao(){
		
	}
 
	public long getIdAvaliacao() {
		return idAvaliacao;
	}
 
	public void setIdAvaliacao(long idAvaliacao) {
		this.idAvaliacao = idAvaliacao;
	}
 
	public Date getDataAvaliacao() {
		return dataAvaliacao;
	}
 
	public void setDataAvaliacao(Date dataAvaliacao) {
		this.dataAvaliacao = dataAvaliacao;
	}
 
	public String getDiagnostico() {
		return diagnostico;
	}
 
	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}
 
	public int getPontuacao() {
		return pontuacao;
	}
 
	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}
 
	public String getNivelAderencia() {
		return nivelAderencia;
	}
 
	public void setNivelAderencia(String nivelAderencia) {
		this.nivelAderencia = nivelAderencia;
	}
 
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public void manterAvaliacao(Cliente cli, Avaliador ave) {
		
	}
	
	public void gerarRecomendacao(Avaliacao ava) {
		
	}
	
	public void gerarPontuacao() {
		
	}
	
}