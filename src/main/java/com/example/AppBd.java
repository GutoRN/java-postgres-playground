package com.example;

import java.sql.DriverManager;
import java.sql.SQLException;

public class AppBd {
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
            var conn = DriverManager.getConnection("jdbc:postgresql://localhost/postgres", "gitpod", "");
            System.out.println("Conexão realizada com sucesso");
        } catch (ClassNotFoundException e) {
            System.err.println("Não foi possivel carregar a biblioteca para acesso ao banco de dados");
        } catch (SQLException e) {
            System.err.println("Não foi possivel conectar ao banco de dados" + e.getMessage());           
        }
    }
}    
