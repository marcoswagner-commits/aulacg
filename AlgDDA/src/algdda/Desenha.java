/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algdda;

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
        
        this.setTitle("Algoritmo DDA - Geração de Retas");
        this.setSize(300,300);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.red);
        //algDDA(g,10,40,60,90);
        //algDDA(g,10,40,50,100);
        algDDA(g,10,40,80,40);
        algDDA(g,10,40,10,90);
    }
       

    private void algDDA(Graphics g, int xi, int yi, int xf, int yf) {
        
        int steps;
        float x=xi, y=yi, incX, incY;
        
        int dx = xf - xi;
        int dy = yf - yi;
        
        if(Math.abs(dx)>Math.abs(dy)) {
            steps = Math.abs(dx); incX = 1; incY= (float) dy /dx; }
        else {
            steps = Math.abs(dy); incY = 1; incX= (float) dx /dy; }
        
        System.out.println(steps + "-" + dx + "-" + dy+ "-" + incX + "-" + incY );
    
        for(int i=0; i<steps; i++) {
            x = x + incX;
            y = y + incY;
            putPixel(g,Math.round(x),Math.round(y)); }
            
        
    }
    
    
     public void putPixel(Graphics g, int x, int y) {
        g.drawLine(x, y, x, y);
        
    }
}
