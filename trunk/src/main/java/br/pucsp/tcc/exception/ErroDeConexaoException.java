package br.pucsp.tcc.exception;

public class ErroDeConexaoException extends Exception
{   
	private static final long serialVersionUID = 7391770095007538970L;

	public ErroDeConexaoException() {
    }
    
    public ErroDeConexaoException(String mensagem) {
        super(mensagem);
    }
}
