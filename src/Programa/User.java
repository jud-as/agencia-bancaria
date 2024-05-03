package Programa;

public class User {

    // Atributos
    private String nome;

    public User(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String toString() {
        return STR."\nNome: \{this.getNome()}";
    }

}
