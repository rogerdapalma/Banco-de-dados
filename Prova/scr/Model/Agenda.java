package Model;

public class Agenda {

    private int id;
    private Funcionario funcionario;
    private String Local_;
    private String Data_dia;
    private String Hora;
    private String Tipo;

    public Agenda(int id, Funcionario funcionario, String Local_, String Data_dia, String Hora, String Tipo) {
        this.id = id;
        this.funcionario = funcionario;
        this.Local_ = Local_;
        this.Data_dia = Data_dia;
        this.Hora = Hora;
        this.Tipo = Tipo;
    }

    public int getId() {
        return id;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public String getLocal_() {
        return Local_;
    }

    public String getData_dia() {
        return Data_dia;
    }

    public String getHora() {
        return Hora;
    }

    public String getTipo() {
        return Tipo;
    }
}
