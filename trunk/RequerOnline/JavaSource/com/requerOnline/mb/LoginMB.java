package com.requerOnline.mb;

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
public class LoginMB {
	private GerenciadorConectado gerenciadorConectado;
	private Boolean errouAutenticacao = false;
	private Boolean logou;
	private ServiceDelegate delegate;
	
	@PostConstruct
	public void iniciar(){
		gerenciadorConectado = SpringBeans.getBeanGerenciadorConectado();
	}
	
	public String logar() throws InterruptedException {
		String pagina = "login";
		delegate = new ServiceDelegateImpl();
		gerenciadorConectado = delegate.getLoginService().getGerenciadorLogado(
				gerenciadorConectado.getGerenciador());
		FacesMessage msg = new FacesMessage();
		if(gerenciadorConectado != null){
			msg.setSummary("Benvindo à página inicial");
			pagina = "index";
			
		}else{
			msg.setSummary("Login ou senha incorretos");
			errouAutenticacao = true;
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
		iniciar();
		return pagina;
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
