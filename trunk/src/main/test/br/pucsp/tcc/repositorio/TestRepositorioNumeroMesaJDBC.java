package br.pucsp.tcc.repositorio;

import junit.framework.TestCase;
import br.pucsp.tcc.modelo.NumeroMesa;

public class TestRepositorioNumeroMesaJDBC extends TestCase{
	
	public void testObterIdentificacao() throws Exception {		
		RepositorioIdentificacao repositorio = new RepositorioNumeroMesaJDBC();
		int idEsperado = 22;		
		NumeroMesa identificacao = (NumeroMesa) repositorio.obterIdentificacao(idEsperado);		
		assertEquals(idEsperado, identificacao.getNumero());
	}
}
