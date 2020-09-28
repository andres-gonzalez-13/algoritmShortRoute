package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Comparator;

import dataestructure.Cursor;
import dataestructure.Vertex;
import java.util.Vector;

import models.Social;
import views.MainView;


public class Controller implements ActionListener {

	private Social social;
	private MainView mainView;

	private Vector<Vertex> vertexToShow;
	private Comparator<Vertex> comparator = new Comparator<Vertex>() {
		@Override
		public int compare(Vertex o1, Vertex o2) {
			return (o1.getPersonSocial().getId() - o2.getPersonSocial().getId() == 0) ? 0 : 1;
		}
	};

	public Controller() {

		social = new Social(comparator, 20);
	/*	social.show();
		social.addConn(1, 4);
		social.addConn(1, 2);
		social.addConn(1, 0);
		social.addConn(3, 4);
		social.addConn(1, 3);
		social.addConn(0, 4);
		social.addConn(3, 2);
		social.addConn(4, 3);*/
		vertexToShow = new Vector();
		Cursor<Vertex> cursor2 = new Cursor<Vertex>(social);

		while (!cursor2.isOut()) {
			vertexToShow.add(cursor2.getInfoAndNext());

		}
		this.mainView = new MainView(this, vertexToShow, social);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (MainActivity.valueOf(e.getActionCommand())) {
			case ACCEPT_PERSONS:
				this.accept_persons();
				break;
			case ADD_FRIEND:
				this.addFriend();
				break;
			case DELETE_FRIEND:
				this.deleteFriend();
				break;
			case MUTUAL_FRIENDS:
				this.mutualFriends();
				break;
			case LEAVE_THE_SOCIAL_NETWORK:
				this.leaveTheSocialNetwork();
				break;
			case SHOW_PERSONS:
				this.showPersons();
				break;
			case ADD_FRIEND_FINALLY:
				this.addFriendFinally();
				break;
			case DELETE_FRIEND_FINALLY:
				this.deleteFriendFinally();
				break;
			case DELETE_PERSON:
				this.showPersonsDeleted();
				break;

			case LEAVE_NETWORK_FINALLY:
				this.leaveNetworkFinally();
				break;

		}
	}

	private void showPersonsDeleted() {
		mainView.showPersonsDeleted(this.social, this);
	}

	private void deleteFriendFinally() {
		int[] id = mainView.addFriendFinally();
		System.out.println("PRIMERA PERSONA DEL: " + id[0] + " SEGUNDA PERSONA DEL: " + id[1]);
		social.deleteFriend(id[0], id[1]);
		social.deleteFriend(id[1], id[0]);

		mainView.repaintGraphic();
	}

	private void addFriendFinally(){
		int[] id = mainView.addFriendFinally();
		System.out.println("PRIMERA PERSONA: " + id[0] + " SEGUNDA PERSONA: " + id[1]);
		social.addConn(id[0], id[1]);
		mainView.repaintGraphic();
	}

	private void accept_persons() {
		mainView.acceptPersons();

	}

	private void addFriend() {
		mainView.addFriend(this.social, this);

	}

	private void deleteFriend() {
		mainView.deleteFriend(this.social, this);
	}

	private void mutualFriends() {
		mainView.mutualFriends(this.social, this);

	}

	private void leaveTheSocialNetwork() {
		mainView.leaveTheSocialNetwork(this.social, this);
	}


	private void leaveNetworkFinally() {
		int id = mainView.leaveNetworkFinally();
		System.out.println("PRIMERA PERSONA: " + id);

		social.deletePersonSocial(id);

		vertexToShow = new Vector();
		Cursor<Vertex> cursor2 = new Cursor<Vertex>(social);

		while (!cursor2.isOut()) {
			vertexToShow.add(cursor2.info());
			System.out.println("PRUEBA: " + cursor2.getInfoAndNext().getPersonSocial().getNickName());
		}

		mainView.resetGraph(vertexToShow);
		mainView.repaintGraphic();
	}


	private void showPersons() {
		mainView.showPersons(this.social, this);
	}
}

