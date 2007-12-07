package br.pucsp.tcc.gui.registrarPedido;

import javax.swing.JOptionPane;

import br.pucsp.tcc.infra.leitorbiometrico.LeitorBiometricoListener;
import br.pucsp.tcc.modelo.ClienteIndividual;
import br.pucsp.tcc.modelo.Identificacao;
import br.pucsp.tcc.modelo.ImpressaoDigital;
import br.pucsp.tcc.repositorio.FabricaRepositorio;
import br.pucsp.tcc.repositorio.RepositorioCliente;

public class ObterIdentificacaoRegistroPedido implements
		LeitorBiometricoListener {

//	private LeitorBiometrico leitor;

//	public void inicializarRegistro() {
//		leitor = new LeitorMicrosoft();
//		try {
//			leitor.iniciar(this);
//		} catch (Exception e) {
//			e.printStackTrace();
//			//FIXME remover o improviso de leitor biométrico
//			//TODO improvisar uma identificacao e chamar o método leituraIdentificacaoFinalizada(Identificacao identificacao)
//			inventarDigital();
//		}
//	}
	
	public void leituraIdentificacaoFinalizada(Identificacao identificacao) {
		ImpressaoDigital digital = (ImpressaoDigital)identificacao;
		ClienteIndividual clienteIndividual = obterCliente(digital.getTemplateId());
		if(clienteIndividual == null) {
			JOptionPane.showMessageDialog(null, "Cliente não encontrado", "Cliente inexistente", JOptionPane.INFORMATION_MESSAGE, null);
		}
		else {
			RegistradorPedidos registradorPedidos = new RegistradorPedidos();
			registradorPedidos.abrirPedido(clienteIndividual);
		}
	}

	public void leituraIdentificacaoIniciada() {
		
	}
	
	private ClienteIndividual obterCliente(int templateId) {
		RepositorioCliente repositorio = new FabricaRepositorio().getRepCliente();
		ClienteIndividual clienteIndividual = repositorio.obterCliente(templateId);
		return clienteIndividual;
	}
	
//	private void inventarDigital() {
//		Integer[] vetor = new Integer[]{
//				new Integer(1),
//				new Integer(2),
//				new Integer(3),
//				new Integer(4),
//				new Integer(5),
//				new Integer(6),
//				new Integer(7),
//				new Integer(8),
//				new Integer(9),};
//		
//		Integer integer = (Integer)JOptionPane.showInputDialog(null, "Escolha uma impressão digital", "Impressão digital", JOptionPane.QUESTION_MESSAGE, null, vetor, null); 
//		int selecionado = integer.intValue();
//		Identificacao identificacao = ImpressaoDigitalMock.digital1;
//		switch (selecionado) {
//		case 1:
//			identificacao = ImpressaoDigitalMock.digital1;
//			break;
//		case 2:
//			identificacao = ImpressaoDigitalMock.digital2;
//			break;
//		case 3:
//			identificacao = ImpressaoDigitalMock.digital3;
//			break;
//		case 4:
//			identificacao = ImpressaoDigitalMock.digital4;
//			break;
//		case 5:
//			identificacao = ImpressaoDigitalMock.digital5;
//			break;
//		case 6:
//			identificacao = ImpressaoDigitalMock.digital6;
//			break;
//		case 7:
//			identificacao = ImpressaoDigitalMock.digital7;
//			break;
//		case 8:
//			identificacao = ImpressaoDigitalMock.digital8;
//			break;
//		case 9:
//			identificacao = ImpressaoDigitalMock.digital9;
//			break;
//
//		default:
//			identificacao = ImpressaoDigitalMock.digital1;
//			break;
//		}
//		leituraIdentificacaoFinalizada(identificacao);
//	}

}
