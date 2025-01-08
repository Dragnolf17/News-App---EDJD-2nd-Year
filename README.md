# War Card Game

#### Francisco Ribeiro - 27942 EDJD

------------------------------------

## Estrutura do Projeto

Para este projeto, decidi dividir a aplicação em diferentes etapas, separando cada etapa por um ficheiro onde iria escrever todo código
relacionado com cada parte da aplicação.
Comecei primeiro com a programação do jogo em si, as suas regras, casos de empates, os turnos e o end game. Senti que seria melhor
começar deste jeito e depois programar tudo em volta do jogo em si. No entanto, antes de programar o resto, tratei das funcionalidades da Firebase, mais o processo de login, assim como a deteção dos jogadores.

Assim que fiz estes dois pilares da aplicação, todo o resto foi escrito e criado em torno destes dois. As funcionalidades de criação de
jogos e de convite a estas salas passaram a ser o próximo passo para esta aplicação. Usando as funcionalidades do Firebase, consegui
implementar, de uma forma simples, multiplayer para dois jogadores.

A etapa final para este projeto focou-se mais no jogo em si outra vez, tratando de tudo de forma que cada jogador conseguisse ver o
mesmo jogo, assim como terem os baralhos separados da mesma forma nos dois lados. Foi aqui que modifiquei o endgame de forma que a sala
fechasse assim que ambos os jogadores terminassem o jogo. No entanto, houve problemas nesta etapa, os quais explicarei melhor no
capítulo das dificuldades.

## Lista de Funcionalidades da Aplicação

A aplicação é um jogo feito para duas pessoas baseado num jogo de cartas designado por “War”. Não entrarei muito em detalhe sobre o
jogo em si, mas para a sua funcionalidade:

- O jogo permite que cada jogador jogue quando for a sua vez.
- Em caso de empate, ambos os jogadores devem pressionar para ver quem ganha o empate.
- As cartas usadas em cada rodada são descartadas de um baralho e adicionadas a outro, tanto em rodadas normais como em empates.
- Quando o jogo termina, ambos os jogadores devem pressionar para sair. Quando isso acontece, a sala é apagada do Firebase para
  evitar sobrecarga com salas vazias.

Além do jogo em si, há outras funcionalidades:

- **Ecrã de Login**:
    - Permite que o jogador insira suas credenciais (email e password).
    - Verifica se os dados submetidos correspondem a uma conta existente.
    - Caso a conta exista, o jogador é redirecionado para o Main Menu.

- **Main Menu**:
    - O jogador pode decidir se quer criar uma sala ou juntar-se a uma já existente.

- **Criação de Sala**:
    - O jogador pressiona um botão e é levado para uma sala de espera.
    - Na sala de espera, é gerado um código único para a sala, que pode ser compartilhado com o oponente.
    - Este código corresponde à sala criada no Firebase. Quando o oponente insere o código, ele é direcionado à sala correspondente.

- **Início do Jogo**:
    - Assim que o Firebase deteta dois jogadores na sala, o ecrã de espera desaparece, e o jogo é iniciado para ambos os jogadores.

## Desenhos, Esquemas e Protótipos da Aplicação

Separação de cada peça da aplicação para cada etapa da criação:

![Ficheiros](C:\AndroidProjects\WarCardGame\Ficheiros.png)

1. **1ª Etapa**: Game e Classes
2. **2ª Etapa**: Login
3. **3ª Etapa**: Main Menu e Repositories
4. **4ª Etapa**: Junção e melhoramento do Main Menu e Game

---

#### Login

![Login](C:\AndroidProjects\WarCardGame\Fotos\Login.png)

Descrição: Diagrama mostrando como o sistema de login valida as credenciais do jogador e o redireciona para o Main Menu.

---

#### Main Menu e Sala de Espera

| ![Main Menu](C:\AndroidProjects\WarCardGame\Fotos\MainMenu.png) | ![Sala de Espera](C:\AndroidProjects\WarCardGame\Fotos\SalaDeEspera.png) |

Descrição: Protótipo representando o layout do Main Menu e a funcionalidade de criação de sala com código único.

---

#### Game (Quando Ambos os Jogadores Estão Dentro da Sala)

![Game](C:\AndroidProjects\WarCardGame\Fotos\Game.png)

Descrição: Esquema visual de como o jogo funciona quando ambos os jogadores estão dentro da sala, com destaque para as interações
entre as cartas e os baralhos.
