package views;

import dataestructure.Cursor;
import dataestructure.Vertex;
import models.Social;

import javax.swing.*;
import java.awt.*;

public class PersonsDialog extends JDialog {

    private Cursor<Vertex> socialCursor;
    private DefaultComboBoxModel dml;

    private JComboBox<String> firstPerson;
   private JComboBox<String> secondPerson;


   public PersonsDialog(Social social){
       this.personsDialogFeatures();

       this.dml = new DefaultComboBoxModel();
       this.socialCursor = new Cursor<>(social);

       while (!socialCursor.isOut()) {
           dml.addElement(socialCursor.getInfoAndNext().getPersonSocial().getNickName());
       }



        this.firstPerson = new JComboBox<>();
        this.secondPerson = new JComboBox<>();

        this.firstPerson.setModel(dml);

        this.add(this.firstPerson);

        this.setVisible(true);
    }

    private void personsDialogFeatures() {
        this.setSize(new Dimension(720, 480));
        this.setLayout(new GridLayout(5, 1));
        this.setBackground(Color.decode("#2c3e50"));
    }


}
