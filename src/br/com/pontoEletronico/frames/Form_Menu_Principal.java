package br.com.pontoEletronico.frames;

import br.com.pontoEletronico.intefaces.AbstractJFrame;
import br.com.pontoEletronico.listeners.Listener_Menu_Principal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import javax.swing.JButton;

public final class Form_Menu_Principal extends AbstractJFrame {

    private static final long serialVersionUID = 2302738149495596051L;
    private final Listener_Menu_Principal listener;

    public Form_Menu_Principal() {
        setImageIcon();
        initComponents();
        listener = new Listener_Menu_Principal(this);
    }

    @Override
    public Optional<List<JButton>> getListButtons() {
        return Optional.ofNullable(Arrays.asList(btAcessarMenu, btBaterPonto, btSair));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        btBaterPonto = new javax.swing.JButton();
        btAcessarMenu = new javax.swing.JButton();
        btSair = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela Principal");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btBaterPonto.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btBaterPonto.setText("1-Bater Ponto");
        btBaterPonto.setActionCommand("baterPonto");
        getContentPane().add(btBaterPonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 92, 125, -1));

        btAcessarMenu.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btAcessarMenu.setText("2- Acessar Menu");
        btAcessarMenu.setActionCommand("acessarMenu");
        getContentPane().add(btAcessarMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 142, -1, -1));

        btSair.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btSair.setText("3-sair");
        btSair.setActionCommand("fechar");
        getContentPane().add(btSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 194, 125, -1));

        jLabel3.setText("Menu Principal do Sistema");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 30, -1, -1));

        setSize(new java.awt.Dimension(249, 340));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Form_Menu_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_Menu_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_Menu_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_Menu_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_Menu_Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAcessarMenu;
    private javax.swing.JButton btBaterPonto;
    private javax.swing.JButton btSair;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
