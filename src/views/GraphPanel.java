/*
 */

package views;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 
 * @author Andres santiago <Andrecksantiago@gmail.com>
 */
public class GraphPanel extends JPanel{
    
    private PanelDraw pd;
    int max=0;
    private JTextField valor;
 
    public void init(ActionListener action){
        setLayout(new BorderLayout());
        pd = new PanelDraw();
        add(pd, BorderLayout.CENTER);

        JPanel pdatos=new JPanel();

        JButton agregar = new JButton("Agregar Nodo");
        agregar.addActionListener(action);

        valor=new JTextField(5);
        pdatos.add(new JLabel("Valor Vertice" +""));
        pdatos.add(valor);
        pdatos.add(agregar);
        add(pdatos,BorderLayout.SOUTH);
    }

    public PanelDraw getPd() {
        return pd;
    }
    
    
 
}


 




