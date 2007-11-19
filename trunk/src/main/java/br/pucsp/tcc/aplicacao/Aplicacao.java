package br.pucsp.tcc.aplicacao;

import javax.swing.JPanel;

import br.pucsp.tcc.gui.cadastrarCliente.ObterIdentificacaoCadastramento;
import br.pucsp.tcc.gui.fecharConta.ObterIdentificacaoFecharConta;
import br.pucsp.tcc.gui.mdi.FactorySingletonMdi;
import br.pucsp.tcc.gui.mdi.Mdi;
import br.pucsp.tcc.gui.registrarPedido.ObterIdentificacaoRegistroPedido;
import br.pucsp.tcc.gui.telaInicial.TelaInicial;

public class Aplicacao implements ComandaDigital {

	public static void main(String[] args) {
		new Aplicacao();
	}

	private Aplicacao() {
		Mdi mdi = FactorySingletonMdi.Construir();
//		JPanel panel = new JPanel();
//		mdi.setContentPane(panel);
		mdi.setComandaDigital(this);
		TelaInicial telaInicial = new TelaInicial();
//		mdi.setVisible(true);
//		cadastrarCliente();
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
	
}
