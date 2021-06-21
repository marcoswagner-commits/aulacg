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
public class Desenha2 extends JComponent {

    private int pixels[][];
    private int px1=50, px2=250, px3=210, px4=200,
                    py1=50, py2=50, py3=200, py4=200;  
        
    public Desenha2() {
        pixels = new int[300][300];
    }
    
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.red);
        poligono(g);
        g.setColor(Color.blue);
        preVarred(g,50,50,250,200);
        g.setColor(Color.red);
        poligono(g);
    }
    
    public void putPixel(Graphics g, int x, int y) {
        g.drawLine(x,y,x,y);
        pixels[x-1][y-1] = 1;
    }
    
    public int getPixel(Graphics g, int x, int y) {
        return pixels[x-1][y-1];
    }

    private void poligono(Graphics g) {
        algBres(g,px1,py1,px2,py2);
        algBres(g,px2,py2,px3,py3);
        algBres(g,px3,py3,px4,py4);
        algBres(g,px4,py4,px1,py1);
       
        
    }

    private void preVarred(Graphics g, int xmin, int ymin, int xmax, int ymax) {
        boolean liga;
        
        for (int y=ymin-1; y<=ymax+1; y++) {
            liga = false;
            for(int x=xmin-1; x<=xmax+1; x++) {
               if (liga) putPixel(g,x,y); 
               
               if((getPixel(g,x+1,y)>0)&(getPixel(g,x+2,y)<1)) liga = !liga;
            }
         }
           
        
    }

    private void algBres(Graphics g, int xi, int yi, int xf, int yf) {
        
        int xerr = 0, yerr = 0, dx, dy, incX, incY, dist;
        
        dx = xf - xi;
        dy = yf - yi;
        
        if (dx > 0) incX = 1;
        else if (dx==0) incX = 0;
        else incX = -1;
        
        if (dy > 0) incY = 1;
        else if (dy==0) incY = 0;
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
