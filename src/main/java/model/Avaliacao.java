package model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "avaliacao")
public class Avaliacao implements Serializable {
	@Override
	public String toString() {
		return "Avaliacao [idAvaliacao=" + idAvaliacao + ", dataAvaliacao=" + dataAvaliacao + ", diagnostico="
				+ diagnostico + ", pontuacao=" + pontuacao + ", nivelAderencia=" + nivelAderencia + ", cliente="
				+ cliente + ", formulario=" + formulario + "]";
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idAvaliacao;

	private LocalDateTime dataAvaliacao;
	private String diagnostico;
	private int pontuacao;
	private String nivelAderencia;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	@OneToOne
	@JoinColumn(name = "formulario_id")
	private Formulario formulario;

	public Avaliacao() {
		super();
	}

	public Avaliacao(long idAvaliacao, LocalDateTime dataAvaliacao, String diagnostico, int pontuacao, String nivelAderencia,
			Cliente cliente, Formulario formulario) {
		super();
		this.idAvaliacao = idAvaliacao;
		this.dataAvaliacao = dataAvaliacao;
		this.diagnostico = diagnostico;
		this.pontuacao = pontuacao;
		this.nivelAderencia = nivelAderencia;
		this.cliente = cliente;
		this.formulario = formulario;
	}
	
	public long getIdAvaliacao() {
		return idAvaliacao;
	}

	public void setIdAvaliacao(long idAvaliacao) {
		this.idAvaliacao = idAvaliacao;
	}

	public LocalDateTime getDataAvaliacao() {
		return dataAvaliacao;
	}

	public void setDataAvaliacao(LocalDateTime dataAvaliacao) {
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

	public Formulario getFormulario() {
		return formulario;
	}

	public void setFormulario(Formulario formulario) {
		this.formulario = formulario;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}