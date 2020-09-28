package views;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.*;

import controller.MainActivity;
import dataestructure.Vertex;
import models.Social;
import rojeru_san.RSButtonRiple;
import rojeru_san.RSMTextFull;
import utils.Constants;

public class MainPanel extends JPanel {

	private static final long serialVersionUID = -8668618688820184387L;
	private Image resizeImage;
	private JPanel startPanel;
	private InformationPanel informationPanel;
	private JPanel personPanel;
	private JLabel imagePerson;
	private RSMTextFull numberPersonsTextFull;
	private RSButtonRiple acceptPersonsBTN;
	private SocialPanel socialPanel;


	public MainPanel(ActionListener actionListener, Vector<Vertex> vertexToShow, Social social) {
		this.mainPanelFeatures();
		this.mainPanelInstances(actionListener, vertexToShow, social);
		this.mainPanelInternalContent();
	}

	private void mainPanelFeatures() {
		this.setBackground(Color.decode("#34495e"));
		this.setLayout(new BorderLayout());
	}

	private void mainPanelInstances(ActionListener actionListener, Vector<Vertex> vertexToShow, Social social) {
		this.backGroundImage();
		this.numberPersonsTextFull = this.numberPersonsTextFull();
		this.acceptPersonsBTN = this.acceptPersonsBTN(actionListener);
		this.imagePerson = this.imagePerson();
		this.personPanel = this.personPanel();
		this.informationPanel = new InformationPanel();
		this.startPanel = this.startPanelFeatures();
		this.socialPanel = new SocialPanel(actionListener, vertexToShow, social);
	}

	private void mainPanelInternalContent() {
		this.add(Constants.insidePanel(this.startPanel, 100, 300, 100,300, "#2c3e50", false), BorderLayout.CENTER);
	}

	private JPanel startPanelFeatures() {
		JPanel startPanel = new JPanel(new GridLayout(1,2));
		startPanel.add(this.informationPanel);
		startPanel.add(this.personPanel);
		return startPanel;
	}

	private JPanel personPanel() {
		JPanel personPanel = new JPanel(new BorderLayout());
		personPanel.setBackground(Color.decode("#31345f"));

		JPanel auxPanel = new JPanel(new GridLayout(4,1));
		auxPanel.setBackground(Color.decode("#31345f"));
		auxPanel.add(Constants.insidePanel(this.numberPersonsTextFull, 20, 100, 20, 100, "#0000", false));
		auxPanel.add(Constants.insidePanel(this.acceptPersonsBTN, 20, 150, 20, 150, "#0000", false));

		personPanel.add(Constants.insidePanel(this.imagePerson, 20, 20, 0, 20, "#0000", false), BorderLayout.PAGE_START);
		personPanel.add(Constants.insidePanel(auxPanel, 10,10,10,10,"#0000", false), BorderLayout.CENTER);
		return personPanel;
	}

	private RSMTextFull numberPersonsTextFull(){
		RSMTextFull numberPersonsTextFull = new RSMTextFull();
		numberPersonsTextFull.setPlaceholder("Ingresa el numero de personas para el grafo");
		numberPersonsTextFull.setModoMaterial(true);
		return numberPersonsTextFull;
	}

	private JLabel imagePerson(){
		JLabel imagePerson = new JLabel(new ImageIcon(getClass().getResource("/images/Persons.png")));
		imagePerson.setHorizontalAlignment(JLabel.CENTER);
		imagePerson.setVerticalAlignment(JLabel.CENTER);
		return  imagePerson;
	}

	private RSButtonRiple acceptPersonsBTN(ActionListener actionListener) {
		RSButtonRiple acceptPersonBTN = Constants.btnRiple("¡Aceptar! ^^", MainActivity.ACCEPT_PERSONS.toString(), actionListener, "#27ae60");
		return acceptPersonBTN;
	}

	private ImageIcon backGroundImage(){
		ImageIcon backGroundImage = new ImageIcon(getClass().getResource("/images/background.jpg"));
		this.resizeImage = backGroundImage.getImage().getScaledInstance(1920, 1080, Image.SCALE_SMOOTH);
		return backGroundImage;
	}

	public void acceptPersons() {
		this.removeAll();
		this.repaint();
		this.revalidate();
		this.add(socialPanel, BorderLayout.CENTER);
		this.repaint();
	}

	public void addFriend(Social social, ActionListener actionListener) {
		socialPanel.addFriend(social, actionListener);
	}

	public void deleteFriend(Social social, ActionListener actionListener) {
		socialPanel.deleteFriend(social, actionListener);
	}

	public void mutualFriends(Social social, ActionListener actionListener) {
		socialPanel.mutualFriends(social, actionListener);
	}

	public void leaveTheSocialNetwork(Social social, ActionListener actionListener) {
		socialPanel.leaveTheSocialNetwork(social, actionListener);
	}



	protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		graphics.drawImage(resizeImage, 0, 0, this);
	}

	public void showPersons(Social social, ActionListener actionListener) {
		socialPanel.showPersons(social, actionListener);
	}

	public int[] addFrienFinally() {
		return  socialPanel.addFrienFinally();
	}

	public void repaintGraphic() {
		this.socialPanel.repaintGraphic();
	}

	public void showPersonsDeleted(Social social, ActionListener actionListener) {
		socialPanel.showPersonsDeleted(social, actionListener);
	}

	public int leaveNetworkFinally() {
		return  socialPanel.leaveNetworkFinally();
	}


	public void resetGraph(Vector<Vertex> vertexToShow) {
		socialPanel.resetGraph(vertexToShow);
	}
}
