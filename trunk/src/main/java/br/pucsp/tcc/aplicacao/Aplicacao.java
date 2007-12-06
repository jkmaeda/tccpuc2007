package br.pucsp.tcc.aplicacao;

import javax.swing.JOptionPane;

import br.pucsp.tcc.gui.cadastrarCliente.ObterIdentificacaoCadastramento;
import br.pucsp.tcc.gui.edicaoPreferencias.EdicaoPreferencias;
import br.pucsp.tcc.gui.edicaoPreferencias.EditorPreferencias;
import br.pucsp.tcc.gui.fecharConta.ObterIdentificacaoFecharConta;
import br.pucsp.tcc.gui.login.TelaLogin;
import br.pucsp.tcc.gui.mdi.FactorySingletonMdi;
import br.pucsp.tcc.gui.mdi.Mdi;
import br.pucsp.tcc.gui.registrarPedido.ObterIdentificacaoRegistroPedido;
import br.pucsp.tcc.gui.telaInicial.TelaInicial;
import br.pucsp.tcc.infra.leitorbiometrico.LeitorBiometricoListener;
import br.pucsp.tcc.infra.leitorbiometrico.griaule.LeitorMicrosoft;
import br.pucsp.tcc.mock.biometria.ImpressaoDigitalMock;
import br.pucsp.tcc.modelo.Identificacao;

public class Aplicacao implements ComandaDigital, IAplicacao {

	private LeitorBiometricoListener listener = null;
	
	public static void main(String[] args) {
		new Aplicacao();
	}

	private IAplicacao aplicacao;
	private LeitorMicrosoft leitor;

	private Aplicacao() {
		inicializarLeitor();
//		logar();
		run();
	}
	
	private void inicializarLeitor() {
		leitor = new LeitorMicrosoft();
	}

	public void run() {
		Mdi mdi = FactorySingletonMdi.Construir();
//		JPanel panel = new JPanel();
//		mdi.setContentPane(panel);
		mdi.setComandaDigital(this);
		TelaInicial telaInicial = new TelaInicial();
//		mdi.setVisible(true);
//		cadastrarCliente();
	}
	
	private void logar() {
		TelaLogin telaLogin = new TelaLogin(this);
	}

	public void cadastrarCliente() {
		listener = new ObterIdentificacaoCadastramento();
		try {
			leitor.iniciar(listener);
		} catch (Exception e) {
			e.printStackTrace();
			//FIXME remover o improviso de leitor biométrico
			//TODO improvisar uma identificacao e chamar o método leituraIdentificacaoFinalizada(Identificacao identificacao)
			inventarDigital();
		}
	}
	
	public void registrarPedido() {
		listener = new ObterIdentificacaoRegistroPedido();
		try {
			leitor.iniciar(listener);
		} catch (Exception e) {
			e.printStackTrace();
			//FIXME remover o improviso de leitor biométrico
			//TODO improvisar uma identificacao e chamar o método leituraIdentificacaoFinalizada(Identificacao identificacao)
			inventarDigital();
		}
	}
	
	public void fecharConta() {
		listener = new ObterIdentificacaoFecharConta();
		try {
			leitor.iniciar(listener);
		} catch (Exception e) {
			e.printStackTrace();
			//FIXME remover o improviso de leitor biométrico
			//TODO improvisar uma identificacao e chamar o método leituraIdentificacaoFinalizada(Identificacao identificacao)
			inventarDigital();
		}
	}

	public void editarPreferencias() {
		EdicaoPreferencias preferencias = new EditorPreferencias();
		preferencias.exibirTelaEdicaoPreferencias();
	}
	
	private void inventarDigital() {
		Integer[] vetor = new Integer[]{
				new Integer(1),
				new Integer(2),
				new Integer(3),
				new Integer(4),
				new Integer(5),
				new Integer(6),
				new Integer(7),
				new Integer(8),
				new Integer(9),};
		
		Integer integer = (Integer)JOptionPane.showInputDialog(null, "Escolha o mock da impressão digital que será utilizada.", "Impressão digital", JOptionPane.QUESTION_MESSAGE, null, vetor, null); 
		int selecionado = integer.intValue();
		Identificacao identificacao = ImpressaoDigitalMock.digital1;
		switch (selecionado) {
		case 1:
			identificacao = ImpressaoDigitalMock.digital1;
			break;
		case 2:
			identificacao = ImpressaoDigitalMock.digital2;
			break;
		case 3:
			identificacao = ImpressaoDigitalMock.digital3;
			break;
		case 4:
			identificacao = ImpressaoDigitalMock.digital4;
			break;
		case 5:
			identificacao = ImpressaoDigitalMock.digital5;
			break;
		case 6:
			identificacao = ImpressaoDigitalMock.digital6;
			break;
		case 7:
			identificacao = ImpressaoDigitalMock.digital7;
			break;
		case 8:
			identificacao = ImpressaoDigitalMock.digital8;
			break;
		case 9:
			identificacao = ImpressaoDigitalMock.digital9;
			break;

		default:
			identificacao = ImpressaoDigitalMock.digital1;
			break;
		}
		listener.leituraIdentificacaoFinalizada(identificacao);
	}
	
}
