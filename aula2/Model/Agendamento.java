package Model;

public class Agendamento {
    private int id;
    private Funcionario funcionario;
    private String data;
    private String hora;
    private String local;
    private String tipo;

    public Agendamento(int id, Funcionario funcionario, String data, String hora, String local, String tipo) {
        this.id = id;
        this.funcionario = funcionario;
        this.data = data;
        this.hora = hora;
        this.local = local;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public String getData() {
        return data;
    }

    public String getHora() {
        return hora;
    }

    public String getLocal() {
        return local;
    }

    public String getTipo() {
        return tipo;
    }  
}
