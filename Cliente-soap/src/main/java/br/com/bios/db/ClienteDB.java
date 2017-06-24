package br.com.bios.db;

import java.util.ArrayList;
import java.util.Arrays;

import br.com.bios.model.Cliente;

public class ClienteDB {
	public ArrayList<Cliente> listar(){
		ArrayList<Cliente> list = new ArrayList<>(Arrays.asList(new Cliente[]{new Cliente(001, "Cli1"), new Cliente(002, "Cli2")}));
		return list;
	}
}
