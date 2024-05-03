package Programa;

import java.util.ArrayList;
import java.util.Scanner;

public class AgenciaBancaria {
    static Scanner input = new Scanner(System.in);
    static ArrayList<Conta> contasBancarias;

    public static void main(String[] args) {
        contasBancarias = new ArrayList<>();
        operacoes();

    }
    public static void operacoes() {

        System.out.println("------------------------------");
        System.out.println("----SELECIONE UMA OPERAÇÃO----\n");
        System.out.println("|    1 - Criar conta    |");
        System.out.println("|    2 - Depositar      |");
        System.out.println("|    3 - Sacar          |");
        System.out.println("|    4 - Transferir     |");
        System.out.println("|    5 - Listar         |");
        System.out.println("|    6 - Sair           |");

        int opc = input.nextInt();
        switch(opc) {
            case 1:
                criarConta();
                break;
            case 2:
                depositar();
                break;
            case 3:
                sacar();
                break;
            case 4:
                transferir();
                break;
            case 5:
                listar();
                break;
            case 6:
                System.out.println("Encerrando programa.");
                System.exit(0);
            default:
                System.out.println("Opção inválida.");
                operacoes();
                break;
        }
    }

    public static void criarConta() {

        System.out.println("\nNome: ");
        String nome = input.next();

        User user = new User(nome);
        Conta conta = new Conta(user);
        contasBancarias.add(conta);
        System.out.println("\nConta criada com sucesso.");

        operacoes();
    }

    private static Conta encontrarConta(int numeroConta) {
        Conta conta = null;
        if(!contasBancarias.isEmpty()) {
            for(Conta c: contasBancarias) {
                if(c.getNumeroConta() == numeroConta){
                    conta = c;
                }
            }
        }
        return conta;
    }

    public static void depositar() {
        System.out.println("\nNúmero da conta: ");
        int numeroConta = input.nextInt();

        Conta conta = encontrarConta(numeroConta);
        if(conta != null) {
            System.out.println("Valor para depósito: ");
            Double valorDeposito = input.nextDouble();
            conta.depositar(valorDeposito);
        }else{
            System.out.println("Conta não encontrada.");
        }
        operacoes();
    }

    public static void sacar() {
        System.out.println("\nNúmero da conta: ");
        int numeroConta = input.nextInt();
        Conta conta = encontrarConta(numeroConta);
        if(conta != null) {
            System.out.println("Valor para saque: ");
            Double valorSaque = input.nextDouble();
            conta.sacar(valorSaque);
        }else{
            System.out.println("Conta não encontrada.");
        }
        operacoes();
    }

    public static void transferir() {

        System.out.println("\nNúmero da conta remetente: ");
        int numeroContaRemetente = input.nextInt();
        Conta contaRemetente = encontrarConta(numeroContaRemetente);
        if(contaRemetente != null) {
            System.out.println("Número da conta de destino: ");
            int numeroContaDestino = input.nextInt();
            Conta contaDestino = encontrarConta(numeroContaDestino);
            if(contaDestino != null){
                System.out.println("Valor da transferência: ");
                Double valor = input.nextDouble();
                contaRemetente.transferir(contaDestino, valor);
            }else{
                System.out.println("\nConta de destino não encontrada.");
            }
        }else{
            System.out.println("\nConta não encontrada");
        }
        operacoes();
    }

    public static void listar() {
        if(!contasBancarias.isEmpty()){
            for(Conta conta: contasBancarias){
                System.out.println(conta);
            }
        }else{
            System.out.println("Não há registro de contas.");
        }
        operacoes();
    }

}
