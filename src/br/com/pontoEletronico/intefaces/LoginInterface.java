/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pontoEletronico.intefaces;

import br.com.pontoEletronico.dal.EntityManagerHelper;
import br.com.pontoEletronico.entities.Usuario;

/**
 *
 * @author Tiago
 */
public interface LoginInterface {
    
    public boolean validarLogin(String login, String senha, EntityManagerHelper<Usuario> emh);
    
}
