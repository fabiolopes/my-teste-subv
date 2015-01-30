package com.requerOnline.serviceImpl;

import com.requerOnline.core.Requerente;
import com.requerOnline.daoImpl.RequerenteDAO;
import com.requerOnline.service.CadastroRequerenteService;

public class CadastroRequerenteServiceImpl implements CadastroRequerenteService {

	@Override
	public void salvar(Requerente requerente) {
		RequerenteDAO dao = new RequerenteDAO();
		dao.inserir(requerente);

	}

}
