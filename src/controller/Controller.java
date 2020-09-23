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
		social.addConn(3, 2);
		social.addConn(4, 3);
		
		
		
	
		/*	
		//Amigos en comun
		SimpleList<PersonSocial> commons = social.commonFriends(2, 3);
		Cursor<PersonSocial> cursor = new Cursor<PersonSocial>(commons);
		while (!cursor.isOut()) {
			System.out.println(cursor.getInfoAndNext());
		}
		 */
		
		
		
		//delete friend
		//System.out.println(social.deleteFriend(1, 4));
		
		/*
		SimpleList<PersonSocial> alone = social.getPersonsSocialAlone();
		Cursor<PersonSocial> cursor = new Cursor<PersonSocial>(alone);
		while (!cursor.isOut()) {
			System.out.println(cursor.getInfoAndNext());
		}*/
		
		
		System.out.println(social.deletePersonSocial(4));
		
		//Imprimimir los amigos de un vertice cualquiera
		
		System.out.println("Amigos del 1");
		Vertex vertex = social.getElement(new Vertex(new PersonSocial(1, ""),comparator));
		Cursor<Vertex> cursor = new Cursor<Vertex>(vertex);
		while (!cursor.isOut()) {
			System.out.println(cursor.getInfoAndNext().getPersonSocial());
		}
	
		System.out.println("Amigos del 2");
		Vertex vertex2 = social.getElement(new Vertex(new PersonSocial(2, ""),comparator));
		Cursor<Vertex> cursor2 = new Cursor<Vertex>(vertex2);
		while (!cursor2.isOut()) {
			System.out.println(cursor2.getInfoAndNext().getPersonSocial());
		}
	
		System.out.println("vertices");
		Cursor<Vertex> cursor3 = new Cursor<Vertex>(social);
		while (!cursor3.isOut()) {
			System.out.println(cursor3.getInfoAndNext().getPersonSocial());
		}
		
		System.out.println(social.size());
	}
}
