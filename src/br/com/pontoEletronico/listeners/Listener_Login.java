/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pontoEletronico.listeners;

import br.com.pontoEletronico.dal.EntityManagerHelper;
import br.com.pontoEletronico.entities.Usuario;
import br.com.pontoEletronico.frames.Form_Login;
import br.com.pontoEletronico.frames.Form_Menu_Principal;
import br.com.pontoEletronico.intefaces.ListenerAbstractDefaultAdapter;
import br.com.pontoEletronico.intefaces.LoginInterface;
import br.com.pontoEletronico.util.ControleInstancias;
import br.com.pontoEletronico.util.UserLogin;
import java.awt.event.ActionEvent;

/**
 *
 * @author Tiago
 */
public final class Listener_Login extends ListenerAbstractDefaultAdapter<Form_Login> {

    private static final long serialVersionUID = -8990698351889987311L;
    private final EntityManagerHelper<Usuario> emh = new EntityManagerHelper();
    private final Usuario usuario = new Usuario();
    private final LoginInterface login = new UserLogin();

    public Listener_Login(Form_Login form) {
        super(form);
        initComponents();
    }

    @Override
    protected void initComponents() {
        super.initComponents();
        Usuario user = new Usuario(1l, "Administrador", "admin", "admin");
        emh.getOperation(EntityManagerHelper.SALVAR, user, EntityManagerHelper.MYSQL_PU);
    }

    @Override
    protected void attachListener() {
        form.getListButtons().ifPresent(lista -> lista.stream().forEach(bt -> bt.addActionListener(this)));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "login":
                if (login.validarLogin(form.getTxtLogin().getText(), String.valueOf(form.getTxtPassword().getPassword()), emh)) {
                    Form_Menu_Principal principal = (Form_Menu_Principal) ControleInstancias.getInstance(Form_Menu_Principal.class.getName());
                    principal.setVisible(true);
                    form.dispose();
                }
                break;
            case "fechar":
                form.fecharSistema();
        }
    }

}
