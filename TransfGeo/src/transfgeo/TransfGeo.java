
package transfgeo;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComponent;
import javax.swing.JFrame;


public class TransfGeo extends JFrame {
 
    public static void main(String[] args) {
       new TransfGeo();
    }
    
    TransfGeo() {
        this.setTitle("Algoritmo de Transformações Geométricas");
        this.setSize(600,400);
        this.add("Center",new TransformaGeo());
        this.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private static class TransformaGeo extends JComponent {
        Polygon poly;
        float mi[][];
        float mt[][];
        float mr[][];
        int li, ci, lt,ct;
        
        public TransformaGeo() {
            iniciaMatrizes();
            addMouseListener(new MouseAdapter () {
                public void mousePressed(MouseEvent evt) {
                    if (evt.getButton() == MouseEvent.BUTTON1)
                        transformaEscala();
                        repaint();
                   }
            });
        }
        
        private void iniciaMatrizes() {
            poly = new Polygon();
            
            li = 3; ci =2;
            mi = new float[li][ci];
            mi[0][0] = 150; mi[0][1] = 100;
            mi[1][0] = 20; mi[1][1] = 200;
            mi[2][0] = 120; mi[2][1] = 200;
            
            for(int i=0;i<mi.length; i++) poly.addPoint((int)mi[i][0], (int)mi[i][1]);
            
//            poly.addPoint(150,100);
//            poly.addPoint(20,200);
//            poly.addPoint(120,200);
        }
        public void transformaEscala() {
            lt = 2; ct = 2;
            mt = new float[lt][ct];
            mt[0][0] = (float) 1.5; mt[0][1] = (float) 0;
            mt[1][0] = (float) 0; mt[1][1] = (float) 1.5;
            
            mr = new float[li][ct];
            
            mr[0][0] =(mi[0][0] * mt[0][0]) + (mi[0][1] * mt[0][1]);
            mr[0][1] =(mi[0][0] * mt[0][1]) + (mi[0][1] * mt[1][1]);
            
            mr[1][0] =(mi[1][0] * mt[0][0]) + (mi[1][1] * mt[0][1]);
            mr[1][1] =(mi[1][0] * mt[0][1]) + (mi[1][1] * mt[1][1]);
            
            mr[2][0] =(mi[2][0] * mt[0][0]) + (mi[2][1] * mt[0][1]);
            mr[2][1] =(mi[2][0] * mt[0][1]) + (mi[2][1] * mt[1][1]);
            
            poly = new Polygon();
            for(int i=0;i<mi.length; i++) poly.addPoint((int)mr[i][0], (int)mr[i][1]);
            
        }
        
        @Override
        public void paint (Graphics g) {
            g.fillPolygon(poly);
            
        }

        
    }
    
}


