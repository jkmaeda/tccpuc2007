package br.pucsp.tcc.gui.gerarIdentificacao.impl;

import br.pucsp.tcc.gui.gerarIdentificacao.TelaExibicaoCliente;
import br.pucsp.tcc.modelo.Cliente;

public class ExibicaoClienteGui implements TelaExibicaoCliente {

	public void exibirCliente(Cliente cliente) {
		System.out.println(cliente);
	}

}
