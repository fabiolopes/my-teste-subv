package br.com.bios.rn;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import br.com.bios.db.ClienteDB;
import br.com.bios.model.ListaCliente;

@WebService
@SOAPBinding(style=Style.RPC)
public class ClienteRN {
	private ClienteDB clienteDB;
	
	public ClienteRN() {
		clienteDB = new ClienteDB();
	}

	@WebMethod(operationName="listar")
	@WebResult(name="ListaCliente")
	public ListaCliente listar(){
		ListaCliente listaCliente = new ListaCliente();
		listaCliente.setResponseCode("0");
		listaCliente.setClientes(clienteDB.listar());
		return listaCliente;
	}
	
}
