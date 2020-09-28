package views;

import controller.MainActivity;
import rojeru_san.RSButtonRiple;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SocialPanel extends JPanel {

    private JPanel leftPanel;
    private GraphPanel graphPanel;


    public SocialPanel(ActionListener actionListener) {
        this.socialPanelInstances(actionListener);
        this.socialPanelFeatures();
        this.socialPanelInternalContent();
    }

    private void socialPanelFeatures(){
        this.setOpaque(false);
        this.setLayout(new BorderLayout());
    }

    private void socialPanelInternalContent(){
        this.add(leftPanel, BorderLayout.LINE_START);
        this.add(new JPanel(), BorderLayout.CENTER);
    }

    private void socialPanelInstances(ActionListener actionListener) {
        this.leftPanel = leftPanel(actionListener);
        this.graphPanel = new GraphPanel();

    }

    private JPanel leftPanel(ActionListener actionListener){
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(11, 1));
        BtnArray[] btnArrays =  {
                new BtnArray("Eliminar amigos", MainActivity.DELETE_FRIEND.toString(),  actionListener, "#3498db"),
                new BtnArray("Añadir amigos", MainActivity.ADD_FRIEND.toString(), actionListener, "#3498db"),
                new BtnArray("Amigos en común", MainActivity.MUTUAL_FRIENDS.toString(), actionListener, "#3498db"),
                new BtnArray("Salir de la red social", MainActivity.LEAVE_THE_SOCIAL_NETWORK.toString(), actionListener, "#3498db") };
        for (BtnArray btn: btnArrays) {
            leftPanel.add(btn);
        }
        return leftPanel;
    }

}
