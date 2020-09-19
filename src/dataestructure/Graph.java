package dataestructure;

import java.util.Comparator;

public class Graph extends SimpleList<Vertex>{

	public Graph() {
		
	}
	
public Graph(Comparator<Vertex> comparator) {
		super(comparator);
	}
	
	
	public boolean addConn(int origin, int destiny) {
		Vertex vertexOrigin = null;
		Vertex vertexDestiny = null;
		Boolean flag = false;
		Cursor<Vertex> cursor = new Cursor<Vertex>(this);
		while (!cursor.isOut()) {
			
			if(cursor.info().getPersonSocial().getId() == origin) {
				System.out.println("entro");
				vertexOrigin = cursor.info();
			}else if(cursor.info().getPersonSocial().getId() == destiny) {
				vertexDestiny = cursor.info();
			}
			cursor.getInfoAndNext();
		}
		
		//System.out.println("origin: " + vertexOrigin.getPersonSocial());
		//System.out.println("destiny: " + vertexDestiny.getPersonSocial());
		
		if(vertexDestiny != null && vertexOrigin != null) {
			vertexDestiny.add(vertexOrigin);
			vertexOrigin.add(vertexDestiny);
			flag = true;
		}
		return flag;
	} 
	
	/**
	 * Metodo que muestra los vertices del grafo
	 */
	public void show() {
		Cursor<Vertex> cursor = new Cursor<Vertex>(this);
		while (!cursor.isOut()) {
			System.out.println("vertice: " + cursor.info().getPersonSocial().getNickName() + " id: "  + cursor.info().getPersonSocial().getId());
			cursor.next();
		}
	}
}