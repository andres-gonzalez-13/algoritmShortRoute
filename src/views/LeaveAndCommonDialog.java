package views;

import controller.MainActivity;
import dataestructure.Cursor;
import dataestructure.Vertex;
import models.Social;
import rojeru_san.RSButtonRiple;
import utils.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LeaveAndCommonDialog extends JDialog {


    private Cursor<Vertex> socialCursor;
    private DefaultComboBoxModel socialBoxModel;
    private JComboBox<Social> socialPerson;
    private RSButtonRiple btnDelete;

    public LeaveAndCommonDialog(Social social, ActionListener actionListener) {
        this.leaveAndCommonDialogFeatures();
        socialCursor = new Cursor<>(social);
        socialBoxModel = new DefaultComboBoxModel();
        socialPerson = new JComboBox<>();
        this.btnDelete = new RSButtonRiple();

        btnDelete.setActionCommand(MainActivity.LEAVE_NETWORK_FINALLY.toString());
        btnDelete.addActionListener(actionListener);

        while (!socialCursor.isOut()){
            socialBoxModel.addElement(socialCursor.info().getPersonSocial().getId() + ", " + socialCursor.getInfoAndNext().getPersonSocial().getNickName());
        }

        if (socialBoxModel.getSize() == 0){
            this.btnDelete.setEnabled(false);
        } else {
            this.btnDelete.setEnabled(true);
        }

        socialPerson.setModel(socialBoxModel);
        btnDelete.setText("Dejar la red social");
        socialPerson.setFont(Constants.fontBtn(20));
        btnDelete.setFont(Constants.fontBtn(20));
        this.add(Constants.insidePanel(socialPerson, 15,70,15,70,"#FFFF",false));
        this.add(Constants.insidePanel(btnDelete, 15,70,15,70,"#FFFF",false));

    }

    private void leaveAndCommonDialogFeatures() {
        this.pack();
        this.setResizable(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLayout(new GridLayout(4, 1));
        this.setSize(620, 380);
        this.setModal(true);
        this.setTitle("Dejar la red social");
        this.setLocationRelativeTo(null); //JUSTO DESPUES DE MI "setSize()"
    }

    public int getIdPerson() {
        return Integer.parseInt(socialPerson.getSelectedItem().toString().split(",")[0]);
    }

    public void refresPanel(){
        this.removeAll();
        this.add(socialPerson);
        this.add(btnDelete);
        this.repaint();
    }
}
