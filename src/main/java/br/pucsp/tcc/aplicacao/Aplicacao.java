package br.pucsp.tcc.aplicacao;

import javax.swing.JPanel;

import br.pucsp.tcc.gui.cadastrarCliente.ObterIdentificacaoCadastramento;
import br.pucsp.tcc.gui.edicaoPreferencias.EdicaoPreferencias;
import br.pucsp.tcc.gui.edicaoPreferencias.EditorPreferencias;
import br.pucsp.tcc.gui.fecharConta.ObterIdentificacaoFecharConta;
import br.pucsp.tcc.gui.login.TelaLogin;
import br.pucsp.tcc.gui.mdi.FactorySingletonMdi;
import br.pucsp.tcc.gui.mdi.Mdi;
import br.pucsp.tcc.gui.mdiEditado.MdiEditado;
import br.pucsp.tcc.gui.mdiSwing.MdiSwing;
import br.pucsp.tcc.gui.registrarPedido.ObterIdentificacaoRegistroPedido;
import br.pucsp.tcc.gui.telaInicial.TelaInicial;
import br.pucsp.tcc.login.Login;

public class Aplicacao implements ComandaDigital, IAplicacao {

	public static void main(String[] args) {
		new Aplicacao();
	}

	private IAplicacao aplicacao;

	private Aplicacao() {
//		logar();
		run();
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
		ObterIdentificacaoCadastramento cadastramento = new ObterIdentificacaoCadastramento();
		cadastramento.inicializarCadastro();
	}
	
	public void registrarPedido() {
		ObterIdentificacaoRegistroPedido registroPedido = new ObterIdentificacaoRegistroPedido();
		registroPedido.inicializarRegistro();
	}
	
	public void fecharConta() {
		ObterIdentificacaoFecharConta fecharConta = new ObterIdentificacaoFecharConta();
		fecharConta.inicializarFechamento();
	}

	public void editarPreferencias() {
		EdicaoPreferencias preferencias = new EditorPreferencias();
		preferencias.exibirTelaEdicaoPreferencias();
	}
	
}
