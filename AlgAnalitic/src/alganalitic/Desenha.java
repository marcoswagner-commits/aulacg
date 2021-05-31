/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alganalitic;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

/**
 *
 * @author marcos_wagner
 */
public class Desenha extends JFrame {
    
    
    public Desenha() {
         
        
        this.setTitle("Linha Reta - Analítico");
        this.setSize(300,300);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
    }
    
    @Override
    public void paint(Graphics g) {
       g.setColor(Color.red);
       algAnalitic(g,10,50,60,100);
       algAnalitic(g,10,50,60,50);
       algAnalitic(g,20,50,20,100);
    }
    
    public void algAnalitic(Graphics g, int xi, int yi, int xf, int yf) {
        float m, b, dy, dx;
        dy = yf - yi;
        dx = xf - xi;
        
        m = (float) dy/dx;
        
        b = (float) (yi - m * xi);
        
        for(int x = xi; x<=xf; x++) {
            int y = (int) (m * x + b);
            putPixel(g,x,y);
        }
    }
    
    public void putPixel(Graphics g, int x, int y) {
        g.drawLine(x, y, x, y);
    }
            
    
}
