package com.requerOnline.mb;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.requerOnline.applicationContext.SpringBeans;
import com.requerOnline.core.GerenciadorConectado;
import com.requerOnline.service.ServiceDelegate;
import com.requerOnline.serviceImpl.ServiceDelegateImpl;

@ManagedBean
@SessionScoped
public class LoginMB implements Serializable {

	private static final long serialVersionUID = 1L;

	private GerenciadorConectado gerenciadorConectado;
	
	private Boolean errouAutenticacao = false;
	
	private Boolean logou;
	
	private ServiceDelegate delegate;

	@PostConstruct
	public void iniciar() {
		gerenciadorConectado = SpringBeans.getBeanGerenciadorConectado();
	}

	public void logar() throws IOException{
		delegate = new ServiceDelegateImpl();
		gerenciadorConectado = delegate.getLoginService().getGerenciadorLogado(
				gerenciadorConectado.getGerenciador());
		FacesMessage msg = new FacesMessage();
		if (gerenciadorConectado != null) {
			FacesContext.getCurrentInstance().getExternalContext().redirect("../../index.xhtml");
		} else {
			msg.setSummary("Login ou senha incorretos");
			errouAutenticacao = true;
			FacesContext.getCurrentInstance().addMessage(null, msg);
			iniciar();
		}		
	}

	public GerenciadorConectado getGerenciadorConectado() {
		return gerenciadorConectado;
	}

	public void setGerenciadorConectado(
			GerenciadorConectado gerenciadorConectado) {
		this.gerenciadorConectado = gerenciadorConectado;
	}

	public Boolean getErrouAutenticacao() {
		return errouAutenticacao;
	}

	public void setErrouAutenticacao(Boolean errouAutenticacao) {
		this.errouAutenticacao = errouAutenticacao;
	}

	public Boolean getLogou() {
		return logou;
	}

	public void setLogou(Boolean logou) {
		this.logou = logou;
	}

}
