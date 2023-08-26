package com.example.dao;

import java.sql.Connection;
import java.sql.SQLException;

public class EstadoDAO {
    private Connection conn;

    public EstadoDAO(Connection conn) {
        this.conn = conn;
    }

    public void listar() {
        
        try {
            
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

    public void localizarEstado(String uf) {
        try{
            var statement = conn.createStatement();
            var sql = "select * from estado where uf= '"+uf+"'";
            System.out.println(sql);
            statement.executeQuery(sql);

        }catch(SQLException e){
            System.err.println("Erro ao executar consulta SQL: ");
        }
        

    }
}
