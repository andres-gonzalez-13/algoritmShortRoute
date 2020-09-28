package views;

import rojeru_san.RSButtonRiple;

import java.awt.*;
import java.awt.event.ActionListener;

public class BtnArray extends RSButtonRiple {

	public  BtnArray(String text, String command, ActionListener actionListener, String color) {
		this.setText(text);
		this.setActionCommand(command);
		this.addActionListener(actionListener);
		btnRipleFeatures(this, color);
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
