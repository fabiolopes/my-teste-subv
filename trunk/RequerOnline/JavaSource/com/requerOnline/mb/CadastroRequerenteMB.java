package com.requerOnline.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.requerOnline.applicationContext.SpringBeans;
import com.requerOnline.core.Requerente;
import com.requerOnline.service.ServiceDelegate;
import com.requerOnline.serviceImpl.ServiceDelegateImpl;
import com.requerOnline.util.enums.EstadoTypes;
import com.requerOnline.util.enums.VinculoTypes;

@ManagedBean
@SessionScoped
public class CadastroRequerenteMB {
	
	private ServiceDelegate delegate;
	private Requerente requerente;
	
	public CadastroRequerenteMB(){
		this.requerente = SpringBeans.getBeanRequerente();
	}
	
	public void salvar(){
		delegate = new ServiceDelegateImpl();
		delegate.getCadastroRequerenteService().salvar(requerente);
	}
	
	
	public VinculoTypes[] getVinculoTypes(){
		return VinculoTypes.values();
	}
	
	public EstadoTypes[] getEstadoTypes(){
		return EstadoTypes.values();
	}

	public Requerente getRequerente() {
		return requerente;
	}

	public void setRequerente(Requerente requerente) {
		this.requerente = requerente;
	}

	public ServiceDelegate getDelegate() {
		return delegate;
	}

	public void setDelegate(ServiceDelegate delegate) {
		this.delegate = delegate;
	}

}
