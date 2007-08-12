package br.pucsp.tcc.exception;

public class RegistroNaoEncontradoException extends Exception
{
    public RegistroNaoEncontradoException() {
    }
    
    public RegistroNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
    
    private static final long serialVersionUID = 3346931393239458217L;
}
