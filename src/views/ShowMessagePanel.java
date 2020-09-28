package views;

import utils.Constants;

import javax.swing.*;
import java.awt.*;

public class ShowMessagePanel extends JPanel {

    private Image resizeImage;

    public ShowMessagePanel(JLabel label) {
        this.backGroundImage();
        this.setLayout(new BorderLayout());

        label.setFont(Constants.fontBtn(22));
        label.setForeground(Color.WHITE);

        this.add(label, BorderLayout.CENTER);
    }

    private ImageIcon backGroundImage(){
        ImageIcon backGroundImage = new ImageIcon(getClass().getResource("/images/background.png"));
        this.resizeImage = backGroundImage.getImage().getScaledInstance(480, 720, Image.SCALE_SMOOTH);
        return backGroundImage;
    }

    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.drawImage(resizeImage, 0, 0, this);
    }



}
