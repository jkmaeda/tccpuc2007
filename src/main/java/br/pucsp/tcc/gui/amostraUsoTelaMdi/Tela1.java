package br.pucsp.tcc.gui.amostraUsoTelaMdi;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

import br.pucsp.tcc.gui.mdi.Mdi;
import br.pucsp.tcc.gui.mdi.FactorySingletonMdi;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.GridBagConstraints;
import java.awt.Font;

public class Tela1 {

	private Mdi jFrame = null;  //  @jve:decl-index=0:visual-constraint="36,6"
	private JPanel jContentPane = null;  //  @jve:decl-index=0:visual-constraint="79,10"
	private JButton jButton = null;
	private JTextField jTextFieldNome = null;
	private JLabel jLabelInfo = null;
	private JLabel jLabelNome = null;
	private JLabel jLabelSobreNome = null;
	private JTextField jTextFieldSobreNome = null;
	private JPanel jPanelNome = null;
	private JPanel jPanelSobreNome = null;
	private JPanel jPanelForm = null;
	private JPanel jPanelCENTER = null;
	private JPanel jPanelLabelInfo = null;
	private JButton jButtonInfo = null;

	public Tela1() {
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
//			jFrame.setSize(new Dimension(355, 184));
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
			BorderLayout borderLayout = new BorderLayout();
			borderLayout.setVgap(7);
			jContentPane = new JPanel();
			jContentPane.setName("Tela1");
			jContentPane.setLayout(borderLayout);
			jContentPane.setSize(new Dimension(302, 151));
			jContentPane.add(getJPanelCENTER(), BorderLayout.CENTER);
			jContentPane.add(new JPanel(), BorderLayout.NORTH);
			jContentPane.add(new JPanel(), BorderLayout.SOUTH);
			jContentPane.add(new JPanel(), BorderLayout.EAST);
			jContentPane.add(new JPanel(), BorderLayout.WEST);
		}
		return jContentPane;
	}

	private JLabel getJLabelSobreNome() {
		if(jLabelSobreNome == null) {
			jLabelSobreNome = new JLabel();
			jLabelSobreNome.setText("Sobrenome");
			jLabelSobreNome.setPreferredSize(new Dimension(90 , 25));
		}
		return jLabelSobreNome;
	}

	private JLabel getJLabelInfo() {
		if(jLabelInfo == null) {
			jLabelInfo = new JLabel();
			jLabelInfo.setText("Teste de Tela MDI");
		}
		return jLabelInfo;
	}

	private JLabel getJLabelNome() {
		if(jLabelNome == null) {
			jLabelNome = new JLabel();
			jLabelNome.setText("Nome");
			jLabelNome.setPreferredSize(new Dimension(90 , 25));
		}
		return jLabelNome;
	}

	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setText("OK");
			jButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Tela2 tela2 = new Tela2(jTextFieldNome.getText(), jTextFieldSobreNome.getText());
					dispose();
				}

				private void dispose() {
					jFrame.dispose();
				}
			});
		}
		return jButton;
	}

	/**
	 * This method initializes jTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldNome() {
		if (jTextFieldNome == null) {
			jTextFieldNome = new JTextField();
			jTextFieldNome.setText("Mark");
			jTextFieldNome.addFocusListener(new java.awt.event.FocusAdapter() {   
				public void focusLost(java.awt.event.FocusEvent e) {    
					jTextFieldNome.setBackground(Color.WHITE);
				}
				public void focusGained(java.awt.event.FocusEvent e) {
					jTextFieldNome.setBackground(new Color(240,230,255));
				}
			});
		}
		return jTextFieldNome;
	}

	/**
	 * This method initializes jTextField1	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldSobreNome() {
		if (jTextFieldSobreNome == null) {
			jTextFieldSobreNome = new JTextField();
			jTextFieldSobreNome.setText("Ferreira de Sousa");
			jTextFieldSobreNome.addFocusListener(new java.awt.event.FocusAdapter() {   
				public void focusLost(java.awt.event.FocusEvent e) {    
					jTextFieldSobreNome.setBackground(Color.WHITE);
				}
				public void focusGained(java.awt.event.FocusEvent e) {
					jTextFieldSobreNome.setBackground(new Color(240,230,255));
				}
			});
		}
		return jTextFieldSobreNome;
	}
	
	public void setNome(String nome) {
		jTextFieldNome.setText(nome);
	}
	
	public void setSobrenome(String sobreNome) {
		jTextFieldSobreNome.setText(sobreNome);
	}

	public void exibir() {
//		jFrame.setVisible(true);
		FactorySingletonMdi.Construir().setVisible(true);
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

	/**
	 * This method initializes jPanelCENTER	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelCENTER() {
		if (jPanelCENTER == null) {
			BorderLayout borderLayout1 = new BorderLayout();
			borderLayout1.setVgap(15);
			jPanelCENTER = new JPanel();
			jPanelCENTER.setLayout(borderLayout1);
			jPanelCENTER.add(getJPanelLabelInfo(), BorderLayout.NORTH);
			jPanelCENTER.add(getJPanelForm(), java.awt.BorderLayout.CENTER);
			jPanelCENTER.add(getJButton(), java.awt.BorderLayout.SOUTH);
		}
		return jPanelCENTER;
	}

	/**
	 * This method initializes jPanelLabelInfo	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelLabelInfo() {
		if (jPanelLabelInfo == null) {
			jPanelLabelInfo = new JPanel();
			jPanelLabelInfo.setLayout(new BorderLayout());
			jPanelLabelInfo.add(getJLabelInfo(), BorderLayout.WEST);
			jPanelLabelInfo.add(getJButtonInfo(), BorderLayout.EAST);
		}
		return jPanelLabelInfo;
	}

	/**
	 * This method initializes jButtonInfo	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonInfo() {
		if (jButtonInfo == null) {
			jButtonInfo = new JButton();
			jButtonInfo.setText("i");
			jButtonInfo.setFont(new Font("Dialog", Font.BOLD, 10));
			jButtonInfo.setPreferredSize(new Dimension(40, 15));
			jButtonInfo.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					TelaInfo telaInfo = new TelaInfo();
					telaInfo.exibir();
				}
			});
		}
		return jButtonInfo;
	}

}
