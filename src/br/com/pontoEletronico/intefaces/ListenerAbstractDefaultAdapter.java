
package br.com.pontoEletronico.intefaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

/**

 * @param <T>
 */
public abstract class ListenerAbstractDefaultAdapter<T> implements Serializable, ActionListener {

    private static final long serialVersionUID = 795437514392226740L;
    protected final T form;

    public ListenerAbstractDefaultAdapter(T form) {
        this.form = form;
    }

    protected void initComponents() {
        attachListener();
    }
<<<<<<< HEAD
    
    protected void attachListener(){
=======

    protected void attachListener() {
>>>>>>> upstream/master
        ((AbstractJFrame) form).getListButtons().ifPresent(lista -> lista.forEach(bt -> bt.addActionListener(this)));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "fechar":
                ((AbstractJFrame) form).fechar();
                break;
        }
    }

    public void setObject(Object object) {
    }

}
