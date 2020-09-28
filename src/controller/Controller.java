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

	private Comparator<Vertex> comparator = new Comparator<Vertex>() {
		@Override
		public int compare(Vertex o1, Vertex o2) {
			return (o1.getPersonSocial().getId() - o2.getPersonSocial().getId() == 0)?0:1;
		}
	};

	public Controller() {

		social = new Social(comparator, 20);
		social.show();
		social.addConn(1, 4);
		social.addConn(1, 2);
		social.addConn(1, 0);
		social.addConn(3, 4);
		social.addConn(1, 3);
		social.addConn(0, 4);
		social.addConn(3, 2);
		social.addConn(4, 3);
		Vector<Vertex> vertexToShow = new Vector();
		Cursor<Vertex> cursor2 = new Cursor<Vertex>(social);

		while (!cursor2.isOut()) {
			vertexToShow.add(cursor2.getInfoAndNext());

		}
		this.mainView = new MainView(this, vertexToShow);
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

		}
	}

	private void accept_persons() {
		mainView.acceptPersons();

	}

	private void addFriend() {
		mainView.addFriend(this.social);

	}

	private void deleteFriend() {
		mainView.deleteFriend(this.social);

	}

	private void mutualFriends() {
		mainView.mutualFriends(this.social);

	}

	private void leaveTheSocialNetwork() {
		mainView.leaveTheSocialNetwork(this.social);
	}

}
