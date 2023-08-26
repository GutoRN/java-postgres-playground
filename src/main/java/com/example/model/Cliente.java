package com.example.model;

public class Cliente{

    private String nome;
    
    private double renda;
    private char sexo;
    private int anoNascimento;

    public Cliente(){
        System.out.println("Criando um Cliente");
    }
    
    public Cliente(double renda){
        System.out.println("Criando um Cliente com o construtor 2");
        this.setRenda(renda);
    }

    public double getRenda() {
        return renda;
    }
    public void setRenda(double renda) {
        if (renda>=0)
            this.renda = renda;
        else
            System.out.println("A renda deve ser maior que zero");
    }
    public char getSexo() {
        return sexo;
    }
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
    public int getAnoNascimento() {
        return anoNascimento;
    }
    public void setAnoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return " [Nome=" + nome + ", Renda=" + renda + ", Sexo =" + sexo + ", Ano de Nascimento=" + anoNascimento
                + "]";
    }
    
}