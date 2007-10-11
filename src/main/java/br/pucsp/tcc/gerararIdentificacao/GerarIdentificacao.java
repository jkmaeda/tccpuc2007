package br.pucsp.tcc.gerararIdentificacao;

public class GerarIdentificacao {

	private FactoryLeitorBiometrico factoryLeitorBiometrico = null;
	
	public void gerarIdentificacao(FactoryLeitorBiometrico factoryLeitorBiometrico) {
		this.factoryLeitorBiometrico = factoryLeitorBiometrico;
		LeitorBiometrico leitorBiometrico = factoryLeitorBiometrico.criarLeitorBiometrico(new IdentificarClienteExibir());
		leitorBiometrico.habilitar();
	}
	
}
