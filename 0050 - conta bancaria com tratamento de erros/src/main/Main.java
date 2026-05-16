package src.main;
import java.util.InputMismatchException;
import java.util.Scanner;
import src.entities.Excecao;
import src.entities.Conta;

public class Main{
    public static void main(String[] args){
        /*Fazer um programa para ler os dados de uma conta bancaria e depois
        realizar um saque nesta conta bancaria, mostrando o novo saldo. 
        Um saque não pode ocorrer ou se nao houver saldo na conta, ou se
        o valor do saque for superior ao limite de saque da conta. 
        Implemente a conta bancária conforme projeto abaixo: 
        implementar try/catch interno na classe Conta*/
        Scanner sc = new Scanner(System.in);

        //número da conta
        System.out.print("Informe o número da conta: ");
        Integer numero = null;
        while (numero == null){
            try {
                numero = sc.nextInt();
                sc.nextLine();
                if (numero <= 0){
                    numero = null;
                    System.out.println("Valor inválido");
                }
            } catch (InputMismatchException e){
                sc.nextLine();
                System.out.println("Valor inválido");
                numero = null;
            }
        }

        //titular
        System.out.print("Informe o nome do titular: ");
        String titular = null;
        while (titular == null){
            try {
                titular = sc.nextLine();
            } catch (InputMismatchException e){
                System.out.println("Valor inválido");
                titular = null;
            }
        }

        //saldo inicial
        System.out.print("Informe o saldo inicial conta: ");
        Double saldoInicial = null;
        while (saldoInicial == null){
            try {
                saldoInicial = sc.nextDouble();
                sc.nextLine();
            } catch (InputMismatchException e){
                sc.nextLine();
                System.out.println("Valor inválido");
                saldoInicial = null;
            }
        }

        //limite da conta
        System.out.print("Informe o limite da conta: ");
        Double limite = null;
        while (limite == null){
            try {
                limite = sc.nextDouble();
                sc.nextLine();
                if (limite <= 0){
                    limite = null;
                    System.out.println("Valor inválido");
                }
            } catch (InputMismatchException e){
                sc.nextLine();
                System.out.println("Valor inválido");
                limite = null;
            }
        }

        //instanciar conta
        Conta conta = new Conta(numero,titular,saldoInicial,limite);

        System.out.println(conta);

        Integer opcao = null;
        do {
            System.out.println(" ** Menu **");
            System.out.println("1 - Depositar");
            System.out.println("2 - Sacar");
            System.out.println("3 - Exibir saldo");
            System.out.println("4 - Sair");
            System.out.print("Informe a opção desejada: ");
            try {
                opcao = sc.nextInt();
                sc.nextLine();
            } catch (Exception e){
                sc.nextLine();
                System.out.println("Valor inválido");
                opcao = null;
            }

            if (opcao != null){
                switch(opcao){
                    case 1:
                        Double valorDeposito = null;
                        while (valorDeposito == null){
                            try {
                                System.out.print("Informe o valor do depósito: ");
                                valorDeposito = sc.nextDouble();
                                sc.nextLine();
                            } catch (Exception e){
                                sc.nextLine();
                                System.out.println("Valor inválido ");
                                valorDeposito = null;
                            }
                        }
                        try {
                            Double novoSaldo = conta.depositar(valorDeposito);
                            System.out.printf("Depósito de %.2f realizado com sucesso. Novo sado: R$ %.2f%n",valorDeposito,novoSaldo);
                        } catch (Excecao e){
                            System.out.println(e.getMensagem());
                        }
                        break;
                    case 2:
                        Double valorSaque = null;
                        while (valorSaque == null){
                            try {
                                System.out.print("Informe o valor do saque: ");
                                valorSaque = sc.nextDouble();
                                sc.nextLine();
                            } catch (Exception e){
                                sc.nextLine();
                                System.out.println("Valor inválido ");
                                valorSaque = null;
                            }
                        }
                        try {
                            Double novoSaldo = conta.sacar(valorSaque);
                            System.out.printf("Depósito de %.2f realizado com sucesso. Novo sado: R$ %.2f%n",valorSaque,novoSaldo);
                        } catch (Excecao e){
                            System.out.println(e.getMensagem());
                        }
                        break;
                    case 3:
                        System.out.println(conta);
                        opcao = null;
                        break;
                    case 4:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida");
                }
            }

        } while ( opcao == null || opcao != 4);
        
        sc.close();
    }
}