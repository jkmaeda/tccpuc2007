package br.pucsp.tcc.infra.leitorbiometrico;

import br.pucsp.tcc.modelo.Identificacao;

public class ImplementacaoVaziaLeitorBiometricoListener implements
		LeitorBiometricoListener {

	public void leituraIdentificacaoFinalizada(Identificacao identificacao) {
		System.out.println("br.pucsp.tcc.infra.leitorbiometrico.ImplementacaoVaziaLeitorBiometricoListener leituraIdentificacaoFinalizada(Identificacao identificacao)");
	}

	public void leituraIdentificacaoIniciada() {
		System.out.println("br.pucsp.tcc.infra.leitorbiometrico.ImplementacaoVaziaLeitorBiometricoListener leituraIdentificacaoIniciada()");
	}

}
