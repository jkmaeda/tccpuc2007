package br.pucsp.tcc.gerararIdentificacao;

import br.pucsp.tcc.gerarIdentificacaoGui.ExibicaoClienteGui;

public class FactoryTelaExibicaoCliente {

	public TelaExibicaoCliente fabricarTelaExibicaoCliente() {
		return new ExibicaoClienteGui();
	}
	
}
