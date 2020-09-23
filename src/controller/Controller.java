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
		social.addConn(1, 4);
		social.addConn(1, 2);
		social.addConn(1, 0);
		social.addConn(3, 4);
		social.addConn(1, 3);
		social.addConn(0, 4);
	
		//delete friend
		//System.out.println(social.deleteFriend(2, 0));
		
		/*SimpleList<PersonSocial> alone = social.getPersonsSocialAlone();
		Cursor<PersonSocial> cursor = new Cursor<PersonSocial>(alone);
		while (!cursor.isOut()) {
			System.out.println(cursor.getInfoAndNext());
		}*/
		
	
		Vertex vertex = social.getElement(new Vertex(new PersonSocial(1, ""),comparator));
		Cursor<Vertex> cursor = new Cursor<Vertex>(vertex);
		while (!cursor.isOut()) {
			System.out.println(cursor.getInfoAndNext().getPersonSocial());
		}
		
		/*
		SimpleList<Vertex> list = social.getListPersonMaxFriends();
		Cursor<Vertex> cursor = new Cursor<Vertex>(list);
		while (!cursor.isOut()) {
			System.out.println("Person: " + cursor.getInfoAndNext().getPersonSocial());
		}*/
		System.out.println(social.size());
	}
}
