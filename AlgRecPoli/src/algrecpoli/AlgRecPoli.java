package algrecpoli;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import javax.swing.JComponent;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class AlgRecPoli extends JFrame {
    public static void main(String[] args) { new AlgRecPoli();  }
    
    AlgRecPoli() {
        this.setTitle("Algoritmo de Recorte de Polígonos de Sutherland-Hodgman");
       this.setSize(500,300);
       this.add("Center",new RecPoli());
       this.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
       this.setLocationRelativeTo(null);
       this.setDefaultCloseOperation(EXIT_ON_CLOSE);
       this.setVisible(true);
    }
}

class RecPoli extends JComponent {
    Poly poly = null;
    float rWidth = 10.0F, rHeight = 7.5F, pixelSize;
    int x0, y0, centerX, centerY; 
    boolean pronto = true;
    
    
    RecPoli() {
        addMouseListener(new MouseAdapter () {
            public void mousePressed(MouseEvent evt) {
                int x = evt.getX(), y = evt.getY();
                if (pronto) {
                    poly = new Poly();
                    x0 = x; y0 = y;
                    pronto = false;
                }
                if (poly.size() > 0 && Math.abs(x - x0) < 3 && Math.abs(y - y0) < 3) 
                        pronto = true;
                else
                    poly.addVertex(new Ponto2D(fx(x), fy(y)));
                repaint();
            }
        });
    }
    
    void initValues() {
        Dimension d = getSize();
        int maxX = d.width - 1, maxY = d.height - 1;
        pixelSize = Math.max(rWidth / maxX, rHeight / maxY);
        centerX = maxX / 2; centerY = maxY / 2;
        }
    
        public float fx(int x) { return (x - centerX) * pixelSize; }
        
        public float fy(int y) { return (centerY - y) * pixelSize;  }
        
        int iX(float x) { return Math.round(centerX + x / pixelSize); }
        
        int iY(float y) { return Math.round(centerY - y / pixelSize);  }
        
        void drawLine(Graphics g, float xi, float yi, float xf, float yf) {
            g.drawLine(iX(xi), iY(yi), iX(xf), iY(yf));
            
        }
        
        public void paint(Graphics g) {
            initValues();
            float xmin = -rWidth / 3, xmax = rWidth / 3,
                    ymin = -rHeight /3, ymax = rHeight / 3;
            
            g.setColor(Color.blue);
            drawLine(g,xmin, ymin, xmax, ymin);
            drawLine(g,xmax, ymin, xmax, ymax);
            drawLine(g,xmax, ymax, xmin, ymax);
            drawLine(g,xmin,ymax, xmin, ymin);
            g.setColor(Color.red);
            if (poly == null) return;
            int n = poly.size();
            if (n == 0) return;
            Ponto2D pi = poly.vertexAt(0);
            if (!pronto) {
                g.drawRect(iX(pi.x) -2, iY(pi.y) -2, 4, 4);
                for (int i = 1; i< n; i++) {
                    Ponto2D pp = poly.vertexAt(i);
                    
                    g.drawLine(iX(pi.x), iY(pi.y), iX(pp.x), iY(pp.y));
                    pi = pp;
                }
            }
            else {
                poly.clipPoli(xmin,ymin, xmax, ymax);
                drawPoly(g, poly);
            }
        }
        
        
        void drawPoly(Graphics g, Poly poly) {
            int n = poly.size();
            if (n== 0) return;
            Ponto2D p1 = poly.vertexAt(n - 1);
            for (int i=0; i< n; i++) {
                Ponto2D p2 = poly.vertexAt(i);
                drawLine(g,p1.x, p1.y,p2.x, p2.y);
                p1 = p2;
            }
                
            
        }
        
        
        
        class Poly {
            Vector<Ponto2D> vp = new Vector<Ponto2D>();
            
            void addVertex(Ponto2D p) {vp.addElement(p);}
                    
             int size() {return vp.size();}   
             
             Ponto2D vertexAt(int i) { return (Ponto2D) vp.elementAt(i);   }
             
             void clipPoli(float xmin, float ymin, float xmax, float ymax) {
                Poly poly1 = new Poly();
                int n;
                Ponto2D pi, pp;
                boolean piIns, ppIns;

                //lado do xmax
                if ((n = size()) == 0) return;
                pp = vertexAt(n - 1);
                for (int i=0; i<n; i++) {
                    pi = pp; pp = vertexAt(i);
                    piIns = pi.x<=xmax;  ppIns = pp.x <= xmax; 
                    if (piIns != ppIns)
                        poly1.addVertex(new Ponto2D(xmax, 
                                pi.y + (pp.y - pi.y) * (xmax - pi.x) / (pp.x - pi.x)));
                    if (ppIns) poly1.addVertex(pp);
                }
                vp = poly1.vp; poly1 = new Poly();

                //lado do xmin
                if ((n = size()) == 0) return;
                pp = vertexAt(n-1);
                for (int i=0; i<n; i++) {
                    pi = pp; pp = vertexAt(i);
                    piIns = pi.x>=xmin;  ppIns = pp.x >= xmin; 
                    if (piIns != ppIns)
                        poly1.addVertex(new Ponto2D(xmin, 
                                pi.y + (pp.y - pi.y) * (xmin - pi.x) / (pp.x - pi.x)));
                    if (ppIns) poly1.addVertex(pp);
                }
                vp = poly1.vp; poly1 = new Poly();

                
                //lado do ymax
                if ((n = size()) == 0) return;
                pp = vertexAt(n-1);
                for (int i=0; i<n; i++) {
                    pi = pp; pp = vertexAt(i);
                    piIns = pi.y<=ymax;  ppIns = pp.y <= ymax; 
                    if (piIns != ppIns)
                        poly1.addVertex(new Ponto2D(pi.x + 
                                (pp.x - pi.x) * (ymax - pi.y) / (pp.y- pi.y),ymax));
                    if (ppIns) poly1.addVertex(pp);
                }
                vp = poly1.vp; poly1 = new Poly();

                //lado do ymin
                if ((n = size()) == 0) return;
                pp = vertexAt(n-1);
                for (int i=0; i<n; i++) {
                    pi = pp; pp = vertexAt(i);
                    piIns = pi.y>=ymin;  ppIns = pp.y >= ymin; 
                    if (piIns != ppIns)
                        poly1.addVertex(new Ponto2D(pi.x + 
                                (pp.x - pi.x) * (ymin - pi.y) / (pp.y- pi.y),ymin));
                    if (ppIns) poly1.addVertex(pp);
                }
                vp = poly1.vp; poly1 = new Poly();
            }
        }
        
        
        
        class Ponto2D {
            float x, y;
            Ponto2D(float x, float y) {this.x= x; this.y = y;}
        }
}
