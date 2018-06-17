
package br.com.pontoEletronico.intefaces;

/**
 
 * @param <T>
 */
public interface Bean<T> {
    
    public void clear();
    public void copiar(T object);
    public T clonar();
    
}
