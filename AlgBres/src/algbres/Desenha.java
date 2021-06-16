/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algbres;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author marcos_wagner
 */
public class Desenha extends JFrame {

    public Desenha() {
        
        this.setTitle("Algoritmo de Bresenham - Geração de Retas");
        this.setSize(300,300);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.red);
        algBres(g,50,50,150,150); //45º
        algBres(g,50,50,150,50); // 0º
        algBres(g,50,50,50,150); //90º
        algBres(g,50,50,150,100); //67,5º
        algBres(g,50,50,100,150); //112,5º
        
    }
       

    private void algBres(Graphics g, int xi, int yi, int xf, int yf) {
        
       int x = xi, y = yi, d=0, dx = xf-xi, dy = yf-yi, c, m, incX=1, incY=1;
       
       if(dx < 0) {incX = -1; dx = -dx;}
       if(dy < 0) {incY = -1; dy = -dy;}
        System.out.println(dx+"-"+dy+"-"+incX+"-"+incY);
       
       if(dy <= dx) {
           c = 2 * dx; m = 2 * dy;
           System.out.println(c+"-"+m);
           //if(incX < 0) dx++;
           for(;;) {
               putPixel(g,x,y);
               if (x == xf) break;
               x += incX;
               d += m;
               if(d >= dx) {y += incY; d -= c;}
               System.out.println(x+"-"+y);
           }
       } else {
           c = 2 * dy; m = 2 * dx;
           System.out.println(c+"-"+m);
           //if(incY < 0) dy++;
           for(;;) {
               putPixel(g,x,y);
               if (y == yf) break;
               y += incY;
               d += m;
               if(d >= dy) {x += incX; d -= c;}
               System.out.println(x+"-"+y);
       }
       
    }
    }
           
          
     public void putPixel(Graphics g, int x, int y) {
        g.drawLine(x, y, x, y);
        
    }
}