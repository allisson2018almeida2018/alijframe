package br.com.pontoEletronico.frames;

import br.com.pontoEletronico.intefaces.AbstractJFrame;
import br.com.pontoEletronico.listeners.Listener_Login;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public final class Form_Login extends AbstractJFrame {

    private static final long serialVersionUID = 6484359625681437289L;
    private final Listener_Login listener;

    public Form_Login() {
        setImageIcon();
        initComponents();
        listener = new Listener_Login(this);
    }

    @Override
    public Optional<List<JButton>> getListButtons() {
        return Optional.ofNullable(Arrays.asList(btAcessar, btSair));
    }

    public JButton getBtAcessar() {
        return btAcessar;
    }

    public JButton getBtSair() {
        return btSair;
    }

    public JTextField getTxtLogin() {
        return txtLogin;
    }

    public JPasswordField getTxtPassword() {
        return txtPassword;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        btAcessar = new javax.swing.JButton();
        btSair = new javax.swing.JButton();
        imgFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela Login");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("USUÁRIO:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 70, 10));

        jLabel1.setText("SENHA:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 70, 10));
        getContentPane().add(txtLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, 110, 30));
        getContentPane().add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 110, 30));

        btAcessar.setText("Acessar");
        btAcessar.setActionCommand("login");
        getContentPane().add(btAcessar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, 90, 40));

        btSair.setText("Sair");
        btSair.setActionCommand("fechar");
        getContentPane().add(btSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 220, 90, 40));

        imgFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pontoEletronico/img/teste2.jpg"))); // NOI18N
        getContentPane().add(imgFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 320));

        setSize(new java.awt.Dimension(416, 362));
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Form_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAcessar;
    private javax.swing.JButton btSair;
    private javax.swing.JLabel imgFundo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables
}
