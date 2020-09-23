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
				vertexOrigin = cursor.info();
			}else if(cursor.info().getPersonSocial().getId() == destiny) {
				vertexDestiny = cursor.info();
			}
			cursor.getInfoAndNext();
		}
		
		
		if(vertexDestiny != null && vertexOrigin != null) {
				if (!vertexOrigin.isExist(vertexDestiny)) {
					vertexDestiny.add(vertexOrigin);
					vertexOrigin.add(vertexDestiny);
					flag = true;
			}
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
