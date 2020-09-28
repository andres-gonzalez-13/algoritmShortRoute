package models;


import java.util.Comparator;
import dataestructure.Cursor;
import dataestructure.Graph;
import dataestructure.SimpleList;
import dataestructure.Vertex;

public class Social extends Graph{
	
	private String[] nombres = {"Maria Carmen","Maria","Carmen","Josefa","Ana Maria","Isabel", "Maria Pilar","Maria Dolores","Laura","Maria Teresa",
			"Antonio","Jose","Manuel", "Francisco","David","Juan","Jose Antonio","Javier","Jose Luis","Daniel","Lucia","Martina","Maria","Sofia",
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
	public SimpleList<PersonSocial> commonFriends(int idFriend1, int idFriend2){
		SimpleList<PersonSocial> commonFriends = new SimpleList<PersonSocial>();
		
		if(isExist(new Vertex(new PersonSocial(idFriend1, ""))) == true && isExist(new Vertex(new PersonSocial(idFriend2, ""))) && idFriend1 != idFriend2){
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
	 * Este metodo retorna la persona que mas amigos tenga en el grafo
	 * @return
	 */
	public PersonSocial getMaxFriends() {
		Vertex vertex = null;
		int current = 0;
		if(this.size() > 0 ) {
		Cursor<Vertex> cursor = new Cursor<Vertex>(this);
		while (!cursor.isOut()) {
			
			if (cursor.info().size() > current) {
				current = cursor.info().size();
				vertex = cursor.info();
			}
			cursor.next();
		 }
	  }
		return vertex.getPersonSocial();
	}
	
	
	
	public boolean deletePersonSocial(int idDelete) {
		Boolean isDelete = false;
		Vertex vertex = new Vertex(new PersonSocial(idDelete, ""));
		if (this.isExist(vertex)) {
			vertex = this.getElement(new Vertex(new PersonSocial(idDelete,"")));
			Cursor<Vertex> cursor = new Cursor<Vertex>(vertex);
			while (!cursor.isOut()) {
				cursor.getInfoAndNext().eliminateNode(this.getComparator(), vertex);
				isDelete = true;
			}
			
			this.eliminateNode(vertex);
		}
		return isDelete;
	}

    public SimpleList<PersonSocial> notFriendsAtPerson(int idPerson){
        SimpleList<PersonSocial> notFriends = new SimpleList<PersonSocial>();
        Vertex idPersonVertex = this.search(getComparator(), new Vertex(new PersonSocial(idPerson, "")));
        Cursor<Vertex> cursor = new Cursor<Vertex>(this);
        while (!cursor.isOut()) {
            if(cursor.info().getPersonSocial().getId() != idPerson && !idPersonVertex.isExist(cursor.info())) {
                notFriends.add(cursor.info().getPersonSocial());
            }
            cursor.next();
        }

        return notFriends;
    }

	public SimpleList<Vertex> getFriends(int idPerson){
		Cursor<Vertex> cursor = new Cursor<Vertex>(this);
		while (!cursor.isOut()) {
			if (cursor.info().getPersonSocial().getId() == idPerson) {
				return cursor.info();
			}
			cursor.next();
		}
		return null;
	}

	public SimpleList<PersonSocial> getPersonsNotI(int idPerson){
		SimpleList<PersonSocial> persons = new SimpleList<PersonSocial>();
		Cursor<Vertex> cursor = new Cursor<Vertex>(this);
		while (!cursor.isOut()) {
			if(cursor.info().getPersonSocial().getId() != idPerson) {
				persons.add(cursor.info().getPersonSocial());
			}
			cursor.next();
		}
		return persons;
	}

}


	