package br.pucsp.tcc.exception;

public class OperacaoInvalidaException extends Exception
{
    public OperacaoInvalidaException() {
    }
    
    public OperacaoInvalidaException(String mensagem) {
        super(mensagem);
    }
    
    private static final long serialVersionUID = 3346931393239458217L;
}
