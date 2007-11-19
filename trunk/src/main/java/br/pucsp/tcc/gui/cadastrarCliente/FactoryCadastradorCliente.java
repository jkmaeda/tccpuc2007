package br.pucsp.tcc.gui.cadastrarCliente;

public class FactoryCadastradorCliente {

	private FactoryCadastradorCliente() {}
	
	public static CadastramentoCliente fabricarCadastradorCliente() {
		CadastramentoCliente cadastradorCliente = new CadastradorClienteIndividualImpl();
		return cadastradorCliente;
	}

}
