package br.pucsp.tcc.modelo;

public enum TipoCliente 
{
	INDIVIDUAL(1), 
	MESA(2);
	
	private int tipo;
	
	private TipoCliente(int _tipo) {
		tipo = _tipo;
	}
	
	public int getTipo() {
		return tipo;
	}
}
