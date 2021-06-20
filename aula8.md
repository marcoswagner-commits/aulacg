
## Aula 08 - Computação Gráfica

> Aula 29/06/2021 - Computação Gráfica
> Atividades da aula - roteiro

## Implementação do Algoritmo Clássico de Preenchimento de Áreas - Comparação de Algoritmos

- Veja o vídeo abaixo que mostra a implementação dos algoritmos
 
🎬
[![material complementar](https://github.com/marcoswagner-commits/projetos_cg/blob/9a7a875a273c69f03b6048ea2138b963fd82fa7b/Capa_Aula8.png)](https://www.youtube.com/watch?v=z1UYtwvp6pE)

🎬
[![material complementar](https://github.com/marcoswagner-commits/projetos_cg/blob/9a7a875a273c69f03b6048ea2138b963fd82fa7b/Capa_Aula8.png)](https://www.youtube.com/watch?v=f86Fw8OHDHk)

🎬
[![material complementar](https://github.com/marcoswagner-commits/projetos_cg/blob/9a7a875a273c69f03b6048ea2138b963fd82fa7b/Capa_Aula8.png)](https://www.youtube.com/watch?v=4yU00lWkhtU)


![Captura de Tela 2021-06-20 às 15 53 11](https://user-images.githubusercontent.com/81576640/122685078-bb95c900-d1df-11eb-863c-d8cb6b5b8107.png)


:shipit: Código 1
```

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algpreetodos;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author marcos_wagner
 */
public class Janela extends JFrame{

    private  JPanel p1, p2, p3, p4;
    private JLabel l1, l2, l3, l4;
    
    public Janela() {
        
        setLayout(new GridLayout(2,2));
        l1 = new JLabel("Alg. Nativo");
        l2 = new JLabel("Alg. Varredura");
        l3 = new JLabel("Alg. Boundery-Fill");
        l4 = new JLabel("Alg. Análise Geométrica");
        p1 = new JPanel(); p2 = new JPanel();
        p3 = new JPanel(); p4 = new JPanel();
        
        p1.setLayout(new BorderLayout());
        p2.setLayout(new BorderLayout());
        p3.setLayout(new BorderLayout());
        p4.setLayout(new BorderLayout());
        
        p1.add(l1,BorderLayout.NORTH);
        p2.add(l2,BorderLayout.NORTH);
        p3.add(l3,BorderLayout.NORTH);
        p4.add(l4,BorderLayout.NORTH);
        
        p1.add(new Desenha1());
        p2.add(new Desenha2());
        p3.add(new Desenha3());
        p4.add(new Desenha4());
        
        add(p1); add(p2); add(p3); add(p4);
        
        
        
        setTitle("Algorimto de Preenchimento de Áreas - Comparação");
        setSize(520,520);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    
}


```

:shipit: Código 2
```

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algpreetodos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import javax.swing.JComponent;

/**
 *
 * @author marcos_wagner
 */
public class Desenha1 extends JComponent {

    private int px1=50, px2=250, px3=210, px4=200,
                    py1=50, py2=50, py3=200, py4=200;  
    
    private Polygon p;
   
    public Desenha1() {
        p = new Polygon();
        
        p.addPoint(px1, py1);
        p.addPoint(px2, py2);
        p.addPoint(px3, py3);
        p.addPoint(px4, py4);
    }
    
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.red);
        
        g.fillPolygon(p);
        g.setColor(Color.blue);
        g.drawPolygon(p);
        
    }
    
}


```

:shipit: Código 3
```
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algpreetodos;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

/**
 *
 * @author marcos_wagner
 */
public class Desenha2 extends JComponent {

    private int pixels[][];
    private int px1=50, px2=250, px3=210, px4=200,
                    py1=50, py2=50, py3=200, py4=200;  
        
    public Desenha2() {
        pixels = new int[300][300];
    }
    
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.red);
        poligono(g);
        g.setColor(Color.blue);
        preVarred(g,50,50,250,200);
        g.setColor(Color.red);
        poligono(g);
    }
    
    public void putPixel(Graphics g, int x, int y) {
        g.drawLine(x,y,x,y);
        pixels[x-1][y-1] = 1;
    }
    
    public int getPixel(Graphics g, int x, int y) {
        return pixels[x-1][y-1];
    }

    private void poligono(Graphics g) {
        algBres(g,px1,py1,px2,py2);
        algBres(g,px2,py2,px3,py3);
        algBres(g,px3,py3,px4,py4);
        algBres(g,px4,py4,px1,py1);
       
        
    }

    private void preVarred(Graphics g, int xmin, int ymin, int xmax, int ymax) {
        boolean liga;
        
        for (int y=ymin-1; y<=ymax+1; y++) {
            liga = false;
            for(int x=xmin-1; x<=xmax+1; x++) {
               if (liga) putPixel(g,x,y); 
               
               if((getPixel(g,x+1,y)>0)&(getPixel(g,x+2,y)<1)) liga = !liga;
            }
         }
           
        
    }

    private void algBres(Graphics g, int xi, int yi, int xf, int yf) {
        
        int xerr = 0, yerr = 0, dx, dy, incX, incY, dist;
        
        dx = xf - xi;
        dy = yf - yi;
        
        if (dx > 0) incX = 1;
        else if (dx==0) incX = 0;
        else incX = -1;
        
        if (dy > 0) incY = 1;
        else if (dy==0) incY = 0;
        else incY = -1;
        
        dx = Math.abs(dx);
        dy = Math.abs(dy);
        
        if (dx > dy) dist = dx;
        else dist = dy;
        
        
        for (int k=0; k<=dist; k++) {
            putPixel(g,xi,yi);
            xerr = xerr + dx; 
            yerr = yerr + dy; 
            
            if(xerr>dist) {xerr = xerr - dist; xi = xi + incX;}
            if(yerr>dist) {yerr = yerr - dist; yi = yi + incY;}
        }
        
    }
    
    
    
}

```

:shipit: Código 4

```
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algpreetodos;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

/**
 *
 * @author marcos_wagner
 */
public class Desenha3 extends JComponent {

   private int px1=25, px2=125, px3=110, px4=100,
                    py1=25, py2=25, py3=100, py4=100; 
   private int pixels[][];
    
    public Desenha3() {
        pixels = new int[300][300];
    }
    
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.red);
        poligono(g);
        g.setColor(Color.blue);
        
        preBF(g,75,60);
        
        
    }
    
     public void poligono(Graphics g) {
        algBres(g,px1,py1,px2,py2);
        algBres(g,px2,py2,px3,py3);
        algBres(g,px3,py3,px4,py4);
        algBres(g,px4,py4,px1,py1);
    }
    
     public void preBF(Graphics g, int x, int y) {
         if (getPixel(g,x,y)== 0) {
             putPixel(g,x,y);
             
             preBF(g,x+1,y);
             preBF(g,x-1,y);
             preBF(g,x,y+1);
             preBF(g,x,y-1);
             
         }
     }
    
    public void putPixel(Graphics g, int x, int y) {
        g.drawLine(x, y, x, y);
        pixels[x-1][y-1] = 1;
    }
    
    public int getPixel(Graphics g, int x, int y) {
         return pixels[x-1][y-1];
    }
    
    public void algBres(Graphics g, int xi, int yi, int xf, int yf) {
        int t, dist;
        int xerr=0, yerr=0, dx, dy;
        int incX, incY;
        
        dx = xf - xi ;
        dy = yf - yi; 
        
        if (dx > 0) incX = 1;
        else if(dx==0) incX = 0;
        else incX = -1;
        
         if (dy > 0) incY = 1;
         else if(dy==0) incY = 0;
        else incY = -1;
         
         dx = Math.abs(dx);
         dy = Math.abs(dy);
         
         if (dx > dy) dist = dx;
         else dist = dy;
         
         for (int k=0; k<=dist; k++) {
             putPixel(g,xi,yi);
             xerr = xerr + dx;
             yerr = yerr + dy;
             
             if(xerr>dist) {xerr = xerr - dist; xi = xi + incX;}
             if(yerr>dist) {yerr = yerr - dist; yi = yi + incY;}
         }
        
    }
    
}
```

:shipit: Código 5

```

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algpreetodos;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

/**
 *
 * @author marcos_wagner
 */
public class Desenha4 extends JComponent {
    
    private Lados lados[];
    private Vx vx[];
    
    int px1=50, px2=250, px3=210, px4=200,
         py1=50, py2=50, py3=200, py4=200;  
        
    public Desenha4() {
        lados = new Lados[4];
        vx = new Vx[312];
        for(int i=0;i<312;i++) vx[i] = new Vx();
    }
    
    @Override
    public void paint(Graphics g) {
        
        
        criaLados();
        g.setColor(Color.blue);
        preAGeo(g);
        
        g.setColor(Color.red);
        algBres(g,px1,py1,px2,py2);
        algBres(g,px2,py2,px3,py3);
        algBres(g,px3,py3,px4,py4);
        algBres(g,px4,py4,px1,py1);
    }
        
    public void algBres(Graphics g, int xi, int yi, int xf, int yf) {
        int t, dist;
        int xerr=0, yerr=0, dx, dy;
        int incX, incY;
        
        dx = xf - xi ;
        dy = yf - yi; 
        
        if (dx > 0) incX = 1;
        else if(dx==0) incX = 0;
        else incX = -1;
        
         if (dy > 0) incY = 1;
         else if(dy==0) incY = 0;
        else incY = -1;
         
         dx = Math.abs(dx);
         dy = Math.abs(dy);
         
         if (dx > dy) dist = dx;
         else dist = dy;
         
         for (int k=0; k<=dist; k++) {
             putPixel(g,xi,yi);
             xerr = xerr + dx;
             yerr = yerr + dy;
             
             if(xerr>dist) {xerr = xerr - dist; xi = xi + incX;}
             if(yerr>dist) {yerr = yerr - dist; yi = yi + incY;}
         }
        
    }
    
    public void putPixel(Graphics g, int x, int y) {
        g.drawLine(x, y, x, y);
    }

    private void criaLados() {
        
        int px1=50, px2=250, px3=210, px4=200,
         py1=50, py2=50, py3=200, py4=200; 
        /// pontos
        // px1=50, px2=250, px3=210, px4=200, px1=50
        // py1=49, py2=050, py3=200, py4=200,  py1=49
        // lados[?] = new Lados(ymin, ymx, xymin, 1/m)
        lados[0] = new Lados(1,50,50,50,0);
        lados[1] = new Lados(2,50,200,250,-0.2666);
        lados[2] = new Lados(3,200,200,210,0);
        lados[3] = new Lados(4,50,200,50,1);
    }

    private void preAGeo(Graphics g) {
      
        int x;
        for(int i=0;i<4;i++) {
            for(int yvar=lados[i].ymin; yvar<=lados[i].ymax; yvar++) {
               x = (int) (lados[i].um_s_m * (yvar - lados[i].ymin) + lados[i].xymin);
               if(vx[yvar].x1== -1) vx[yvar].x1 = x;
               else vx[yvar].x2= x;
            }
         }
        ordernaVx();
        imprimeVx(g);
        
    }

    private void ordernaVx() {
        for (int y=0; y<312; y++)
        {
            int aux =vx[y].x1;
            if(vx[y].x1 > vx[y].x2) {
                vx[y].x1 =vx[y].x2;
                vx[y].x2 = aux;
            }
        }
        
    }

    private void imprimeVx(Graphics g) {
        for (int y=0; y<312; y++) {
            if(vx[y].x1 != -1) {
                  algBres(g,vx[y].x1,y,vx[y].x2,y);
            }
        }
        
    }

    public class Lados {
        
        int lado;
        int ymin;
        int ymax;
        int xymin;
        double um_s_m;

        public Lados() {
            this(0,0,0,0,0.0);
        }

        public Lados(int lado, int ymin, int ymax, int xymin, double um_s_m) {
            this.lado = lado;
            this.ymin = ymin;
            this.ymax = ymax;
            this.xymin = xymin;
            this.um_s_m = um_s_m;
        }
        
        
    }

    public class Vx {
        
        int x1;
        int x2;

        public Vx() {
            this.x1 = -1;
            this.x2 = -1;
        }
    }
    
}

```

