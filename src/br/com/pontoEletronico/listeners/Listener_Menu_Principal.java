
package br.com.pontoEletronico.listeners;

import br.com.pontoEletronico.frames.Form_Menu_Gestao;
import br.com.pontoEletronico.frames.Form_Menu_Principal;
import br.com.pontoEletronico.frames.Form_Validar_Ponto;
import br.com.pontoEletronico.intefaces.ListenerAbstractDefaultAdapter;
import br.com.pontoEletronico.util.ControleInstancias;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;


public class Listener_Menu_Principal extends ListenerAbstractDefaultAdapter<Form_Menu_Principal> {

    private static final long serialVersionUID = -2406298625979756040L;

    public Listener_Menu_Principal(Form_Menu_Principal form) {
        super(form);
        initComponents();
    }

    @Override
    public void actionPerformed(ActionEvent aEvent) {
        switch (aEvent.getActionCommand()) {
            case "baterPonto":
                Form_Validar_Ponto validarPonto = (Form_Validar_Ponto) ControleInstancias.getInstance(Form_Validar_Ponto.class.getName());
                validarPonto.setVisible(true);
                validarPonto.requestFocus();
                validarPonto.setState(JFrame.NORMAL);
                break;
            case "acessarMenu":
                Form_Menu_Gestao gestao = (Form_Menu_Gestao) ControleInstancias.getInstance(Form_Menu_Gestao.class.getName());
                gestao.setVisible(true);
                gestao.requestFocus();
                gestao.setState(JFrame.NORMAL);
                break;
            case "fechar":
                form.fecharSistema();
                break;
        }
    }

}
