package br.pucsp.tcc.gui.cadastrarCliente;

import br.pucsp.tcc.infra.leitorbiometrico.LeitorBiometricoListener;
import br.pucsp.tcc.modelo.Identificacao;

public class ObterIdentificacaoCadastramento implements
		LeitorBiometricoListener {

//	private LeitorBiometrico leitor;
	private CadastramentoCliente cadastradorCliente  = null;
	
//	public void inicializarCadastro() {
////		leitor = new LeitorMicrosoft();
////		leitor.setListener(this);
////		System.out.println("1");
////		try {
////			leitor.iniciar(this);
////			leitor.setListener(this);
////			System.out.println("3");
////		} catch (Exception e) {
////			e.printStackTrace();
////			//FIXME remover o improviso de leitor biométrico
////			//TODO improvisar uma identificacao e chamar o método leituraIdentificacaoFinalizada(Identificacao identificacao)
////			inventarDigital();
////		}
//	}

	public void leituraIdentificacaoFinalizada(Identificacao identificacao) {
		cadastradorCliente = FactoryCadastradorCliente.fabricarCadastradorCliente();
		cadastradorCliente.setIdentificacao(identificacao);
		cadastradorCliente.solicitarInformacoesUsuario();
	}

	public void leituraIdentificacaoIniciada() {
		
	}

}
