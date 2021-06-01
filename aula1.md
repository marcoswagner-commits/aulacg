# Aula 01/06/2021 - Computação Gráfica
## Atividades da aula - roteiro

## Implementação do Algoritmo Clássico de Geração de Linhas Analítico



- Vejam os vídeos abaixo que mostram a implementação do algoritmo
- 
[![material complementar](https://github.com/marcoswagner-commits/projetos_cg/blob/772c14a7a9279b7671c6b781cb370fecc3c8ceb9/Capa_Videos_Youtube.png)](https://youtu.be/l2LYNFHsraY)
-

[![material complementar](https://github.com/marcoswagner-commits/projetos_cg/blob/ed96718e42bb50ad3cc413efcab534f8f6ad0f1a/Capa_Videos_Youtube-2.png)](https://youtu.be/NNHFp6vDD00)

:shipit: Código 1
```
public class Desenha extends JFrame {
        
    public Desenha() {
       
        this.setTitle("Linha Reta - Analítico");
        this.setSize(300,300);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
    }
    
    @Override
    public void paint(Graphics g) {
       g.setColor(Color.red);
       algAnalitic(g,10,50,60,100);
       algAnalitic(g,10,50,60,50);
       algAnalitic(g,20,50,20,100);
    }
    
    public void algAnalitic(Graphics g, int xi, int yi, int xf, int yf) {
        float m, b, dy, dx;
        dy = yf - yi;
        dx = xf - xi;
        
        m = (float) dy/dx;
        
        b = (float) (yi - m * xi);
        
        for(int x = xi; x<=xf; x++) {
            int y = (int) (m * x + b);
            putPixel(g,x,y);
        }
    }
    
    public void putPixel(Graphics g, int x, int y) {
        g.drawLine(x, y, x, y);
    }
            
    
}
```


