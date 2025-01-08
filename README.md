# War Card Game

#### Francisco Ribeiro 27942

### Estrutura do Projeto

Para este projeto, decidi dividir a aplicação em diferentes etapas, separando cada etapa por um ficheiro onde iria escrever todo código relacionado com cada parte da aplicação.
Comecei primeiro com a programação do jogo em si, as suas regras, casos de empates, os turnos e o end game. Senti que seria melhor começar deste jeito e depois programar tudo em volta do jogo em si. No entanto, antes de programar o resto, tratei das funcionalidades da Firebase, mais o processo de login, assim como a deteção dos jogadores.

Assim que fiz estes dois pilares da aplicação, todo o resto foi escrito e criado em torno destes dois. As funcionalidades de criação de jogos e de convite a estas salas passaram a ser o próximo passo para esta aplicação. Usando as funcionalidades do Firebase, consegui implementar, de uma forma simples, multiplayer para dois jogadores.

A etapa final para este projeto focou-se mais no jogo em si outra vez, tratando de tudo de forma que cada jogador conseguisse ver o mesmo jogo, assim como terem os baralhos separados da mesma forma nos dois lados. Foi aqui que modifiquei o endgame de forma que a sala fechasse assim que ambos os jogadores terminassem o jogo. No entanto, houve problemas nesta etapa, os quais explicarei melhor no capítulo das dificuldades.

