package views;

import controller.MainActivity;
import dataestructure.Vertex;
import models.Social;
import rojeru_san.RSButtonRiple;
import utils.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Vector;

public class SocialPanel extends JPanel {

    private JPanel leftPanel;
    private GraphPanel graphPanel;
    private PersonsDialog personsDialog;
    private LeaveAndCommonDialog leaveAndCommonDialog;

    public SocialPanel(ActionListener actionListener, Vector<Vertex> vertexToShow, Social social) {
        this.socialPanelInstances(actionListener, vertexToShow);
        this.socialPanelFeatures();
        this.socialPanelInternalContent(social, actionListener);
    }

    private void socialPanelFeatures(){
        this.setOpaque(false);
        this.setLayout(new BorderLayout());
    }

    private void socialPanelInternalContent(Social social, ActionListener actionListener){
        this.add(leftPanel, BorderLayout.LINE_START);
        this.add(this.graphPanel, BorderLayout.CENTER);
        this.personsDialog = new PersonsDialog(social, actionListener);
        this.leaveAndCommonDialog = new LeaveAndCommonDialog(social, actionListener);
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

    public void repaintGraphic() {
        this.repaint();
        this.graphPanel.repaint();
    }

    public void addFriend(Social social, ActionListener actionListener) {
        this.refreshValues(social, actionListener);

        this.personsDialog.getSocialPerson().addActionListener(actionListener);
        this.personsDialog.getSocialPerson().setActionCommand(MainActivity.SHOW_PERSONS.toString());

        this.personsDialog.getAcceptAction().addActionListener(actionListener);
        this.personsDialog.getAcceptAction().setActionCommand(MainActivity.ADD_FRIEND_FINALLY.toString());

        this.personsDialog.showPersons(social, actionListener);
        this.personsDialog.setVisible(true);
    }

    public void deleteFriend(Social social, ActionListener actionListener) {
        this.refreshValues(social, actionListener);

        this.personsDialog.getSocialPerson().addActionListener(actionListener);
        this.personsDialog.getSocialPerson().setActionCommand(MainActivity.DELETE_PERSON.toString());

        this.personsDialog.getAcceptAction().addActionListener(actionListener);
        this.personsDialog.getAcceptAction().setActionCommand(MainActivity.DELETE_FRIEND_FINALLY.toString());

        this.personsDialog.showPersonsDeleted(social, actionListener);
        this.personsDialog.setVisible(true);
    }

    public void mutualFriends(Social social, ActionListener actionListener) {
        System.out.println("ENTRO MUTUEL");
    }

    public void leaveTheSocialNetwork(Social social, ActionListener actionListener) {
        this.leaveAndCommonDialog = new LeaveAndCommonDialog(social, actionListener);
        this.leaveAndCommonDialog.setVisible(true);
    }


    public int leaveNetworkFinally() {
        return this.leaveAndCommonDialog.getIdPerson();
    }


    public void showPersons(Social social, ActionListener actionListener) {
        personsDialog.showPersons(social,actionListener);
    }

    public void showPersonsDeleted(Social social, ActionListener actionListener) {
        personsDialog.showPersonsDeleted(social,actionListener);
    }

    public int[] addFrienFinally() {
        return personsDialog.addFriendFinally();
    }


    public void resetGraph(Vector<Vertex> vertexToShow) {
        this.graphPanel.setOpaque(false);
        this.graphPanel.getPanelDraw().setVgrafos(vertexToShow);
        this.revalidate();
        this.repaint();
    }

    public void refreshValues(Social social, ActionListener actionListener) {
        this.personsDialog = new PersonsDialog(social, actionListener);
    }
}
