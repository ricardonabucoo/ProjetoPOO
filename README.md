










Estrututa de diretórios do projeto:

/ProjetoPOO
│
├── /source                # Diretório principal do código fonte
│   ├── Main.java          # Arquivo principal do jogo (entry point)
│   ├── Game.java          # Lógica principal do jogo
│   ├── /entities          # Pacote para as entidades do jogo (jogador, frutas, etc.)
│   │   ├── Elem.java
│   │   ├── StaticElem.java
│   │   ├── DynamicElem.java
│   │   └── etc
│   ├── /input             # Pacote para controle de input do usuário
│   │   └── InputHandler.java (exemplo)
│   ├── /ui                # Pacote para interface gráfica do usuário (HUD, menus, etc.)
│   │   └── Menu.java (exemplo)
│   ├── /sound             # Pacote para sons e efeitos sonoros
│   │   └── SoundManager.java (exemplo)
│   └── /graphics          # Pacote para renderização gráfica
│       └── GraphicsManager.java (exemplo)
│
├── /assets                # Recursos de mídia (imagens, sons, etc.)
│   ├── /images            # Texturas e imagens do jogo
│   └── /sounds            # Arquivos de som e trilha sonora
│
├── /lib                   # Bibliotecas externas
│   └── lwjgl.jar          # Exemplo de biblioteca (LWJGL para gráficos)
│
├── /tests                 # Testes unitários e de integração
│   └── GameTest.java
│
├── /docs                  # Documentação do projeto
│   └── README.md
│
└── /build                 # Diretório para arquivos compilados
    └── classes



