package br.pucsp.tcc.gui.login;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import br.pucsp.tcc.aplicacao.IAplicacao;
import br.pucsp.tcc.login.Login;

import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;

public class TelaLogin {

	private JFrame jFrame = null;  //  @jve:decl-index=0:visual-constraint="49,32"
	private JPanel jContentPane = null;
	private JPanel jPanelCENTER = null;
	private JPanel jPanelJLabels = null;
	private JPanel jPanelJTextFields = null;
	private JLabel jLabelLogin = null;
	private JLabel jLabelSenha = null;
	private JTextField jTextFieldLogin = null;
	private JPasswordField jPasswordFieldSenha = null;
	private JPanel jPanelBotao = null;
	private JButton jButtonOK = null;
	private IAplicacao aplicacao;

	public TelaLogin(IAplicacao aplicacao) {
		this.aplicacao = aplicacao;
		try {
			UIManager.setLookAndFeel(new WindowsLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		jFrame = getJFrame();
		jTextFieldLogin.requestFocus();
	}
	
	/**
	 * This method initializes jFrame	
	 * 	
	 * @return javax.swing.JFrame	
	 */
	private JFrame getJFrame() {
		if (jFrame == null) {
			jFrame = new JFrame();
			jFrame.setSize(new Dimension(346, 195));
			jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			jFrame.setTitle("Login");
			jFrame.setContentPane(getJContentPane());
			centerComponent(jFrame);
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
			BorderLayout borderLayout1 = new BorderLayout();
			borderLayout1.setHgap(10);
			borderLayout1.setVgap(20);
			jContentPane = new JPanel();
			jContentPane.setLayout(borderLayout1);
			jContentPane.add(getJPanelCENTER(), BorderLayout.CENTER);
			jContentPane.add(new JPanel(), BorderLayout.NORTH);
			jContentPane.add(getJPanelBotao(), BorderLayout.SOUTH);
			jContentPane.add(new JPanel(), BorderLayout.EAST);
			jContentPane.add(new JPanel(), BorderLayout.WEST);
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
			borderLayout.setHgap(20);
			jPanelCENTER = new JPanel();
			jPanelCENTER.setLayout(borderLayout);
			jPanelCENTER.add(getJPanelJLabels(), BorderLayout.WEST);
			jPanelCENTER.add(getJPanelJTextFields(), BorderLayout.CENTER);
		}
		return jPanelCENTER;
	}

	/**
	 * This method initializes jPanelJLabels	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelJLabels() {
		if (jPanelJLabels == null) {
			jLabelSenha = new JLabel();
			jLabelSenha.setText("Senha:");
			jLabelSenha.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabelLogin = new JLabel();
			jLabelLogin.setText("Login:");
			jLabelLogin.setHorizontalAlignment(SwingConstants.RIGHT);
			GridLayout gridLayout = new GridLayout();
			gridLayout.setRows(2);
			gridLayout.setVgap(20);
			gridLayout.setColumns(1);
			jPanelJLabels = new JPanel();
			jPanelJLabels.setLayout(gridLayout);
			jPanelJLabels.add(jLabelLogin, null);
			jPanelJLabels.add(jLabelSenha, null);
		}
		return jPanelJLabels;
	}

	/**
	 * This method initializes jPanelJTextFields	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelJTextFields() {
		if (jPanelJTextFields == null) {
			GridLayout gridLayout1 = new GridLayout();
			gridLayout1.setRows(2);
			gridLayout1.setVgap(20);
			gridLayout1.setColumns(1);
			jPanelJTextFields = new JPanel();
			jPanelJTextFields.setLayout(gridLayout1);
			jPanelJTextFields.add(getJTextFieldLogin(), null);
			jPanelJTextFields.add(getJPasswordFieldSenha(), null);
		}
		return jPanelJTextFields;
	}

	/**
	 * This method initializes jTextFieldLogin	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldLogin() {
		if (jTextFieldLogin == null) {
			jTextFieldLogin = new JTextField();
			jTextFieldLogin.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jPasswordFieldSenha.requestFocus();
				}
			});
		}
		return jTextFieldLogin;
	}

	/**
	 * This method initializes jPasswordFieldSenha	
	 * 	
	 * @return javax.swing.JPasswordField	
	 */
	private JPasswordField getJPasswordFieldSenha() {
		if (jPasswordFieldSenha == null) {
			jPasswordFieldSenha = new JPasswordField();
			jPasswordFieldSenha.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jButtonOK.requestFocus();
				}
			});
		}
		return jPasswordFieldSenha;
	}

	private void centerComponent(Component comp) {
		Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension compSize = comp.getSize();
		int centerX = (screenDim.width - compSize.width) >> 1;
		int centerY = (screenDim.height - compSize.height) >> 2;
		comp.setLocation(centerX, centerY);
	}

	/**
	 * This method initializes jPanelBotao	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelBotao() {
		if (jPanelBotao == null) {
			BorderLayout borderLayout2 = new BorderLayout();
			borderLayout2.setHgap(80);
			borderLayout2.setVgap(10);
			jPanelBotao = new JPanel();
			jPanelBotao.setLayout(borderLayout2);
			jPanelBotao.add(getJButtonOK(), BorderLayout.CENTER);
//			jPanelBotao.add(new JPanel(), BorderLayout.NORTH);
			jPanelBotao.add(new JPanel(), BorderLayout.SOUTH);
			jPanelBotao.add(new JPanel(), BorderLayout.EAST);
			jPanelBotao.add(new JPanel(), BorderLayout.WEST);
		}
		return jPanelBotao;
	}

	/**
	 * This method initializes jButtonOK	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonOK() {
		if (jButtonOK == null) {
			jButtonOK = new JButton();
			jButtonOK.setText("Logar");
			jButtonOK.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					String usuario = jTextFieldLogin.getText();
					char[] caracteres = jPasswordFieldSenha.getPassword();
					String senha = new String(caracteres);
					Login login = new Login();
					String senhaEsperada = login.get(usuario);
					boolean logado = senha.equals(senhaEsperada);
					if(!logado) {
						System.exit(0);
					}
					else {
						aplicacao.run();
						jFrame.dispose();
					}
				}
			});
		}
		return jButtonOK;
	}
	
}
