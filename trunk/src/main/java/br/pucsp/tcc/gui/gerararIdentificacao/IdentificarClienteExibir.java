package br.pucsp.tcc.gui.gerararIdentificacao;

import java.util.Vector;

import br.pucsp.tcc.gui.cadastrarCliente.CadastrarCliente;
import br.pucsp.tcc.gui.cadastrarCliente.CadastradorClienteIndividualImpl;
import br.pucsp.tcc.modelo.Cliente;
import br.pucsp.tcc.modelo.ClienteIndividual;
import br.pucsp.tcc.modelo.Identificacao;
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
		clienteIndividual.setIdentificacao(new ImpressaoDigital("1234"));
		clienteIndividual.setNome("Mark");
		bancoDeDados.add(clienteIndividual);
	}
	
	public void identificarCliente(String codigoBiometrico) {
		cliente = repositorioCliente.obterPorId(Integer.parseInt(codigoBiometrico));
		
		CadastrarCliente cadastradorCliente = new CadastradorClienteIndividualImpl();
		cadastradorCliente.setCliente(cliente);
		cadastradorCliente.setIdentificacao(new ImpressaoDigital(codigoBiometrico));
		cadastradorCliente.solicitarInformacoesUsuario();
		
//		MyCliente clienteFalso = new MyCliente(codigoBiometrico);
//		if(bancoDeDados.contains(clienteFalso)) {
//			for(ClienteIndividual cli: bancoDeDados) {
//				if(clienteFalso.equals(cli)) {
//					cliente = cli;
//					exibirCliente();
//				}
//			}
//		}
//		else {
//			System.out.println("cliente não encontrado");
//		}
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
