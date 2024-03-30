package model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Formulario implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idFormulario;
	
	private boolean possuiControle;
	private int[] vetResposta;
	
	@OneToOne(mappedBy = "formulario", cascade = CascadeType.ALL)
	private Avaliacao avaliacao;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

	public Formulario() {
		
	}
	
	public Formulario(long idFormulario, boolean possuiControle, int[] vetResposta,
		 Cliente cliente) {
		super();
		this.idFormulario = idFormulario;
		this.possuiControle = possuiControle;
		this.vetResposta = vetResposta;
		this.cliente = cliente;
	}
	
	public long getIdFormulario() {
		return idFormulario;
	}

	public void setIdFormulario(long idFormulario) {
		this.idFormulario = idFormulario;
	}

	public boolean isPossuiControle() {
		return possuiControle;
	}

	public void setPossuiControle(boolean possuiControle) {
		this.possuiControle = possuiControle;
	}

	public int[] getVetResposta() {
		return vetResposta;
	}

	public void setRespostaFinal(int[] vetResposta) {
		this.vetResposta = vetResposta;
	}

	public Avaliacao getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
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

	public void enviarForms(Cliente cli) {
		
	}

}