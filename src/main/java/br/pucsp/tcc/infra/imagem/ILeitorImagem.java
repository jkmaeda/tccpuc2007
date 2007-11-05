package br.pucsp.tcc.infra.imagem;

import java.awt.Image;

public interface ILeitorImagem
{
    Image converter(byte[] bytes);
    
    byte[] converter(Image imagem);
}
