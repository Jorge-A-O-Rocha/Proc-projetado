package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Avaliador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idAvaliador;

	private String nomeAvaliador;
	private String emailAvaliador;
	private String telefone;

	public Avaliador() {

	}

	public long getIdAvaliador() {
		return idAvaliador;
	}

	public void setIdAvaliador(long idAvaliador) {
		this.idAvaliador = idAvaliador;
	}

	public String getNomeAvaliador() {
		return nomeAvaliador;
	}

	public void setNomeAvaliador(String nomeAvaliador) {
		this.nomeAvaliador = nomeAvaliador;
	}

	public String getEmailAvaliador() {
		return emailAvaliador;
	}

	public void setEmailAvaliador(String emailAvaliador) {
		this.emailAvaliador = emailAvaliador;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
