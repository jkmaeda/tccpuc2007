package br.pucsp.tcc.gui.cadastrarCliente;

import br.pucsp.tcc.modelo.Identificacao;

public class CadastradorCliente {

	private FactoryCadastradorCliente factoryCadastradorCliente;

	public CadastradorCliente(FactoryCadastradorCliente factoryCadastradorCliente) {
		this.factoryCadastradorCliente = factoryCadastradorCliente;
	}
	
	public void cadastrar(Identificacao identificacao) {
		CadastrarCliente cadastradorCliente = factoryCadastradorCliente.fabricarCadastradorCliente();
		cadastradorCliente.setIdentificacao(identificacao);
		cadastradorCliente.solicitarInformacoesUsuario();
	}
	
}
