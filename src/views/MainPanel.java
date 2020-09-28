package views;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;
import javax.swing.*;

import controller.MainActivity;
import dataestructure.SimpleList;
import dataestructure.Vertex;
import models.PersonSocial;
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
        if (numberPersonsTextFull.getText().equals("")){
            acceptPersonsBTN.setEnabled(false);
        } else if(Integer.parseInt(numberPersonsTextFull.getText()) > 20 || Integer.parseInt(numberPersonsTextFull.getText())==0){
            acceptPersonsBTN.setEnabled(false);
        } else {
            acceptPersonsBTN.setEnabled(true);
        }
	}

	private void mainPanelFeatures() {
		this.setBackground(Color.decode("#34495e"));
		this.setLayout(new BorderLayout());
	}

	private void mainPanelInstances(ActionListener actionListener, Vector<Vertex> vertexToShow, Social social) {
		this.backGroundImage();
		this.numberPersonsTextFull = this.numberPersonsTextFull();

		this.numberPersonsTextFull.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if(numberPersonsTextFull.getText().length() > 7){
					numberPersonsTextFull.setText("1");
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (numberPersonsTextFull.getText().equals("")){
					acceptPersonsBTN.setEnabled(false);
				} else if(Integer.parseInt(numberPersonsTextFull.getText()) > 20 || Integer.parseInt(numberPersonsTextFull.getText())==0 || Integer.parseInt(numberPersonsTextFull.getText())<2){
					acceptPersonsBTN.setEnabled(false);
				} else {
					acceptPersonsBTN.setEnabled(true);
				}
			}
		});

		this.acceptPersonsBTN = this.acceptPersonsBTN(actionListener);
		this.imagePerson = this.imagePerson();
		this.personPanel = this.personPanel();
		this.informationPanel = new InformationPanel();
		this.startPanel = this.startPanelFeatures();

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
		JPanel auxPanel = new JPanel(new GridLayout(4,1));
		JLabel welcomeLabel = new JLabel();
		JLabel membersLabel = new JLabel();
		personPanel.setBackground(Color.decode("#31345f"));
		this.featuresLabel(welcomeLabel, "<html><p align='center' >¡Bienvenido! ^^ <br/>Integrantes: <html>");
		this.featuresLabel(membersLabel, "<html><p align='center' >Andres Santiago Gonzales Moreno<br/>Jhonn Eduardo Hernandez Vega<br/>Cristian Camilo Lopez Niño</p></html>\"");

		auxPanel.setBackground(Color.decode("#31345f"));
		auxPanel.add(Constants.insidePanel(this.numberPersonsTextFull, 20, 100, 20, 100, "#0000", false));
		auxPanel.add(Constants.insidePanel(this.acceptPersonsBTN, 20, 150, 20, 150, "#0000", false));

		auxPanel.add(Constants.insidePanel(welcomeLabel, 20, 100, 20, 100, "#0000", false));
		auxPanel.add(Constants.insidePanel(membersLabel, 0, 100, 5, 100, "#0000", false));

		personPanel.add(Constants.insidePanel(this.imagePerson, 20, 20, 0, 20, "#0000", false), BorderLayout.PAGE_START);
		personPanel.add(Constants.insidePanel(auxPanel, 10,10,10,10,"#0000", false), BorderLayout.CENTER);
		return personPanel;
	}

	private void featuresLabel(JLabel label, String string){
		label.setText(string);
		label.setFont(Constants.fontBtn(18));
		label.setForeground(Color.WHITE);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setVerticalTextPosition(JLabel.CENTER);
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setVerticalAlignment(JLabel.CENTER);
	}

	private RSMTextFull numberPersonsTextFull(){
		RSMTextFull numberPersonsTextFull = new RSMTextFull();
		numberPersonsTextFull.setPlaceholder("Ingresa el numero de personas (Menor o igual a 20)");
		numberPersonsTextFull.setModoMaterial(true);
		numberPersonsTextFull.setSoloNumeros(true);
		return numberPersonsTextFull;
	}

	private JLabel imagePerson(){
		JLabel imagePerson = new JLabel(new ImageIcon(getClass().getResource("/images/Persons.png")));
		imagePerson.setHorizontalAlignment(JLabel.CENTER);
		imagePerson.setVerticalAlignment(JLabel.CENTER);
		return  imagePerson;
	}

	public void valuesLimit(){

	}

	private RSButtonRiple acceptPersonsBTN(ActionListener actionListener) {
		RSButtonRiple acceptPersonBTN = Constants.btnRiple("Aceptar", MainActivity.ACCEPT_PERSONS.toString(), actionListener, "#27ae60");
		return acceptPersonBTN;
	}

	private ImageIcon backGroundImage(){
		ImageIcon backGroundImage = new ImageIcon(getClass().getResource("/images/background.jpg"));
		this.resizeImage = backGroundImage.getImage().getScaledInstance(1920, 1080, Image.SCALE_SMOOTH);
		return backGroundImage;
	}

	public void acceptPersons(ActionListener actionListener, Vector<Vertex> vertexToShow, Social social) {
		this.removeAll();
		this.repaint();
		this.revalidate();
		this.socialPanel = new SocialPanel(actionListener, vertexToShow, social);
		this.add(socialPanel, BorderLayout.CENTER);
		this.repaint();
	}

	public int getCountPersons(){
		return Integer.parseInt(numberPersonsTextFull.getText());
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

	public int[] addFrienFinally(Social social) {
		return  socialPanel.addFrienFinally(social);
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

	public void refreshValues(Social social, ActionListener actionListener) {
		socialPanel.refreshValues(social, actionListener);
	}

	public void mutualFriendsShow(Social social, ActionListener actionListener) {
		socialPanel.mutualFriendsShow(social, actionListener);
	}

	public void mutualFriendFinally(SimpleList<PersonSocial> commonFriends) {
		socialPanel.mutualFriendFinally(commonFriends);
	}

	public int[] commonFrindValues() {
		return socialPanel.commonFrindValues();
	}
}
