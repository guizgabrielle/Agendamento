package Consultas;

public class Paciente extends Pessoa {
    private String endereco;
    private int id;

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void set(String temp) {
    }

    public int getID() {
        return id;
    }

    public void setId(int id) {
        this.id = id;

    }

    @Override
    public String toString() {
        String string = "ID: " + String.valueOf(this.id) + "\tNome: " + this.nome + "\tEndereço: " + this.endereco;
        return string;
    }
}
