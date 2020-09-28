package views;

import controller.MainActivity;
import dataestructure.Vertex;
import rojeru_san.RSButtonRiple;
import utils.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Vector;

public class SocialPanel extends JPanel {

    private JPanel leftPanel;
    private GraphPanel graphPanel;


    public SocialPanel(ActionListener actionListener, Vector<Vertex> vertexToShow) {
        this.socialPanelInstances(actionListener, vertexToShow);
        this.socialPanelFeatures();
        this.socialPanelInternalContent();
    }

    private void socialPanelFeatures(){
        this.setOpaque(false);
        this.setLayout(new BorderLayout());
    }

    private void socialPanelInternalContent(){
        this.add(leftPanel, BorderLayout.LINE_START);
        this.add(this.graphPanel, BorderLayout.CENTER);
    }

    private void socialPanelInstances(ActionListener actionListener, Vector<Vertex> vertexToShow) {
        this.leftPanel = leftPanel(actionListener);
        this.graphPanel = new GraphPanel();
        this.graphPanel.setOpaque(false);
        this.graphPanel.getPanelDraw().setVgrafos(vertexToShow);

    }

    private JPanel leftPanel(ActionListener actionListener){
        JPanel leftPanel = new JPanel();
        leftPanel.setOpaque(false);
        leftPanel.setLayout(new GridLayout(12, 1));
        BtnArray[] btnArrays =  {
                new BtnArray("Eliminar amigos", MainActivity.DELETE_FRIEND.toString(),  actionListener, "#3498db"),
                new BtnArray("Añadir amigos", MainActivity.ADD_FRIEND.toString(), actionListener, "#3498db"),
                new BtnArray("Amigos en común", MainActivity.MUTUAL_FRIENDS.toString(), actionListener, "#3498db"),
                new BtnArray("Salir de la red social", MainActivity.LEAVE_THE_SOCIAL_NETWORK.toString(), actionListener, "#3498db") };
        leftPanel.add(Constants.getSpace(0,0,0,0));
        for (BtnArray btn: btnArrays) {
            leftPanel.add(Constants.insidePanel(btn, 15,10,15,10,"#0000", false));
        }
        return leftPanel;
    }

    public void addFriend() {
        System.out.println("ENTRO ADD");
    }

    public void deleteFriend() {
        System.out.println("ENTRO FRIEND");
    }

    public void mutualFriends() {
        System.out.println("ENTRO MUTUEL");
    }

    public void leaveTheSocialNetwork() {
        System.out.println("ENTRO LEAVE");
    }


}
