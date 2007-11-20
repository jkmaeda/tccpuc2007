package br.pucsp.tcc.gui.edicaoPreferenciasImpl;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.Properties;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import br.pucsp.tcc.aplicacao.ArquivoDeConfiguracao;
import br.pucsp.tcc.gui.mdi.FactorySingletonMdi;
import br.pucsp.tcc.gui.mdi.Mdi;
import br.pucsp.tcc.gui.mdiEditado.MdiEditado;
import br.pucsp.tcc.gui.mdiSwing.MdiSwing;

import java.awt.GridBagConstraints;
import javax.swing.BorderFactory;
import javax.swing.border.TitledBorder;
import java.awt.Font;
import java.awt.Color;

public class EditorPreferenciasGui {

	private Mdi jFrame = null;
	private JPanel jContentPane = null;
	private JPanel jPanelCENTER = null;
	private JPanel jPanelSOUTH = null;
	private JPanel jPanelNORTH = null;
	private JPanel jPanelEAST = null;
	private JPanel jPanelWEST = null;
	private JPanel jPanelJRadioButton = null;
	private JRadioButton jRadioButtonColored = null;
	private JRadioButton jRadioButtonWindows = null;
	private ButtonGroup buttonGroup;
	private JButton jButtonAplicar = null;
	private JPanel jPanelBotoes = null;
	private JButton jButtonCancelar = null;
	private JPanel jPanelEscolha = null;
	
