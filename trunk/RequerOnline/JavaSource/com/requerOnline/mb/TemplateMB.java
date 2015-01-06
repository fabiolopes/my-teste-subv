package com.requerOnline.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class TemplateMB {

	@ManagedProperty(value="#{loginMB}")
	private LoginMB loginMB;
	

}
