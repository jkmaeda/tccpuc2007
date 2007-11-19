package br.pucsp.tcc.exception;

public class ClienteNaoEncontrado extends Exception {

	private static final long serialVersionUID = -1380364679649432537L;

	public ClienteNaoEncontrado() {
    }

	public ClienteNaoEncontrado(String mensagem) {
        super(mensagem);
    }
	
}
