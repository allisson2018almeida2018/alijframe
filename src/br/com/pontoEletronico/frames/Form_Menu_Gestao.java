/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pontoEletronico.frames;

import br.com.pontoEletronico.intefaces.AbstractJFrame;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import javax.swing.JButton;

/**
 *
 * @author ALMEIDA
 */
public final class Form_Menu_Gestao extends AbstractJFrame {

    private static final long serialVersionUID = 4156382916689717568L;

    /**
     * Creates new form BatendoPonto
     */
    public Form_Menu_Gestao() {
        setImageIcon();
        initComponents();
    }

    @Override
    public Optional<List<JButton>> getListButtons() {
        return Optional.ofNullable(Arrays.asList(btExportarFolha, btSair, btVerFolha, btVerHoras, btVoltar));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btVerFolha = new javax.swing.JButton();
        btVerHoras = new javax.swing.JButton();
        btExportarFolha = new javax.swing.JButton();
        btVoltar = new javax.swing.JButton();
        btSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("MENU");

        btVerFolha.setText("1- Ver folha de ponto");
        btVerFolha.setActionCommand("verFolha");
        btVerFolha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVerFolhaActionPerformed(evt);
            }
        });

        btVerHoras.setText("2- Ver horas trabalhadas");
        btVerHoras.setActionCommand("verHoras");
        btVerHoras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVerHorasActionPerformed(evt);
            }
        });

        btExportarFolha.setText("3- Exportar folha de ponto");
        btExportarFolha.setActionCommand("exportarFolha");
        btExportarFolha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExportarFolhaActionPerformed(evt);
            }
        });

        btVoltar.setText("4-Voltar");
        btVoltar.setActionCommand("voltar");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });

        btSair.setText("5-Sair");
        btSair.setActionCommand("fechar");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btVerFolha, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btExportarFolha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addComponent(btVerHoras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(220, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addGap(37, 37, 37)
                .addComponent(btVerFolha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btVerHoras)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btExportarFolha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btVoltar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btSair)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btExportarFolhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExportarFolhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btExportarFolhaActionPerformed

    private void btVerFolhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVerFolhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btVerFolhaActionPerformed

    private void btVerHorasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVerHorasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btVerHorasActionPerformed

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btVoltarActionPerformed

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btSairActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Form_Menu_Gestao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_Menu_Gestao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_Menu_Gestao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_Menu_Gestao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_Menu_Gestao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btExportarFolha;
    private javax.swing.JButton btSair;
    private javax.swing.JButton btVerFolha;
    private javax.swing.JButton btVerHoras;
    private javax.swing.JButton btVoltar;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}