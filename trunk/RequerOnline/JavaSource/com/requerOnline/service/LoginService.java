package com.requerOnline.service;

import com.requerOnline.core.Gerenciador;
import com.requerOnline.core.GerenciadorConectado;

public interface LoginService {

	public GerenciadorConectado getGerenciadorLogado(Gerenciador gerenciador);
	
	public void desconectarGerenciadorLogado(GerenciadorConectado gerenciadorConectado);
	
}
