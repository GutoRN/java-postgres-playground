package com.example;

import java.util.ArrayList;
import java.util.List;

import com.example.model.Cliente;

public class AppListas {

    public static void main(String[] args) {

        List<Cliente> listaClientes = new ArrayList<>();
        Cliente Cliente1 = new Cliente();
        Cliente Cliente2 = new Cliente();
        Cliente1.setNome("Marcio");
        Cliente1.setRenda(15000);
        Cliente1.setSexo('M');
        Cliente1.setAnoNascimento(1978);
        listaClientes.add(Cliente1);
        Cliente2.setNome("Augusto");
        Cliente2.setRenda(16000);
        Cliente2.setSexo('M');
        Cliente2.setAnoNascimento(1980);
        listaClientes.add(Cliente2);
        //System.out.println(Cliente1);
        for (Cliente cliente : listaClientes) {
            System.out.println("Cliente "+ cliente);
        }
    }

    
    
}
