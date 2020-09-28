/*
 */

package views;

import java.awt.*;
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
    
    private PanelDraw panelDraw;

    public GraphPanel(){
        this.panelDraw = new PanelDraw();
        this.setLayout(new BorderLayout());
        this.add(this.panelDraw, BorderLayout.CENTER);
    }


    public PanelDraw getPanelDraw() {
        return this.panelDraw;
    }


 
}


 




