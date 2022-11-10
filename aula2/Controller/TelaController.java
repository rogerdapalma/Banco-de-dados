
package Controller;

import View.CadastroFuncionario;
import View.ListarFuncionario;

public class TelaController {
    private CadastroFuncionario cadastro;
    private ListarFuncionario lista;

    public TelaController(CadastroFuncionario cadastro, ListarFuncionario lista) {
        this.cadastro = cadastro;
        this.lista = lista;
    }
    
    public void initController(){
        //mudar da tela listar para cadastro
        lista.getjBNew().addActionListener(e -> exibirTelaCadastro());
        //mudar da tela de cadastro para tela listage
        cadastro.getjBReturn().addActionListener(e -> exibirTelaListagem());
    }
    
    private void exibirTelaCadastro(){
        cadastro.setVisible(true);
        lista.setVisible(false);
    }
    private void exibirTelaListagem(){
        lista.setVisible(true);
        cadastro.setVisible(false);
    }
    
}
