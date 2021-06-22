/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algcircbres;

import java.awt.Graphics;
import javax.swing.JComponent;

/**
 *
 * @author marcos_wagner
 */
public class Desenha extends JComponent {

    private int desloc; 
    
    public Desenha() {
        desloc = 150;
    }
    
    @Override
    public void paint(Graphics g) {
        algBres(g,100);
        
    }
    
    public void algBres(Graphics g, int raio) {
        int x=0, y=raio, u=1, v=2 *raio-1, e=0;
               
        while(x<=y) {
            simetria(g,x,y);
            x++;
            e = e + u;
            u = u + 2;
            if (v<(2*e)) {y--; e=e-v; v=v-2;}
        }
        
           
        }
    

    private void simetria(Graphics g, int x, int y) {
        putPixel(g,x,y);
        putPixel(g,x,-y);
        putPixel(g,-x,y);
        putPixel(g,-x,-y);
        
        putPixel(g,y,x);
        putPixel(g,y,-x);
        putPixel(g,-y,x);
        putPixel(g,-y,-x);
          
    }
    private void putPixel(Graphics g, int x, int y) {
        g.drawLine(x+desloc, y+desloc, x+desloc, y+desloc);
    }
}
