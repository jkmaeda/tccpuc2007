package br.pucsp.tcc.gui.fecharConta;

import br.pucsp.tcc.mock.biometria.ImpressaoDigitalMock;
import br.pucsp.tcc.modelo.Identificacao;

public class MainFecharConta {

	public static void main(String[] args) {
		FechamentoDeConta conta = new FechadorDeConta();
		Identificacao identificacao = ImpressaoDigitalMock.digital1;
		conta.solicitarConfirmacaoFechamentoConta(identificacao);
	}
	
}
