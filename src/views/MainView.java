package views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

public class MainView extends JFrame {

	private static final long serialVersionUID = 6313156717813295316L;
	private MainPanel mainPanel;

	public MainView(ActionListener actionListener) {
		mainViewFeatures();
		mainViewInstances(actionListener);
		mainViewInternalContent();
		this.setVisible(true);
	}

	private void mainViewFeatures() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setTitle("Grafos");
		this.setMinimumSize(new Dimension(480, 320));
		//this.setIconImage(new ImageIcon(getClass().getResource("/images/calculadora.png")).getImage());
	}

	private void mainViewInstances(ActionListener actionListener) {
		mainPanel = new MainPanel(actionListener);
	}

	private void mainViewInternalContent() {
		this.add(mainPanel, BorderLayout.CENTER);
	}

}
