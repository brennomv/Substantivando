package com.example.substantivando10;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class DashboardActivity extends AppCompatActivity {

    TextView txtView_pergunta;
    TextView txtResposta01;
    TextView txtResposta02;
    TextView txtResposta03;
    TextView txtResposta04;
    String text = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        txtView_pergunta = (TextView) findViewById(R.id.txtView_pergunta);
        txtResposta01 = (TextView) findViewById(R.id.txtResposta01);
        txtResposta02 = (TextView) findViewById(R.id.txtResposta02);
        txtResposta03 = (TextView) findViewById(R.id.txtResposta03);
        txtResposta04 = (TextView) findViewById(R.id.txtResposta04);

        BancoDeDados banco = new BancoDeDados(this);
        BancoDeDados_Resposta bancoRes = new BancoDeDados_Resposta(this);

        //Inserindo dados das perguntas no BD.
        banco.inserePergunta(new Perguntas("Qual dessas palavras é um substantivo?"));
        banco.inserePergunta(new Perguntas("Qual dessas palavras é um substantivo simples?"));
        banco.inserePergunta(new Perguntas("Qual dessas palavras é um substantivo composto?"));
        banco.inserePergunta(new Perguntas("Qual dessas palavras é um substantivo comum?"));
        banco.inserePergunta(new Perguntas("Qual dessas palavras é um substantivo próprio?"));
        banco.inserePergunta(new Perguntas("Qual dessas palavras é um substantivo concreto?"));
        banco.inserePergunta(new Perguntas("Qual dessas palavras é um substantivo abstrato?"));
        banco.inserePergunta(new Perguntas("Qual dessas palavras é um substantivo primitivo?"));
        banco.inserePergunta(new Perguntas("Qual dessas palavras é um substantivo derivado?"));
        banco.inserePergunta(new Perguntas("Qual dessas palavras é um substantivo coletivo?"));

        //Inserindo Respostas

        bancoRes.insereRespostas(new Respostas("correr"));
        bancoRes.insereRespostas(new Respostas("banana"));
        bancoRes.insereRespostas(new Respostas("quatro"));
        bancoRes.insereRespostas(new Respostas("você"));
        bancoRes.insereRespostas(new Respostas("ultrssonografia"));
        bancoRes.insereRespostas(new Respostas("micro-ondas"));
        bancoRes.insereRespostas(new Respostas("escorpião"));
        bancoRes.insereRespostas(new Respostas("autoestima"));
        bancoRes.insereRespostas(new Respostas("paralelepípedo"));
        bancoRes.insereRespostas(new Respostas("hidrelétrica"));
        bancoRes.insereRespostas(new Respostas("caixote"));
        bancoRes.insereRespostas(new Respostas("biscoito"));
        bancoRes.insereRespostas(new Respostas("cidade"));
        bancoRes.insereRespostas(new Respostas("Paulo"));
        bancoRes.insereRespostas(new Respostas("Belém"));
        bancoRes.insereRespostas(new Respostas("África"));
        bancoRes.insereRespostas(new Respostas("pessoa"));
        bancoRes.insereRespostas(new Respostas("estado"));
        bancoRes.insereRespostas(new Respostas("Pará"));
        bancoRes.insereRespostas(new Respostas("rua"));
        bancoRes.insereRespostas(new Respostas("amor"));
        bancoRes.insereRespostas(new Respostas("fome"));
        bancoRes.insereRespostas(new Respostas("felicidade"));
        bancoRes.insereRespostas(new Respostas("vento"));
        bancoRes.insereRespostas(new Respostas("saudade"));
        bancoRes.insereRespostas(new Respostas("verde"));
        bancoRes.insereRespostas(new Respostas("cachorro"));
        bancoRes.insereRespostas(new Respostas("sol"));
        bancoRes.insereRespostas(new Respostas("terreno"));
        bancoRes.insereRespostas(new Respostas("ferreiro"));
        bancoRes.insereRespostas(new Respostas("chuveiro"));
        bancoRes.insereRespostas(new Respostas("vidro"));
        bancoRes.insereRespostas(new Respostas("sabão"));
        bancoRes.insereRespostas(new Respostas("gaveta"));
        bancoRes.insereRespostas(new Respostas("solar"));
        bancoRes.insereRespostas(new Respostas("açucar"));
        bancoRes.insereRespostas(new Respostas("casulo"));
        bancoRes.insereRespostas(new Respostas("bichano"));
        bancoRes.insereRespostas(new Respostas("circo"));
        bancoRes.insereRespostas(new Respostas("tribo"));

        //consultando e mostrando pergunta
        Perguntas p = banco.consultaPerguntasId(01);
        txtView_pergunta.setText(String.valueOf(p.getPergunta()));

        Respostas r1 = bancoRes.consultaRespostaId(01);
        txtResposta01.setText(String.valueOf(r1.getRespostas()));
        txtResposta01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mensagem = new AlertDialog.Builder(DashboardActivity.this);
                mensagem.setTitle("AAAHHH");
                mensagem.setMessage("Não foi dessa vez!");
                mensagem.setNeutralButton("Tente de novo. Você vai Conseguir", null);
                mensagem.show();
            }
        });

        Respostas r2 = bancoRes.consultaRespostaId(02);
        txtResposta02.setText(String.valueOf(r2.getRespostas()));
        txtResposta02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mensagem = new AlertDialog.Builder(DashboardActivity.this);
                mensagem.setTitle("Parabens!");
                mensagem.setMessage("Você Acertou!");
                mensagem.setNeutralButton("", null);
                mensagem.setCancelable(false);
                mensagem.setPositiveButton(" Próxima Pergunta ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        txtView_pergunta.setText(String.valueOf(""));
                        txtResposta01.setText(String.valueOf(""));
                        txtResposta02.setText(String.valueOf(""));
                        txtResposta03.setText(String.valueOf(""));
                        txtResposta04.setText(String.valueOf(""));

                        //consultando e mostrando pergunta
                        Perguntas p2 = banco.consultaPerguntasId(02);
                        txtView_pergunta.setText(String.valueOf(p2.getPergunta()));

                        Respostas r5 = bancoRes.consultaRespostaId(05);
                        txtResposta01.setText(String.valueOf(r5.getRespostas()));
                        txtResposta01.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                AlertDialog.Builder mensagem = new AlertDialog.Builder(DashboardActivity.this);
                                mensagem.setTitle("AAAHHH");
                                mensagem.setMessage("Não foi dessa vez!");
                                mensagem.setNeutralButton("Tente de novo. Você vai Conseguir", null);
                                mensagem.show();
                            }
                        });

                        Respostas r6 = bancoRes.consultaRespostaId(06);
                        txtResposta02.setText(String.valueOf(r6.getRespostas()));
                        txtResposta02.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                AlertDialog.Builder mensagem = new AlertDialog.Builder(DashboardActivity.this);
                                mensagem.setTitle("AAAHHH");
                                mensagem.setMessage("Não foi dessa vez!");
                                mensagem.setNeutralButton("Tente de novo. Você vai Conseguir", null);
                                mensagem.show();
                            }

                        });

                        Respostas r7 = bancoRes.consultaRespostaId(07);
                        txtResposta03.setText(String.valueOf(r7.getRespostas()));
                        txtResposta03.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                AlertDialog.Builder mensagem = new AlertDialog.Builder(DashboardActivity.this);
                                mensagem.setTitle("Parabens!");
                                mensagem.setMessage("Você Acertou!");
                                mensagem.setNeutralButton("", null);
                                mensagem.setCancelable(false);
                                mensagem.setPositiveButton(" Próxima Pergunta ", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        Intent intent = new Intent(DashboardActivity.this, Activity_Final.class);
                                        startActivity(intent);
                                    }
                                });
                                mensagem.show();
                            }

                        });

                        Respostas r8 = bancoRes.consultaRespostaId(8);
                        txtResposta04.setText(String.valueOf(r8.getRespostas()));
                        txtResposta04.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                AlertDialog.Builder mensagem = new AlertDialog.Builder(DashboardActivity.this);
                                mensagem.setTitle("AAAHHH");
                                mensagem.setMessage("Não foi dessa vez!");
                                mensagem.setNeutralButton("Tente de novo. Você vai Conseguir", null);
                                mensagem.show();
                            }
                        });
                    }
                });
                mensagem.show();
            }
        });

        Respostas r3 = bancoRes.consultaRespostaId(03);
        txtResposta03.setText(String.valueOf(r3.getRespostas()));
        txtResposta03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mensagem = new AlertDialog.Builder(DashboardActivity.this);
                mensagem.setTitle("AAAHHH");
                mensagem.setMessage("Não foi dessa vez!");
                mensagem.setNeutralButton("Tente de novo. Você vai Conseguir", null);
                mensagem.show();
            }
        });

        Respostas r4 = bancoRes.consultaRespostaId(04);
        txtResposta04.setText(String.valueOf(r4.getRespostas()));
        txtResposta04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mensagem = new AlertDialog.Builder(DashboardActivity.this);
                mensagem.setTitle("AAAHHH");
                mensagem.setMessage("Não foi dessa vez!");
                mensagem.setNeutralButton("Tente de novo. Você vai Conseguir", null);
                mensagem.show();
            }
        });
    }
}