package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.example.dao.ConnectionManager;
import com.example.dao.DAO;
import com.example.dao.EstadoDAO;
import com.example.dao.ProdutoDAO;
import com.example.model.Marca;
import com.example.model.Produto;


public class AppBd {
    private Connection conn;

    public static void main(String[] args) {
      new AppBd();
    }

    public AppBd(){
        try(var conn = ConnectionManager.getConnection() ) {
          //  carregarDriverJDBC();
            var estadoDAO = new EstadoDAO(conn);
            estadoDAO.listar();
            estadoDAO.localizarEstado("PR");
                    
            
            var marca = new Marca();
            marca.setId(2L);

            var produto = new Produto();
            produto.setId(205L);
            produto.setMarca(marca);
            produto.setNome("Produto Novo");
            produto.setValor(900);
           // inserirProduto(conn, produto);
            var produtoDAO = new ProdutoDAO(conn);
            produtoDAO.alterar(produto);
            produtoDAO.excluir(207L);
            
            var dao = new DAO(conn);
            dao.listar("produto");


          

        }catch (SQLException e) {
            System.err.println("Não foi possivel conectar ao banco de dados" + e.getMessage());                 
        }        
    }

  

  

  

    

    
    private void carregarDriverJDBC() {
        try {
            Class.forName("org.postgresql.Driver");         
        } catch (ClassNotFoundException e) {
            System.err.println("Não foi possivel carregar a biblioteca para acesso ao banco de dados");
        }
    }
}    
