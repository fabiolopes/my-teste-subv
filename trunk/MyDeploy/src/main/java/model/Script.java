package model;

public class Script {
	
	//Descrição do pacote ex: AGE.tar
	private String descricao;
	
	//script a ser rodado
	private String script;
	
	public Script(String descricao, String script) {
		super();
		this.descricao = descricao;
		this.script = script;
	}

	public Script() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getScript() {
		return script;
	}

	public void setScript(String script) {
		this.script = script;
	}
	
	
	

}
