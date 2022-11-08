package AgendamentoApp;

import Controler.Controller;
import Model.DAO;
import Model.Funcionario;
import Vieww.Menu;
import Vieww.Cadastro;
import Vieww.ExibirCadastro;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Controller c = new Controller(new Menu(), new Cadastro(), new ExibirCadastro());
        c.initController();
        DAO dao = new DAO();

        //  dao.inserirFuncionario(new Funcionario(0, "carlos", "selva@gmail", "futuro presidente"));
        // dao.inserirFuncionario(new Funcionario(0, "celso", "jozo@gmail", "ex presidente "));
        ArrayList<Funcionario> ListaDeFuncionarios = dao.listaFuncionarios();
        for (int i = 0; i < ListaDeFuncionarios.size(); i++) {
            System.out.println("id: " + ListaDeFuncionarios.get(i).getId());
            System.out.println("nome: " + ListaDeFuncionarios.get(i).getNome());
            System.out.println("email: " + ListaDeFuncionarios.get(i).getEmail());
            System.out.println("cargo: " + ListaDeFuncionarios.get(i).getCargo());
        }

    }

}
