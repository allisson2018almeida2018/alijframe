/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pontoEletronico.intefaces;

/**
 *
 * @author Tiago
 * @param <T>
 */
public interface Bean<T> {
    
    public void clear();
    public void copiar(T object);
    public T clonar();
    
}
