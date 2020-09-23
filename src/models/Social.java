package models;


import java.util.Comparator;
import dataestructure.Cursor;
import dataestructure.Graph;
import dataestructure.SimpleList;
import dataestructure.Vertex;

public class Social extends Graph{
	
	private String[] nombres = {"María Carmen","María","Carmen","Josefa","Ana María","Isabel", "María Pilar","María Dolores","Laura","María Teresa",
			"Antonio","José","Manuel", "Francisco","David","Juan","José Antonio","Javier","José Luis","Daniel","Lucía","Martina","María","Sofía",
			"Paula","Daniela","Valeria","Alba","Julia","Noa"};
	
	public Social(Comparator<Vertex> comparator, int cant) {
		super(comparator);
		initSocial(cant);
	}
	
	public void initSocial(int cant) {
		for (int i = 0; i < cant; i++) {
			this.add(new Vertex(new PersonSocial(i, nombres[i])));
		}
	}
	
	
	/**
	 * Metodo para definir los amigos en comun entre dos personas sociales
	 * @param idFriend1
	 * @param idFriend2
	 * @return una lista de personas sociales
	 */
	public SimpleList<PersonSocial> commonFriends(int idFriend1, int idFriend2){
		SimpleList<PersonSocial> commonFriends = new SimpleList<PersonSocial>();
		
		Cursor<Vertex> cursorFriend1 = new Cursor<Vertex>(this.search(this.getComparator(), new Vertex(new PersonSocial(idFriend1, ""))));
		while (!cursorFriend1.isOut()) {
			Cursor<Vertex> cursorFriend2 = new Cursor<Vertex>(this.search(this.getComparator(), new Vertex(new PersonSocial(idFriend2, ""))));
			while (!cursorFriend2.isOut()) {
				if(cursorFriend1.info().getPersonSocial().getId() == cursorFriend2.info().getPersonSocial().getId()) {
					commonFriends.add(cursorFriend1.info().getPersonSocial());
				}
				cursorFriend2.next();
			}
			cursorFriend1.next();
		}
		return commonFriends;
	}
	
	
	public boolean deleteFriend(int idPersonSocial, int idPersonSocialDelete) {
		Boolean isDelete = false;
		Cursor<Vertex> cursor = new Cursor<Vertex>(this);
		while (!cursor.isOut()) {
			if(cursor.info().getPersonSocial().getId() == idPersonSocial) {
				isDelete = deleteFriend(cursor.info(), idPersonSocialDelete);
			}
			cursor.next();
		}
		
		return isDelete;
	}
	
	private boolean deleteFriend(Vertex vertex, int idPersonSocialDelete) {
		Boolean isDelete = false;
		Cursor<Vertex> cursor = new Cursor<Vertex>(vertex);
		while (!cursor.isOut()) {
			if (cursor.info().getPersonSocial().getId() == idPersonSocialDelete) {
				vertex.eliminateNode(this.getComparator(), new Vertex(new PersonSocial(idPersonSocialDelete, "")));
				isDelete = true;
			}
			cursor.next();
		}
		return isDelete;
	}
	
	
}


	