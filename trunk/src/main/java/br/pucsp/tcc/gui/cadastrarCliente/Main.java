package br.pucsp.tcc.gui.cadastrarCliente;

import br.pucsp.tcc.modelo.Identificacao;
import br.pucsp.tcc.modelo.ImpressaoDigital;

class Main {

	public static void main(String[] args) {
		FactoryCadastradorCliente factoryCadastradorCliente = new FactoryCadastradorClienteIndividual();
		Identificacao identificacao = new ImpressaoDigital("123");
		CadastradorCliente cadastrarCliente = new CadastradorCliente(factoryCadastradorCliente);
		cadastrarCliente.cadastrar(identificacao);
	}
}
