package br.pucsp.tcc.repositorio;

import junit.framework.TestCase;
import br.pucsp.tcc.modelo.Identificacao;
import br.pucsp.tcc.modelo.NumeroMesa;

public class TestRepositorioNumeroMesaJDBC extends TestCase{
	
	public void testObterIdentificacao() throws Exception {		
		RepositorioIdentificacao repositorio = new RepositorioNumeroMesaJDBC();
		int idEsperado = 22;		
		NumeroMesa identificacao = (NumeroMesa) repositorio.obterIdentificacao(idEsperado);		
		assertEquals(idEsperado, identificacao.getNumero());
	}
	
	public void testExisteIdentificacao() throws Exception {
		RepositorioIdentificacao repositorio = new RepositorioNumeroMesaJDBC();		
		Identificacao id = new NumeroMesa(22);
		boolean existeIdEsperado = true;
		boolean existeIdObtido = repositorio.existeIdentificacao(id);		
		assertEquals(existeIdEsperado, existeIdObtido);
	}
	
	public void testSalvarIdentificacao() {
		RepositorioIdentificacao repositorio = new RepositorioNumeroMesaJDBC();		
		Identificacao id = new NumeroMesa(50);		
		repositorio.salvar(id);
		boolean valorEsperado = true;
		boolean valorObtido = repositorio.existeIdentificacao(id);
		assertEquals(valorEsperado, valorObtido);	
	}
	
	public void testExcluirIdentificacao() {
		RepositorioIdentificacao repositorio = new RepositorioNumeroMesaJDBC();		
		Identificacao id = new NumeroMesa(50);	
		repositorio.excluir(id);
		boolean valorEsperado = false;
		boolean valorObtido = repositorio.existeIdentificacao(id);
		assertEquals(valorEsperado, valorObtido);
	}
}
