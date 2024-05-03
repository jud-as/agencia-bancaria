package Programa;

import utilitarios.Utils;

public class Conta {

    private static int contadorDeContas = 1;
    private int numeroConta;
    private User user;
    private Double saldo = 0.0;
    private String agencia;

    public Conta(User user) {
        this.numeroConta = contadorDeContas;
        this.user = user;
        contadorDeContas += 1;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String toString(){
        return STR."\nNome: \{this.user.getNome()}\nAgência: \{this.getAgencia()}\nNúmero: \{this.getNumeroConta()}\nSaldo: \{Utils.doubleToString(this.getSaldo())}\n";
    }

    public void depositar(Double valor) {
        if (valor > 0) {
            setSaldo(getSaldo() + valor);
            System.out.println("\nDepósito realizado com sucesso.");
        }else{
            System.out.println("\nNão foi possível realizar o depósito.");
        }
    }

    public void sacar(Double valor) {
        if (valor > 0 && this.getSaldo() >= valor) {
            if (valor % 1 == 0 ) {
                setSaldo(getSaldo() - valor);
                System.out.println("\nSaque realizado com sucesso.");
            }else{
                System.out.println("Cédulas indisponíveis");
            }
        }else{
            System.out.println("\nNão foi possível realizar o saque.");
        }
    }

    public void transferir(Conta contaDeposito, Double valor) {
        if(valor > 0 && this.getSaldo() >= valor){
            setSaldo(getSaldo() - valor);

            contaDeposito.saldo = contaDeposito.getSaldo() + valor;
            System.out.println("\nTransferência realizada com sucesso.");
        }else{
            System.out.println("\nNão foi possível realizar a transferência.");
        }
    }

}
