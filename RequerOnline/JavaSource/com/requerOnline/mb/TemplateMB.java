package com.requerOnline.mb;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.requerOnline.service.ServiceDelegate;

@ManagedBean
@ViewScoped
public class TemplateMB implements Serializable {

	private static final long serialVersionUID = 1L;

	private ServiceDelegate delegate;
	
	@ManagedProperty(value="#{loginMB}")
	private LoginMB loginMB;
	
	public String iniciar(){
		return "index";
	}
	
	public String logoff() throws IOException{
		//loginMB.setGerenciadorConectado(SpringBeans.getBeanGerenciadorConectado());
		//FacesContext.getCurrentInstance().getExternalContext().redirect("view/acesso/login.xhtml");
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
