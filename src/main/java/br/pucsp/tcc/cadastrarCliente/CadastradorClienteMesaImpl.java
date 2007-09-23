package br.pucsp.tcc.cadastrarCliente;

import br.pucsp.tcc.cadastrarClienteGui.CadastrarClienteMesaGui;

public class CadastradorClienteMesaImpl implements CadastradorCliente {

	private FactoryCadastradorCliente factoryCadastradorCliente;

	public CadastradorClienteMesaImpl(FactoryCadastradorCliente factoryCadastradorCliente) {
		this.factoryCadastradorCliente = factoryCadastradorCliente;
	}
	
	public void cadastrarCliente() {
		new CadastrarClienteMesaGui(factoryCadastradorCliente);
	}

}
