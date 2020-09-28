package views;

import javax.swing.*;
import java.awt.*;

public class ShowMessageDialog extends JDialog {



    public ShowMessageDialog(JLabel text) {
        this.showMessageDialogFeatures();
        this.add(new ShowMessagePanel(text));
        this.setVisible(true);
    }

    private void showMessageDialogFeatures() {
        this.setResizable(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setTitle("Amigos en común");
        this.setLayout(new BorderLayout());
        this.setSize(480, 720);
        this.setModal(true);
        this.setLocationRelativeTo(null); //JUSTO DESPUES DE MI "setSize()"
    }


}
