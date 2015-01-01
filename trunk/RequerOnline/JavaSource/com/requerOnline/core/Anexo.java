package com.requerOnline.core;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Service;

import com.requerOnline.util.enums.AnexoTypes;
import com.requerOnline.util.enums.DocumentoTypes;

@Service
@Entity
public class Anexo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@NotNull(message="Informe o caminho do anexo")
	private String pathAnexo;
	
	@NotNull
	private DocumentoTypes type;
	
	private String descDocumento;
	
	@NotNull
	private AnexoTypes tipo;

	public Anexo() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPathAnexo() {
		return pathAnexo;
	}

	public void setPathAnexo(String pathAnexo) {
		this.pathAnexo = pathAnexo;
	}

	public DocumentoTypes getType() {
		return type;
	}

	public void setType(DocumentoTypes type) {
		this.type = type;
	}

	public String getDescDocumento() {
		return descDocumento;
	}

	public void setDescDocumento(String descDocumento) {
		this.descDocumento = descDocumento;
	}

	public AnexoTypes getTipo() {
		return tipo;
	}

	public void setTipo(AnexoTypes tipo) {
		this.tipo = tipo;
	}

}
