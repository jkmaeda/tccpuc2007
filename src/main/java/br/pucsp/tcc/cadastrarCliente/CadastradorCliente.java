package br.pucsp.tcc.cadastrarCliente;

import br.pucsp.tcc.modelo.Identificacao;

public interface CadastradorCliente {

	public void setIdentificacao(Identificacao identificacao);
	public void salvarCadastro();
	public void solicitarInformacoesUsuario();
	
}
