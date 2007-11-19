package br.pucsp.tcc.gui.fecharConta;

import br.pucsp.tcc.modelo.Identificacao;

public interface FechamentoDeConta {

	public void solicitarConfirmacaoFechamentoConta(Identificacao identificacao);
	
	public void fecharConta();
	
}
