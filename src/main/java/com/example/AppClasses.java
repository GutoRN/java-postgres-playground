package com.example;

public class AppClasses {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.setRenda(-10000);
        cliente.setSexo('M');
        cliente.setAnoNascimento(1980);
        System.out.println("Renda: "+cliente.getRenda());
        System.out.println("Sexo: "+cliente.getSexo());
        System.out.println("Ano de Nascimento: "+cliente.getAnoNascimento());

        Cliente cliente2= new Cliente(200);
        System.out.println("Renda: "+cliente2.getRenda());
        System.out.println("Sexo: "+cliente2.getSexo());
        System.out.println("Ano de Nascimento: "+cliente2.getAnoNascimento());
        

    }
    
}
