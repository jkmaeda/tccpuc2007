package br.pucsp.tcc.cadastrarCliente;

public class FactoryCadastradorClienteIndividual implements
		FactoryCadastradorCliente {

	public CadastradorCliente fabricarCadastradorCliente() {
		CadastradorCliente cadastradorCliente = new CadastradorClienteIndividualImpl();
		return cadastradorCliente;
	}

}
