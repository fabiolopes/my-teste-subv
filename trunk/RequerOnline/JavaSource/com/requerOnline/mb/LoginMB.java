package com.requerOnline.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.requerOnline.applicationContext.SpringBeans;
import com.requerOnline.core.Gerenciador;
import com.requerOnline.core.GerenciadorConectado;
import com.requerOnline.core.Secretario;
import com.requerOnline.service.ServiceDelegate;
import com.requerOnline.serviceImpl.ServiceDelegateImpl;
import com.requerOnline.util.enums.PerfilTypes;

@ManagedBean
@SessionScoped
public class LoginMB {
	Secretario s = new Secretario();
	private GerenciadorConectado gerenciadorConectado = new GerenciadorConectado();
	private Boolean logou;
	private ServiceDelegate delegate;
	
	public LoginMB(){
		gerenciadorConectado.setGerenciador(s);
	}

	// De acordo com o perfil selecionado na tela, a instância de gerenciador
	// será determinada
	public void instanciarTipoGerenciador() {
		if (PerfilTypes.ADMINISTRADOR.equals(gerenciadorConectado
				.getGerenciador().getPerfil())) {
			gerenciadorConectado.setGerenciador(SpringBeans
					.getBeanAdministrador());
		} else if (PerfilTypes.SECRETARIO.equals(gerenciadorConectado
				.getGerenciador().getPerfil())) {
			gerenciadorConectado
					.setGerenciador(SpringBeans.getBeanSecretario());
		}
	}

	public void logar() {
		instanciarTipoGerenciador();
		delegate = new ServiceDelegateImpl();
		gerenciadorConectado = delegate.getLoginService().getGerenciadorLogado(
				gerenciadorConectado.getGerenciador());
		if(gerenciadorConectado.getDataHoraLogin() != null){
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
