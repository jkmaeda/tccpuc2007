package br.pucsp.tcc.gerararIdentificacao;

import br.pucsp.tcc.leitorBiometrico.LeitorBiometricoGui;

public class FactoryLeitorBiometrico {

	public LeitorBiometrico criarLeitorBiometrico(IdentificadorCliente identificadorCliente) {
		return new LeitorBiometricoGui(identificadorCliente);
	}
	
}
