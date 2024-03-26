package model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="avaliacao")
public class Avaliacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idAvaliacao;

	private Date dataAvaliacao;
	private String diagnostico;
	private int pontuacao;
	private String nivelAderencia;
	
	@ManyToOne
    @JoinColumn(name = "cliente_id")
	private Cliente cliente;
	@ManyToOne
	@JoinColumn(name = "avaliador_id")
    private Avaliador avaliador;
	
	public Avaliacao() {
		super();
	}
	
	public Avaliacao(long idAvaliacao, Date dataAvaliacao, String diagnostico, int pontuacao, String nivelAderencia,
			Cliente cliente, Avaliador avaliador) {
		super();
		this.idAvaliacao = idAvaliacao;
		this.dataAvaliacao = dataAvaliacao;
		this.diagnostico = diagnostico;
		this.pontuacao = pontuacao;
		this.nivelAderencia = nivelAderencia;
		this.cliente = cliente;
		this.avaliador = avaliador;
	}
	
	public Avaliador getAvaliador() {
		return avaliador;
	}

	public void setAvaliador(Avaliador avaliador) {
		this.avaliador = avaliador;
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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