package br.pucsp.tcc.cadastrarClienteGui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;

public abstract class Tela {
	
	/**
	 * This is the default constructor
	 */
	public Tela() {
		super();
	}
	
	protected void centralizar(Component component){
  	    Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
  	    Dimension compSize = component.getSize();
  	    int centerX = (screenDim.width - compSize.width) >> 1;
  	    int centerY = (screenDim.height - compSize.height) >> 1;
  	    component.setLocation(centerX, centerY);
	}

	public abstract void exibir();

}
