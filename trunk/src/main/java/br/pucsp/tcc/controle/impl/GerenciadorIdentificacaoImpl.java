package br.pucsp.tcc.controle.impl;

import br.pucsp.tcc.controle.GerenciadorIdentificacao;
import br.pucsp.tcc.exception.OperacaoInvalidaException;
import br.pucsp.tcc.modelo.Identificacao;
import br.pucsp.tcc.modelo.ImpressaoDigital;
import br.pucsp.tcc.modelo.NumeroMesa;
import br.pucsp.tcc.modelo.TipoIdentificacao;
import br.pucsp.tcc.repositorio.FabricaRepositorio;
import br.pucsp.tcc.repositorio.RepositorioIdentificacao;

public class GerenciadorIdentificacaoImpl implements GerenciadorIdentificacao
{
    FabricaRepositorio fabRepositorios;
    RepositorioIdentificacao repIdentificacao;
    
    public GerenciadorIdentificacaoImpl() {
        fabRepositorios = new FabricaRepositorio();
        repIdentificacao = fabRepositorios.getRepIdentificacao();
    }
    
    @Override
    public Identificacao gerarIdentificacao(String info,
            TipoIdentificacao tipo) throws OperacaoInvalidaException
    {
        Identificacao id = null;
        
        // construir a identificação
        switch(tipo)
        {
            case IMPRESSAO_DIGITAL:
                id = new ImpressaoDigital(info);
                break;
                
            case MESA:
                id = new NumeroMesa(Integer.parseInt(info));
                break;
                
            default:
                throw new OperacaoInvalidaException("Tipo de identificação desconhecido");
        }
        
        return id;
    }
}
