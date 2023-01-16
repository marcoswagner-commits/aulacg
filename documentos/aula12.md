## Aula 12 - Computação Gráfica

> Aula 03/08/2021 - Computação Gráfica
> Atividades da aula - roteiro

## Implementação de Algoritmos para demonstração das transformações geométricas

![anima_escala](https://user-images.githubusercontent.com/81576640/127195708-b8ebfbe9-8e3d-4129-89d3-9d6e7a28ba6c.gif)

![trans-anim](https://user-images.githubusercontent.com/81576640/127233348-614706ab-b22c-45d0-9953-3fd8b289ef54.gif)


![Rot-anim](https://user-images.githubusercontent.com/81576640/127195715-948dd0d6-af93-46bf-9eb9-c5e05bd7c7cb.gif)



- [Conteúdo do Curso](https://github.com/marcoswagner-commits/projetos_cg/blob/1c9aef018249c95479398ea3e954ce697592ff8d/ApostilaCG2021_Modulo2.pdf)

### Passo 1: Implementar o algoritmo para demonstrar a transformação geométrica de Escala
- [x] Criar em java uma matriz de pontos
- [x] Desenhar a matriz de pontos
- [x] Criar uma matriz de transformação
- [x] Aplicar a matriz resultante

- Veja o vídeo abaixo que mostra a implementação dos algoritmos
 
🎬
[![material complementar](https://github.com/marcoswagner-commits/projetos_cg/blob/3865f586fe81a3c5d1ee748a77560772f5513704/Capa_Aula12-13.png)](https://www.youtube.com/watch?v=kjlaXhsOWDw)

🎬
[![material complementar](https://github.com/marcoswagner-commits/projetos_cg/blob/3865f586fe81a3c5d1ee748a77560772f5513704/Capa_Aula12-13.png)](https://www.youtube.com/watch?v=Cq6ZIce8r0M)



:shipit: Código 1
```

package transfgeo;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComponent;
import javax.swing.JFrame;


public class TransfGeo extends JFrame {
 
    public static void main(String[] args) {
       new TransfGeo();
    }
    
    TransfGeo() {
        this.setTitle("Algoritmo de Transformações Geométricas");
        this.setSize(600,400);
        this.add("Center",new TransformaGeo());
        this.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private static class TransformaGeo extends JComponent {
        Polygon poly;
        float mi[][];
        float mt[][];
        float mr[][];
        int li, ci, lt,ct;
        
        public TransformaGeo() {
            iniciaMatrizes();
            addMouseListener(new MouseAdapter () {
                public void mousePressed(MouseEvent evt) {
                    if (evt.getButton() == MouseEvent.BUTTON1)
                        transformaEscala();
                        repaint();
                   }
            });
        }
        
        private void iniciaMatrizes() {
            poly = new Polygon();
            
            li = 3; ci =2;
            mi = new float[li][ci];
            mi[0][0] = 150; mi[0][1] = 100;
            mi[1][0] = 20; mi[1][1] = 200;
            mi[2][0] = 120; mi[2][1] = 200;
            
            for(int i=0;i<mi.length; i++) poly.addPoint((int)mi[i][0], (int)mi[i][1]);
            
//            poly.addPoint(150,100);
//            poly.addPoint(20,200);
//            poly.addPoint(120,200);
        }
        public void transformaEscala() {
            lt = 2; ct = 2;
            mt = new float[lt][ct];
            mt[0][0] = (float) 1.5; mt[0][1] = (float) 0;
            mt[1][0] = (float) 0; mt[1][1] = (float) 1.5;
            
            mr = new float[li][ct];
            
            mr[0][0] =(mi[0][0] * mt[0][0]) + (mi[0][1] * mt[0][1]);
            mr[0][1] =(mi[0][0] * mt[0][1]) + (mi[0][1] * mt[1][1]);
            
            mr[1][0] =(mi[1][0] * mt[0][0]) + (mi[1][1] * mt[0][1]);
            mr[1][1] =(mi[1][0] * mt[0][1]) + (mi[1][1] * mt[1][1]);
            
            mr[2][0] =(mi[2][0] * mt[0][0]) + (mi[2][1] * mt[0][1]);
            mr[2][1] =(mi[2][0] * mt[0][1]) + (mi[2][1] * mt[1][1]);
            
            poly = new Polygon();
            for(int i=0;i<mi.length; i++) poly.addPoint((int)mr[i][0], (int)mr[i][1]);
            
        }
        
        @Override
        public void paint (Graphics g) {
            g.fillPolygon(poly);
            
        }

        
    }
    
}


```



