/*
 */

package views;

import dataestructure.Vertex;
import utils.Constants;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Vector;
import javax.swing.JPanel;

/**
 * 
 * @author Andres santiago <Andrecksantiago@gmail.com>
 */
public class PanelDraw extends JPanel{

    int x = 740;
    int y = 440;
    int ancho = 60;
    int alto = 60;
    public Vector<Integer> xvs;
    public Vector<Integer> yvs;
    public Vector<Vertex> vgrafos;
    int indice = 0;

    public PanelDraw(){
        vgrafos = new Vector();
        xvs = new Vector<Integer>();
        yvs = new Vector<Integer>();
        this.setOpaque(false);
        setDoubleBuffered(true);
    }

    @Override
    public void paint(Graphics g) {
        paintComponents(g);
    }

    @Override
    public void paintComponents(Graphics grafico){
        super.paintComponents(grafico);
        Graphics2D g = (Graphics2D)grafico;

        if(vgrafos.size() != 0){
            g.setColor(new Color(0,0,0,0));
            g.fillRect(0, 0, getWidth(), getHeight());
            int radio = 350;
            float angulo = 360/vgrafos.size();
            angulo = (float) Math.toRadians(angulo);
            for(int i = indice;i < vgrafos.size();i++){
                int xv = (int)(x + radio*Math.cos(i * angulo));
                int yv = (int) (y - radio * Math.sin(i * angulo));
                xvs.add(xv);
                yvs.add(yv);
                indice++;
            }
        }

        for(int i = 0;i < vgrafos.size();i++){
            for(int j = 0;j < vgrafos.size();j++){
                g.setStroke(new BasicStroke(2));
                g.setColor(Color.BLACK);
                g.setFont(Constants.fontBtn(22));
                if(vgrafos.get(i).isExist(vgrafos.get(j))){
                    g.drawLine(xvs.get(i)+15,yvs.get(i)+15,xvs.get(j)+15,yvs.get(j)+15);
                }
                g.setColor(Color.WHITE);
                g.fillOval(xvs.get(i), yvs.get(i), ancho, alto);
                g.setColor(Color.BLACK);
                g.drawOval(xvs.get(i),yvs.get(i), ancho, alto);
                g.drawString(""+vgrafos.get(i).getPersonSocial().getNickName(), xvs.get(i)+((ancho/2)-3), yvs.get(i)+((alto/2)+3));

            }
        }
    }
    
    public Vector<Vertex> getVgrafos() {
        return vgrafos;
    }
    public void setVgrafos(Vector<Vertex> vgrafos) {
        this.vgrafos = vgrafos;
        repaint();
    }
    

}
