package com.requerOnline.mb;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.requerOnline.applicationContext.SpringBeans;
import com.requerOnline.service.ServiceDelegate;

@ManagedBean
@ViewScoped
public class TemplateMB {

	private ServiceDelegate delegate;
	
	@ManagedProperty(value="#{loginMB}")
	private LoginMB loginMB;
	
	public String iniciar(){
		return "index";
	}
	
	public void logoff() throws IOException{
		loginMB.setGerenciadorConectado(SpringBeans.getBeanGerenciadorConectado());
		FacesContext.getCurrentInstance().getExternalContext().redirect("view/acesso/login.xhtml");
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
