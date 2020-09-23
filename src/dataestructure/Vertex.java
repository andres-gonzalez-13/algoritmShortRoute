package dataestructure;

import java.util.Comparator;

import models.PersonSocial;

public class Vertex extends SimpleList<Vertex>{
	
	private PersonSocial personSocial;
	
	public Vertex(PersonSocial personSocial,Comparator<Vertex> comparator) {
		super(comparator);
		this.personSocial = personSocial;
	}
	
	public Vertex(PersonSocial personSocial) {
		this.personSocial = personSocial;
	}

	public PersonSocial getPersonSocial() {
		return personSocial;
	}

	public void setPersonSocial(PersonSocial personSocial) {
		this.personSocial = personSocial;
	}
	
	public int gradeVertex() {
		return this.size();
	}

}
