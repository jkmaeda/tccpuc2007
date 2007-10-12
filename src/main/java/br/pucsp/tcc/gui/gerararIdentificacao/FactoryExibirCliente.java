package br.pucsp.tcc.gui.gerararIdentificacao;

import br.pucsp.tcc.gui.gerarIdentificacao.impl.ExibicaoClienteGui;

public class FactoryExibirCliente {

	public TelaExibicaoCliente criarTelaExibicaoCliente() {
		return new ExibicaoClienteGui();
	}
	
}
