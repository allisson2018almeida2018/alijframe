
package br.com.pontoEletronico.intefaces;

import br.com.pontoEletronico.util.MessageFactory;
import java.awt.Image;
import java.util.List;
import java.util.Optional;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;


public abstract class AbstractJFrame extends JFrame{
    
    private static final long serialVersionUID = 4839238423907716969L;
    private final Image image = new ImageIcon(getClass().getResource("/br/com/pontoEletronico/img/icon.gif")).getImage();
    
    public abstract Optional<List<JButton>> getListButtons();
    
    protected void setImageIcon(){
        if(image != null){
            setIconImage(image);
        }
    }
    
    public void fechar(){
        if(MessageFactory.getSystemMsg(MessageFactory.FECHAR_FRAME, this)){
            dispose();
        }
    }
    
    public void fecharSistema(){
        if(MessageFactory.getSystemMsg(MessageFactory.FECHAR_SISTEMA, this)){
            System.exit(0);
        }
    }
}
