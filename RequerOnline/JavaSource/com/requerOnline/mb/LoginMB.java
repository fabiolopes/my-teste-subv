package com.requerOnline.mb;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.requerOnline.applicationContext.SpringBeans;
import com.requerOnline.core.GerenciadorConectado;
import com.requerOnline.service.ServiceDelegate;
import com.requerOnline.serviceImpl.ServiceDelegateImpl;

@ManagedBean
@SessionScoped
public class LoginMB {
	private GerenciadorConectado gerenciadorConectado;
	private Boolean errouAutenticacao;
	private ServiceDelegate delegate;
	
	@PostConstruct
	public void iniciar(){
		gerenciadorConectado = SpringBeans.getBeanGerenciadorConectado();
		errouAutenticacao = false;
	}
	
	public String logar() {
		delegate = new ServiceDelegateImpl();
		gerenciadorConectado = delegate.getLoginService().getGerenciadorLogado(
				gerenciadorConectado.getGerenciador());
		if(gerenciadorConectado != null){
		}else{
			errouAutenticacao = true;
		}
		return "login";
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

}
