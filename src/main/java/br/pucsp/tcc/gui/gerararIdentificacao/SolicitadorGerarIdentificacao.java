package br.pucsp.tcc.gui.gerararIdentificacao;

public class SolicitadorGerarIdentificacao {
	
	public static void main(String[] args) {
		GerarIdentificacao gerarIdentificacao = new GerarIdentificacao();
		gerarIdentificacao.gerarIdentificacao(new FactoryLeitorBiometrico());
	}
	
}