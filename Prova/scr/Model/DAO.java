package Model;

import java.sql.*;
import java.util.ArrayList;

public class DAO {

    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/aula03";
    private String user = "root";
    private String password = "laboratorio";

    //método de conexão
    private Connection conectar() {
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            return con;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    //READ - Recupar informações de funcionários
    public ArrayList<Funcionario> listaFuncionarios() {
        //criar lista de funcionario
        ArrayList<Funcionario> listaFuncionario = new ArrayList();
        //declarar a query utilizada para retonar dados de funcioanrios
        String read = "select * from funcionario;";
        try {
            //abrir a conexão
            Connection con = conectar();
            //preparar a query para execução no banco de dados
            PreparedStatement pst = con.prepareStatement(read);
            //executar a query e armazena em um RS
            ResultSet rs = pst.executeQuery();
            //passando os valores contidos no RS para a lista de func.
            while (rs.next()) {
                int id = Integer.parseInt(rs.getString(1));
                String nome = rs.getString(2);
                String email = rs.getString(3);
                String cargo = rs.getString(4);
                //adicionar um novo funcionario a Lista
                listaFuncionario.add(new Funcionario(id, nome, email, cargo));
            }
            con.close();
            return listaFuncionario;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    // create - insere dados no banco 
    public void inserirFuncionario(Funcionario funcionario) {
        //criar a query de inserção
        String insert = "INSERT into Funcionario (Nome, Email, Cargo)"
                + " values(?, ?, ?);";

        try {
            //aabrir uma conexão 
            Connection con = conectar();
            //preparar a query para execução
            PreparedStatement pst = con.prepareStatement(insert);
            //setar os valores e serem inseridos
            pst.setString(1, funcionario.getNome());
            pst.setString(2, funcionario.getEmail());
            pst.setString(3, funcionario.getCargo());
            //execute query
            pst.execute();
            //fecha conexão
            con.close();
            pst.close();
        } catch (Exception e) {
            System.out.println("ERRO AO INSERIR" + e);
        }

    }
}
