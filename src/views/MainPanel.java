package views;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.*;

import controller.MainActivity;
import dataestructure.Vertex;
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


	public MainPanel(ActionListener actionListener, Vector<Vertex> vertexToShow) {
		this.mainPanelFeatures();
		this.mainPanelInstances(actionListener, vertexToShow);
		this.mainPanelInternalContent();
	}

	private void mainPanelFeatures() {
		this.setBackground(Color.decode("#34495e"));
		this.setLayout(new BorderLayout());
	}

	private void mainPanelInstances(ActionListener actionListener, Vector<Vertex> vertexToShow) {
		this.backGroundImage();
		this.numberPersonsTextFull = this.numberPersonsTextFull();
		this.acceptPersonsBTN = this.acceptPersonsBTN(actionListener);
		this.imagePerson = this.imagePerson();
		this.personPanel = this.personPanel();
		this.informationPanel = new InformationPanel();
		this.startPanel = this.startPanelFeatures();
		this.socialPanel = new SocialPanel(actionListener, vertexToShow);
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

	public void addFriend() {
		socialPanel.addFriend();
	}

	public void deleteFriend() {
		socialPanel.deleteFriend();
	}

	public void mutualFriends() {
		socialPanel.mutualFriends();
	}

	public void leaveTheSocialNetwork() {
		socialPanel.leaveTheSocialNetwork();
	}



	protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		graphics.drawImage(resizeImage, 0, 0, this);
	}

}
