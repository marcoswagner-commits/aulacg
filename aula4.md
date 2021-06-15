# Aula 15/06/2021 - Computação Gráfica
## Atividades da aula - roteiro

## Implementação do Algoritmo Clássico de Geração de Linhas - Todos os algoritmos


- Veja o vídeo abaixo que mostra a implementação dos algoritmos
 
[![material complementar](https://github.com/marcoswagner-commits/projetos_cg/blob/0c0c8bd24a072a2cc511e78a6089101c524e4610/Capa_Videos_Youtube-aula4.png)](https://www.youtube.com/watch?v=dn13HmKxUjc)


:shipit: Código 1
```
public class Desenha extends JFrame {

    public Desenha() {
        
        this.setTitle("Algoritmo de Geração de Linhas - Todos");
        this.setSize(300,300);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    @Override
    public void paint(Graphics g) {
//       g.setColor(Color.red);
//        algAnalitic(g,50,50,150,150); //45º
//        algAnalitic(g,50,50,150,50); // 0º
//        algAnalitic(g,50,50,50,150); //90º
//        algAnalitic(g,50,50,150,100); //67,5º
//        algAnalitic(g,50,50,100,150); //112,5º
//       
       g.setColor(Color.red);
        algDDA(g,150,50,50,150); //45º
        ///algDDA(g,51,51,151,51); // 0º
        //algDDA(g,51,51,51,151); //90º
        //algDDA(g,51,51,151,101); //67,5º
        //algDDA(g,51,51,101,151); //112,5º
       
//       g.setColor(Color.blue);
//        algBres(g,52,52,152,152); //45º
//        algBres(g,52,52,152,52); // 0º
//        algBres(g,52,52,52,152); //90º
//        algBres(g,52,52,152,102); //67,5º
//        algBres(g,52,52,102,152); //112,5º
    }
    
     public void algAnalitic(Graphics g, int x1, int y1,int x2,int y2) {
        float m, b, dy, dx;
        dy = y2 - y1;
        dx = x2 - x1;
                
        m = (float) dy / dx;
        System.out.println(m);
        
        b = (float) (y1 - m * x1);
        System.out.println(b);
        
        for (int x = x1; x<=x2; x++) {
            int y = (int) (m * x + b);
            System.out.println(y);
            putPixel(g,x,y);
        }
    }
        private void algDDA(Graphics g, int xi, int yi, int xf, int yf) {
        
        int steps;
        float x=xi, y=yi, incX, incY;
            System.out.println("xi: "+x+"- yi: "+ y);
        
        int dx = xf - xi;
        int dy = yf - yi;
        
        if(Math.abs(dx)>Math.abs(dy)) {
            steps = Math.abs(dx); incX = 1; incY= (float) dy /dx; 
            if (dx < 0) incX = -1;
        }
        else  if(Math.abs(dx)<Math.abs(dy)){
            steps = Math.abs(dy); incY = 1; incX= (float) dx /dy; 
            if (dy < 0) incY = -1;  
        } else {
            steps = Math.abs(dy); incY = 1; incX= 1; 
            if (dy < 0) incY = -1;  
            if (dx < 0) incX = -1;  
        }
               
        System.out.println(steps + "/" + dx + "/" + dy+ "/" + incX + "/" + incY );
    
        for(int i=0; i<steps; i++) {
            x = x + incX;
            y = y + incY;
            putPixel(g,Math.round(x),Math.round(y)); 
            System.out.println("xi: "+x+"- yi: "+ y);
        }
            
        
    }
        
    private void algBres(Graphics g, int xi, int yi, int xf, int yf) {
        
       int x = xi, y = yi, d=0, dx = xf-xi, dy = yf-yi, c, m, incX=1, incY=1;
       
       if(dx < 0) {incX = -1; dx = -dx;}
       if(dy < 0) {incY = -1; dy = -dy;}
        System.out.println(dx+"-"+dy+"-"+incX+"-"+incY);
       
       if(dy <= dx) {
           c = 2 * dx; m = 2 * dy;
           System.out.println(c+"-"+m);
           if(incX < 0) dx++;
           for(;;) {
               putPixel(g,x,y);
               if (x == xf) break;
               x += incX;
               d += m;
               if(d >= dx) {y += incY; d -= c;}
               System.out.println(x+"-"+y);
           }
       } else {
           c = 2 * dy; m = 2 * dx;
           System.out.println(c+"-"+m);
           if(incY < 0) dy++;
           for(;;) {
               putPixel(g,x,y);
               if (y == yf) break;
               y += incY;
               d += m;
               if(d >= dy) {x += incX; d -= c;}
               System.out.println(x+"-"+y);
       }
       
    }
    }
    
    
    public void putPixel(Graphics g, int x, int y) {
        g.drawLine(x,y,x,y);
    }
}
```
