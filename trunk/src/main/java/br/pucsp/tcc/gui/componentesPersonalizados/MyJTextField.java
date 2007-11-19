package br.pucsp.tcc.gui.componentesPersonalizados;

import java.awt.Color;
import java.awt.event.FocusAdapter;

import javax.swing.JTextField;

@SuppressWarnings("serial")
public class MyJTextField extends JTextField {

	public MyJTextField() {
		super();
		this.addFocusListener(new MyFocusEvent(this));
	}
	
	public class MyFocusEvent extends FocusAdapter {
		
		private MyJTextField myJTextField;
		
		public MyFocusEvent(MyJTextField myJTextField) {
			this.myJTextField = myJTextField;
		}
		
		public void focusLost(java.awt.event.FocusEvent e) {
			myJTextField.setBackground(Color.WHITE);
			myJTextField.setForeground(Color.BLACK);
		}
		public void focusGained(java.awt.event.FocusEvent e) {
			myJTextField.setSelectionStart(0);
			myJTextField.setSelectionEnd(myJTextField.getText().length());
			myJTextField.setForeground(Color.BLUE);
			myJTextField.setBackground(new Color(227, 255, 223));
		}
		
	}
	
}
