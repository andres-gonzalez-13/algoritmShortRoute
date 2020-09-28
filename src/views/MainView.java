package views;

import dataestructure.Vertex;
import models.Social;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

public class MainView extends JFrame {

	private static final long serialVersionUID = 6313156717813295316L;
	private MainPanel mainPanel;

	public MainView(ActionListener actionListener, Vector<Vertex> vertexToShow) {
		this.mainViewFeatures();
		this.mainViewInstances(actionListener, vertexToShow);
		this.mainViewInternalContent();
		this.setVisible(true);
	}

	private void mainViewFeatures() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setTitle("Grafos");
		this.setLayout(new BorderLayout());
		this.setMinimumSize(new Dimension(1280, 720));
		//this.setIconImage(new ImageIcon(getClass().getResource("/images/calculadora.png")).getImage());
	}

	private void mainViewInstances(ActionListener actionListener, Vector<Vertex> vertexToShow) {
		this.mainPanel = new MainPanel(actionListener, vertexToShow);
	}

	public void acceptPersons(){
		this.mainPanel.acceptPersons();
	}

	public void addFriend(Social social) {
		this.mainPanel.addFriend(social);
	}

	public void deleteFriend(Social social) {
		this.mainPanel.deleteFriend(social);
	}

	public void mutualFriends(Social social) {
		this.mainPanel.mutualFriends(social);
	}

	public void leaveTheSocialNetwork(Social social) {
		this.mainPanel.leaveTheSocialNetwork(social);
	}


	private void mainViewInternalContent() {
		this.add(mainPanel, BorderLayout.CENTER);
	}

}
