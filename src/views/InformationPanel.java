package views;

import javax.swing.*;
import java.awt.*;

public class InformationPanel extends JPanel {

    private ImageIcon backGroundImage;
    private Image resizeImage;

    public InformationPanel() {
        this.backGroundImage = backGroundImage();
    }

    private ImageIcon backGroundImage(){
        ImageIcon backGroundImage = new ImageIcon(getClass().getResource("/images/backgroundTwo.jpg"));
        this.resizeImage = backGroundImage.getImage().getScaledInstance(660, 890, Image.SCALE_SMOOTH);
        return backGroundImage;
    }

    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);
    }

    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.drawImage(this.resizeImage, 0, 0, this);
    }


}
