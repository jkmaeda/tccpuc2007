package br.pucsp.tcc.cadastrarCliente;

import br.pucsp.tcc.CadastrarClienteGui.CadastrarClienteGui;

public class CadastrarCliente implements CadastradorCliente {

	private FactoryCadastradorCliente factoryCadastradorCliente;

	public CadastrarCliente(FactoryCadastradorCliente factoryCadastradorCliente) {
		this.factoryCadastradorCliente = factoryCadastradorCliente;
	}
	
	public void cadastrarCliente() {
		new CadastrarClienteGui(factoryCadastradorCliente);
	}
	
}
