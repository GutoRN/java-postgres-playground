package com.example;

import java.util.Scanner;

public class AppScanner {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome: ");
        cliente.setNome(sc.nextLine());
        System.out.println("Digite a renda: ");
        cliente.setRenda(sc.nextDouble());
        System.out.println("Nome: "+cliente.getNome());
        System.out.println("Renda: "+cliente.getRenda());
        System.out.println("Sexo: "+cliente.getSexo());
        System.out.println("Ano de Nascimento: "+cliente.getAnoNascimento());

        
        

    }
    
}
