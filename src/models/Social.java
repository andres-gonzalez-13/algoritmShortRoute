package models;

import java.util.Comparator;

import dataestructure.Graph;
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

}
