# Aula 03 - Computação Gráfica 

## Implementação do Algoritmo Clássico de Geração de Linhas - Método de Bresenham


- Veja o vídeo abaixo que mostra a implementação do algoritmo
 
[![material complementar](https://github.com/marcoswagner-commits/projetos_cg/blob/32af429f87070ccb22bcc95cce90002801565898/Capa_Aula3.png)](https://www.youtube.com/watch?v=C719hAhvCDw)


- Obs.: O código abaixo possui uma correção que não está presente no vídeo (em duas seções do código onde está =+ deveria ser +=)!

:shipit: Código 1
```
public class Desenha extends JFrame {

    public Desenha() {
        
        this.setTitle("Algoritmo de Bresenham - Geração de Retas");
        this.setSize(300,300);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.red);
        algBres(g,10,40,60,90);
        algBres(g,10,40,50,100);
        algBres(g,10,40,80,40);
        algBres(g,10,40,10,90);
    }
       

    private void algBres(Graphics g, int xi, int yi, int xf, int yf) {
        
       int x = xi, y = yi, d=0, dx = xf-xi, dy = yf-yi, c, m, incX=1, incY=1;
       
       if(dx < 0) {incX = -1; dx = -dx;}
       if(dy < 0) {incY = -1; dy = -dy;}
       
       
       if(dy <= dx) {
           c = 2 * dx; m = 2 * dy;
           if(incX < 0) dx++;
           for(;;) {
               putPixel(g,x,y);
               if (x == xf) break;
               x += incX;
               d += m;
               if(d >= dx) {y += incY; d -= c;}

           }
       } else {
           c = 2 * dy; m = 2 * dx;
           if(incY < 0) dy++;
           for(;;) {
               putPixel(g,x,y);
               if (y == yf) break;
               y += incY;
               d += m;
               if(d >= dy) {x += incX; d -= c;}

       }
       
    }
    }
    
    
     public void putPixel(Graphics g, int x, int y) {
        g.drawLine(x, y, x, y);
        
    }
}
```
