## Aula 09 - Computação Gráfica

> Aula 01/07/2021 - Computação Gráfica
> Atividades da aula - roteiro

## Implementação do Algoritmo Clássico de Circunferência - Equação Paramétrica

- [Conteúdo do Curso](https://github.com/marcoswagner-commits/projetos_cg/blob/56bc895a869568bf9bb4c13f42e976b133f58330/ApostilaCG2021_Modulo2.pdf)

![Tabela_Seno_Coseno](https://user-images.githubusercontent.com/81576640/122778837-b5592880-d283-11eb-8c57-c097cc932717.jpg)

- Veja o vídeo abaixo que mostra a implementação dos algoritmos
 
🎬
[![material complementar](https://github.com/marcoswagner-commits/projetos_cg/blob/9a7a875a273c69f03b6048ea2138b963fd82fa7b/Capa_Aula9.png)](https://www.youtube.com/watch?v=BOf0kEBVzYQ)

🎬
[![material complementar](https://github.com/marcoswagner-commits/projetos_cg/blob/9a7a875a273c69f03b6048ea2138b963fd82fa7b/Capa_Aula9.png)](https://www.youtube.com/watch?v=f86Fw8OHDHk)



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
        desloc = 110;
    }
    
    @Override
    public void paint(Graphics g) {
        algParam(g,20);
        
    }
    
    public void algParam(Graphics g, int raio) {
        int x, y;
        for (int ang=0; ang<360; ang++) {
            x = (int) (raio * Math.cos(Math.PI*ang/180));
            y = (int) (raio * Math.sin(Math.PI*ang/180));
            putPixel(g,x,y);
        }
    }

    private void putPixel(Graphics g, int x, int y) {
        g.drawLine(x+desloc, y+desloc, x+desloc, y+desloc);
    }
}


```



