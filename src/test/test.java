package test;

import java.util.Comparator;

import dataestructure.Cursor;
import dataestructure.Graph;
import dataestructure.NodeList;
import dataestructure.Vertex;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Vector;
import javax.swing.JFrame;
import models.PersonSocial;
import views.GraphPanel;

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
		graph.add(new Vertex(personSocial, comparator));
		graph.add(new Vertex(personSocial1,comparator));
		graph.add(new Vertex(personSocial2, comparator));
		graph.add(new Vertex(personSocial3, comparator));
		graph.add(new Vertex(personSocial4, comparator));
		graph.add(new Vertex(personSocial5, comparator));
		
		graph.show();
                graph.setComparator(comparator);
		
		//Aqui se agregan amigos teniendo en cuenta el id de amigo
		Boolean isInsert = graph.addConn(6, 2);
                //esta conexion da nullpointer
		Boolean isInsert2 = graph.addConn(1, 3);
		Boolean isInsert3 = graph.addConn(3, 5);
                Boolean isInsert4 = graph.addConn(4, 5);
                
                //este da bug no de porque
//                Boolean isInsert6 = graph.addConn(6, 5);
		System.out.println("inserto?: " + isInsert4);
		
		Vertex search = graph.search(comparator, new Vertex(new PersonSocial(5, "")));
//		System.out.println("vertex: " + search.getPersonSocial().getNickName());
		Cursor<Vertex> cursor = new Cursor<Vertex>(search);
                
                
                Vector<Vertex> vertexToShow = new Vector();
                
                
                Cursor<Vertex> cursor2 = new Cursor<Vertex>(graph);
                    while (!cursor2.isOut()) {
                    vertexToShow.add(cursor2.getInfoAndNext());
                }
                
                
                JFrame frame = new JFrame();
                    frame.setSize(new Dimension(400, 400));
                    frame.setLayout(new BorderLayout());
                    GraphPanel grapher = new GraphPanel();

                    frame.add(grapher, BorderLayout.CENTER);
                    
                frame.setVisible(true);
	}

}
