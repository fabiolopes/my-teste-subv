package br.com.livraria.service;

import java.util.List;

import br.com.livraria.modelo.Editora;

public interface IEditoraService {

	public void inserirEditora(final Editora editora);
	
	public void atualizarEditora(final Editora editora);
	
	public List<Editora> listarEditoras();
	
	public Editora localizarEditoraPorId(final Long id);
	
	public void excluirEditora(final Editora editora);
	
}
