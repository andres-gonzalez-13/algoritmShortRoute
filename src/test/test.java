package test;

import java.util.Comparator;

import dataestructure.Cursor;
import dataestructure.Graph;
import dataestructure.Vertex;
import models.PersonSocial;

public class test {
	
	public static void main(String[] args) {
		
		PersonSocial personSocial = new PersonSocial(1,"andrea");
		PersonSocial personSocial1 = new PersonSocial(2,"carlos");
		PersonSocial personSocial2 = new PersonSocial(3,"juan");
		PersonSocial personSocial3 = new PersonSocial(4,"carla");
		PersonSocial personSocial4 = new PersonSocial(5,"lili");
		PersonSocial personSocial5 = new PersonSocial(6,"lila");
		
		
		Comparator<Vertex> comparator = new Comparator<Vertex>() {
			
			@Override
			public int compare(Vertex o1, Vertex o2) {
				// TODO Auto-generated method stub
				return (o1.getPersonSocial().getId() - o2.getPersonSocial().getId() == 0)?0:1 ;
			}
		};
		
		
		Graph graph = new Graph(comparator);
		graph.add(new Vertex(personSocial));
		graph.add(new Vertex(personSocial1));
		graph.add(new Vertex(personSocial2));
		graph.add(new Vertex(personSocial3));
		graph.add(new Vertex(personSocial4));
		graph.add(new Vertex(personSocial5));
		
		graph.show();
		
		//Aqui se agregan amigos teniendo en cuenta el id de amigo
		Boolean isInsert = graph.addConn(1, 5);
		Boolean isInsert2 = graph.addConn(2, 5);
		
		System.out.println("inserto?: " + isInsert2);
		
		Vertex search = graph.search(comparator, new Vertex(new PersonSocial(5, "")));
		System.out.println("vertex: " + search.getPersonSocial().getNickName());
		Cursor<Vertex> cursor = new Cursor<Vertex>(search);
		while (!cursor.isOut()) {
			System.out.println("friend: " + cursor.getInfoAndNext().getPersonSocial());
		}
	}

}
