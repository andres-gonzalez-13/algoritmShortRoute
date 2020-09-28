package views;

import controller.MainActivity;
import dataestructure.Cursor;
import dataestructure.SimpleList;
import dataestructure.Vertex;
import models.PersonSocial;
import models.Social;
import rojeru_san.RSButtonRiple;
import utils.Constants;

import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

public class PersonsDialog extends JDialog {

    private Cursor<Vertex> socialCursor;
    private Cursor<Vertex> socialCursorDeleted;
    private Cursor<PersonSocial> personSocialCursor;

    private DefaultComboBoxModel socialBoxModel;
    private DefaultComboBoxModel secondSocialBoxModel;
    private JComboBox<Social> socialPerson;
    private JComboBox<Social> secondSocialPerson;
    private RSButtonRiple acceptAction;
    private ShowMessageDialog showMessageDialog;

    public JComboBox<Social> getSocialPerson() {
        return socialPerson;
    }

    public RSButtonRiple getAcceptAction() {
        return acceptAction;
    }

    public PersonsDialog(Social social, ActionListener actionListener) {
        this.personsDialogFeatures();
        this.socialBoxModel = new DefaultComboBoxModel();
        this.secondSocialBoxModel = new DefaultComboBoxModel();
        this.socialPerson = new JComboBox();
        this.secondSocialPerson = new JComboBox();
        acceptAction = new RSButtonRiple();
        this.socialCursor = new Cursor<>(social);

        while (!socialCursor.isOut()) {
            socialBoxModel.addElement(socialCursor.info().getPersonSocial().getId() + ", " + socialCursor.getInfoAndNext().getPersonSocial().getNickName());
        }

        this.socialPerson.setModel(socialBoxModel);


        socialPerson.setFont(Constants.fontBtn(20));
        secondSocialPerson.setFont(Constants.fontBtn(20));
        acceptAction.setFont(Constants.fontBtn(20));

        this.add(Constants.insidePanel(socialPerson, 15,70,15,70,"#FFFF",false));
        this.add(Constants.insidePanel(secondSocialPerson, 15,70,15,70,"#FFFF",false));
        this.add(Constants.insidePanel(acceptAction, 15,70,15,70,"#FFFF",false));

    }

    private void personsDialogFeatures() {
        this.setResizable(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setTitle("Topicos Avanzados de Programación");
        this.setLayout(new GridLayout(5, 1));
        this.setSize(720, 480);
        this.setModal(true);
        this.setLocationRelativeTo(null); //JUSTO DESPUES DE MI "setSize()"
    }


    public void showPersons(Social social, ActionListener actionListener) {
        System.out.println("PERSONA SELECCIONADA: " + socialPerson.getSelectedItem());
        personSocialCursor = new Cursor<>(social.notFriendsAtPerson(Integer.parseInt(socialPerson.getSelectedItem().toString().split(",")[0])));

        secondSocialBoxModel = new DefaultComboBoxModel();
        while (!personSocialCursor.isOut()) {
            System.out.println("PERSONAS PROBANDO: " + personSocialCursor.info().getNickName());
            secondSocialBoxModel.addElement(personSocialCursor.info().getId() + ", " + personSocialCursor.getInfoAndNext().getNickName());
        }

        if (secondSocialBoxModel.getSize() == 0){
            acceptAction.setEnabled(false);
        } else {
            acceptAction.setEnabled(true);
        }


        secondSocialPerson.setModel(secondSocialBoxModel);
        secondSocialPerson.revalidate();
        secondSocialPerson.repaint();
    }

    public int[] addFriendFinally() {
        int valuesId[] = {Integer.parseInt(socialPerson.getSelectedItem().toString().split(",")[0]), Integer.parseInt(secondSocialPerson.getSelectedItem().toString().split(",")[0])};
        return valuesId;
    }

    public void showPersonsDeleted(Social social, ActionListener actionListener) {
        System.out.println("PERSONA SELECCIONADA: " + socialPerson.getSelectedItem());
        socialCursorDeleted = new Cursor<>(social.getFriends(Integer.parseInt(socialPerson.getSelectedItem().toString().split(",")[0])));

        secondSocialBoxModel = new DefaultComboBoxModel();

        while (!socialCursorDeleted.isOut()) {
            secondSocialBoxModel.addElement(socialCursorDeleted.info().getPersonSocial().getId() + ", " + socialCursorDeleted.getInfoAndNext().getPersonSocial().getNickName());
        }

        if (secondSocialBoxModel.getSize() == 0){
            acceptAction.setEnabled(false);
        } else {
            acceptAction.setEnabled(true);
        }


        secondSocialPerson.setModel(secondSocialBoxModel);
        secondSocialPerson.revalidate();
        secondSocialPerson.repaint();
    }


    public void mutualFriendsShow(Social social, ActionListener actionListener) {
        personSocialCursor = new Cursor<>(social.getPersonsNotI(Integer.parseInt(socialPerson.getSelectedItem().toString().split(",")[0])));
        secondSocialBoxModel = new DefaultComboBoxModel();

        while (!personSocialCursor.isOut()) {
            secondSocialBoxModel.addElement(personSocialCursor.info().getId() + ", " + personSocialCursor.getInfoAndNext().getNickName());
        }

        if (secondSocialBoxModel.getSize() == 0){
            acceptAction.setEnabled(false);
        } else {
            acceptAction.setEnabled(true);
        }



        secondSocialPerson.setModel(secondSocialBoxModel);
        secondSocialPerson.revalidate();
        secondSocialPerson.repaint();
    }

    public void mutualFriendFinally(SimpleList<PersonSocial> commonFriends) {

        JLabel mutualFrindsLabel = new JLabel();
        Cursor<PersonSocial> commonCursor = new Cursor<>(commonFriends);

        while (!commonCursor.isOut()) {
            mutualFrindsLabel.setText(commonCursor.getInfoAndNext().getNickName() + ", " + mutualFrindsLabel.getText());
        }
        System.out.println("HOLA PRUEBA");
        showMessageDialog = new ShowMessageDialog(mutualFrindsLabel);

    }
}
