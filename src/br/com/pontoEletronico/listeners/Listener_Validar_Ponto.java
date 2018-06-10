/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pontoEletronico.listeners;

import br.com.pontoEletronico.dal.EntityManagerHelper;
import br.com.pontoEletronico.entities.FolhaPonto;
import br.com.pontoEletronico.entities.Funcionario;
import br.com.pontoEletronico.entities.Ponto;
import br.com.pontoEletronico.frames.Form_Validar_Ponto;
import br.com.pontoEletronico.intefaces.ListenerAbstractDefaultAdapter;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.swing.JOptionPane;

/**
 *
 * @author Tiago
 */
public final class Listener_Validar_Ponto extends ListenerAbstractDefaultAdapter<Form_Validar_Ponto> {

    private static final long serialVersionUID = 955209342845885525L;

    private final EntityManagerHelper emh = new EntityManagerHelper();
    private final FolhaPonto folhaPonto = new FolhaPonto();
    private final Ponto ponto = new Ponto();

    public Listener_Validar_Ponto(Form_Validar_Ponto form) {
        super(form);
        initComponents();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        switch (e.getActionCommand()) {
            case "ponto":
                baterPonto();
                break;
        }
    }

    private void baterPonto() {
        Funcionario func = (Funcionario) emh.getObjectNamedQuery(Funcionario.class, "funcionario.findByMatricula", "paramMatricula", Long.parseLong(form.getTxtMatricula().getText()), EntityManagerHelper.MYSQL_PU);
        if (func != null && func.getSenha().equals(form.getTxtSenha().getText())) {
            verificarPolhaPonto(func);
            folhaPonto.getListaPonto().add(new Ponto(folhaPonto, LocalDate.now(), LocalTime.now(),
                    folhaPonto.getListaPonto().isEmpty() ? Ponto.ENTRADA
                    : folhaPonto.getListaPonto().get(folhaPonto.getListaPonto().size() - 1).getTipo() == Ponto.ENTRADA ? Ponto.SAIDA : Ponto.ENTRADA
            ));
            emh.getOperation(EntityManagerHelper.ATUALIZAR, folhaPonto, EntityManagerHelper.MYSQL_PU);
            JOptionPane.showMessageDialog(form, "Ponto Registrado com sucesso!", "Ponto Registrado", JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(form, "Funcionário não encontrado", "Registro Inexistente", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void verificarPolhaPonto(Funcionario func) {
        if (func != null) {
            Optional<List<?>> lista = Optional.ofNullable(emh.getObjectListNamedQuery(FolhaPonto.class, "folha.findByFuncionario", new String[]{"paramFuncionario"}, new Object[]{func}, EntityManagerHelper.MYSQL_PU));
            if (lista.isPresent()) {
                List<FolhaPonto> folhas = (List<FolhaPonto>) lista.get();
                folhas.forEach((fp) -> {
                    if (fp.getMesReferencia().equals(LocalDate.now().format(DateTimeFormatter.ofPattern("MM/yyyy")))) {
                        folhaPonto.copiar(fp);
                    } else {
                        folhaPonto.copiar(new FolhaPonto(LocalDate.now().format(DateTimeFormatter.ofPattern("MM/yyyy")), func, new ArrayList()));
                    }
                });
            }
        }
    }

}
