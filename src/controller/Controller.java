package controller;

import java.util.Comparator;

import dataestructure.Vertex;
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
	}
}
