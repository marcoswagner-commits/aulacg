## Aula 17 - Computação Gráfica

## Implementação de Algoritmo de Curvas B-Spline

- [Conteúdo do Curso](https://github.com/marcoswagner-commits/projetos_cg/blob/6ad36f5898322174ec7c05a76d1d8c4e67e97656/ApostilaCG2021_Modulo2.pdf)

![Splines_1](https://user-images.githubusercontent.com/81576640/127563586-e28c0116-c92f-4739-a13b-9f8a231b518b.gif)
![Splines_2](https://user-images.githubusercontent.com/81576640/127563599-e7575d56-6479-4e5f-8a67-64aa912eb75d.gif)


### Passo 1: Implementar o algoritmo que demonstre Curvas de B-Spline
- [x] Criar um mapeamento isotrópico com coordenas lógicas 0-10 para x e 0-10 para y
- [x] Criação de um retângulo de direcionamento dos pontos de controle
- [x] Criar quatro pontos de controle iniciais para geração da primeira curva 
- [x] Criar função (método) com base no formalismo matemático da respectiva equação de B-Splines (vide conteúdo)

![Captura de Tela 2021-07-29 às 21 19 43](https://user-images.githubusercontent.com/81576640/127581433-41dfd2b5-4b5b-4654-a6d4-8ab7ceea2053.png)
![Captura de Tela 2021-07-29 às 21 19 22](https://user-images.githubusercontent.com/81576640/127581437-cd0c1c55-f94a-4b68-90e4-6bc61ed4837b.png)



- Veja o vídeo abaixo que mostra a implementação dos algoritmos
 
🎬
[![material complementar](https://github.com/marcoswagner-commits/projetos_cg/blob/5cfc010ea574a440df9f67195aa7c4f89b2efaf9/Capa_Aula_16-17.png)](https://www.youtube.com/watch?v=g4XygEzldaI)

🎬
[![material complementar](https://github.com/marcoswagner-commits/projetos_cg/blob/5cfc010ea574a440df9f67195aa7c4f89b2efaf9/Capa_Aula_16-17.png)](https://www.youtube.com/watch?v=2xWoODrnKSk)



:shipit: Código 1
```

package algcurvaspline;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;
import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseListener;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class AlgCurvaSpline extends JFrame {
    public static void main(String[] args) { new AlgCurvaSpline();  }
    
    AlgCurvaSpline() {
         this.setTitle("Algoritmo de Curvas B-Spline");
            this.setSize(500,300);
            this.add("Center", new BSpline());
            this.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
            this.setLocationRelativeTo(null);
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            this.setVisible(true);
    }
}

    class BSpline extends Canvas {
        Vector<Ponto2D> pts = new Vector<Ponto2D>();
        int np = 0, centerX, centerY;
        float rWidth = 10.0F,  rHeight = 10.0F, pixelSize;
        boolean pronto = false;

        public BSpline() {
            addMouseListener(new MouseAdapter () {
                public void mousePressed(MouseEvent evt) {
                    float x= fx(evt.getX()), y = fy(evt.getY());
                    if(pronto) {
                        pts.removeAllElements();
                        np = 0;
                        pronto = false;
                    }
                    pts.addElement(new Ponto2D(x,y));
                    np++;
                    repaint();
                  }
            });
            
        addKeyListener(new KeyAdapter() {
         public void keyTyped(KeyEvent evt) {
            evt.getKeyChar();
             
            if (np >= 4) pronto = true;
            repaint();
         }
      });
     }
        
        void initValues() {
            Dimension d = getSize();
            int maxX = d.width - 1, maxY = d.height -1;
            pixelSize = Math.max(rWidth / maxX, rHeight / maxY);
            centerX = maxX / 2; centerY = maxY / 2;
        }
        
        public float fx(int x) { return (x - centerX) * pixelSize; }
        public float fy(int y) { return (centerY - y) * pixelSize;  }
        int iX(float x) { return Math.round(centerX + x / pixelSize); }
        int iY(float y) { return Math.round(centerY - y / pixelSize);  }
        
        void geraCurva(Graphics g, Ponto2D[] p) {
            int m = 50, n = p.length;
            float xA, yA, xB, yB, xC, yC, xD, yD;
            float a0, a1, a2, a3, b0, b1, b2, b3;
            float x = 0, y =0, x0, y0;
            boolean primeiro = true;
            for (int i = 1; i < n-2; i++) {
                xA = p[i-1].x; xB  = p[i].x; xC = p[i+1].x; xD = p[i+2].x;
                yA = p[i-1].y; yB  = p[i].y; yC = p[i+1].y; yD = p[i+2].y;
                
                a3 = (-xA + 3 * (xB - xC) + xD) / 6;
                b3 = (-yA + 3 * (yB - yC) + yD) / 6;
                
                a2 = (xA - 2 * xB + xC) / 2;
                b2 = (yA - 2 * yB + yC) / 2;
                
                a1 = (xC - xA) / 2;
                b1 = (yC - yA) / 2;
                
                a0 = (xA + 4 * xB + xC)/6;
                b0 = (yA + 4 * yB + yC)/6;
                
                for (int j=0; j<=m; j++) {
                    x0 = x;
                    y0 = y;
                    float t = (float) j / (float) m;
                    x = ((a3 * t + a2) * t + a1) * t + a0;
                    y = ((b3 * t + b2) * t + b1) * t + b0;
                    if (primeiro) primeiro = false;
                    else
                        g.drawLine(iX(x0),iY(y0),iX(x),iY(y));
                }
            }
            
            
        }
        
        @Override
        public void paint (Graphics g) {
            initValues();
            g.setColor(Color.blue);
            int left = iX(-rWidth / 2), right = iX(rWidth /2), 
                 bottom = iY(-rHeight / 2 ), top = iY(rHeight / 2);
            g.drawRect(left, top, right - left, bottom - top);
            Ponto2D[] p = new Ponto2D[np];
            pts.copyInto(p);
            if(!pronto) {
                for (int i=0; i < np; i++) {
                    g.setColor(Color.black);
                    g.drawRect(iX(p[i].x) -2, iY(p[i].y) - 2, 4, 4);
                    if (i > 0)
                        g.drawLine(iX(p[i-1].x), iY(p[i-1].y), iX(p[i].x), iY(p[i].y));
                }
            }
            if (np >= 4) { g.setColor(Color.red);geraCurva(g,p);}
        }
    }

class Ponto2D {
            float x, y;
            Ponto2D(float x, float y) {this.x= x; this.y = y;}
        }



```



