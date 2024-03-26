package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import dao.IUsuario;


@Entity
@Table(name="cliente")
public class Cliente implements Serializable, IUsuario {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idCliente;

	private String cnpj;
	private String nomeCliente;
	private String idContrato;
	private String nomeEmpresa;
	private String razaoSocial;
	private String nomeGestor;
	private String pontoFocal;
	private String tipoServico;
	private String descricaoServico;
	private String emailCliente;
	
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Avaliacao> avaliacoes;
	
	public Cliente() {

	}

	public Cliente(long idCliente, String cnpj, String nomeCliente, String idContrato, String nomeEmpresa,
			String razaoSocial, String nomeGestor, String pontoFocal, String tipoServico, String descricaoServico,
			String emailCliente) {
		super();
		this.idCliente = idCliente;
		this.cnpj = cnpj;
		this.nomeCliente = nomeCliente;
		this.idContrato = idContrato;
		this.nomeEmpresa = nomeEmpresa;
		this.razaoSocial = razaoSocial;
		this.nomeGestor = nomeGestor;
		this.pontoFocal = pontoFocal;
		this.tipoServico = tipoServico;
		this.descricaoServico = descricaoServico;
		this.emailCliente = emailCliente;
	}
	
	public long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getIdContrato() {
		return idContrato;
	}

	public void setIdContrato(String idContrato) {
		this.idContrato = idContrato;
	}

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeGestor() {
		return nomeGestor;
	}

	public void setNomeGestor(String nomeGestor) {
		this.nomeGestor = nomeGestor;
	}

	public String getPontoFocal() {
		return pontoFocal;
	}

	public void setPontoFocal(String pontoFocal) {
		this.pontoFocal = pontoFocal;
	}

	public String getTipoServico() {
		return tipoServico;
	}

	public void setTipoServico(String tipoServico) {
		this.tipoServico = tipoServico;
	}

	public String getDescricaoServico() {
		return descricaoServico;
	}

	public void setDescricaoServico(String descricaoServico) {
		this.descricaoServico = descricaoServico;
	}

	public String getEmailCliente() {
		return emailCliente;
	}

	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}

	public List<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}

	public void setAvaliacoes(List<Avaliacao> avaliacoes) {
		this.avaliacoes = avaliacoes;
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
	
	public void Contrato() {
		
	}
	
}