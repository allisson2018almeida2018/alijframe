/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pontoEletronico.util;

import java.awt.Component;
import java.io.Serializable;
import javax.swing.JOptionPane;

/**
 *
 * @author Tiago
 */
public class MessageFactory implements Serializable{

    private static final long serialVersionUID = 283352174362849008L;
    public static final int FECHAR_FRAME = 0, FECHAR_SISTEMA = 1;
    
    public static boolean getSystemMsg(int msg, Component parent){
        switch(msg){
            case FECHAR_FRAME:
                return JOptionPane.showConfirmDialog(parent, "Deseja realmente fechar a tela?", "Fechar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0;
            case FECHAR_SISTEMA:
                return JOptionPane.showConfirmDialog(parent, "Deseja realmente fechar o sistema?", "Fechar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0;
            default:
                return false;
        }
    }
    
}
