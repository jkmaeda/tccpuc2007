package br.pucsp.tcc.gerararIdentificacao;

import br.pucsp.tcc.gerarIdentificacaoGui.ExibicaoClienteGui;

public class FactoryExibirCliente {

	public TelaExibicaoCliente criarTelaExibicaoCliente() {
		return new ExibicaoClienteGui();
	}
	
}
