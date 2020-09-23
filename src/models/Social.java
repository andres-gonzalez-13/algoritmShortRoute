package models;

import java.util.Comparator;

import dataestructure.Graph;
import dataestructure.Vertex;

public class Social extends Graph{
	
	private String[] nombres = {"Mar�a Carmen","Mar�a","Carmen","Josefa","Ana Mar�a","Isabel", "Mar�a Pilar","Mar�a Dolores","Laura","Mar�a Teresa",
			"Antonio","Jos�","Manuel", "Francisco","David","Juan","Jos� Antonio","Javier","Jos� Luis","Daniel","Luc�a","Martina","Mar�a","Sof�a",
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
