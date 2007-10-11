package br.pucsp.tcc.gerarIdentificacaoGui;

import br.pucsp.tcc.gerararIdentificacao.TelaExibicaoCliente;
import br.pucsp.tcc.modelo.Cliente;

public class ExibicaoClienteGui implements TelaExibicaoCliente {

	public void exibirCliente(Cliente cliente) {
		System.out.println(cliente);
	}

}
