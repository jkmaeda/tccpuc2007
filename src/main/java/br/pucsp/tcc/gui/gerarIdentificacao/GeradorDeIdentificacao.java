package br.pucsp.tcc.gui.gerarIdentificacao;

import br.pucsp.tcc.infra.leitorbiometrico.LeitorBiometrico;
import br.pucsp.tcc.infra.leitorbiometrico.LeitorBiometricoListener;
import br.pucsp.tcc.infra.leitorbiometrico.griaule.LeitorMicrosoft;
import br.pucsp.tcc.modelo.Identificacao;

public class GeradorDeIdentificacao implements GeracaoDeIdentificacao, LeitorBiometricoListener {

	private LeitorBiometrico leitor;
	private LeitorBiometricoListener listener;

	public void gerarIdentificacao(LeitorBiometricoListener listener) {
		this.listener = listener;
		inicializarLeitor();
	}
	
	private void inicializarLeitor() {
//		leitor = new LeitorMicrosoft();
		try {
			leitor.iniciar(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void leituraIdentificacaoFinalizada(Identificacao identificacao) {
		listener.leituraIdentificacaoFinalizada(identificacao);
	}

	public void leituraIdentificacaoIniciada() {
		
	}

}
