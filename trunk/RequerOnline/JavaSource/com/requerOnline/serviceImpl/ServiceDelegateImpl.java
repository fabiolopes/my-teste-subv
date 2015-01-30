package com.requerOnline.serviceImpl;

import java.io.Serializable;

import com.requerOnline.service.CadastroRequerenteService;
import com.requerOnline.service.LoginService;
import com.requerOnline.service.ServiceDelegate;

public class ServiceDelegateImpl implements ServiceDelegate, Serializable{

	private static final long serialVersionUID = 1L;

	@Override
	public LoginService getLoginService() {
		return (LoginService) new LoginServiceImpl();
	}

	@Override
	public CadastroRequerenteService getCadastroRequerenteService() {
		return (CadastroRequerenteService) new CadastroRequerenteServiceImpl();
	}	

}
