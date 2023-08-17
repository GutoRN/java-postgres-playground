package com.example;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AppBd {
    public static void main(String[] args) {
        
        try {
            Class.forName("org.postgresql.Driver");         
        } catch (ClassNotFoundException e) {
            System.err.println("Não foi possivel carregar a biblioteca para acesso ao banco de dados");
        }

        Statement statement = null;
        
        try(var conn = DriverManager.getConnection("jdbc:postgresql://localhost/postgres", "gitpod", "")) {
            System.out.println("Conexão realizada com sucesso");
            statement = conn.createStatement();
            var result=statement.executeQuery("select * from estado");
            while(result.next()){
                System.out.printf("Id: %d Nome: %s UF: %s\n",result.getInt("Id"),result.getString("nome"),result.getString("uf"));
            }
            

        } catch (SQLException e) {
            if(statement==null)
                System.err.println("Não foi possivel conectar ao banco de dados" + e.getMessage());
            else 
                System.err.println("Não foi possivel executar a consulta banco de dados" + e.getMessage());          
        } 
    }
}    
