package br.pucsp.tcc.gui.amostraUsoTelaMdi;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Rectangle;
import javax.swing.JButton;

import br.pucsp.tcc.gui.mdi.Mdi;
import br.pucsp.tcc.gui.mdi.FactorySingletonMdi;
import java.awt.GridBagLayout;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Dimension;

public class Tela2 {

	private Mdi jFrame = null;
	private JPanel jContentPane = null;  //  @jve:decl-index=0:visual-constraint="10,10"
	private JLabel jLabelInfo = null;
	private JLabel jLabelNome = null;
	private JLabel jLabelSobreNome = null;
	private JTextField jTextFieldNome = null;
	private JTextField jTextFieldSobreNome = null;
	private JButton jButton = null;

	private String nome;
	private String sobreNome;
	private JPanel jPanelCENTER = null;
	private JPanel jPanelNome = null;
	private JPanel jPanelSobreNome = null;
	private JPanel jPanelForm = null;
	
	public Tela2(String nome, String sobrenome) {
		this.nome = nome;
		this.sobreNome = sobrenome;
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
//			jFrame.setSize(new Dimension(342, 177));
			jFrame.setContentPane(getJContentPane());
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
			BorderLayout borderLayout1 = new BorderLayout();
			borderLayout1.setVgap(7);
			jContentPane = new JPanel();
			jContentPane.setLayout(borderLayout1);
			jContentPane.setName("Tela2");
			jContentPane.setSize(new Dimension(264, 106));
			jContentPane.add(getJPanelCENTER(), BorderLayout.CENTER);
			jContentPane.add(new JPanel(), BorderLayout.NORTH);
			jContentPane.add(new JPanel(), BorderLayout.SOUTH);
			jContentPane.add(new JPanel(), BorderLayout.EAST);
			jContentPane.add(new JPanel(), BorderLayout.WEST);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setText("Editar");
			jButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Tela1 tela1 = new Tela1();
					tela1.setNome(jTextFieldNome.getText());
					tela1.setSobrenome(jTextFieldSobreNome.getText());
					dispose();
				}
			});
		}
		return jButton;
	}

	private void dispose() {
		jFrame.dispose();
	}

	/**
	 * This method initializes jPanelCENTER	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelCENTER() {
		if (jPanelCENTER == null) {
			BorderLayout borderLayout = new BorderLayout();
			borderLayout.setVgap(15);
			jPanelCENTER = new JPanel();
			jPanelCENTER.setLayout(borderLayout);
			jPanelCENTER.add(getJLabelInfo(), BorderLayout.NORTH);
			jPanelCENTER.add(getJPanelForm(), BorderLayout.CENTER);
			jPanelCENTER.add(getJButton(), BorderLayout.SOUTH);
		}
		return jPanelCENTER;
	}

	/**
	 * This method initializes jPanelNome	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelNome() {
		if (jPanelNome == null) {
			jPanelNome = new JPanel();
			jPanelNome.setLayout(new BorderLayout());
			jPanelNome.add(getJLabelNome(), BorderLayout.WEST);
			jPanelNome.add(getJTextFieldNome(), BorderLayout.CENTER);
		}
		return jPanelNome;
	}

	private JTextField getJTextFieldNome() {
		if(jTextFieldNome == null) {
			jTextFieldNome = new JTextField();
			jTextFieldNome.setText(nome);
			jTextFieldNome.setEditable(false);
		}
		return jTextFieldNome;
	}

	private JTextField getJTextFieldSobreNome() {
		if(jTextFieldSobreNome == null) {
			jTextFieldSobreNome = new JTextField();
			jTextFieldSobreNome.setText(sobreNome);
			jTextFieldSobreNome.setEditable(false);
		}
		return jTextFieldSobreNome;
	}

	private JLabel getJLabelInfo() {
		if(jLabelInfo == null) {
			jLabelInfo = new JLabel();
			jLabelInfo.setText("Este são seus dados:");
		}
		return jLabelInfo;
	}

	private JLabel getJLabelNome() {
		if(jLabelNome == null) {
			jLabelNome = new JLabel();
			jLabelNome.setText("Nome:");
			jLabelNome.setPreferredSize(new Dimension(90, 25));
		}
		return jLabelNome;
	}

	private JLabel getJLabelSobreNome() {
		if(jLabelSobreNome == null) {
			jLabelSobreNome = new JLabel();
			jLabelSobreNome.setText("Sobrenome:");
			jLabelSobreNome.setPreferredSize(new Dimension(90, 25));
		}
		return jLabelSobreNome;
	}

	/**
	 * This method initializes jPanelSobreNome	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelSobreNome() {
		if (jPanelSobreNome == null) {
			jPanelSobreNome = new JPanel();
			jPanelSobreNome.setLayout(new BorderLayout());
			jPanelSobreNome.add(getJLabelSobreNome(), BorderLayout.WEST);
			jPanelSobreNome.add(getJTextFieldSobreNome(), BorderLayout.CENTER);
		}
		return jPanelSobreNome;
	}

	/**
	 * This method initializes jPanelForm	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelForm() {
		if (jPanelForm == null) {
			GridLayout gridLayout = new GridLayout();
			gridLayout.setRows(2);
			gridLayout.setVgap(7);
			gridLayout.setColumns(1);
			jPanelForm = new JPanel();
			jPanelForm.setLayout(gridLayout);
			jPanelForm.add(getJPanelNome(), null);
			jPanelForm.add(getJPanelSobreNome(), null);
		}
		return jPanelForm;
	}

	public void exibir() {
//		jFrame.setVisible(true);
		FactorySingletonMdi.Construir().setVisible(true);
	}

}
