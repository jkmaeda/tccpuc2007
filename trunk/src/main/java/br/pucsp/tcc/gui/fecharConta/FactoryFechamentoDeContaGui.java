package br.pucsp.tcc.gui.fecharConta;

import java.util.Properties;

import br.pucsp.tcc.aplicacao.ArquivoDeConfiguracao;
import br.pucsp.tcc.gui.fecharConta.impl.FechadorDeContaGui;

public class FactoryFechamentoDeContaGui {

	public static FechamentoDeContaGui criarTela() {
		Properties properties = ArquivoDeConfiguracao.getProperties();
		String fullyQualifiedName = properties.getProperty("fecharContaGui");
		FechamentoDeContaGui contaGui = null;
		try {
			contaGui = (FechamentoDeContaGui)Class.forName(fullyQualifiedName).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	    return contaGui;
	}
	
	
}
