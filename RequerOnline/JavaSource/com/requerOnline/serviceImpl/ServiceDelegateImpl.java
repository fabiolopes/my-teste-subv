package com.requerOnline.serviceImpl;

import com.requerOnline.service.LoginService;
import com.requerOnline.service.ServiceDelegate;

public class ServiceDelegateImpl implements ServiceDelegate{

	@Override
	public LoginService getLoginService() {
		return (LoginService) new LoginServiceImpl();
	}	

}
