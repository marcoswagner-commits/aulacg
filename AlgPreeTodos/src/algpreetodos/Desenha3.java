/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algpreetodos;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

/**
 *
 * @author marcos_wagner
 */
public class Desenha3 extends JComponent {

   private int px1=25, px2=125, px3=110, px4=100,
                    py1=25, py2=25, py3=100, py4=100; 
   private int pixels[][];
    
    public Desenha3() {
        pixels = new int[300][300];
    }
    
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.red);
        poligono(g);
        g.setColor(Color.blue);
        
        preBF(g,75,60);
        
        
    }
    
     public void poligono(Graphics g) {
        algBres(g,px1,py1,px2,py2);
        algBres(g,px2,py2,px3,py3);
        algBres(g,px3,py3,px4,py4);
        algBres(g,px4,py4,px1,py1);
    }
    
     public void preBF(Graphics g, int x, int y) {
         if (getPixel(g,x,y)== 0) {
             putPixel(g,x,y);
             
             preBF(g,x+1,y);
             preBF(g,x-1,y);
             preBF(g,x,y+1);
             preBF(g,x,y-1);
             
         }
     }
    
    public void putPixel(Graphics g, int x, int y) {
        g.drawLine(x, y, x, y);
        pixels[x-1][y-1] = 1;
    }
    
    public int getPixel(Graphics g, int x, int y) {
         return pixels[x-1][y-1];
    }
    
    public void algBres(Graphics g, int xi, int yi, int xf, int yf) {
        int t, dist;
        int xerr=0, yerr=0, dx, dy;
        int incX, incY;
        
        dx = xf - xi ;
        dy = yf - yi; 
        
        if (dx > 0) incX = 1;
        else if(dx==0) incX = 0;
        else incX = -1;
        
         if (dy > 0) incY = 1;
         else if(dy==0) incY = 0;
        else incY = -1;
         
         dx = Math.abs(dx);
         dy = Math.abs(dy);
         
         if (dx > dy) dist = dx;
         else dist = dy;
         
         for (int k=0; k<=dist; k++) {
             putPixel(g,xi,yi);
             xerr = xerr + dx;
             yerr = yerr + dy;
             
             if(xerr>dist) {xerr = xerr - dist; xi = xi + incX;}
             if(yerr>dist) {yerr = yerr - dist; yi = yi + incY;}
         }
        
    }
    
}
