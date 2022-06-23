## Aula 18 - Computação Gráfica

> Aula 23/06/2022 a 30/06/2022 - Computação Gráfica
> Atividades da aula - roteiro


## Engine Gráfica Unity3D
- [Conteúdo do Curso - Material sugerido](https://docs.unity3d.com/Manual/Materials.html)

### Roteiro Caçadores de Ouro
- [Roteiro Jogo Caçadores de Ouro](https://github.com/marcoswagner-commits/jogos_digitais/tree/documentos/documentos/cacadores_ouro.md)

	Este curso é uma introdução a Engine de Modelagem Gráfica “Unity3D”. Uma engine que permite a construção de ambientes virtuais 2 e 3D, e, consequentemente possibilita a construção de jogos digitais (games), sejam pequenos e simples, ou, até mesmo grandes e complexos. Serão apresentados componentes básicos e essenciais desta ferramenta, comumente usados na maioria dos projetos. Será abordado desde instalação até a versão final de um jogo (build). Será usado como estudo de caso ou exemplo de aplicação o “Roll a Ball” um tutorial disponibilizado pela própria Unity (https://play.unity.com/mg/other/roll-a-ball-game-from-tutorial) e acrescentado algumas funcionalidades. Apesar de existirem vários projetos reconstruindo este tutorial, esta abordagem prima pelo uso de uma didática simples e acessível. Este projeto será construído com ênfase nos componentes 3D da ferramenta.

	Recomenda-se este curso para interessados no desenvolvimento de jogos, e não há necessidade de já ter tido contato com a Unity. Sugere-se uma pequena preparação sobre alguns conceitos de Computação Gráfica e Programação de Computadores com uso de linguagem C#. No entanto, qualquer carência destas naturezas podem ser supridas no próprio decorrer do curso com materiais complementares.

O curso terá a seguinte estrutura:

1 - Introdução

2 - Programação

3 - Movimentos

4 - Câmeras

5 - Interação

6 - Interface com o Usuário (UI)

7 - Animação

8 - Inimigo e NavMesh

9 - Audios

10 - Build

![Captura de Tela 2022-02-07 às 14 48 51](https://user-images.githubusercontent.com/81576640/152843772-52fd5503-e118-45ae-baa9-4360e7e3c30d.png)

🎬 Apresentação do Curso

[![Vídeo de Introdução](https://github.com/marcoswagner-commits/projetos_cg/blob/aa3f6a6ace359cfac3b5b9f9758fb9c642fe950b/Capa_Aula_Unity3D.png)](https://www.youtube.com/watch?v=VFsOvShfL-M)



### Passo 1: Introdução
- [x] Instalação [↪️](https://unity3d.com/pt/get-unity/download)
 - Instalação do UnityHub
- [x] Primeiro projeto (2D/3D)
 - AulaCG2022
- [x] Layout (telas)
 - Scene, Game, Project, Inspector, Hierarchy
- [x] Primeiros Comandos
 - GameObject 
 - Geometrias Primitiva
- alt-c1, alt-c2, alt-c3, f...
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
 
### Passo 8: Inimigo e NavMesh
- [x] Importando um "inimigo"
 - https://assetstore.unity.com
  - Importar via Package Manager (Fantasy Monster - Skeleton)
  - Escolher as animações para jogo
  - Colocar o personagem na hierarquia (configurar o posicionamento e tamanho) - Tirar o Prefab - Criar um AnimatorController 
- [x] NavMesh
  - Abrir Navigation (Window - AI - Navigation)
  - Preparar o ambiente
  - Selecionar o Piso (chão) e Paredes como estáticos 
  - Na janela Navigation - Bake - Baker (área onde o inimigo irá percorrer)
  - Adicionar ao "inimigo" o component Nav Mesh Agent
- [x] Comportamentos
  - Criar um script "inimigo"
   - Criar um vector de posições (Transform[])
   - Verificar o método SetDestination
   - Criar um conjunto de pontos no cenário (Points)
- [x] Configurar jogador para comemorar vitória
- [x] Configurar inimigo para atacar

🎬
[![material complementar](https://github.com/marcoswagner-commits/projetos_cg/blob/aa3f6a6ace359cfac3b5b9f9758fb9c642fe950b/Capa_Aula_Unity3D.png)](https://www.youtube.com/watch?v=uwji4t-8IoA)

 
#### Script Jogador
 ```
using System.Runtime.InteropServices;
using System.Globalization;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Jogador : MonoBehaviour
{
   private Rigidbody rg;
   public float velocidade;
   public GameObject Item_Particula;
   private Animator an;
   private bool isDead;
   
     
   // Start is called before the first frame update
   void Start()
   {
      rg = GetComponent<Rigidbody>();
      an = GetComponent<Animator>();
      
   }

    // Update is called once per frame
   void Update()
   {
       
   }

   private void FixedUpdate() 
   {

     if (isDead) return; 

     float horizontal = Input.GetAxis("Horizontal");
     float vertical = Input.GetAxis("Vertical");

      if(horizontal != 0 || vertical != 0) 
      {
        an.SetBool("run",true);
      }
      else
      {
        an.SetBool("run",false);
      }

      Vector3 movimento =  new Vector3(horizontal,0,vertical);

      if (movimento != Vector3.zero) 
        {
          transform.rotation = Quaternion.LookRotation(movimento);
        }
 
      rg.AddForce( movimento * velocidade);
   }

   private void OnTriggerEnter(Collider other) {
     if (other.gameObject.CompareTag("Item")) {
       Instantiate(Item_Particula, other.gameObject.transform.position, Quaternion.identity);
       Destroy(other.gameObject);
       NivelController.instance.SetItensColetados();
       if (NivelController.instance.GetWin()) Win();
      }
      else if (other.gameObject.CompareTag("inimigo")) {
        Instantiate(Item_Particula, other.gameObject.transform.position, Quaternion.identity);
        Death();
      }
       
   }

   private void Death() {
     isDead = true;
     Destroy(gameObject);
   }

   private void Win() {
     
     an.SetBool("win",true);
   }
}
 ```  
 
 #### Script Inimigo
 ```
using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.AI;

public class Inimigo : MonoBehaviour
{
    public Transform[] destPoints;
    private NavMeshAgent agent;
    private Animator animator;
    private int index = 0;
    // Start is called before the first frame update
    void Start()
    {
      animator = GetComponent<Animator>();
      agent = GetComponent<NavMeshAgent>();
      agent.SetDestination(destPoints[index].position);
        
    }

    // Update is called once per frame
    void Update()
    {
        if (agent.remainingDistance < 0.5f) {
          index++;
          if (index >= destPoints.Length ) index = 0;
          agent.SetDestination(destPoints[index].position);
        }
    }

    private void OnTriggerEnter(Collider other) {
     if (other.gameObject.CompareTag("jogador")) {
       animator.SetBool("attack",true);
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
   private bool win;

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
       win=false;
   }

   public void SetItensColetados() 
   {
     itenscoletados++;

     textoPontos.text = "Itens Coletados: 0" + itenscoletados.ToString();

     if (itenscoletados >= totalitens) {textoFinal.SetActive(true); win=true;}
     
     
   }

   public bool GetWin() 
   {
     return win;
          
   }

   // Update is called once per frame
   void Update()
   {
       
   }
}
 ```  
 
### Passo 9: Audios
- [x] Audio Source 
 - Importando o audio de um pacote
 - Criar um objeto vazio
 - "Resetar" o transform
 - Colocar um componente "Audio Source"
 - Vincular o audio "ambiente" ao componente
 - Diminuir o volume
 - Marcar a opção Play on Awake
 - Marcar a opção Loop
- [x] Audio via script
  - Criar um componente no script do jogador do tipo AudioSource (GetComponent - audioSource)
  - Criar uma variável pública do tipo AudioClip para três áudios (itens coletados, vitória e morte)
  - Criar uma função para tocar o audio (PlayAudio - AuditoClip clip)
   - audioSource.clip = clip // auditoSource.Play();
  - Criar um vínculo com os métodos de vitória, morte, itens coletados
 
 🎬
[![material complementar](https://github.com/marcoswagner-commits/projetos_cg/blob/aa3f6a6ace359cfac3b5b9f9758fb9c642fe950b/Capa_Aula_Unity3D.png)](https://www.youtube.com/watch?v=UUmpPt_xg8U)

 
#### Script Jogador
```
using System.Runtime.InteropServices;
using System.Globalization;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Jogador : MonoBehaviour
{
    private Rigidbody rg;
    private Animator animator;
    private AudioSource audio;
    public float velocidade;
    public GameObject Item_Particula;
    private  bool isDead;
    public AudioClip itens, win, dead;
    
      
    // Start is called before the first frame update
    void Start()
    {
       rg = GetComponent<Rigidbody>();
       animator = GetComponent<Animator>();
       audio = GetComponent<AudioSource>();
       
    }

     // Update is called once per frame
    void Update()
    {
        
    }

    private void FixedUpdate() 
    {
      if (isDead) return; 

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
        PlayAudio(itens);
        if (NivelController.instance.GetWin()) Win();
      }
      else if (other.gameObject.CompareTag("Inimigo")) {
        Instantiate(Item_Particula, other.gameObject.transform.position, Quaternion.identity);
        Death();
      }
    }

    private void Death() {
      isDead = true;
      Destroy(gameObject);
      PlayAudio(dead);
    }

    private void Win() {
      animator.SetBool("win", true);
      PlayAudio(win);
    }

    private void PlayAudio(AudioClip clip) {
      audio.clip = clip;
      audio.Play();
    }
}

```  

### Passo 10: Build
- [x] Controle de cena
 - Criar um script SceneController
 - Criar uma função pública LoadScene(string scene)
 - Importar a classe SceneManagement
 - Criar uma função pública ReloadScene(SceneManager.GetActive Scene(). buildIndex);
 - Transformar a classe principal para Singleton
 - Chamar a classe em jogador
- [x] Build do Jogo

 
 🎬
[![material complementar](https://github.com/marcoswagner-commits/projetos_cg/blob/aa3f6a6ace359cfac3b5b9f9758fb9c642fe950b/Capa_Aula_Unity3D.png)](https://www.youtube.com/watch?v=q0mDs_V55KE)

 
#### Script Jogador
```
using System.Runtime.InteropServices;
using System.Globalization;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Jogador : MonoBehaviour
{
    private Rigidbody rg;
    private Animator animator;
    private AudioSource audioSource;
    public float velocidade;
    public GameObject Item_Particula;
    private  bool isDead;
    public AudioClip itens, win, dead;
    public  string scene;
    
      
    // Start is called before the first frame update
    void Start()
    {
       rg = GetComponent<Rigidbody>();
       animator = GetComponent<Animator>();
       audioSource = GetComponent<AudioSource>();
       
    }

     // Update is called once per frame
    void Update()
    {
        
    }

    private void FixedUpdate() 
    {
      if (isDead) return; 

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
        PlayAudio(itens);
        if (NivelController.instance.GetWin()) Win();
      }
      else if (other.gameObject.CompareTag("Inimigo")) {
        Instantiate(Item_Particula, other.gameObject.transform.position, Quaternion.identity);
        Death();
      }
    }

    private void Death() {
      isDead = true;
      PlayAudio(dead);
      this.gameObject.SetActive(false);
      Invoke("ReloadScene", 3F);
      
    }

    private void Win() {
      animator.SetBool("win", true);
      PlayAudio(win);
      Invoke("LoadScene", 3F);
    }

    private void PlayAudio(AudioClip clip) {
      audioSource.clip = clip;
      audioSource.Play();
    }

    private void RelaoadScene() {
      SceneController.instance.ReloadScene();
    }

    private void LoadScene() {
      SceneController.instance.LoadScene(scene);
    }
}


``` 
 
 
#### Script SceneController
```
using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class SceneController : MonoBehaviour
{
    public static SceneController instance;

    private void Awake() {
      instance = this;
    }

    public void LoadScene(string scene) {
      SceneManager.LoadScene(scene);
    }

    public void ReloadScene() {
      SceneManager.LoadScene(SceneManager.GetActiveScene().buildIndex);
    }
}


``` 
