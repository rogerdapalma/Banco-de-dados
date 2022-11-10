package Controller;

import Model.Funcionario;
import Model.FuncionarioDAO;
import View.CadastroFuncionario;
import View.ListarFuncionario;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FuncionarioController {

    private ListarFuncionario lista;
    private FuncionarioDAO dao = new FuncionarioDAO();
    private CadastroFuncionario cadastro;

    public FuncionarioController(ListarFuncionario lista, CadastroFuncionario cadastro) {
        this.lista = lista;
        this.cadastro = cadastro;
    }

    public void initController() {
        //listar os funcionarios
        lista.getjBList().addActionListener(e -> listarFuncionarios());
        //Deletar funcionario
        lista.getjBDelete().addActionListener(e -> deletarFuncionario());
        //Inserir Funcionario no banco
        cadastro.getjBInsert().addActionListener(e -> inserirFuncionario());

    }

    //Inserir
    private void inserirFuncionario() {
        String nome = cadastro.getjTFName().getText();
        String email = cadastro.getjTFEmail1().getText();
        String cargo = cadastro.getjTFCargo().getText();
        //encapsulando os dados
        Funcionario funcionario = new Funcionario(nome, email, cargo);
        //salvdando no banco
        dao.inserirFuncionario(funcionario);
        //Avisar quer o registro foi salvo
        JOptionPane.showMessageDialog(null, "SAVED!");
        //limpar dados
        cadastro.limparCampos();
    }

    //Listar
    private void listarFuncionarios() {
        ArrayList<Funcionario> listaDeFuncionarios = dao.listarFuncionarios();
        DefaultTableModel model = ((DefaultTableModel) lista.getjTable1().getModel());
        //Limpar as linhas da tabela
        model.setRowCount(0);
        for (int i = 0; i < listaDeFuncionarios.size(); i++) {
            model.addRow(new String[]{listaDeFuncionarios.get(i).getId() + "",
                listaDeFuncionarios.get(i).getNome(),
                listaDeFuncionarios.get(i).getEmail(),
                listaDeFuncionarios.get(i).getCargo()});
        }
    }

    //Update
    //Delete
    private void deletarFuncionario() {
        JTable tabela = lista.getjTable1();
        int linha = tabela.getSelectedRow();
        System.out.println("LINHA: " + linha);
        //Verifica se tem algum funcionario selecionado
        if (linha != -1) {
            //Encapsula as informações de um funcionario
            int id = Integer.parseInt(tabela.getValueAt(linha, 0) + "");
            String nome = tabela.getValueAt(linha, 1) + "";
            String email = tabela.getValueAt(linha, 2) + "";
            String cargo = tabela.getValueAt(linha, 3) + "";
            Funcionario funcionario = new Funcionario(id, nome, email, cargo);
            //Verificação de deleção
            int showConfirmDialog = JOptionPane.showConfirmDialog(null, "DELETAR O FUNCIONARIO: "
                    + funcionario.toString());
            if (showConfirmDialog == 0) {
                //deltar o funcionario do banco
                dao.deletarFuncionario(funcionario);
                //Atualizar a lista
                listarFuncionarios();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Selecione o funcionario a ser deletado: ");
        }
    }

}
