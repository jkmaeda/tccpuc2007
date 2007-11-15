package br.pucsp.tcc.gui.mdi;

import javax.swing.JPanel;

public interface Mdi {

	public abstract void dispose();

	public abstract void setVisible(boolean visivel);

	public abstract void setContentPane(JPanel contentPane);

	public abstract void setTitle(String title);

}
