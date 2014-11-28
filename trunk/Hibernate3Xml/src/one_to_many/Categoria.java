package one_to_many;

import java.util.Set;
import java.util.HashSet;

public class Categoria {

	private int id;
	
	private String nome;

	private Set<Produto> produtos = new HashSet<Produto>();
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(Set<Produto> produtos) {
		this.produtos = produtos;
	}
	
	public void addProduto(Produto produto){
		produtos.add(produto);
	}
	
}
