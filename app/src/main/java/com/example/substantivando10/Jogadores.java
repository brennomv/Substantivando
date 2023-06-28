package com.example.substantivando10;

public class Jogadores {

    int id;
    String nome;

    public Jogadores()
    {
    }
    public Jogadores(String nome)
    {
        this.nome = nome;
    }
    public Jogadores(int id, String nome)
    {
        this.id = id;
        this.nome = nome;
    }
    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public String getNome()
    {
        return nome;
    }
    public void setNome(String nome)
    {
        this.nome = nome;
    }
}
