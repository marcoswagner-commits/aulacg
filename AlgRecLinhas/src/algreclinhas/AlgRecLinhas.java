package algreclinhas;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class AlgRecLinhas extends JFrame {
   public static void main(String[] args) {
        new AlgRecLinhas();
    }
    
   AlgRecLinhas() {
       this.setTitle("Algoritmo de Recorte de Retas de Cohen-Sutherland");
       this.setSize(500,300);
       this.add("Center",new RecLinhas());
       this.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
       this.setLocationRelativeTo(null);
       this.setDefaultCloseOperation(EXIT_ON_CLOSE);
       this.setVisible(true);
   }

    class RecLinhas extends JComponent {
        float xmin, xmax, ymin, ymax, rWidth = 10.0F, rHeight = 7.5F, pixelSize;
        int maxX, maxY, centerX, centerY, np=0;

        public float fx(int x) {
            return (x - centerX) * pixelSize;
        }
        
        public float fy(int y) {
            return (centerY - y) * pixelSize;
        }
        
        int iX(float x) {
            return Math.round(centerX + x / pixelSize);
        }
        
        int iY(float y) {
            return Math.round(centerY - y / pixelSize);
        }
        
        public RecLinhas() {
            addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                float x = fx((evt.getX())), y = fy(evt.getY());
                if (np == 2) np = 0;
                if (np == 0) {xmin = x; ymin = y;}
                else {
                    xmax = x; ymax = y;
                    if (xmax < xmin) {
                        float t = xmax;
                        xmax = xmin;
                        xmin = t;
                    }
                    if (ymax < ymin) {
                        float t = ymax;
                        ymax = ymin;
                        ymin = t;
                    }
                }
                np++;
                repaint();
            }
        });
        }
    
        int clipCode(float x, float y) {
         return (x < xmin ? 8 : 0) | (x > xmax ? 4 : 0) | (y < ymin ? 2 : 0) | (y > ymax ? 1 : 0);    
        }
        
        void clipLine(Graphics g, float xi, float yi, float xf, float yf, float xmin, float ymin, float xmax, float ymax) {
            int cP = clipCode(xi, yi), cQ = clipCode(xf, yf);
            float dx, dy;
            while((cP | cQ) != 0) {
                if ((cP & cQ) != 0) return;
                dx = xf - xi; dy = yf - yi;
                if (cP != 0) {
                    if ((cP & 8) == 8) {
                     yi = yi + (xmin - xi) * dy / dx;
                     xi = xmin;
                } else if ((cP & 4) == 4) {
                     yi = yi + (xmax - xi) * dy / dx;
                     xi = xmax;
                } else if ((cP & 2) == 2) {
                     xi = xi + (ymin - yi) * dx / dy;
                     yi = ymin;
                } else if ((cP & 1) == 1) {
                     xi = xi + (ymax - yi) * dx / dy;
                     yi = ymax;
                }
                    
                    cP = clipCode(xi,yi);
                } else if (cQ != 0) {
                   if ((cQ & 8) == 8) {
                     yf = yf + (xmin - xf) * dy / dx;
                     xf = xmin;
                } else if ((cQ & 4) == 4) {
                     yf = yf + (xmax - xf) * dy / dx;
                     xf = xmax;
                } else if ((cQ & 2) == 2) {
                     xf = xf + (ymin - yf) * dx / dy;
                     yf = ymin;
                } else if ((cQ & 1) == 1) {
                     xf = xf + (ymax - yf) * dx / dy;
                     yf = ymax;
                }
                   cQ = clipCode(xf,yf);
                }
            }
            drawLine(g,xi,yi,xf,yf);
        }
        
        void initValues() {
        Dimension d = getSize();
        maxX = d.width - 1; maxY = d.height - 1;
        pixelSize = Math.max(rWidth / maxX, rHeight / maxY);
        centerX = maxX / 2; centerY = maxY / 2;
        }
    
        @Override
        public void paint (Graphics g) {
            initValues();
            if ((np ==0)||(np==1)) drawLine(g,-4,3,4,-3);
            clipLine(g,-4,3,4,-3,xmin,ymin,xmax,ymax);
            if (np == 1) {
                drawLine(g,fx(0),ymin,fx(maxX),ymin);
                drawLine(g,xmin,fy(0),xmin,fy(maxY));
            } else if (np == 2) {
                drawLine(g,xmin, ymin, xmax, ymin);
                drawLine(g,xmax, ymin, xmax, ymax);
                drawLine(g,xmax, ymax, xmin, ymax);
                drawLine(g,xmin, ymax, xmin, ymin);
                
            }
        
        }
        
        void drawLine(Graphics g, float xP, float yP, float xQ, float yQ) {
            g.drawLine(iX(xP),iY(yP),iX(xQ), iY(yQ));
        }
}     
}
