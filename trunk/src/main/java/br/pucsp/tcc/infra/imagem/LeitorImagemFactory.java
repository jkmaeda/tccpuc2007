package br.pucsp.tcc.infra.imagem;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LeitorImagemFactory
{
    private static LeitorImagem leitor;
    
    public LeitorImagemFactory()
    {
    }
    
    public static LeitorImagem get()
    {
        if(LeitorImagemFactory.leitor == null)
        {
            logger.debug("Criando leitor (conversor) de imagem");
            LeitorImagemFactory.leitor = new LeitorImagemMemoria();
        }
        return leitor;
    }
    
    static Log logger = LogFactory.getLog(LeitorImagemFactory.class);
}
