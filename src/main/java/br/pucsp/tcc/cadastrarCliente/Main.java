package br.pucsp.tcc.cadastrarCliente;

import br.pucsp.tcc.modelo.Identificacao;
import br.pucsp.tcc.modelo.ImpressaoDigital;

class Main {

	public static void main(String[] args) {
		FactoryCadastradorCliente factoryCadastradorCliente = new FactoryCadastradorClienteIndividual();
		Identificacao identificacao = new ImpressaoDigital("123");
		CadastrarCliente cadastrarCliente = new CadastrarCliente(factoryCadastradorCliente);
		cadastrarCliente.cadastrar(identificacao);
	}
}
