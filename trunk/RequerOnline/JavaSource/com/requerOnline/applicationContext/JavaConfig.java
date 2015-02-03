package com.requerOnline.applicationContext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.requerOnline.core.Administrador;
import com.requerOnline.core.Anexo;
import com.requerOnline.core.Endereco;
import com.requerOnline.core.Funcionario;
import com.requerOnline.core.Gerenciador;
import com.requerOnline.core.GerenciadorConectado;
import com.requerOnline.core.Requerente;
import com.requerOnline.core.Requerimento;
import com.requerOnline.core.Secretario;

@Configuration
public class JavaConfig {

	@Bean
	public Administrador administrador(){
		return new Administrador();
	}
	
	@Bean
	public Anexo anexo(){
		return new Anexo();
	}
	
	@Bean
	public Endereco endereco(){
		return new Endereco();
	}
	
	@Bean
	public Gerenciador gerenciador(){
		return new Gerenciador();
	}
	
	@Bean
	public GerenciadorConectado gerenciadorConectado(){
		return new GerenciadorConectado();
	}
	
	@Bean
	public Requerente requerente(){
		return new Requerente();
	}
	
	@Bean
	public Requerimento requerimento(){
		return new Requerimento();
	}
	
	@Bean
	public Secretario secretario(){
		return new Secretario();
	}

}
