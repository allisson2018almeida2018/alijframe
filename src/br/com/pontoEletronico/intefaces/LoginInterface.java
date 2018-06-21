
package br.com.pontoEletronico.intefaces;

import br.com.pontoEletronico.dal.EntityManagerHelper;
import br.com.pontoEletronico.entities.Usuario;


public interface LoginInterface {
    
    public boolean validarLogin(String login, String senha, EntityManagerHelper<Usuario> emh);
    
}
