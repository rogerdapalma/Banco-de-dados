package App;

import Controller.FuncionarioController;
import Controller.TelaController;
import Model.FuncionarioDAO;
import Model.Funcionario;
import View.CadastroFuncionario;
import View.ListarFuncionario;
import java.util.ArrayList;
import javax.swing.JFrame;

public class App {
    
    public static void main(String[] args) {
        ListarFuncionario lista = new ListarFuncionario();
        CadastroFuncionario cadastro = new CadastroFuncionario();
        FuncionarioController fc = new FuncionarioController(lista, cadastro);
        
        TelaController tc = new TelaController(cadastro, lista);
        fc.initController();
        tc.initController();
        lista.setVisible(true);
    }
}
