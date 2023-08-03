package com.example;

public class AppClasses {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.renda=10000;
        cliente.sexo='M';
        cliente.anoNascimento = 1980;
        System.out.println("Renda: "+cliente.renda);
        System.out.println("Sexo: "+cliente.sexo);
        System.out.println("Ano de Nascimento: "+cliente.anoNascimento);
        

    }
    
}
