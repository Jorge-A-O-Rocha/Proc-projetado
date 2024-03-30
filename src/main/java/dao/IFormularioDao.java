package dao;

import java.util.List;

import model.Formulario;

public interface IFormularioDao {
	public Formulario pesquisar(String formulario) ;
	public void inserir(Formulario formulario) ;
	public void remover (long id) ;
	public List<Formulario> lista(); 
	public List<Formulario> apenasUmFormulario (String codForms);
}
