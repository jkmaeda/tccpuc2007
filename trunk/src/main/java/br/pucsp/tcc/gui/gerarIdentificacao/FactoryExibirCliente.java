package br.pucsp.tcc.gui.gerarIdentificacao;

import br.pucsp.tcc.gui.gerarIdentificacao.impl.ExibicaoClienteGui;

public class FactoryExibirCliente {

	public TelaExibicaoCliente criarTelaExibicaoCliente() {
		return new ExibicaoClienteGui();
	}
	
}
