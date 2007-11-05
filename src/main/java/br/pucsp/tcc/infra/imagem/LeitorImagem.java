package br.pucsp.tcc.infra.imagem;

import java.awt.Image;

/**
 * Realiza a conversão de imagens de acordo com o argumento fornecido.
 * 
 * @author Gustavo Steigert
 * @author Mark Ferreira
 */
public interface LeitorImagem
{
    Image converter(byte[] bytes);
    
    byte[] converter(Image imagem);
}
