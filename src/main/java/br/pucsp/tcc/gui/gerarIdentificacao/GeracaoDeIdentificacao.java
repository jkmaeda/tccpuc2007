package br.pucsp.tcc.gui.gerarIdentificacao;

import br.pucsp.tcc.infra.leitorbiometrico.LeitorBiometricoListener;

public interface GeracaoDeIdentificacao {

	public void gerarIdentificacao(LeitorBiometricoListener listener);
	
}