package br.com.sgst.core;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;

@Entity
public class Empresa {

	private int id;
	
	private String nome;
	
	private String cnpj;
	
	private Date dtVencPPRA;
	
	private Date dtVencPCMSO;
	
	private Date dtVencLTCAT;
	
	private boolean ppraEmDia;
	
	private boolean pcmsoEmDia;
	
	private boolean ltcatEmDia;
	
	private List<Funcionario> funcionarios;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Date getDtVencPPRA() {
		return dtVencPPRA;
	}

	public void setDtVencPPRA(Date dtVencPPRA) {
		this.dtVencPPRA = dtVencPPRA;
	}

	public Date getDtVencPCMSO() {
		return dtVencPCMSO;
	}

	public void setDtVencPCMSO(Date dtVencPCMSO) {
		this.dtVencPCMSO = dtVencPCMSO;
	}

	public Date getDtVencLTCAT() {
		return dtVencLTCAT;
	}

	public void setDtVencLTCAT(Date dtVencLTCAT) {
		this.dtVencLTCAT = dtVencLTCAT;
	}

	public boolean isPpraEmDia() {
		return ppraEmDia;
	}

	public void setPpraEmDia(boolean ppraEmDia) {
		this.ppraEmDia = ppraEmDia;
	}

	public boolean isPcmsoEmDia() {
		return pcmsoEmDia;
	}

	public void setPcmsoEmDia(boolean pcmsoEmDia) {
		this.pcmsoEmDia = pcmsoEmDia;
	}

	public boolean isLtcatEmDia() {
		return ltcatEmDia;
	}

	public void setLtcatEmDia(boolean ltcatEmDia) {
		this.ltcatEmDia = ltcatEmDia;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	
}
