package controller;

import java.util.Comparator;

import dataestructure.Cursor;
import dataestructure.SimpleList;
import dataestructure.Vertex;
import models.PersonSocial;
import models.Social;

public class Controller {
	
	private Social social;
	private Comparator<Vertex> comparator = new Comparator<Vertex>() {
		@Override
		public int compare(Vertex o1, Vertex o2) {
			// TODO Auto-generated method stub
			return (o1.getPersonSocial().getId() - o2.getPersonSocial().getId() == 0)?0:1;
		}
	};

	public Controller() {
		social = new Social(comparator, 5);
		social.show();
		social.addConn(2, 4);
		social.addConn(1, 2);
		social.addConn(0, 2);
		social.addConn(4, 1);
		social.addConn(3, 4);
		social.addConn(1, 3);
		social.addConn(0, 4);
		
		//delete friend
		System.out.println(social.deleteFriend(2, 0));
		
		SimpleList<PersonSocial> commons = social.commonFriends(2, 4);
		Cursor<PersonSocial> cursor = new Cursor<PersonSocial>(commons);
		while (!cursor.isOut()) {
			System.out.println(cursor.getInfoAndNext());
		}
		
	}
}
