package br.com.livraria.service;

public class ServiceDelegateImpl implements ServiceDelegate{

	private EditoraService editoraService;
	
	private AutorService autorService;

	public ServiceDelegateImpl(){
		editoraService = new EditoraService();
		autorService = new AutorService();
	}
	
	public EditoraService getEditoraService() {
		return editoraService;
	}

	public void setEditoraService(EditoraService editoraService) {
		this.editoraService = editoraService;
	}

	public AutorService getAutorService() {
		return autorService;
	}

	public void setAutorService(AutorService autorService) {
		this.autorService = autorService;
	}
	


}
