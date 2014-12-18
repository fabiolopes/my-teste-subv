package br.com.sgst.core;

import java.util.Date;

import br.com.sgst.enums.DocumentoTypes;

public class DocumentoEmpresa {

	private int id;
	
	private Date data;
	
	private DocumentoTypes documento;
	
	private Empresa empresa;
	
	private boolean docFeito;
	
	private Date dataCadastro;
	
	private Usuario usuarioCadastrador;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public DocumentoTypes getDocumento() {
		return documento;
	}

	public void setDocumento(DocumentoTypes documento) {
		this.documento = documento;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public boolean isDocFeito() {
		return docFeito;
	}

	public void setDocFeito(boolean docFeito) {
		this.docFeito = docFeito;
	}
	
	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Usuario getUsuarioCadastrador() {
		return usuarioCadastrador;
	}

	public void setUsuarioCadastrador(Usuario usuarioCadastrador) {
		this.usuarioCadastrador = usuarioCadastrador;
	}
	
}
