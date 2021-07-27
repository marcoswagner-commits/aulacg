/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algcircparam;

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
        algParam(g,100);
        
    }
    
    public void algParam(Graphics g, int raio) {
        int x, y;
        for (int ang=0; ang<360; ang++) {
            System.out.println("Loops: "+ang);
            x = (int) (raio * Math.cos(Math.PI*ang/180));
            y = (int) (raio * Math.sin(Math.PI*ang/180));
            putPixel(g,x,y);
        }
    }

    private void putPixel(Graphics g, int x, int y) {
        g.drawLine(x+desloc, y+desloc, x+desloc, y+desloc);
    }
}
