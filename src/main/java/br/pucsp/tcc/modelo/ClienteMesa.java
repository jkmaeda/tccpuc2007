package br.pucsp.tcc.modelo;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ClienteMesa extends Cliente
{
    private List<ClienteIndividual> clientesIndividuais;
    
    public ClienteMesa() {
        this.setClientesIndividuais(new LinkedList<ClienteIndividual>());
    }
    
    public List<ClienteIndividual> getClientesIndividuais() {
        return clientesIndividuais;
    }
    public void setClientesIndividuais(
            List<ClienteIndividual> clientesIndividuais) {
        this.clientesIndividuais = clientesIndividuais;
    }
    
    // configurar o logger
    static Log logger = LogFactory.getLog(ClienteMesa.class);
}
