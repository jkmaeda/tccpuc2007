package br.pucsp.tcc.gui.gerarIdentificacao;

public class GerarIdentificacao {

	private FactoryLeitorBiometrico factoryLeitorBiometrico = null;
	
	public void gerarIdentificacao(FactoryLeitorBiometrico factoryLeitorBiometrico) {
		this.factoryLeitorBiometrico = factoryLeitorBiometrico;
		LeitorBiometrico leitorBiometrico = factoryLeitorBiometrico.criarLeitorBiometrico(new IdentificarClienteExibir());
		leitorBiometrico.habilitar();
	}
	
}
