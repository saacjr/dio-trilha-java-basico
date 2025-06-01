package org.contaBanco;

import java.util.*;

public class ContaTerminal {
    int numero;
    String agencia;
    String nomeCliente;
    float saldo;

    static Scanner scanner = new Scanner(System.in);
    static Map<String, ContaTerminal> contas = new HashMap<>();

    public ContaTerminal(int numero, String agencia, String nomeCliente, float saldo) {
        this.numero = numero;
        this.agencia = agencia;
        this.nomeCliente = nomeCliente;
        this.saldo = saldo;
    }

    public void exibirMensagemBoasVindas() {
        System.out.printf("\nOlá %s, obrigado por criar uma conta em nosso banco, sua agência é %s, conta %d e seu saldo %.2f já está disponível para saque.\n",
                nomeCliente, agencia, numero, saldo);
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("""
  
  1 - Criar conta
  2 - Entrar na conta
  3 - Relatar erro
  4 - Sair
Insira sua opção:""");

            int opcao = lerInteiroComValidacao();
            switch (opcao) {
                case 1 -> criarConta();
                case 2 -> entrarConta();
                case 3 -> {
                    System.out.print("Relate seu erro aqui: ");
                    scanner.nextLine();
                    System.out.println("Obrigado por seu relato! :)");
                }
                case 4 -> {
                    System.out.println("Saindo...");
                    return;
                }
                default -> System.out.println("Opção inválida.");
            }
        }
    }

    static void criarConta() {
        System.out.print("Por favor, digite o número da Conta: ");
        int numero = lerInteiroComValidacao();

        System.out.print("Por favor, digite o número da Agência: ");
        String agencia = scanner.nextLine();

        System.out.print("Por favor, digite o nome do Cliente: ");
        String nome = scanner.nextLine();

        System.out.print("Por favor, digite o saldo inicial: ");
        float saldo = lerFloatComValidacao();

        ContaTerminal conta = new ContaTerminal(numero, agencia, nome, saldo);
        contas.put(numero + ":" + agencia, conta);
        conta.exibirMensagemBoasVindas();
    }

    static void entrarConta() {
        System.out.print("Digite o número da conta: ");
        int numero = lerInteiroComValidacao();
        System.out.print("Digite a agência: ");
        String agencia = scanner.nextLine();

        ContaTerminal conta = contas.get(numero + ":" + agencia);
        if (conta == null) {
            System.out.println("Conta não encontrada.");
            return;
        }

        while (true) {
            System.out.println("""
  
  1 - Sacar
  2 - Depositar
  3 - Investir
  4 - Voltar
Insira sua opção:""");

            int opcao = lerInteiroComValidacao();
            switch (opcao) {
                case 1 -> conta.sacar();
                case 2 -> conta.depositar();
                case 3 -> conta.investir();
                case 4 -> {
                    System.out.println("Voltando...");
                    return;
                }
                default -> System.out.println("Opção inválida.");
            }
        }
    }

    void sacar() {
        System.out.print("Digite o valor para saque: ");
        float saque = lerFloatComValidacao();
        if (saque <= saldo) {
            saldo -= saque;
            System.out.printf("Saque de R$ %.2f realizado com sucesso. Saldo atual: R$ %.2f\n", saque, saldo);
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    void depositar() {
        System.out.print("Digite o valor para depósito: ");
        float deposito = lerFloatComValidacao();
        saldo += deposito;
        System.out.printf("Depósito de R$ %.2f realizado. Saldo atual: R$ %.2f\n", deposito, saldo);
    }

    void investir() {
        System.out.print("Digite o valor a ser investido: ");
        float aporte = lerFloatComValidacao();
        if (aporte > saldo) {
            System.out.println("Saldo insuficiente.");
        } else {
            Random random = new Random();
            float juros = -1 + random.nextFloat() * 2;
            saldo += aporte * juros;
            if (juros < 0) {
                System.out.printf("Que pena, o investimento teve um prejuízo de %.0f%% :(%n", -juros * 100);
            } else if (juros > 0) {
                System.out.printf("Oba! O investimento teve lucro de %.0f%% ;)%n", juros * 100);
            } else {
                System.out.println("Nem quem ganhar, nem quem perder vai ganhar ou vai perder...\nO investimento não deu em nada :/");
            }
            System.out.printf("Saldo atual: R$ %.2f\n", saldo);
        }
    }

    static int lerInteiroComValidacao() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Retornando ao menu principal...\n");
            main(null);
            return -1;
        }
    }

    static float lerFloatComValidacao() {
        try {
            return Float.parseFloat(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Retornando ao menu principal...\n");
            main(null);
            return -1f;
        }
    }
}
