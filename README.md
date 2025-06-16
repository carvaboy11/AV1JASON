Participantes:  
Cristiano Hopfer Lima

Rgm:8838425521

Gabriel de Albuquerque Mello Martins Carvalho
rgm:42448557


Informações Gerais sobre o Projeto
Este projeto é um jogo de RPG em turnos feito em Java, todo para ser jogado no terminal. A ideia foi inspirada no jogo Slay the Spire, então ele mistura elementos de construção de baralho (deck-building), gerenciamento de energia e decisões estratégicas conforme o jogador avança pelo mapa. Você controla um herói que enfrenta inimigos em batalhas usando cartas de ataque, defesa e habilidades especiais. Cada partida envolve escolher rotas, lidar com desafios diferentes e pensar bem como usar suas cartas e recursos. O foco é no raciocínio e na estratégia, mesmo com uma interface simples e totalmente textual.
As principais funcionalidades incluem:
Sistema de combate baseado em cartas, com consumo de energia.


Progressão por mapa e encontros randômicos com monstros.


Recompensas após batalhas que impactam no desempenho futuro.


Organização modular por pacotes, visando separação de responsabilidades e reutilização de código.
Pacote application
Contém a lógica principal e o ponto de entrada do programa.
GamePlay.java: Classe central de controle do fluxo do jogo. Inicializa o herói, gerencia o mapa e coordena os combates.


 Pacote application.geradores
Responsável pela geração de conteúdo dinâmico.
GerarCartas.java: Gera instâncias de cartas de dano e defesa.


GerarMonstros.java: Gera instâncias de inimigos com comportamento variado.


 Pacote application.utility
Agrupa utilitários de apoio ao fluxo do jogo.
Combate.java: Gerencia os turnos de batalha, uso de cartas e controle de energia.


Console.java: Interface de entrada/saída via terminal.


MapaRPG.java: Representa o mapa que o herói percorre, com eventos em cada local.


Recompensa.java: Aplica as recompensas obtidas após as vitórias.


 Pacote entities
Reúne as entidades fundamentais do jogo.
Personagem.java: Classe abstrata que representa os atributos comuns a heróis e monstros.


TurnoPersonagem.java: Uma interface que  Define a lógica das ações inimigas em seu turno.


 Pacote entities.Carta
Hierarquia de cartas utilizadas em combate.
Carta.java: Superclasse abstrata para qualquer tipo de carta.


CartaDeDano.java: Representa uma carta ofensiva que causa dano ao oponente.


CartaDeDefesa.java: Representa uma carta defensiva que concede armadura.


 Pacote entities.personagens
Heroi.java: Representa o personagem controlado pelo jogador. Estende Personagem, possui deck de cartas e energia.


monstros.Monstro.java: Subclasse de Personagem que define os inimigos.


monstros.AcoesDoMonstro.java: Comporta a lógica dos ataques dos monstros.


 Pacote exceptions
SemEnergiaException.java: Exceção personalizada lançada quando o jogador tenta utilizar uma carta sem energia suficiente.


Relações Entre as Classes
Herança: Heroi e Monstro derivam de Personagem; CartaDeDano e CartaDeDefesa derivam de Carta.


Agregação: O herói agrega um baralho de cartas e seus atributos, mas pode funcionar independentemente delas.


Composição: GamePlay compõe todos os elementos essenciais do jogo, sendo seu orquestrador principal (ela é o main da aplicação).


Associação: Utilitários como Combate e Console interagem diretamente com instâncias de personagens e cartas, exercendo funções específicas de controle e exibição.
Instruções de Execução
 Pré-requisitos
JDK 17 ou superior instalado


IDE compatível com Java (IntelliJ IDEA, Eclipse, VS Code) ou terminal com javac e java


 Compilação e Execução Manual
Extraia os arquivos do projeto.


No terminal, acesse o diretório raiz onde está a pasta src/.


Compile os arquivos:(de preferência acessar o terminal pelo windows PowerShell)
Utilização do ChatGPT:O ChatGPT foi utilizado como ferramenta de apoio durante o desenvolvimento deste projeto, oferecendo suporte técnico e criativo em diferentes etapas. Contribuiu com a documentação, auxiliando na organização e redação formal das informações técnicas. Também ajudou na geração inicial de objetos de instância, como cartas, monstros e mapas, servindo de base para a construção da lógica do jogo. No aspecto funcional, ajudou a estruturar a lógica básica de combate, controle de energia, turnos e aplicação de efeitos. Além disso, forneceu orientações para implementar a geração de um relatório .txt. Sua utilização permitiu agilizar o desenvolvimento e garantir maior clareza na estruturação do código e das funcionalidades.
Referências e Recursos
Slay the Spire — MegaCrit Games

