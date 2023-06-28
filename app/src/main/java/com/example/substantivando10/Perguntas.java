package com.example.substantivando10;

public class Perguntas {


    int id;
    String pergunta;

    public Perguntas()
    {
    }
    public Perguntas(String pergunta)
    {
        this.pergunta = pergunta;
    }
    public Perguntas(int id, String pergunta)
    {
        this.id = id;
        this.pergunta = pergunta;
    }
    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public String getPergunta()
    {
        return pergunta;
    }
    public void setPergunta(String pergunta)
    {
        this.pergunta = pergunta;
    }

}
