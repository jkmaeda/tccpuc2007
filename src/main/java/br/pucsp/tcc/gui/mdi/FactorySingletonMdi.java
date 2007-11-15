package br.pucsp.tcc.gui.mdi;

import java.util.Properties;

import br.pucsp.tcc.aplicacao.ArquivoDeConfiguracao;
import br.pucsp.tcc.gui.mdiSwing.MdiSwing;

public class FactorySingletonMdi {

	private static Mdi mdi = null;
	
	public static Mdi Contruir() {
		if(mdi == null) {
			mdi = fabricarMdi();
		}
		return mdi;
	}
	
	private static Mdi fabricarMdi() {
		System.out.println(MdiSwing.class);
		Properties properties = ArquivoDeConfiguracao.getPeoperties();
		String fullyQualifiedName = properties.getProperty("mdi");
		mdi = null;
		try {
	    	mdi = (Mdi)Class.forName(fullyQualifiedName).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	    return mdi;
	}
	
}
