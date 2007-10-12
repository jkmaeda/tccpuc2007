package br.pucsp.tcc.gui.cadastrarCliente;

public class FactoryCadastradorClienteIndividual implements
		FactoryCadastradorCliente {

	public CadastrarCliente fabricarCadastradorCliente() {
		CadastrarCliente cadastradorCliente = new CadastradorClienteIndividualImpl();
		return cadastradorCliente;
	}

}
