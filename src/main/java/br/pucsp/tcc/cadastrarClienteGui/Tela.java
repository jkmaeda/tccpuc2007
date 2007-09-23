package br.pucsp.tcc.cadastrarClienteGui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

public abstract class Tela extends JFrame {

	/**
	 * This is the default constructor
	 */
	public Tela() {
		super();
	}
	
	protected void centralizar(){
		Component comp = this;
  	    Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
  	    Dimension compSize = comp.getSize();
  	    int centerX = (screenDim.width - compSize.width) >> 1;
  	    int centerY = (screenDim.height - compSize.height) >> 1;
  	    comp.setLocation(centerX, centerY);
	}

	protected void exibir() {
		this.setVisible(true);
	}

}
