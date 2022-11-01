package Controler;

import Model.DAO;
import Model.Funcionario;
import Vieww.Menu;
import Vieww.Cadastro;
import Vieww.ExibirCadastro;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Controller {

    private Menu menu;
    private Cadastro cadastro;
    private ExibirCadastro tabela;
    private DAO dao = new DAO();
    
    public Controller(Menu menu, Cadastro cadastro, ExibirCadastro tabela) {
        this.menu = menu;
        this.cadastro = cadastro;
        this.tabela = tabela;
    }
    
    public void initController() {
        menu.setVisible(true);
        menu.getjButtonCADASTRO().addActionListener(e -> exibirTelaCadastro());
        cadastro.getjButtonMENU().addActionListener(e -> exibirTelamenu());
        cadastro.getjButtonSalvar().addActionListener(e -> salvarFuncionario());
        cadastro.getjButtonExibirTabela().addActionListener(e -> exibirTabela());
        tabela.getjButtonExibir().addActionListener(e -> printTabela());
        tabela.getjButtonCadastro().addActionListener(e -> exibirTelaCadastro1());
        
    }

    private void printTabela() {
        DefaultTableModel model = ((DefaultTableModel) tabela.getjTableExibir().getModel());
        ArrayList<Funcionario> ListaDeFuncionarios = dao.listaFuncionarios();
        
        model.setRowCount(0);
        for (int i = 0; i < ListaDeFuncionarios.size(); i++) {
            model.addRow(new String[]{ListaDeFuncionarios.get(i).getId() + "", ListaDeFuncionarios.get(i).getNome(), ListaDeFuncionarios.get(i).getEmail(), ListaDeFuncionarios.get(i).getCargo()});
            
        }
    }

    private void exibirTabela() {
        tabela.setVisible(true);
        cadastro.setVisible(false);
    }

    private void salvarFuncionario() {
        System.out.println(cadastro.getjTextName().getText());
        System.out.println(cadastro.getjTextFieldEmail().getText());
        System.out.println(cadastro.getjTextFieldCargo().getText());
        
        dao.inserirFuncionario(new Funcionario(0, cadastro.getjTextName().getText(),
                cadastro.getjTextFieldEmail().getText(), cadastro.getjTextFieldCargo().getText()));
    }

    private void exibirTelamenu() {
        menu.setVisible(true);
        cadastro.setVisible(false);
    }

    private void exibirTelaCadastro() {
        cadastro.setVisible(true);
        menu.setVisible(false);
    }

    private void exibirTelaCadastro1() {
        cadastro.setVisible(true);
        tabela.setVisible(false);
    }
    
}
