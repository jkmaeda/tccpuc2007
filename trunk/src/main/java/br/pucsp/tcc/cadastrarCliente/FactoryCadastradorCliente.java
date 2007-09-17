package br.pucsp.tcc.cadastrarCliente;

public class FactoryCadastradorCliente {

	public CadastradorCliente fabricarCadastradorClienteMesa() {
		return new CadastradorClienteMesaImpl(this);
	}
	
	public CadastradorCliente fabricarCadastradorClienteIndividual() {
		return new CadastradorClienteIndividualImpl();
	}
}
