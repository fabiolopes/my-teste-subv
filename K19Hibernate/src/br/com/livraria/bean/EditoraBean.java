package br.com.livraria.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.livraria.modelo.Editora;

@ManagedBean
@SessionScoped
public class EditoraBean {
	
	private Editora editora;
	
	public void init(){
		editora = new Editora();
	}

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

}
