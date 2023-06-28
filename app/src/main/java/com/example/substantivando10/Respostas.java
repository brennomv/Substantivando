package com.example.substantivando10;

import android.content.DialogInterface;
import android.view.View;

import androidx.appcompat.app.AlertDialog;

public class Respostas {

    int id;
    String respostas;

    public Respostas()
    {
    }
    public Respostas(String respostas)
    {
        this.respostas = respostas;
    }
    public Respostas(int id, String respostas)
    {
        this.id = id;
        this.respostas = respostas;
    }
    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public String getRespostas()
    {
        return respostas;
    }
    public void setRespostas(String respostas)
    {
        this.respostas = respostas;
    }
    }

