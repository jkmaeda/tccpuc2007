package br.pucsp.tcc.gui.gerarIdentificacao;

import br.pucsp.tcc.gui.gerarIdentificacao.impl.ExibicaoClienteGui;

public class FactoryTelaExibicaoCliente {

	public TelaExibicaoCliente fabricarTelaExibicaoCliente() {
		return new ExibicaoClienteGui();
	}
	
}
