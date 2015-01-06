package com.requerOnline.serviceImpl;

import java.util.HashMap;
import java.util.Map;

import com.requerOnline.core.Gerenciador;
import com.requerOnline.core.GerenciadorConectado;
import com.requerOnline.daoImpl.GerenciadorDAO;
import com.requerOnline.service.LoginService;

public class LoginServiceImpl implements LoginService{

	@Override
	public GerenciadorConectado getGerenciadorLogado(Gerenciador gerenciador) {
		Map<String, Object> dados = new HashMap<String, Object>();
		dados.put("matricula", gerenciador.getMatricula());
		dados.put("senha", gerenciador.getSenha());
		
		GerenciadorDAO dao = new GerenciadorDAO();
		return dao.logar(dados);
	}



}
