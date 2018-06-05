/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pontoEletronico.util;

import br.com.pontoEletronico.dal.EntityManagerHelper;
import br.com.pontoEletronico.entities.Usuario;
import br.com.pontoEletronico.intefaces.LoginInterface;

/**
 *
 * @author Tiago
 */
public class UserLogin implements LoginInterface {

    private final Usuario usuario = new Usuario();
    
    @Override
    public boolean validarLogin(String login, String senha, EntityManagerHelper<Usuario> emh) {
        usuario.copiar(emh.getObjectNamedQuery(Usuario.class, "usuario.findByLogin", "paramLogin", login, EntityManagerHelper.MYSQL_PU));
        if(usuario.getId() != null){
            return usuario.getSenha().equals(senha);
        }
        return false;
    }
    
}
