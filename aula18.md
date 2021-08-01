## Aula 18 - Computação Gráfica

> Aula - Computação Gráfica
> Atividades da aula - roteiro

## Engine Gráfica Unity3D

- [Conteúdo do Curso - Material sugerido](https://profsalu.files.wordpress.com/2018/08/2-unity-3d-apresentac3a7c3a3o.pdf)



### Passo 1: Introdução
- [x] Instalação [↪️](https://unity3d.com/pt/get-unity/download)
 - Instalação do UnityHub
- [x] Primeiro projeto (2D/3D)
 - AulaCG2021
- [x] Layout (telas)
 - Scene, Game, Project, Inspector, Hierarchy
- [x] Primeiros Comandos
 - GameObject 
 - Geometrias Primitiva
- alt-c1, alt-c2, alt-c3, f
- [x] Tranformações (Move, Rotate, Scale) - Gizmos e Manipulação
- [x] Materiais
 - Primeiro jogador (personagem) e primeiro plano  

🎬
[![material complementar](https://github.com/marcoswagner-commits/projetos_cg/blob/aa3f6a6ace359cfac3b5b9f9758fb9c642fe950b/Capa_Aula_Unity3D.png)](https://www.youtube.com/watch?v=lpSgS96B50k)

### Passo 2: Programação
- [x] Scripts
 - Criar uma pasta de Scripts
 - Criar um script
 - Vincular script ao componente
  - Abrir script no Visual Studio Code
  - Analisar o código
   - name_spaces; classes : MonoBehaviour; funções (Start e Update) 
- [x] Variáveis
- [x] Funções
- [x] Controle (if-else - loops)

🎬
[![material complementar](https://github.com/marcoswagner-commits/projetos_cg/blob/aa3f6a6ace359cfac3b5b9f9758fb9c642fe950b/Capa_Aula_Unity3D.png)](https://www.youtube.com/watch?v=jGbjqzE5cH8)

#### Script
 ```
using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Jogador : MonoBehaviour
public class jogador : MonoBehaviour
{
    int varA = 10;
    int varB = 15;
    // Start is called before the first frame update
    void Start()
    {
        UnityEngine.Debug.Log(Soma(varA,varB));

    if (Soma(varA, varB) > 10) UnityEngine.Debug.Log("Número maior que 10");
    else UnityEngine.Debug.Log("Número menor ou igual a 10");
    for (int i=0; i<10; i++)
        {
          UnityEngine.Debug.Log(i);
        }
        
    }

    int Soma(int a, int b) 
    {
      return (a + b);
    }

    // Update is called once per frame
    void Update()
    {
        
    }
}
 ```

### Passo 3: Movimentos
- [x] Componentes
 - Movimento (Transformação Geométrica - Position)
 - Movimento por meio da "Física"
  - Analisando o componente Rigidbody (massa - arrasto - gravidade - colisão)
- [x] Código (Script)
 - Criando um Rigidbody no código (público e privado)
  - Associar o Rigidbody pela Unity
  - Associar o Rigidbody pelo método Start (GetComponent<Rigidbody>)
  - FixedUpdate - adicionando força (x,y,z)  
  - Controlando a velocidade (inputs)
   - InputManager (GetAxis)
  - Editando inputs(Project Settings - Inputs)

🎬
[![material complementar](https://github.com/marcoswagner-commits/projetos_cg/blob/aa3f6a6ace359cfac3b5b9f9758fb9c642fe950b/Capa_Aula_Unity3D.png)](https://www.youtube.com/watch?v=i_1jef-1pgQ)
 
#### Script
 ```
using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Jogador : MonoBehaviour
{
    Rigidbody rg;

    public float velocidade;
     
    // Start is called before the first frame update
    void Start()
    {
       rg = GetComponent<Rigidbody>();
    }
    // Update is called once per frame
    void Update()
    {
       
    }

    private void FixedUpdate() 
    {
      float horizontal = Input.GetAxis("Horizontal");
      float vertical = Input.GetAxis("Vertical");
      Vector3 movimento =  new Vector3(horizontal,0,vertical);
      rg.AddForce( movimento * velocidade);
    }
}
 ```
  
### Passo 4: Câmeras
- [x] Câmera
 - Câmera seguindo o jogador
  - Câmera "filha" do Jogador
  - Câmera x Jogador - Script (CameraController)
   - Obtendo posição do jogador e atualizando a posição da câmera (LateUpdate)
- [x] Cenário
 - Criando um limite/fronteira para o plano
 - Criando cubos para limitar o cenário do jogo
 
 🎬
[![material complementar](https://github.com/marcoswagner-commits/projetos_cg/blob/aa3f6a6ace359cfac3b5b9f9758fb9c642fe950b/Capa_Aula_Unity3D.png)](https://www.youtube.com/watch?v=AXoppi02I1s)

#### Script
 ```
using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class CameraController : MonoBehaviour
{

    public Transform player;
    private Vector3 offset;
    // Start is called before the first frame update
    void Start()
    {
        offset = transform.position - player.position;
    }

    // Update is called once per frame
    void Update()
    {
              
    }

    private void LateUpdate() {
      transform.position = player.position + offset;
    }
}

 
 ``` 
 
### Passo 5: Interação
- [x] Criando outros itens
- [x] Prefab 
- [x] Colisão
- [x] Objeto via tag
- [x] Objeto via componente

### Passo 6: Interface com o Usuário (UI)
- [x] Interface de usuário
- [x] Level Controller
- [x] Singleton

### Passo 7: Animação
- [x] Import de Assets
- [x] Configuração de Animações
- [x] Animação via script

### Passo 8: Iluminação
- [x] NavMesh
- [x] Comportamentos
- [x] Iluminação

### Passo 9: Audios
- [x] Audio Source e via script
- [x] Cinemachine
- [x] Timeline

### Passo 10: Build
- [x] Layers
- [x] Controle de cena
- [x] Build do Jogo

- Veja o vídeo abaixo que mostra a implementação dos algoritmos
 





