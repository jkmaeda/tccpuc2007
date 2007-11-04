package br.pucsp.tcc.repositorio;

import java.awt.Image;
import java.util.List;

import br.pucsp.tcc.mock.biometria.ImpressaoDigitalMock;
import br.pucsp.tcc.modelo.Cliente;
import br.pucsp.tcc.modelo.ClienteIndividual;
import br.pucsp.tcc.modelo.ImpressaoDigital;
import junit.framework.TestCase;

public class TestRepositorioClienteJDBC extends TestCase 
{
	public void testSavarCliente() throws Exception
	{		
		Image info = ImpressaoDigitalMock.digital1.getInfo();		
		ImpressaoDigital identificacao = new ImpressaoDigital(info);
		
		ClienteIndividual clienteEsperado = new ClienteIndividual();
		
		clienteEsperado.setIdentificacao(identificacao);
		clienteEsperado.setNome("cliente de teste com impressão digital");
		clienteEsperado.setCpf("72226562354");
				
		RepositorioCliente repositorio = new RepositorioClienteJDBC();
		
		int idObtido = repositorio.salvar(clienteEsperado);		
		ClienteIndividual clienteObtido = (ClienteIndividual) repositorio.obterPorId(idObtido);
		
		assertEquals(clienteEsperado.getId(), clienteObtido.getId());
		assertEquals(clienteEsperado.getCpf(), clienteObtido.getCpf());
		
	}
	
	public void testObterClientePorId()
	{
		RepositorioCliente repositorio = new RepositorioClienteJDBC();
		ClienteIndividual clienteObtido = (ClienteIndividual) repositorio.obterPorId(4);
		assertEquals(4, clienteObtido.getId());
	}
	
	public void testObterClientePorNome()
	{
		RepositorioCliente repositorio = new RepositorioClienteJDBC();
		ClienteIndividual clienteObtido = (ClienteIndividual) repositorio.obterPorNome("Fulano");
		assertEquals("Fulano", clienteObtido.getNome());
	}
	
	public void testObterClientes()
	{
		RepositorioCliente repositorio = new RepositorioClienteJDBC();
		List<Cliente> clientesObtidos = repositorio.obterClientes();
		assertTrue(clientesObtidos.size() > 2);
	}
	
	public void testExcluirCliente()
	{
		Image info = ImpressaoDigitalMock.digital1.getInfo();
		ImpressaoDigital identificacao = new ImpressaoDigital(info);
		
		ClienteIndividual cliente = new ClienteIndividual();
		cliente.setNome("cliente de exclusão");
		cliente.setCpf("72226562354");		
		cliente.setIdentificacao(identificacao);
		
		RepositorioCliente repositorio = new RepositorioClienteJDBC();
		
		int idObtido = repositorio.salvar(cliente);
		
		cliente.setId(idObtido);
		
		repositorio.excluir(cliente);
		
		ClienteIndividual cli = (ClienteIndividual) repositorio.obterPorId(idObtido);
		assertNull(cli);
	}
}