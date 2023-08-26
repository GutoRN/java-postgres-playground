package com.example.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.example.model.Estado;

public class EstadoDAO {
    private Connection conn;

    public EstadoDAO(Connection conn) {
        this.conn = conn;
    }

    public List<Estado> listar() throws SQLException {
        var lista = new LinkedList<Estado>();
        var statement = conn.createStatement();
        var result=statement.executeQuery("select * from estado");
        while(result.next()){
            var estado=new Estado();
            estado.setId(result.getLong("id"));
            estado.setNome(result.getString("nome"));
            estado.setUf(result.getString("uf"));
            lista.add(estado);
           
        }
        return lista;
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
