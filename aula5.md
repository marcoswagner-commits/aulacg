## Aula 05 - Computação Gráfica

> Aula 17/06/2021 - Computação Gráfica
> Atividades da aula - roteiro

## Implementação do Algoritmo Clássico de Preenchimento de Áreas - Varredura

- Veja o vídeo abaixo que mostra a implementação dos algoritmos
 
[![material complementar](https://github.com/marcoswagner-commits/projetos_cg/blob/2c262549b09a178950de46fef1258dbeec5b1d03/Capa_Aula5.png)](https://www.youtube.com/watch?v=ZR3LNVua7Pw)


:shipit: Código 1
```
package algpreevarred;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

/**
 *
 * @author marcos_wagner
 */
public class Desenha extends JComponent {

    int pixels[][];
    
    public Desenha() {
        pixels = new int[300][300];
    }
    
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.red);
        poligono(g);
        g.setColor(Color.blue);
        preVarred(g,150,150,200,200);
        g.setColor(Color.red);
        poligono(g);
        
        
    }
    
    public void preVarred(Graphics g, int xmin, int ymin, int xmax, int ymax) {
        boolean liga;
        
        for (int y=ymin-1; y<=ymax+1; y++) {
            liga = false;
            for(int x=xmin-1; x<=xmax+1; x++) {
                if (liga) putPixel(g,x,y);
                if((getPixel(g,x+1,y) > 0)&(getPixel(g,x+2,y)<1)) liga = !liga;
                
                
            }
        }
    }
    
    public void poligono(Graphics g) {
        algBres(g,150,150,200,150);
        algBres(g,200,150,200,200);
        algBres(g,200,200,150,200);
        algBres(g,150,200,150,150);
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
    
    public void putPixel(Graphics g, int x, int y) {
        g.drawLine(x, y, x, y);
        pixels[x-1][y-1] = 1;
    }
    
    public int getPixel(Graphics g, int x, int y) {
         return pixels[x-1][y-1];
    }
    
}


```
