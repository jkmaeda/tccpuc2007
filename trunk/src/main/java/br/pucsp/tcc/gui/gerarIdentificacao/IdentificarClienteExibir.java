package br.pucsp.tcc.gui.gerarIdentificacao;

import java.util.Vector;

import br.pucsp.tcc.gui.cadastrarCliente.CadastrarCliente;
import br.pucsp.tcc.gui.cadastrarCliente.CadastradorClienteIndividualImpl;
import br.pucsp.tcc.mock.biometria.ImpressaoDigitalMock;
import br.pucsp.tcc.modelo.Cliente;
import br.pucsp.tcc.modelo.ClienteIndividual;
import br.pucsp.tcc.modelo.ImpressaoDigital;
import br.pucsp.tcc.repositorio.FabricaRepositorio;
import br.pucsp.tcc.repositorio.RepositorioCliente;

public class IdentificarClienteExibir implements IdentificadorCliente {

	private static Vector<ClienteIndividual> bancoDeDados = new Vector<ClienteIndividual>();
	private Cliente cliente = null;
	private FactoryTelaExibicaoCliente factoryTelaExibicao;
	private TelaExibicaoCliente telaExibicaoCliente = null;
	private RepositorioCliente repositorioCliente;
	
	public IdentificarClienteExibir() {
		FabricaRepositorio fabrica = new FabricaRepositorio();
		repositorioCliente = fabrica.getRepCliente();
		factoryTelaExibicao = new FactoryTelaExibicaoCliente();
		telaExibicaoCliente = factoryTelaExibicao.fabricarTelaExibicaoCliente();
		ClienteIndividual clienteIndividual = new ClienteIndividual();
		clienteIndividual.setIdentificacao(ImpressaoDigitalMock.digital1);
		clienteIndividual.setNome("Mark");
		bancoDeDados.add(clienteIndividual);
	}
	
	public void identificarCliente(String codigoBiometrico)
	{
		cliente = repositorioCliente.obterPorId(Integer.parseInt(codigoBiometrico));
		
		CadastrarCliente cadastradorCliente = new CadastradorClienteIndividualImpl();
		cadastradorCliente.setCliente(cliente);		
		cadastradorCliente.setIdentificacao(ImpressaoDigitalMock.digital1);
		cadastradorCliente.solicitarInformacoesUsuario();		
	}
	
	public void exibirCliente() {
		telaExibicaoCliente.exibirCliente(cliente);
	}
	
	public class MyCliente {
		
		private String codigo = null;
		
		public MyCliente(String codigo) {
			this.codigo = codigo;
		}
		
		public String getCodigo() {
			return codigo;
		}
		
		@Override
		public boolean equals(Object obj) {
			if(obj instanceof ClienteIndividual) {
				
				ClienteIndividual cliente = (ClienteIndividual)obj;
				ImpressaoDigital id = (ImpressaoDigital)cliente.getIdentificacao(); 
				if(id.getInfo().equals(codigo)) {
					return true;
				}
			}
			return false;
		}
	}

}
