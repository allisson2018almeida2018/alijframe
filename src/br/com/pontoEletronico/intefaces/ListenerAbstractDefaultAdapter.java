/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pontoEletronico.intefaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

/**
 *
 * @author Tiago
 * @param <T>
 */
public abstract class ListenerAbstractDefaultAdapter<T> implements Serializable, ActionListener{
    
    private static final long serialVersionUID = 795437514392226740L;
    protected final T form;

    public ListenerAbstractDefaultAdapter(T form) {
        this.form = form;
    }
    
    protected void initComponents(){
        attachListener();
    }
    
    protected void attachListener(){
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "fechar":
                ((AbstractJFrame) form).fechar();
                break;
        }
    }

}
