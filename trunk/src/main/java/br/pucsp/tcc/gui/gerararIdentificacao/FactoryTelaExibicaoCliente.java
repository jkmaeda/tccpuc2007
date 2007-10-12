package br.pucsp.tcc.gui.gerararIdentificacao;

import br.pucsp.tcc.gui.gerarIdentificacao.impl.ExibicaoClienteGui;

public class FactoryTelaExibicaoCliente {

	public TelaExibicaoCliente fabricarTelaExibicaoCliente() {
		return new ExibicaoClienteGui();
	}
	
}
