package br.com.livraria.service;

import java.util.List;

import br.com.livraria.modelo.Autor;

public interface IAutorService {

	public void inserirAutor(final Autor autor);

	public void atualizarAutor(final Autor autor);

	public List<Autor> listarAutores();

	public Autor localizarAutorPorId(final Long id);

	public void excluirAutor(final Autor autor);
}
