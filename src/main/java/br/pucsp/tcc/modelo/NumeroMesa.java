package br.pucsp.tcc.modelo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class NumeroMesa extends Identificacao
{
    private int numero;
    
    public NumeroMesa(int numero) {
        this.setNumero(numero);
    }
    
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    // configurar o logger
    static Log logger = LogFactory.getLog(NumeroMesa.class);
}
