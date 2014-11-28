package br.com.livraria.serviceImpl;

import java.util.List;

import br.com.livraria.dao.IDAO;
import br.com.livraria.daoimpl.EditoraDAO;
import br.com.livraria.modelo.Editora;
import br.com.livraria.service.IEditoraService;

public class EditoraServiceImpl implements IEditoraService{

	private IDAO editoraDAO;

	public EditoraServiceImpl() {
		this.editoraDAO = new EditoraDAO();
	}

	@Override
	public void inserirEditora(Editora editora) {
		editoraDAO.inserir(editora);
		
	}

	@Override
	public void atualizarEditora(Editora editora) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Editora> listarEditoras() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Editora localizarEditoraPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void excluirEditora(Editora editora) {
		// TODO Auto-generated method stub
		
	}

}
