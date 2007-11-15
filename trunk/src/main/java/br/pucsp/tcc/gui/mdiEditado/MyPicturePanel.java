package br.pucsp.tcc.gui.mdiEditado;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MyPicturePanel extends JPanel {

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
//		super.paintComponent(g);
//		Image imagem = new ImageIcon("C:\\Documents and Settings\\Mark\\Desktop\\Botões\\TelaMain.png").getImage();
//		Image imagem = new ImageIcon("C:\\Documents and Settings\\Mark\\Desktop\\botões2\\TelaMain.png").getImage();          
//		Image imagem = new ImageIcon("C:\\Documents and Settings\\Mark\\Desktop\\Telas\\GIMP\\TelaMain.png").getImage();          
		Image imagem = new ImageIcon("imagens\\TelaPrincipalBackground.png").getImage();                    
		g.drawImage(imagem, 0, 0, this); 
	}
	
}
