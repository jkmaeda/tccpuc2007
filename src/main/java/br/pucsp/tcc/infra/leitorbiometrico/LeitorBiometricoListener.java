package br.pucsp.tcc.infra.leitorbiometrico;

import br.pucsp.tcc.modelo.Identificacao;

public interface LeitorBiometricoListener
{
	void leituraIdentificacaoIniciada();
	
	void leituraIdentificacaoFinalizada(Identificacao identificacao);
	
}