	public EditorPreferenciasGui() {
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
//			jFrame.setSize(new Dimension(376, 191));
			jFrame.setContentPane(getJContentPane());
//			jFrame.setVisible(true);
			FactorySingletonMdi.Construir().setVisible(true);
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
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.setName("Editar Preferências");
			jContentPane.add(getJPanelCENTER(), BorderLayout.CENTER);
			jContentPane.add(getJPanelSOUTH(), BorderLayout.SOUTH);
			jContentPane.add(getJPanelNORTH(), BorderLayout.NORTH);
			jContentPane.add(getJPanelEAST(), BorderLayout.EAST);
			jContentPane.add(getJPanelWEST(), BorderLayout.WEST);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jPanelCENTER	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelCENTER() {
		if (jPanelCENTER == null) {
			BorderLayout borderLayout = new BorderLayout();
			borderLayout.setHgap(50);
			borderLayout.setVgap(50);
			jPanelCENTER = new JPanel();
			jPanelCENTER.setLayout(borderLayout);
			jPanelCENTER.add(getJPanelEscolha(), BorderLayout.CENTER);
			jPanelCENTER.add(new JPanel(), java.awt.BorderLayout.NORTH);
			jPanelCENTER.add(new JPanel(), BorderLayout.SOUTH);
			jPanelCENTER.add(new JPanel(), BorderLayout.EAST);
			jPanelCENTER.add(new JPanel(), BorderLayout.WEST);
		}
		return jPanelCENTER;
	}

	/**
	 * This method initializes jPanelSOUTH	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelSOUTH() {
		if (jPanelSOUTH == null) {
			BorderLayout borderLayout1 = new BorderLayout();
			borderLayout1.setHgap(50);
			borderLayout1.setVgap(10);
			jPanelSOUTH = new JPanel();
			jPanelSOUTH.setLayout(borderLayout1);
			jPanelSOUTH.add(getJPanelBotoes(), BorderLayout.CENTER);
			jPanelSOUTH.add(new JPanel(), BorderLayout.NORTH);
			jPanelSOUTH.add(new JPanel(), BorderLayout.SOUTH);
			jPanelSOUTH.add(new JPanel(), BorderLayout.EAST);
			jPanelSOUTH.add(new JPanel(), BorderLayout.WEST);
		}
		return jPanelSOUTH;
	}

	/**
	 * This method initializes jPanelNORTH	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelNORTH() {
		if (jPanelNORTH == null) {
			jPanelNORTH = new JPanel();
			jPanelNORTH.setLayout(new GridBagLayout());
		}
		return jPanelNORTH;
	}

	/**
	 * This method initializes jPanelEAST	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelEAST() {
		if (jPanelEAST == null) {
			jPanelEAST = new JPanel();
			jPanelEAST.setLayout(new GridBagLayout());
		}
		return jPanelEAST;
	}

	/**
	 * This method initializes jPanelWEST	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelWEST() {
		if (jPanelWEST == null) {
			jPanelWEST = new JPanel();
			jPanelWEST.setLayout(new GridBagLayout());
		}
		return jPanelWEST;
	}

	/**
	 * This method initializes jPanelJRadioButton	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelJRadioButton() {
		if (jPanelJRadioButton == null) {
			GridLayout gridLayout = new GridLayout();
			gridLayout.setRows(2);
			gridLayout.setColumns(1);
			gridLayout.setVgap(10);
			jPanelJRadioButton = new JPanel();
			jPanelJRadioButton.setLayout(gridLayout);
			jPanelJRadioButton.add(getJRadioButtonColored(), null);
			jPanelJRadioButton.add(getJRadioButtonWindows(), null);
		}
		return jPanelJRadioButton;
	}

	/**
	 * This method initializes jRadioButtonColored	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButtonColored() {
		if (jRadioButtonColored == null) {
			jRadioButtonColored = new JRadioButton();
			jRadioButtonColored.setFont(new Font("Tahoma", Font.PLAIN, 18));
			if(jFrame.getEstilo().equals(Mdi.COLOR)) {
				jRadioButtonColored.setSelected(true);
			}
			getButtonGroup().add(jRadioButtonColored);
			jRadioButtonColored.setText("Color");
		}
		return jRadioButtonColored;
	}

	/**
	 * This method initializes jRadioButtonWindows	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButtonWindows() {
		if (jRadioButtonWindows == null) {
			jRadioButtonWindows = new JRadioButton();
			jRadioButtonWindows.setFont(new Font("Tahoma", Font.PLAIN, 18));
			if(jFrame.getEstilo().equals(Mdi.WINDOWS)) {
				jRadioButtonWindows.setSelected(true);
			}
			getButtonGroup().add(jRadioButtonWindows);
			jRadioButtonWindows.setText("Windows");
		}
		return jRadioButtonWindows;
	}
	
	private ButtonGroup getButtonGroup() {
		if(buttonGroup == null) {
			buttonGroup = new ButtonGroup();
		}
		return buttonGroup;
	}

	/**
	 * This method initializes jButtonAplicar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonAplicar() {
		if (jButtonAplicar == null) {
			jButtonAplicar = new JButton();
			jButtonAplicar.setText("Aplicar");
			jButtonAplicar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Properties properties = ArquivoDeConfiguracao.getProperties();
					Mdi mdi = null;
					if(jFrame.getEstilo().equals(Mdi.COLOR)) {
						properties.setProperty("mdi", properties.getProperty("mdiSwing"));
//						mdi = new MdiSwing();
//						FactorySingletonMdi.setMdi(mdi);
					}
					if(jFrame.getEstilo().equals(Mdi.WINDOWS)) {
						properties.setProperty("mdi", properties.getProperty("mdiEditado"));
//						mdi = new MdiEditado();
//						FactorySingletonMdi.setMdi(mdi);
					}
					ArquivoDeConfiguracao.save();
					jFrame.dispose();
				}
			});
		}
		return jButtonAplicar;
	}

	/**
	 * This method initializes jPanelBotoes	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelBotoes() {
		if (jPanelBotoes == null) {
			GridLayout gridLayout1 = new GridLayout();
			gridLayout1.setRows(1);
			gridLayout1.setHgap(50);
			gridLayout1.setColumns(2);
			jPanelBotoes = new JPanel();
			jPanelBotoes.setLayout(gridLayout1);
			jPanelBotoes.add(getJButtonAplicar(), null);
			jPanelBotoes.add(getJButtonCancelar(), null);
		}
		return jPanelBotoes;
	}

	/**
	 * This method initializes jButtonCancelar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonCancelar() {
		if (jButtonCancelar == null) {
			jButtonCancelar = new JButton();
			jButtonCancelar.setText("Cancelar");
			jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jFrame.dispose();
				}
			});
		}
		return jButtonCancelar;
	}

	/**
	 * This method initializes jPanelEscolha	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelEscolha() {
		if (jPanelEscolha == null) {
			BorderLayout borderLayout2 = new BorderLayout();
			borderLayout2.setHgap(40);
			borderLayout2.setVgap(50);
			jPanelEscolha = new JPanel();
			jPanelEscolha.setLayout(borderLayout2);
			jPanelEscolha.setBorder(BorderFactory.createTitledBorder(null, "Estilo de Visualização", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Tahoma", Font.PLAIN, 15), new Color(0, 70, 213)));
			jPanelEscolha.add(getJPanelJRadioButton(), BorderLayout.CENTER);
			jPanelEscolha.add(new JPanel(), BorderLayout.NORTH);
			jPanelEscolha.add(new JPanel(), BorderLayout.SOUTH);
			jPanelEscolha.add(new JPanel(), BorderLayout.EAST);
			jPanelEscolha.add(new JPanel(), BorderLayout.WEST);
		}
		return jPanelEscolha;
	}

}
