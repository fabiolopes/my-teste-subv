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
	private Boolean logou;
	private ServiceDelegate delegate;
	
	@PostConstruct
	public void iniciar(){
		gerenciadorConectado = SpringBeans.getBeanGerenciadorConectado();
	}
	
	public void logar() {
		delegate = new ServiceDelegateImpl();
		gerenciadorConectado = delegate.getLoginService().getGerenciadorLogado(
				gerenciadorConectado.getGerenciador());
		if(gerenciadorConectado != null){
			System.out.println("logou");
		}else{
			System.out.println("deu bronca");
		}

	}

	public GerenciadorConectado getGerenciadorConectado() {
		return gerenciadorConectado;
	}

	public void setGerenciadorConectado(
			GerenciadorConectado gerenciadorConectado) {
		this.gerenciadorConectado = gerenciadorConectado;
	}

	public Boolean getLogou() {
		return logou;
	}

	public void setLogou(Boolean logou) {
		this.logou = logou;
	}

}
