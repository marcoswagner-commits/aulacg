## Aula 13 - Computação Gráfica

> Aula 05/08/2021 - Computação Gráfica
> Atividades da aula - roteiro

## Implementação de Algoritmos para demonstração das transformações geométricas

![anima_escala](https://user-images.githubusercontent.com/81576640/127195708-b8ebfbe9-8e3d-4129-89d3-9d6e7a28ba6c.gif)

![trans-anim](https://user-images.githubusercontent.com/81576640/127233348-614706ab-b22c-45d0-9953-3fd8b289ef54.gif)

![Rot-anim](https://user-images.githubusercontent.com/81576640/127195715-948dd0d6-af93-46bf-9eb9-c5e05bd7c7cb.gif)


- [Conteúdo do Curso](https://github.com/marcoswagner-commits/projetos_cg/blob/79e8c86a418d2b1dfa9682b547de624f9e3c43a6/ApostilaCG2021_Modulo2.pdf)

### Passo 1: Implementar o algoritmo para demonstrar a transformação geométrica de Translação
- [x] Criar em java uma matriz de pontos
- [x] Desenhar a matriz de pontos
- [x] Criar uma matriz de transformação
- [x] Aplicar a aplicar a matriz resultante

### Passo 2: Implementar o algoritmo para demonstrar a transformação geométrica de Rotação
- [x] Criar em java uma matriz de pontos
- [x] Desenhar a matriz de pontos
- [x] Criar uma matriz de transformação
- [x] Aplicar a aplicar a matriz resultante


- Veja o vídeo abaixo que mostra a implementação dos algoritmos
 
🎬
[![material complementar](https://github.com/marcoswagner-commits/projetos_cg/blob/9a7a875a273c69f03b6048ea2138b963fd82fa7b/Capa_Aula9.png)](https://www.youtube.com/watch?v=RXKv48jAskA)

🎬
[![material complementar](https://github.com/marcoswagner-commits/projetos_cg/blob/9a7a875a273c69f03b6048ea2138b963fd82fa7b/Capa_Aula9.png)](https://www.youtube.com/watch?v=SkVOsu8tcBk)



:shipit: Código 1 com Translação
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
        double tx=1, ty=1;
        double mi[][];
        double mt[][];
        double mr[][];
        int li, ci, lt,ct;
        
        public TransformaGeo() {
            iniciaMatrizes();
            addMouseListener(new MouseAdapter () {
                public void mousePressed(MouseEvent evt) {
                    if (evt.getButton() == MouseEvent.BUTTON1)
                    { transformaEscala();}
                    else if (evt.getButton() == MouseEvent.BUTTON2)
                    { transformaTranslada(); tx=tx+1; ty=ty+1;}
                        repaint();
                   }
            });
        }
        
        private void iniciaMatrizes() {
            poly = new Polygon();
            
            li = 3; ci =2;
            mi = new double[li][ci];
            mi[0][0] = 150; mi[0][1] = 100;
            mi[1][0] = 20; mi[1][1] = 200;
            mi[2][0] = 120; mi[2][1] = 200;
            
                    

        }
        public void transformaEscala() {
            lt = 2; ct = 2;
            mt = new double[lt][ct];
            mt[0][0] = (double) 1.5; mt[0][1] = (double) 0;
            mt[1][0] = (double) 0; mt[1][1] = (double) 1.5;
            
            mr = new double[li][ct];
            
            mr[0][0] =(mi[0][0] * mt[0][0]) + (mi[0][1] * mt[0][1]);
            mr[0][1] =(mi[0][0] * mt[0][1]) + (mi[0][1] * mt[1][1]);
            
            mr[1][0] =(mi[1][0] * mt[0][0]) + (mi[1][1] * mt[0][1]);
            mr[1][1] =(mi[1][0] * mt[0][1]) + (mi[1][1] * mt[1][1]);
            
            mr[2][0] =(mi[2][0] * mt[0][0]) + (mi[2][1] * mt[0][1]);
            mr[2][1] =(mi[2][0] * mt[0][1]) + (mi[2][1] * mt[1][1]);
            
           pushMatrix();
            
        }
        
        public void transformaTranslada() {
            mr = new double[li][ci];
            
            mr[0][0] =(mi[0][0] + tx);
            mr[0][1] =(mi[0][1] + ty);
            
            mr[1][0] =(mi[1][0] + tx);
            mr[1][1] =(mi[1][1] + ty);
            
            mr[2][0] =(mi[2][0] + tx);
            mr[2][1] =(mi[2][1] + ty);
            
            pushMatrix();
            
        }
        
        public void pushMatrix() {
            for(int i=0; i<li; i++)
                for(int j=0; j<ci; j++)
                    mi[i][j] = mr[i][j];
        }
        
        @Override
        public void paint (Graphics g) {
            poly = new Polygon();
            for(int i=0;i<mi.length; i++) poly.addPoint((int)mi[i][0], (int)mi[i][1]);
            g.fillPolygon(poly);
            
        }

        
    }
    
}




```



:shipit: Código 2 com Rotação
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
        double tx=1, ty=1, ang=0.1;
        double mi[][];
        double mt[][];
        double mr[][];
        int li, ci, lt,ct;
        
        public TransformaGeo() {
            iniciaMatrizes();
            addMouseListener(new MouseAdapter () {
                public void mousePressed(MouseEvent evt) {
                    if (evt.getButton() == MouseEvent.BUTTON1)
                    { transformaEscala();}
                    else if (evt.getButton() == MouseEvent.BUTTON2)
                    { transformaTranslada(); tx=tx+1; ty=ty+1;}
                    else if (evt.getButton() == MouseEvent.BUTTON3)
                    { transformaRotacao(); ang=ang+0.1;}
                    repaint();
                   }
            });
        }
        
        private void iniciaMatrizes() {
            poly = new Polygon();
            
            li = 3; ci =2;
            mi = new double[li][ci];
            mi[0][0] = 150; mi[0][1] = 100;
            mi[1][0] = 20; mi[1][1] = 200;
            mi[2][0] = 120; mi[2][1] = 200;
            
                    

        }
        public void transformaEscala() {
            lt = 2; ct = 2;
            mt = new double[lt][ct];
            mt[0][0] = (double) 1.5; mt[0][1] = (double) 0;
            mt[1][0] = (double) 0; mt[1][1] = (double) 1.5;
            
            mr = new double[li][ct];
            
            mr[0][0] =(mi[0][0] * mt[0][0]) + (mi[0][1] * mt[0][1]);
            mr[0][1] =(mi[0][0] * mt[0][1]) + (mi[0][1] * mt[1][1]);
            
            mr[1][0] =(mi[1][0] * mt[0][0]) + (mi[1][1] * mt[0][1]);
            mr[1][1] =(mi[1][0] * mt[0][1]) + (mi[1][1] * mt[1][1]);
            
            mr[2][0] =(mi[2][0] * mt[0][0]) + (mi[2][1] * mt[0][1]);
            mr[2][1] =(mi[2][0] * mt[0][1]) + (mi[2][1] * mt[1][1]);
            
           pushMatrix();
            
        }
        
        public void transformaTranslada() {
            mr = new double[li][ci];
            
            mr[0][0] =(mi[0][0] + tx);
            mr[0][1] =(mi[0][1] + ty);
            
            mr[1][0] =(mi[1][0] + tx);
            mr[1][1] =(mi[1][1] + ty);
            
            mr[2][0] =(mi[2][0] + tx);
            mr[2][1] =(mi[2][1] + ty);
            
            pushMatrix();
            
        }
        
        public void transformaRotacao() {
            lt = 2; ct = 2;
            mr = new double[li][ct];
            
            double cos = Math.cos(ang);
            double sen = Math.sin(ang);
            
            mr[0][0] =(mi[0][0] * cos) - (mi[0][1] * sen);
            mr[0][1] =(mi[0][0] * sen) + (mi[0][1] * cos);
            
            mr[1][0] =(mi[1][0] * cos) - (mi[1][1] * sen);
            mr[1][1] =(mi[1][0] * sen) + (mi[1][1] * cos);
            
            mr[2][0] =(mi[2][0] * cos) - (mi[2][1] * sen);
            mr[2][1] =(mi[2][0] * sen) + (mi[2][1] * cos);
            
           pushMatrix();
            
        }
        
        public void pushMatrix() {
            for(int i=0; i<li; i++)
                for(int j=0; j<ci; j++)
                    mi[i][j] = mr[i][j];
        }
        
        @Override
        public void paint (Graphics g) {
            poly = new Polygon();
            for(int i=0;i<mi.length; i++) poly.addPoint((int)mi[i][0], (int)mi[i][1]);
            g.fillPolygon(poly);
            
        }

        
    }
    
}






```



