package Model;

public class Funcionario {
    private int id;
    private String nome;
    private String email;
    private String cargo;

    public Funcionario(int id, String nome, String email, String cargo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cargo = cargo;
    }

    public Funcionario(String nome, String email, String cargo) {
        this.nome = nome;
        this.email = email;
        this.cargo = cargo;
    }
    

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getCargo() {
        return cargo;
    }

    @Override
    public String toString() {
        return "\nID:" + id + "\nNome: " + nome + "\nEmail:" + email + 
                "\nCargo: " + cargo;
    }
}
