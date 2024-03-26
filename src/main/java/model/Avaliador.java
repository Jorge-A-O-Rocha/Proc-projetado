package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import dao.IUsuario;

@Entity
public class Avaliador implements Serializable, IUsuario {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idAvaliador;

	private String nomeAvaliador;
	private String emailAvaliador;
	private String telefone;
	
	@OneToMany(mappedBy = "avaliador", cascade = CascadeType.ALL)
    private List<Avaliacao> avaliacoes;

	public Avaliador() {

	}

	public Avaliador(long idAvaliador, String nomeAvaliador, String emailAvaliador, String telefone) {
		super();
		this.idAvaliador = idAvaliador;
		this.nomeAvaliador = nomeAvaliador;
		this.emailAvaliador = emailAvaliador;
		this.telefone = telefone;
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

	@Override
	public void login() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cadastro() {
		// TODO Auto-generated method stub
		
	}

}