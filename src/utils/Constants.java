package utils;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import rojeru_san.RSButtonRiple;

public class Constants {

    public static JLabel getSpace(int top, int left, int bottom, int right) {
        JLabel getSpace = new JLabel();
        getSpace.setBorder(new EmptyBorder(top, left, bottom, right));
        return getSpace;
    }

    public static JPanel insidePanel(Component comp, int top, int left, int bottom, int right, String color,
                                     boolean opaque) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.decode(color));
        panel.setOpaque(opaque);
        insidePanelContent(panel, comp, top, left, bottom, right);
        return panel;
    }

    private static void insidePanelContent(JPanel panel, Component comp, int top, int left, int bottom, int right) {
        panel.add(getSpace(top, 0, 0, 0), BorderLayout.PAGE_START);
        panel.add(getSpace(0, left, 0, 0), BorderLayout.LINE_START);
        panel.add(comp, BorderLayout.CENTER);
        panel.add(getSpace(0, 0, bottom, 0), BorderLayout.PAGE_END);
        panel.add(getSpace(0, 0, 0, right), BorderLayout.LINE_END);
    }

    public static RSButtonRiple btnRiple(String texto, String command, ActionListener actionListener, String color) {
        RSButtonRiple btnRiple = new RSButtonRiple();
        btnRiple.setText(texto);
        btnRiple.setActionCommand(command);
        btnRiple.addActionListener(actionListener);
        btnRipleFeatures(btnRiple, color);
        return btnRiple;
    }

    private static void btnRipleFeatures(RSButtonRiple rsButtonRiple, String color) {
        rsButtonRiple.setFocusable(false);
        rsButtonRiple.setColorHover(Color.decode("#2ecc71"));
        rsButtonRiple.setBackground(Color.decode(color));
        rsButtonRiple.setFont(fontBtn(16));
        rsButtonRiple.setBorderPainted(false);
    }

    public static Font fontBtn(int size) {
        Font ralewaye = new Font("Raleway", Font.PLAIN, size);
        return ralewaye;
    }

}
