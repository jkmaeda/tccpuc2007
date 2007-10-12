package br.pucsp.tcc.gui.gerarIdentificacao;

import br.pucsp.tcc.leitorBiometrico.LeitorBiometricoGui;

public class FactoryLeitorBiometrico {

	public LeitorBiometrico criarLeitorBiometrico(IdentificadorCliente identificadorCliente) {
		return new LeitorBiometricoGui(identificadorCliente);
	}
	
}
