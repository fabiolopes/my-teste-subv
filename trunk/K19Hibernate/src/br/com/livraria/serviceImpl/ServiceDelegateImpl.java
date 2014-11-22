package br.com.livraria.serviceImpl;

public class ServiceDelegateImpl implements ServiceDelegate{

	private EditoraServiceImpl editoraService;
	
	private AutorServiceImpl autorService;

	public ServiceDelegateImpl(){
		editoraService = new EditoraServiceImpl();
		autorService = new AutorServiceImpl();
	}
	
	public EditoraServiceImpl getEditoraService() {
		return editoraService;
	}

	public void setEditoraService(EditoraServiceImpl editoraService) {
		this.editoraService = editoraService;
	}

	public AutorServiceImpl getAutorService() {
		return autorService;
	}

	public void setAutorService(AutorServiceImpl autorService) {
		this.autorService = autorService;
	}
	


}
