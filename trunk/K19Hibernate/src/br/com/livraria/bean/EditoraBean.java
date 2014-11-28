package br.com.livraria.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.livraria.modelo.Editora;
import br.com.livraria.service.IServiceDelegate;
import br.com.livraria.serviceImpl.ServiceDelegateImpl;

@ManagedBean
@SessionScoped
public class EditoraBean {
	
	private Editora editora;
	private IServiceDelegate delegate;
	
	public void init(){
		editora = new Editora();
		delegate = new ServiceDelegateImpl();
	}
	
	public void inserirEditora(){
		delegate.getEditoraService().inserirEditora(editora);
	}

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

}
