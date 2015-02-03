package com.requerOnline.applicationContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.requerOnline.core.Administrador;
import com.requerOnline.core.Anexo;
import com.requerOnline.core.Endereco;
import com.requerOnline.core.GerenciadorConectado;
import com.requerOnline.core.Requerente;
import com.requerOnline.core.Requerimento;
import com.requerOnline.core.Secretario;

//Classe geradora das instâncias de todos os beans da aplicação
public class SpringBeans {

	private static Administrador administrador;
	private static Anexo anexo;
	private static Endereco endereco;
	private static GerenciadorConectado gerenciadorConectado;
	private static Requerente requerente;
	private static Requerimento requerimento;
	private static Secretario secretario;
	private static ApplicationContext applicationContext;

	private static void getApplicationContext() {
		if (applicationContext == null) {
			applicationContext = new AnnotationConfigApplicationContext(JavaConfig.class);
		}
	}

	public static Administrador getBeanAdministrador() {
		if (administrador == null) {
			getApplicationContext();
			administrador = (Administrador) applicationContext
					.getBean("Administrador");
		}
		return administrador;
	}

	public static Anexo getBeanAnexo() {
		if (anexo == null) {
			getApplicationContext();
			anexo = (Anexo) applicationContext.getBean("Anexo");
		}
		return anexo;
	}

	public static Endereco getBeanEndereco() {
		if (endereco == null) {
			getApplicationContext();
			endereco = (Endereco) applicationContext.getBean("Endereco");
		}
		return endereco;
	}

	public static GerenciadorConectado getBeanGerenciadorConectado() {
		if (gerenciadorConectado == null) {
			getApplicationContext();
			gerenciadorConectado = (GerenciadorConectado) applicationContext
					.getBean("gerenciadorConectado");
		}
		return gerenciadorConectado;
	}
	
	public static Requerente getBeanRequerente(){
		if(requerente == null){
			getApplicationContext();
			requerente = (Requerente) applicationContext.getBean("requerente");
		}
		return requerente;
	}
	
	public static Requerimento getBeanRequerimento(){
		if(requerimento == null){
			getApplicationContext();
			requerimento = (Requerimento) applicationContext.getBean("Requerimento");
		}
		return requerimento;
	}
	
	public static Secretario getBeanSecretario(){
		if(secretario == null){
			getApplicationContext();
			secretario = (Secretario) applicationContext.getBean("Secretario");
		}
		return secretario;
	}

}
