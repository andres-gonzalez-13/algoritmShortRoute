package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SocialPanel extends JPanel {

    private JPanel leftPanel;
    private GraphPanel graphPanel;

    public SocialPanel(ActionListener actionListener) {
        this.socialPanelInstances();
        this.socialPanelFeatures();
        this.socialPanelInternalContent();
    }

    private void socialPanelFeatures(){
        this.setOpaque(false);
        this.setLayout(new BorderLayout());
    }

    private void socialPanelInternalContent(){
        this.add(leftPanel, BorderLayout.LINE_START);
    }

    private void socialPanelInstances() {
        this.leftPanel = new JPanel();
        this.leftPanel.setBackground(Color.BLACK);

    }

}
