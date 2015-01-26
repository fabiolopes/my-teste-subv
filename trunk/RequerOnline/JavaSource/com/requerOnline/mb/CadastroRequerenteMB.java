package com.requerOnline.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.requerOnline.util.enums.VinculoTypes;

@ManagedBean
@SessionScoped
public class CadastroRequerenteMB {

	
	
	
	
	
	public VinculoTypes[] getVinculoTypes(){
		return VinculoTypes.values();
	}
	public CadastroRequerenteMB() {
		// TODO Auto-generated constructor stub
	}

}
