package views;

import dataestructure.SimpleList;
import dataestructure.Vertex;
import models.PersonSocial;
import models.Social;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.*;

public class MainView extends JFrame {

	private static final long serialVersionUID = 6313156717813295316L;
	private MainPanel mainPanel;

	public MainView(ActionListener actionListener, Vector<Vertex> vertexToShow, Social social) {
		this.mainViewFeatures();
		this.mainViewInstances(actionListener, vertexToShow, social);
		this.mainViewInternalContent();
		this.setVisible(true);
	}

	private void mainViewFeatures() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setTitle("Simulador: RED Social");
		this.setLayout(new BorderLayout());
		this.setMinimumSize(new Dimension(1280, 720));
		this.setIconImage(new ImageIcon(getClass().getResource("/images/icon.png")).getImage());
	}

	private void mainViewInstances(ActionListener actionListener, Vector<Vertex> vertexToShow, Social social) {
		this.mainPanel = new MainPanel(actionListener, vertexToShow, social);
	}

	public void acceptPersons(ActionListener actionListener, Vector<Vertex> vertexToShow, Social social){
		this.mainPanel.acceptPersons(actionListener, vertexToShow, social);
	}

	public void valuesLimit(){
		this.mainPanel.valuesLimit();
	}

	public int getCountPersons(){
		return  mainPanel.getCountPersons();
	}

	public void addFriend(Social social, ActionListener actionListener) {
		this.mainPanel.addFriend(social, actionListener);
	}

	public void deleteFriend(Social social, ActionListener actionListener) {
		this.mainPanel.deleteFriend(social, actionListener);
	}

	public void mutualFriends(Social social, ActionListener actionListener) {
		this.mainPanel.mutualFriends(social, actionListener);
	}

	public void leaveTheSocialNetwork(Social social, ActionListener actionListener) {
		this.mainPanel.leaveTheSocialNetwork(social, actionListener);
	}


	private void mainViewInternalContent() {
		this.add(mainPanel, BorderLayout.CENTER);
	}

	public void showPersons(Social social, ActionListener actionListener) {
		this.mainPanel.showPersons(social, actionListener);
	}

	public int[] addFriendFinally(Social social) {
		return this.mainPanel.addFrienFinally(social);
	}

	public void repaintGraphic() {
		this.mainPanel.repaintGraphic();
	}


	public void showPersonsDeleted(Social social, ActionListener actionListener) {
		this.mainPanel.showPersonsDeleted(social, actionListener);
	}

	public int leaveNetworkFinally() {
		return  this.mainPanel.leaveNetworkFinally();
	}


	public void resetGraph(Vector<Vertex> vertexToShow) {
		this.mainPanel.resetGraph(vertexToShow);
	}

	public void refreshValues(Social social, ActionListener actionListener) {
		mainPanel.refreshValues(social, actionListener);
	}

	public void mutualFriendsShow(Social social, ActionListener actionListener) {
		mainPanel.mutualFriendsShow(social, actionListener);
	}

	public void mutualFriendFinally(SimpleList<PersonSocial> commonFriends) {
		mainPanel.mutualFriendFinally(commonFriends);
	}

	public int[] commonFrindValues() {
		return mainPanel.commonFrindValues();
	}
}
