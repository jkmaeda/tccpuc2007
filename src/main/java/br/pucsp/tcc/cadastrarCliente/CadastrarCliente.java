package br.pucsp.tcc.cadastrarCliente;

import br.pucsp.tcc.modelo.Identificacao;

public class CadastrarCliente {

	private FactoryCadastradorCliente factoryCadastradorCliente;

	public CadastrarCliente(FactoryCadastradorCliente factoryCadastradorCliente) {
		this.factoryCadastradorCliente = factoryCadastradorCliente;
	}
	
	public void cadastrar(Identificacao identificacao) {
		CadastradorCliente cadastradorCliente = factoryCadastradorCliente.fabricarCadastradorCliente();
		cadastradorCliente.setIdentificacao(identificacao);
		cadastradorCliente.solicitarInformacoesUsuario();
	}
	
}
