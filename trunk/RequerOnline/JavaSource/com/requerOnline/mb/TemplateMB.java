package com.requerOnline.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.requerOnline.service.ServiceDelegate;

@ManagedBean
@ViewScoped
public class TemplateMB {

	private ServiceDelegate delegate;
	
	@ManagedProperty(value="#{loginMB}")
	private LoginMB loginMB;
	
	public String logoff(){
		delegate.getLoginService().desconectarGerenciadorLogado(loginMB.getGerenciadorConectado());
		return "login";
	}

	public LoginMB getLoginMB() {
		return loginMB;
	}

	public void setLoginMB(LoginMB loginMB) {
		this.loginMB = loginMB;
	}

	public ServiceDelegate getDelegate() {
		return delegate;
	}

	public void setDelegate(ServiceDelegate delegate) {
		this.delegate = delegate;
	}
	

}
