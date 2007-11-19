package br.pucsp.tcc.gui.telaInicial;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;

import br.pucsp.tcc.gui.mdi.FactorySingletonMdi;
import br.pucsp.tcc.gui.mdi.Mdi;

import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Font;

public class TelaInicial {

	private Mdi jFrame = null;
	private JPanel jContentPane = null;
	private JPanel jPanelCenter = null;
	private JLabel jLabelTitulo = null;
	private JPanel jPanelCENTER_NORTH = null;
	private JLabel jLabelIntegrantes = null;
	private JPanel jPanelCENTER_CENTER = null;
	private JPanel jPanelNome = null;
	private JLabel jLabelGustavo = null;
	private JLabel jLabelIvan = null;
	private JLabel jLabelJacques = null;
	private JLabel jLabelMark = null;
	
	public TelaInicial() {
		jFrame = getJFrame();
	}
	
	/**
	 * This method initializes jFrame	
	 * 	
	 * @return javax.swing.JFrame	
	 */
	private Mdi getJFrame() {
		if (jFrame == null) {
			jFrame = FactorySingletonMdi.Construir();
//			jFrame.setSize(new Dimension(320, 186));
			jFrame.setContentPane(getJContentPane());
			jFrame.setVisible(true);
		}
		return jFrame;
	}

	/**
	 * This method initializes jContentPane	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			BorderLayout borderLayout = new BorderLayout();
			borderLayout.setHgap(50);
			borderLayout.setVgap(50);
			jContentPane = new JPanel();
			jContentPane.setName("Comanda Digital");
			jContentPane.setLayout(borderLayout);
			jContentPane.add(getJPanelCenter(), BorderLayout.CENTER);
			jContentPane.add(new JPanel(), BorderLayout.NORTH);
			jContentPane.add(new JPanel(), BorderLayout.SOUTH);
			jContentPane.add(new JPanel(), BorderLayout.EAST);
			jContentPane.add(new JPanel(), BorderLayout.WEST);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jPanelCenter	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelCenter() {
		if (jPanelCenter == null) {
			jLabelTitulo = new JLabel();
			jLabelTitulo.setText("TCC: Comanda Digital");
			jLabelTitulo.setFont(new Font("Edwardian Script ITC", Font.PLAIN, 45));
			jLabelTitulo.setForeground(Color.blue);
			BorderLayout borderLayout1 = new BorderLayout();
			borderLayout1.setVgap(15);
			jPanelCenter = new JPanel();
			jPanelCenter.setLayout(borderLayout1);
			jPanelCenter.add(getJPanelCENTER_NORTH(), BorderLayout.NORTH);
			jPanelCenter.add(getJPanelCENTER_CENTER(), BorderLayout.CENTER);
		}
		return jPanelCenter;
	}

	/**
	 * This method initializes jPanelCENTER_NORTH	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelCENTER_NORTH() {
		if (jPanelCENTER_NORTH == null) {
			jLabelIntegrantes = new JLabel();
			jLabelIntegrantes.setText("Integrantes:");
			jLabelIntegrantes.setFont(new Font("Bodoni MT", Font.BOLD, 18));
			jLabelIntegrantes.setForeground(Color.blue);
			GridLayout gridLayout = new GridLayout();
			gridLayout.setRows(2);
			gridLayout.setVgap(50);
			gridLayout.setColumns(1);
			jPanelCENTER_NORTH = new JPanel();
			jPanelCENTER_NORTH.setLayout(gridLayout);
			jPanelCENTER_NORTH.add(jLabelTitulo, null);
			jPanelCENTER_NORTH.add(jLabelIntegrantes, null);
		}
		return jPanelCENTER_NORTH;
	}

	/**
	 * This method initializes jPanelCENTER_CENTER	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelCENTER_CENTER() {
		if (jPanelCENTER_CENTER == null) {
			BorderLayout borderLayout2 = new BorderLayout();
			borderLayout2.setHgap(20);
			borderLayout2.setVgap(20);
			jPanelCENTER_CENTER = new JPanel();
			jPanelCENTER_CENTER.setLayout(borderLayout2);
			jPanelCENTER_CENTER.add(getJPanelNome(), BorderLayout.CENTER);
			jPanelCENTER_CENTER.add(new JPanel(), BorderLayout.WEST);
			jPanelCENTER_CENTER.add(new JPanel(), BorderLayout.EAST);
			jPanelCENTER_CENTER.add(new JPanel(), BorderLayout.SOUTH);
			jPanelCENTER_CENTER.add(new JPanel(), BorderLayout.NORTH);
		}
		return jPanelCENTER_CENTER;
	}

	/**
	 * This method initializes jPanelNome	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelNome() {
		if (jPanelNome == null) {
			jLabelMark = new JLabel();
			jLabelMark.setForeground(Color.blue);
			jLabelMark.setFont(new Font("Bodoni MT", Font.PLAIN, 18));
			jLabelMark.setText("Mark de Sousa");
			jLabelJacques = new JLabel();
			jLabelJacques.setForeground(Color.blue);
			jLabelJacques.setFont(new Font("Bodoni MT", Font.PLAIN, 18));
			jLabelJacques.setText("Jacques Maeda");
			jLabelIvan = new JLabel();
			jLabelIvan.setForeground(Color.blue);
			jLabelIvan.setFont(new Font("Bodoni MT", Font.PLAIN, 18));
			jLabelIvan.setText("Ivan Claus");
			jLabelGustavo = new JLabel();
			jLabelGustavo.setForeground(Color.blue);
			jLabelGustavo.setFont(new Font("Bodoni MT", Font.PLAIN, 18));
			jLabelGustavo.setText("Gustavo Steigert");
			GridLayout gridLayout1 = new GridLayout();
			gridLayout1.setRows(4);
			gridLayout1.setVgap(5);
			gridLayout1.setColumns(1);
			jPanelNome = new JPanel();
			jPanelNome.setLayout(gridLayout1);
			jPanelNome.add(jLabelGustavo, null);
			jPanelNome.add(jLabelIvan, null);
			jPanelNome.add(jLabelJacques, null);
			jPanelNome.add(jLabelMark, null);
		}
		return jPanelNome;
	}

}
