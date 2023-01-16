
## Aula 10 - Computação Gráfica

> Aula 06/07/2021 - Computação Gráfica
> Atividades da aula - roteiro

## Implementação do Algoritmo Clássico de Circunferência - Incremental com Simetria

- [Conteúdo do Curso](https://github.com/marcoswagner-commits/projetos_cg/blob/56bc895a869568bf9bb4c13f42e976b133f58330/ApostilaCG2021_Modulo2.pdf)

- Veja o vídeo abaixo que mostra a implementação dos algoritmos
 
🎬

[![material complementar](https://github.com/marcoswagner-commits/projetos_cg/blob/9a7a875a273c69f03b6048ea2138b963fd82fa7b/Capa_Aula10.png)](https://www.youtube.com/watch?v=41vksW80Ra8)


![Captura de Tela 2021-06-21 às 16 04 36](https://user-images.githubusercontent.com/81576640/122814692-ee58c380-d2aa-11eb-816a-ac1cc1364663.png)


:shipit: Código 1
```


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
        algIncSem(g,100);
        
    }
    
    public void algIncSem(Graphics g, int raio) {
        int x=0, y=0;
        double ang=0.0;
        
        while(ang<Math.PI/4) {
             x = (int) (raio * Math.cos(ang));
            y = (int) (raio * Math.sin(ang));
            //putPixel(g,x,y);
            simetria(g,x,y);
            ang = ang + (double) 1/raio;
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



