package br.pucsp.tcc.infra.leitorbiometrico;

public interface LeitorBiometrico
{
	/**
	 * Inicializa o leitor biométrico caso ele ainda não esteja iniciado.
	 */
	public void setListener(LeitorBiometricoListener listener);
	public void iniciar(LeitorBiometricoListener listener) throws Exception;
	
	/**
	 * Libera os recursos alocados pelo leitor biométrico.
	 */
	public void finalizar() throws Exception;
	
}
