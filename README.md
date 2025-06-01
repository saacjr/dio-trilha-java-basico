# Conta Bancária no Terminal

Este é um projeto desenvolvido como parte do bootcamp **"Bradesco + DIO Java Cloud Native"**. Ele simula uma aplicação bancária simples em linha de comando, permitindo ao usuário criar contas, acessar contas existentes, realizar saques, depósitos e simular investimentos.

## Funcionalidades

* Criação de conta com entrada via terminal
* Armazenamento de contas em memória enquanto o programa estiver em execução
* Menu de navegação principal e menus internos
* Validação de entradas numéricas
* Operações disponíveis para contas existentes:

    * Saque (com verificação de saldo)
    * Depósito
    * Investimento (com retorno aleatório e mensagens informativas)
* Relato de erros simulados pelo usuário

## Tecnologias

* Java 17 ou superior (pode funcionar em versões anteriores)
* IDE como IntelliJ IDEA ou VS Code (opcional)

## Como executar

1. Clone este repositório ou copie os arquivos fonte para seu ambiente local
2. Compile o arquivo `ContaTerminal.java`
3. Execute a aplicação no terminal:

```bash
javac ContaTerminal.java
java org.contaBanco.ContaTerminal
```

## Estrutura

A lógica da aplicação está inteiramente contida na classe `ContaTerminal`. Os dados das contas são armazenados em um `HashMap` estático enquanto o programa roda, o que permite multiplas contas ativas durante a sessão.

## Sobre o Bootcamp

Este projeto foi desenvolvido como parte do bootcamp **"Bradesco - Java Cloud Native"**, promovido pela [Digital Innovation One (DIO)](https://www.dio.me/). O objetivo é colocar em prática conhecimentos básicos de Java, entrada de dados, controle de fluxo e manipulação de coleções.

## Licença

Este projeto é de uso educacional e não possui licença de uso comercial.
