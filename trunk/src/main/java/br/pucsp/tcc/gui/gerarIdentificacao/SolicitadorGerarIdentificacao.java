package br.pucsp.tcc.gui.gerarIdentificacao;

public class SolicitadorGerarIdentificacao {
	
	public static void main(String[] args) {
		GerarIdentificacao gerarIdentificacao = new GerarIdentificacao();
		gerarIdentificacao.gerarIdentificacao(new FactoryLeitorBiometrico());
	}
	
}