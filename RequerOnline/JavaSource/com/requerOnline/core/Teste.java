package com.requerOnline.core;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.requerOnline.dao.ConnectionFactory;

public class Teste {

	public static void main(String[] args) {
		EntityManager em = ConnectionFactory.getManagerFactory();
		
		/*Endereco e = new Endereco();
		e.setBairro("Centro");
		e.setCidade("Lagoa de Itaenga");
		e.setNum("99");
		e.setRua("Rua 1");
		e.setId(1L);
		
		Requerente r = new Requerente();
		r.setCpf("485.267.887-10");
		r.setEmail("fabio@gmail.com");
		r.setEndereco(e);
		r.setFuncao("Agente Administrativo");
		r.setMatricula("6878");
		r.setNacionalidade("Barsileiro");
		r.setNome("Lopes");
		r.setRg("13111579-2");
		r.setSecretaria("Sem lotação");
		r.setSenha("98898797");
		r.setSetor("Nenhum");
		r.setTelefone("(99) 9999-7526");
		r.setVinculo("Estatutário");
		
		Secretario s = new Secretario();
		s.setMatricula("1111");
		s.setCpf("485.267.887-10");
		s.setNome("Lopes");
		s.setSenha("11111111");
		s.setEmail("fabio@gmail.com");
		s.setSecretaria("Adm");
		
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
		
		
		
		
		
		Query q = em.createQuery("select object (s) from Secretario s");
		@SuppressWarnings({ "unused", "unchecked" })
		List<Secretario> secretarios = q.getResultList();
		System.out.println();*/
	}
}
