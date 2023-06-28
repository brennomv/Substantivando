package com.example.substantivando10;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;
public class BancoDeDados extends SQLiteOpenHelper
{
    private static final int VERSAO_BANCO_DADOS = 1;
    private static final String NOME_BANCO_DADOS = "gerenciaPerguntas";
    private static final String TABELA_PERGUNTAS = "pergunta";
    private static final String CAMPO_ID= "id";
    private static final String CAMPO_PERGUNTAS = "pergunta";

    public BancoDeDados(Context context)
    {
        super(context, NOME_BANCO_DADOS, null, VERSAO_BANCO_DADOS);
    }
    @Override
    public void onCreate(SQLiteDatabase banco)
    {
        String CriaTabelaPerguntas = "CREATE TABLE " + TABELA_PERGUNTAS + "(" + CAMPO_ID + " INTEGER PRIMARY KEY," + CAMPO_PERGUNTAS + " TEXT" + ")";
        banco.execSQL(CriaTabelaPerguntas);
    }
    @Override
    public void onUpgrade(SQLiteDatabase banco, int i, int i1)
    {
        banco.execSQL("DROP TABLE IF EXISTS " + TABELA_PERGUNTAS);
        onCreate(banco);
    }
    public void deletar(SQLiteDatabase banco)
    {
        banco.execSQL("DROP TABLE IF EXISTS " + TABELA_PERGUNTAS);
    }
    public void inserePergunta(Perguntas pergunta)
    {
        SQLiteDatabase banco = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(CAMPO_PERGUNTAS, pergunta.getPergunta());
        banco.insert(TABELA_PERGUNTAS, null, values);
        banco.close();
    }

    public Perguntas consultaPerguntas (int id)
    {
        SQLiteDatabase banco= this.getReadableDatabase();
        Cursor cursor = banco.query(TABELA_PERGUNTAS, new String[] {CAMPO_ID, CAMPO_PERGUNTAS}, CAMPO_ID + "=?", new String[] {String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
        {
            cursor.moveToFirst();
        }
        Perguntas perguntas = new Perguntas(Integer.parseInt(cursor.getString(0)), cursor.getString( 1));
        return perguntas;
    }

    public Perguntas consultaPerguntasId (int id)
    {
        SQLiteDatabase banco = this.getReadableDatabase();
        Cursor cursor = banco.query(TABELA_PERGUNTAS, new String[] {CAMPO_ID, CAMPO_PERGUNTAS}, CAMPO_ID + "=?", new String[] {String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
        {
            cursor.moveToFirst();
        }
        Perguntas perguntas = new Perguntas(Integer.parseInt(cursor.getString(0)), cursor.getString(1));
        return perguntas;

    }

    public List<Perguntas> listaTodosPerguntas()
    {
        List<Perguntas> listaPerguntas = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABELA_PERGUNTAS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst())
        {
            do
            {
                Perguntas perguntas = new Perguntas();
                perguntas.setId(Integer.parseInt(cursor.getString(0)));
                perguntas.setPergunta(cursor.getString(1));
                listaPerguntas.add(perguntas);
            }
            while (cursor.moveToNext());
        }
        return listaPerguntas;
    }

    public int atualizaPerguntas (Perguntas perguntas)
    {
        SQLiteDatabase banco = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(CAMPO_PERGUNTAS, perguntas.getPergunta());
        return banco.update(TABELA_PERGUNTAS, values, CAMPO_ID + "=?", new String[]
                {String.valueOf(perguntas.getId())});
    }
    public void deletaPerguntas(Perguntas perguntas)
    {SQLiteDatabase banco = this.getWritableDatabase();
        banco.delete(TABELA_PERGUNTAS, CAMPO_ID + "=?", new String[]
                {String.valueOf(perguntas.getId())});
        banco.close();
    }
    public int consultaQuantidadePerguntas()
    {
        String countQuery = "SELECT * FROM " + TABELA_PERGUNTAS;
        SQLiteDatabase banco = this.getReadableDatabase();
        Cursor cursor = banco.rawQuery(countQuery, null);
        cursor.close();
        return cursor.getCount();
    }
}
