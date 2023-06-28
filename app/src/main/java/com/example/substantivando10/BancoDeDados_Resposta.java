package com.example.substantivando10;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

public class BancoDeDados_Resposta extends SQLiteOpenHelper
{
    private static final int VERSAO_BANCO_DADOS = 1;
    private static final String NOME_BANCO_DADOS = "gerenciaResposta";
    private static final String TABELA_RESPOSTA = "resposta";
    private static final String CAMPO_ID= "id";
    private static final String CAMPO_RESPOSTA = "resposta";

    public BancoDeDados_Resposta(Context context)
    {
        super(context, NOME_BANCO_DADOS, null, VERSAO_BANCO_DADOS);
    }
    @Override
    public void onCreate(SQLiteDatabase bancoRes)
    {
        String CriaTabelaResposta = "CREATE TABLE " + TABELA_RESPOSTA + "(" + CAMPO_ID + " INTEGER PRIMARY KEY," + CAMPO_RESPOSTA + " TEXT" + ")";
        bancoRes.execSQL(CriaTabelaResposta);
    }
    @Override
    public void onUpgrade(SQLiteDatabase bancoRes, int i, int i1)
    {
        bancoRes.execSQL("DROP TABLE IF EXISTS " + TABELA_RESPOSTA);
        onCreate(bancoRes);
    }
    public void deletar(SQLiteDatabase banco)
    {
        banco.execSQL("DROP TABLE IF EXISTS " + TABELA_RESPOSTA);
    }
    public void insereRespostas(Respostas resposta)
    {
        SQLiteDatabase banco = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(CAMPO_RESPOSTA, resposta.getRespostas());
        banco.insert(TABELA_RESPOSTA, null, values);
        banco.close();
    }

    public Respostas consultaResposta (int id)
    {
        SQLiteDatabase banco= this.getReadableDatabase();
        Cursor cursor = banco.query(TABELA_RESPOSTA, new String[] {CAMPO_ID, CAMPO_RESPOSTA}, CAMPO_ID + "=?", new String[] {String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
        {
            cursor.moveToFirst();
        }
        Respostas respostas = new Respostas(Integer.parseInt(cursor.getString(0)), cursor.getString( 1));
        return respostas;
    }

    public Respostas consultaRespostaId (int id)
    {
        SQLiteDatabase bancoRes = this.getReadableDatabase();
        Cursor cursor = bancoRes.query(TABELA_RESPOSTA, new String[] {CAMPO_ID, CAMPO_RESPOSTA}, CAMPO_ID + "=?", new String[] {String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
        {
            cursor.moveToFirst();
        }
        Respostas respostas = new Respostas(Integer.parseInt(cursor.getString(0)), cursor.getString(1));
        return respostas;

    }

    public List<Respostas> listaTodosRespostas()
    {
        List<Respostas> listaRespostas = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABELA_RESPOSTA;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst())
        {
            do
            {
                Respostas respostas = new Respostas();
                respostas.setId(Integer.parseInt(cursor.getString(0)));
                respostas.setRespostas(cursor.getString(1));
                listaRespostas.add(respostas);
            }
            while (cursor.moveToNext());
        }
        return listaRespostas;
    }

    public int atualizaRespostas (Respostas respostas)
    {
        SQLiteDatabase banco = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(CAMPO_RESPOSTA, respostas.getRespostas());
        return banco.update(TABELA_RESPOSTA, values, CAMPO_ID + "=?", new String[]
                {String.valueOf(respostas.getId())});
    }
    public void deletaRespostas(Respostas respostas)
    {SQLiteDatabase banco = this.getWritableDatabase();
        banco.delete(TABELA_RESPOSTA, CAMPO_ID + "=?", new String[]
                {String.valueOf(respostas.getId())});
        banco.close();
    }
    public int consultaQuantidadeRespostas()
    {
        String countQuery = "SELECT * FROM " + TABELA_RESPOSTA;
        SQLiteDatabase banco = this.getReadableDatabase();
        Cursor cursor = banco.rawQuery(countQuery, null);
        cursor.close();
        return cursor.getCount();
    }
}