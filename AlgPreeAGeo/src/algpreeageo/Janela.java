/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algpreeageo;

import javax.swing.JFrame;

/**
 *
 * @author marcos_wagner
 */
public class Janela extends JFrame {

    public Janela() {
        
        this.add(new Desenha());
        
        this.setTitle("Algoritmo de Preenchimento de Áreas - Análise Geométrica");
        this.setSize(300,300);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
}
