package br.com.livraria.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.livraria.modelo.Autor;

@ManagedBean
@SessionScoped
public class AutorBean {

	private Autor autor;

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}
}
