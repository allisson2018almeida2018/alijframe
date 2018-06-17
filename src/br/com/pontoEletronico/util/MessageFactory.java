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
public class MessageFactory implements Serializable {

    private static final long serialVersionUID = 283352174362849008L;
    public static final int FECHAR_FRAME = 0, FECHAR_SISTEMA = 1, LOGIN = 2, SALVAR = 3, VALIDAR_CAMPOS = 4, DELETAR = 5;

    public static boolean getSystemMsg(int msg, Component parent) {
        switch (msg) {
            case FECHAR_FRAME:
                return JOptionPane.showConfirmDialog(parent, "Deseja realmente fechar a tela?", "Fechar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0;
            case FECHAR_SISTEMA:
                return JOptionPane.showConfirmDialog(parent, "Deseja realmente fechar o sistema?", "Fechar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0;
            case SALVAR:
                return JOptionPane.showConfirmDialog(parent, "Deseja realmente salvar o registro?", "Salvar registro", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0;
            case DELETAR:
                return JOptionPane.showConfirmDialog(parent, "Deseja realmente deletar o registro?", "Deletar registro", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0;
            default:
                return false;
        }
    }

    public static void getOperationMsg(int msg, Component parent, boolean result) {
        switch (msg) {
            case LOGIN:
                if (result) {
                    JOptionPane.showMessageDialog(parent, "Login efetuado com sucesso", "Login", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(parent, "Erro ao tentar efetuar login", "Erro", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case SALVAR:
                if (result) {
                    JOptionPane.showMessageDialog(parent, "Registro salvo com sucesso", "Salvar", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(parent, "Erro ao tentar salvar registro", "Erro", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case DELETAR:
                if (result) {
                    JOptionPane.showMessageDialog(parent, "Registro deletado com sucesso", "Deletar", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(parent, "Erro ao tentar deletar registro", "Erro", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case VALIDAR_CAMPOS:
                if (!result) {
                    JOptionPane.showMessageDialog(parent, "Os campos obrigatórios não foram preenchidos", "Erro de validação", JOptionPane.WARNING_MESSAGE);
                }
                break;
        }
    }

}
