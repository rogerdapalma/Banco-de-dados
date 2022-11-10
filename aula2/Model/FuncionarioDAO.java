package Model;

import ConnectionFactory.ConnectionFactory;
import java.sql.*;
import java.util.ArrayList;

public class FuncionarioDAO {
    private Connection con;
    
    //CREATE - Isere pessoas no banco de dados
    public void inserirFuncionario(Funcionario funcionario){
        //Criando aquery de inserção
        String insert = "Insert into Funcionario(nome,email,cargo) "
                + "values (?, ?, ?);";
        //Abrir a conexão
        con = new ConnectionFactory().getConnection();
        try {
            //Preparar a query para execução
            PreparedStatement pst = con.prepareStatement(insert);
            //Setando o valores a serem inseridos
            pst.setString(1, funcionario.getNome());
            pst.setString(2, funcionario.getEmail());
            pst.setString(3, funcionario.getCargo());
            //Executando a query
            pst.execute();
            //Fechando a conexão
            con.close();
            pst.close();
        } catch (SQLException e) {
            System.out.println("ERRO AO INSERIR REGISTRO: " + e);
        }
        
    }
    
    //READ - Recupar informações de funcionários
    public ArrayList<Funcionario> listarFuncionarios(){
        //criar lista de funcionario
        ArrayList<Funcionario> listaFuncionario = new ArrayList();
        //declarar a query utilizada para retonar dados de funcioanrios
        String read = "select * from funcionario;";
        try {
            //abrir a conexão
            con = new ConnectionFactory().getConnection();
            //preparar a query para execução no banco de dados
            PreparedStatement pst = con.prepareStatement(read);
            //executar a query e armazena em um RS
            ResultSet rs = pst.executeQuery();
            //passando os valores contidos no RS para a lista de func.
            while(rs.next()){
                int id =  Integer.parseInt(rs.getString(1));
                String nome = rs.getString(2);
                String email = rs.getString(3);
                String cargo = rs.getString(4);
                //adicionar um novo funcionario a Lista
                listaFuncionario.add(new Funcionario(id, nome, email,cargo));
            }
            con.close();
            return listaFuncionario;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        } 
    }
    
    //UPDATE - Alterar informações de um funcionario
    public void editarFuncionario(Funcionario funcionario){
        //declarar a query
        String update = "update funcionario set nome = ?, email = ?, cargo = ?"
                + " where ID = ?;";
        //Abrindo conexão
        con = new ConnectionFactory().getConnection();
        try {
            //preparando a query
            PreparedStatement pst = con.prepareStatement(update);
            //setar os valor do update
            pst.setString(1, funcionario.getNome());
            pst.setString(2, funcionario.getEmail());
            pst.setString(3, funcionario.getCargo());
            pst.setString(4, funcionario.getId()+"");
            //executa a query
            pst.executeUpdate();
            //fecha conexão
            con.close();
            pst.close();
        } catch (SQLException e) {
            System.out.println("ERRO AO ATUALIZAR O BANCO: " + e);
        }
    }
    
    //DELETE - Remover um registro do banco
    public void deletarFuncionario(Funcionario funcionario){
        //query para deletar funcionario
        String delete = "delete from funcionario where id = ?;";
        //abriri a conexão
        con = new ConnectionFactory().getConnection();
        try {
            //preparando a query
            PreparedStatement pst = con.prepareStatement(delete);
            //setando o funcionario a ser excluido
            pst.setString(1, funcionario.getId()+"");
            //executando a query
            pst.execute();
            //fechando a conexão
            con.close();
            pst.close();
        } catch (SQLException e) {
            System.out.println("ERRO AO DELTER FUNCIONARIO: " + e);
        }
        
    }
    
 
}
