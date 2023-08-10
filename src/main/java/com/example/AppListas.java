package com.example;

import java.util.ArrayList;
import java.util.List;

public class AppListas {

    public static void main(String[] args) {

        List<Cliente> listaClientes = new ArrayList<>();
        Cliente Cliente1 = new Cliente();
        Cliente1.setNome("Marcio");
        Cliente1.setRenda(15000);
        Cliente1.setSexo('M');
        Cliente1.setAnoNascimento(1978);
        listaClientes.add(Cliente1);
        //System.out.println(Cliente1);
        for (Cliente cliente : listaClientes) {
            System.out.println("Cliente "+ cliente);
        }
    }

    
    
}
