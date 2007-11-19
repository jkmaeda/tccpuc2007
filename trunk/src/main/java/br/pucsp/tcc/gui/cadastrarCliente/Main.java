package br.pucsp.tcc.gui.cadastrarCliente;

import br.pucsp.tcc.mock.biometria.ImpressaoDigitalMock;
import br.pucsp.tcc.modelo.Identificacao;

class Main {

	public static void main(String[] args) {
		Identificacao identificacao = ImpressaoDigitalMock.digital1;
		CadastramentoCliente cadastradorCliente = FactoryCadastradorCliente.fabricarCadastradorCliente();
		
		cadastradorCliente.setIdentificacao(identificacao);
		cadastradorCliente.solicitarInformacoesUsuario();
	}
}
