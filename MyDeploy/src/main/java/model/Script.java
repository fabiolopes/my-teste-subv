package model;

public class Script {
	
	//Descrição do pacote ex: AGE.tar
	private String descricao;
	
	//script a ser rodado
	private String script;
	
	private String server;
	
	public Script(String descricao, String script, String server) {
		super();
		this.descricao = descricao;
		this.script = script;
		this.setServer(server);
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

	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}
	
	
	

}
