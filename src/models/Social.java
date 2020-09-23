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
			this.add(new Vertex(new PersonSocial(i, nombres[i]),this.getComparator()));
		}
	}
	
	
	/**
	 * Metodo para definir los amigos en comun entre dos personas sociales
	 * @param idFriend1
	 * @param idFriend2
	 * @return una lista de personas sociales
	 */
	public SimpleList<PersonSocial> commonFriends(int idFriend1, int idFriend2,Comparator<Vertex> comparator){
		SimpleList<PersonSocial> commonFriends = new SimpleList<PersonSocial>();
		
		if(isExist(new Vertex(new PersonSocial(idFriend1, ""),comparator)) == true && isExist(new Vertex(new PersonSocial(idFriend2, ""),comparator)) && idFriend1 != idFriend2){
		Cursor<Vertex> cursorFriend1 = new Cursor<Vertex>(this.search(this.getComparator(), new Vertex(new PersonSocial(idFriend1, ""),comparator)));
		while (!cursorFriend1.isOut()) {
			Cursor<Vertex> cursorFriend2 = new Cursor<Vertex>(this.search(this.getComparator(), new Vertex(new PersonSocial(idFriend2, ""),comparator)));
			while (!cursorFriend2.isOut()) {
				if(cursorFriend1.info().getPersonSocial().getId() == cursorFriend2.info().getPersonSocial().getId()) {
					commonFriends.add(cursorFriend1.info().getPersonSocial());
				}
				cursorFriend2.next();
			}
			cursorFriend1.next();
		}
		
	  }
		
		return commonFriends;
	}
	
	/**
	 * Este metodo comprueba que exista la persona que desea eliminar
	 * @param idPersonSocial
	 * @param idPersonSocialDelete
	 * @return false si cualquiera de las dos personas no existen, es decir no se elimino ninguna persona
	 */
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
	
	/**
	 * Al existir la persona que quiere eliminar a un amigo, pues se valida que exista la persona a eliminar y se elimina
	 * @param vertex
	 * @param idPersonSocialDelete
	 * @return si no existe la persona a eliminar pues false
	 */
	private boolean deleteFriend(Vertex vertex, int idPersonSocialDelete) {
		Boolean isDelete = false;
		Cursor<Vertex> cursor = new Cursor<Vertex>(vertex);
		while (!cursor.isOut()) {
			if (cursor.info().getPersonSocial().getId() == idPersonSocialDelete) {
				vertex.eliminateNode(this.getComparator(), new Vertex(new PersonSocial(idPersonSocialDelete, ""),this.getComparator()));
				isDelete = true;
			}
			cursor.next();
		}
		return isDelete;
	}
	
	
	/**
	 * Este metodo retorna las personas que no tienen amigos
	 * @return lista de personas
	 */
	public SimpleList<PersonSocial> getPersonsSocialAlone(){
		SimpleList<PersonSocial> personSocialAlone = new SimpleList<PersonSocial>();
		Cursor<Vertex> cursor = new Cursor<Vertex>(this); 
		while (!cursor.isOut()) {
			if (cursor.info().size() == 0) {
				personSocialAlone.add(cursor.info().getPersonSocial());
			}
			cursor.next();
		}
		return personSocialAlone;
	}
	
	/**
	 * 
	 * @return
	 */
	public SimpleList<Vertex> getListPersonMaxFriends() {
		SimpleList<Vertex> list = new SimpleList<Vertex>();
		Cursor<Vertex> cursor = new Cursor<Vertex>(this);
		while (!cursor.isOut()) {
			cursor.info().getPersonSocial().setId(cursor.info().size());
			list.add(cursor.info());
			cursor.next();
		}
		return list;
	}
	
	
}


	