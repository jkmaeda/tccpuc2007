package br.pucsp.tcc.gui2.managers;

import java.awt.Component;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public abstract class Manager implements ActionListener
{
    protected JDialog dialog;
    protected JPanel panel;
    
    public abstract JPanel create();
    
    public abstract String getTitle();
    
    public void open()
    {
        dialog = new JDialog();
        dialog.setTitle(this.getTitle());
        dialog.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        
        panel = this.create();
        
        dialog.getContentPane().add(panel);
        dialog.pack();
        dialog.setResizable(false);
        dialog.setLocationRelativeTo(null);
        
        this.captureEvents();
        
        dialog.setVisible(true);
    }
    
    public void cancel()
    {
        dialog.dispose();
    }
    
    protected void captureEvents()
    {
        for(Component c : panel.getComponents())
        {
            if(c instanceof JButton)
            {
                ((JButton) c).addActionListener(this);
            }
        }
    }
    
    protected void showError(Throwable t)
    {
        t.printStackTrace();
        String msg = (t.getMessage() == null || t.getMessage().equals("")) ? "Não foi possível completar a operação"
                : t.getMessage();
        JOptionPane.showMessageDialog(null, msg, "Erro", JOptionPane.ERROR_MESSAGE);
    }
}
