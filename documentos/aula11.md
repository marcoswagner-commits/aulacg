
## Aula 11 - Computação Gráfica

## Implementação do Algoritmo Clássico de Circunferência - Bresenham

- [Conteúdo do Curso](https://github.com/marcoswagner-commits/projetos_cg/blob/56bc895a869568bf9bb4c13f42e976b133f58330/ApostilaCG2021_Modulo2.pdf)

- Veja o vídeo abaixo que mostra a implementação dos algoritmos
 
🎬

[![material complementar](https://github.com/marcoswagner-commits/projetos_cg/blob/9a7a875a273c69f03b6048ea2138b963fd82fa7b/Capa_Aula11.png)](https://www.youtube.com/watch?v=fPUDIOWkn88)



![Captura de Tela 2021-06-21 às 21 56 13](https://user-images.githubusercontent.com/81576640/122846395-21677b00-d2dc-11eb-806e-5e9f71094b0e.png)


:shipit: Código 1
```

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



```



