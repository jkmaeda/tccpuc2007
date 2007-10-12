package br.pucsp.tcc.gui.cadastrarCliente;

public class FactoryCadastradorClienteIndividual implements
		FactoryCadastradorCliente {

	public CadastradorCliente fabricarCadastradorCliente() {
		CadastradorCliente cadastradorCliente = new CadastradorClienteIndividualImpl();
		return cadastradorCliente;
	}

}
