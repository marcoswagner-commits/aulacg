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
- [x] Colocando texturas
 - Colocar textura para o jogador
 - Colocar textura para o chão
- [x] Criando outros itens
  - Criar um objeto com o nome item (cube)
  - Definir material para o objeto
  - Criando animação via script para os itens
  - Usando o deltaTime para controlar a animação
  - Criando um efeito para o item
- [x] Prefab 
   - Criando uma pasta Prefabs
   - Duplicando os itens
   - Tirando a colisão dos itens (Is Trigger)
   - Habilitando gatilho para os itens
- [x] Colisão
  - Criar método onTriggerEnter para colisão do jogador com os itens
- [x] Objeto via tag
  - Identificando o objeto via tag
  - Criando uma nova tag
  - Comparando uma tag encontrada ("CompareTag")
- [x] Criando um efeito para o jogador (Trail Renderer)


  🎬
[![material complementar](https://github.com/marcoswagner-commits/projetos_cg/blob/aa3f6a6ace359cfac3b5b9f9758fb9c642fe950b/Capa_Aula_Unity3D.png)](https://www.youtube.com/watch?v=nWZuEtOQCg4)
 
#### Script Jogador
 ```
using System.Globalization;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Jogador : MonoBehaviour
{
    Rigidbody rg;

    public float velocidade;

    public GameObject Item_Particula;
     
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

    private void OnTriggerEnter(Collider other) {
      if (other.gameObject.CompareTag("item")) {
        Instantiate(Item_Particula, other.gameObject.transform.position, Quaternion.identity);
        Destroy(other.gameObject);
      }
    }
}

 
 ``` 
 
 #### Script GiraItem
 ```
using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class GiraItem : MonoBehaviour
{
    // Update is called once per frame
    void Update()
    {
        transform.Rotate(new Vector3(15,30,45) * Time.deltaTime);
    }
}

 
 ``` 
 
 
### Passo 6: Interface com o Usuário (UI)
- [x] Interface de usuário
  - Criar três textos (Total de Itens - Itens Coletados - Fase Completa)
 - [x] Nível Controller
  - Criar um gameObject NivelController
  - Criar um script NivelController
  - Atualizando os textos
- [x] Singleton
  - Usando padrão de instância única para acessar o NivelController
 
🎬
[![material complementar](https://github.com/marcoswagner-commits/projetos_cg/blob/aa3f6a6ace359cfac3b5b9f9758fb9c642fe950b/Capa_Aula_Unity3D.png)](https://www.youtube.com/watch?v=nW48-mLMByw)
 
#### Script Jogador
 ```

using System.Runtime.InteropServices;
using System.Globalization;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Jogador : MonoBehaviour
{
    Rigidbody rg;
    public float velocidade;
    public GameObject Item_Particula;
    
      
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

    private void OnTriggerEnter(Collider other) {
      if (other.gameObject.CompareTag("item")) {
        Instantiate(Item_Particula, other.gameObject.transform.position, Quaternion.identity);
        Destroy(other.gameObject);
        NivelController.instance.SetItensColetados();
      }
    }
}

 
 ``` 
 
 #### Script NivelController
 ```

using System.Diagnostics;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class NivelController : MonoBehaviour
{
    public static NivelController instance;

    public int totalitens;

    public Text textoPontos;
    public Text textoTotal;
    public GameObject textoFinal;

    private int itenscoletados;

   void Awake()
    {
      instance = this;
        
    }
   // Start is called before the first frame update
    void Start()
    {
        textoFinal.SetActive(false);
        textoPontos.text = "Itens Coletados: 0" + itenscoletados;
    }

    public void SetItensColetados() 
    {
      itenscoletados++;

      textoPontos.text = "Itens Coletados: 0" + itenscoletados.ToString();

      if (itenscoletados >= totalitens) {textoFinal.SetActive(true);}
      
      
    }

    // Update is called once per frame
    void Update()
    {
        
    }
}
 
 
 ``` 
 
### Passo 7: Animação
- [x] Import de Assets
  - https://assetstore.unity.com
  - Importar via Package Manager (Jammo_LowPoly)
- [x] Configuração de Animações
  - Associar Animator_Controller_Jamo ao Personagem
  - Abrir Animator (Window - Animation - Animator)
  - Colocar as animações Idle, Running, Victory Idle
  - Excluir outras animações
  - Criar transição entre Idle e Running (ida e volta) - Make Transition
  - Criar parâmetro "run" e aplicar nas condições das transições
  - Desmarcar opção Has Exit Time
- [x] Animação via script
  - Transformar o personagem em Jogador
  - Adicionar script Jogador - componente Rigidbody - componente Capsule Collider (ajustar...)
  - Adequar o código do jogador para movimento (parado e correndo)
  - Adequar orientação do jogador (usar Quaternion.LookRotation)

  🎬
[![material complementar](https://github.com/marcoswagner-commits/projetos_cg/blob/aa3f6a6ace359cfac3b5b9f9758fb9c642fe950b/Capa_Aula_Unity3D.png)](https://www.youtube.com/watch?v=dHwMjHzQ7n8)
 
 #### Script Jogador
 ```
using System.Runtime.InteropServices;
using System.Globalization;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Jogador : MonoBehaviour
{
    Rigidbody rg;
    Animator animator;
    public float velocidade;
    public GameObject Item_Particula;
    
      
    // Start is called before the first frame update
    void Start()
    {
       rg = GetComponent<Rigidbody>();
       animator = GetComponent<Animator>();
       
    }

     // Update is called once per frame
    void Update()
    {
        
    }

    private void FixedUpdate() 
    {
      float horizontal = Input.GetAxis("Horizontal");
      float vertical = Input.GetAxis("Vertical");

      if (horizontal  != 0 || vertical != 0) 
      {
          animator.SetBool("run", true);
      }
      else
      {
          animator.SetBool("run", false);
      }

      Vector3 movimento =  new Vector3(horizontal,0,vertical);

      if (movimento != Vector3.zero)
        transform.rotation = Quaternion.LookRotation(movimento);

      rg.AddForce( movimento * velocidade);
    }

    private void OnTriggerEnter(Collider other) {
      if (other.gameObject.CompareTag("item")) {
        Instantiate(Item_Particula, other.gameObject.transform.position, Quaternion.identity);
        Destroy(other.gameObject);
        NivelController.instance.SetItensColetados();
      }
    }
}


 ``` 

 
### Passo 8: Iluminação
- [x] Importando um "inimigo"
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

