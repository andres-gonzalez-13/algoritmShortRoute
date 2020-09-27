package views;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import controller.MainActivity;

public class MainPanel extends JPanel {

	private static final long serialVersionUID = -8668618688820184387L;
	private ImageIcon backGroundImage;

	private BtnArray[] btnHome = {
			new BtnArray("A Binario", MainActivity.toBinary.toString(), "#3498db", "/images/calculadora.png"),
			new BtnArray("A ASCII", MainActivity.toASCII.toString(), "#3498db", "/images/calculadora.png"),
			new BtnArray("A Unicode", MainActivity.toUnicode.toString(), "#3498db", "/images/calculadora.png"),
			new BtnArray("A IEEE 754", MainActivity.toIEEE754.toString(), "#3498db", "/images/calculadora.png") };


	public MainPanel(ActionListener actionListener) {
		mainPanelFeatures();
		mainPanelInstances();
		mainPanelInternalContent(actionListener);
	}

	private void mainPanelFeatures() {
		this.setBackground(Color.decode("#34495e"));
	}

	private void mainPanelInstances() {
	//	backGroundImage = new ImageIcon(getClass().getResource("/images/background.jpg"));

	}

	private void mainPanelInternalContent(ActionListener actionListener) {
	}

	protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
//		graphics.drawImage(backGroundImage.getImage(), 0, 0, this);
	}

}
