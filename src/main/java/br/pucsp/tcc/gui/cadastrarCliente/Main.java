package br.pucsp.tcc.gui.cadastrarCliente;

import br.pucsp.tcc.mock.biometria.ImpressaoDigitalMock;
import br.pucsp.tcc.modelo.Identificacao;

class Main {

	public static void main(String[] args) {
		FactoryCadastradorCliente factoryCadastradorCliente = new FactoryCadastradorClienteIndividual();
		Identificacao identificacao = ImpressaoDigitalMock.digital1;
		CadastradorCliente cadastrarCliente = new CadastradorCliente(factoryCadastradorCliente);
		cadastrarCliente.cadastrar(identificacao);
	}
}
