package br.pucsp.tcc.exception;

public class IdentificacaoInvalidaException extends Exception
{
    public IdentificacaoInvalidaException() {
    }
    
    public IdentificacaoInvalidaException(String mensagem) {
        super(mensagem);
    }
    
    private static final long serialVersionUID = 3346931393239458217L;
}
