package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AppBd {
    private static final String PASSWORD = "";
    private static final String USERNAME = "gitpod";
    private static final String JDBC_URL = "jdbc:postgresql://localhost/postgres";
    private Connection conn;

    public static void main(String[] args) {
      new AppBd();
    }

    public AppBd(){
        try(var conn = getConnection() ) {
          //  carregarDriverJDBC();
            listarEstados(conn);
            localizarEstado(conn,"TO");
            
            
            var marca = new Marca();
            marca.setId(2L);

            var produto = new Produto();
            produto.setId(205L);
            produto.setMarca(marca);
            produto.setNome("Produto Novo");
            produto.setValor(900);
           // inserirProduto(conn, produto);
            alterarProduto(conn,produto );
            excluirProduto(conn,204L);
            listarDadosTabela(conn,"produto");

        }catch (SQLException e) {
            System.err.println("Não foi possivel conectar ao banco de dados" + e.getMessage());                 
        }        
    }

  private void excluirProduto(Connection conn, long id) {
        var sql="delete from produto where id = ?";
        try {
            var statement=conn.prepareStatement(sql);
            statement.setLong(1, id);
            if (statement.executeUpdate()==1){
                System.out.println("id exluida com sucesso");
            }else System.out.println("id nao encontrada");
                  
        } catch (SQLException e) {
            System.err.println("Erro ao excluir" + e.getMessage());
        }
    }

private void inserirProduto(Connection conn, Produto produto) {
        var sql="insert into produto (nome, marca_id,valor) values(?,?,?)";
        try (var statement = conn.prepareStatement(sql)) {
            statement.setString(1, produto.getNome());
            statement.setLong(2, produto.getMarca().getId());
            statement.setDouble(3, produto.getValor());
            statement.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.err.println("Erro na execução da consulta: " + e.getMessage()); 
        }
    }

    private void alterarProduto(Connection conn, Produto produto) {
        var sql="update produto set nome=?, marca_id=?, valor=? where id = ?";
        try (var statement = conn.prepareStatement(sql)) {
            statement.setString(1, produto.getNome());
            statement.setLong(2, produto.getMarca().getId());
            statement.setDouble(3, produto.getValor());
            statement.setLong(4, produto.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.err.println("Erro na alteração do produto: " + e.getMessage()); 
        }
    }    

  private void listarDadosTabela(Connection conn, String tabela){
        var sql = "select * from " + tabela;
        System.out.println(sql);
        try {
            var statement=conn.createStatement();
            var result=statement.executeQuery(sql);

            var metadata=result.getMetaData();
            int cols=metadata.getColumnCount();

            for (int i = 1; i <= cols; i++) {
                System.out.printf("%-25s | ", metadata.getColumnName(i));
            }

            System.out.println();

            while(result.next()){
                
                for (int i = 1; i <= cols; i++) {
                    System.out.printf("%-25s | ", result.getString(i));
                }
                System.out.println();
            }

        } catch (SQLException e) {
            System.out.println("Erro na execução da consulta");
        }
    }

    private void localizarEstado(Connection conn, String uf) {
        try{
            var statement = conn.createStatement();
            var sql = "select * from estado where uf= '"+uf+"'";
            System.out.println(sql);
            statement.executeQuery(sql);

        }catch(SQLException e){
            System.err.println("Erro ao executar consulta SQL: ");
        }
        

    }

    private void listarEstados(Connection conn) {
        
        try {
            System.out.println("Conexão realizada com sucesso");
            var statement = conn.createStatement();
            var result=statement.executeQuery("select * from estado");
            while(result.next()){
                System.out.printf("Id: %d Nome: %s UF: %s\n",result.getInt("Id"),result.getString("nome"),result.getString("uf"));
            }
            System.out.println();

        } catch (SQLException e) {
                System.err.println("Não foi possivel executar a consulta banco de dados" + e.getMessage());          
        }
    }

    private Connection getConnection() throws SQLException{
        return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
    }

    private void carregarDriverJDBC() {
        try {
            Class.forName("org.postgresql.Driver");         
        } catch (ClassNotFoundException e) {
            System.err.println("Não foi possivel carregar a biblioteca para acesso ao banco de dados");
        }
    }
}    
