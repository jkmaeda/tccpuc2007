package br.pucsp.tcc.gui.cadastrarCliente.impl;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class JPanelViewImpressaoDigital extends JPanel {

	private Image image;

	public JPanelViewImpressaoDigital(Image image) {
		this.image = image;
	}

	@Override
	protected void paintComponent(Graphics g) {
		if(image != null) {
			g.drawImage(image, 0, 0, 110, 130, this);
		}
	}
	
}
