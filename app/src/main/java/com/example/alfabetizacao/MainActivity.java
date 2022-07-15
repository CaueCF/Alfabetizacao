package com.example.alfabetizacao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Runnable {

    private ArrayList<Button> btns;
    private Button principal;
    private ArrayList<Elemento> imagens;
    private LinearLayout botoes, text;
    private Handler handler;
    private int vazio;
    private Elemento aux;
    private ProgressBar progresso;
    private String x;
    private ArrayList<String> silabas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botoes = (LinearLayout) findViewById(R.id.layoutBotoes);
        text = (LinearLayout) findViewById(R.id.layoutText);
        principal = (Button) findViewById(R.id.buttonImagem);
        progresso = (ProgressBar) findViewById(R.id.progressBar);

        x = new String();
        Intent i = getIntent();

        if (i != null) {
            Bundle so = new Bundle();
            so = i.getExtras();
            if (so != null) {
                x = so.getString("tipo", null);
            }
        } /*else if (i2 != null) {
            Bundle si = new Bundle();
            si = i.getExtras();
            if (si != null) {
                x = si.getString("silabas", null);
            }
        }*/

        progresso.setPadding(100, 0, 100, 0);

        imagens = new ArrayList<Elemento>();

        if(x.equals("soletrando")) {
            carregaElementoLetra();
        }else if(x.equals("silabas")){
            carregaElementoSilaba();
        }

        Collections.shuffle(imagens);

        progresso.setMax(imagens.size());
        aux = imagens.get(0);
        btns = new ArrayList<Button>();

        if(x.equals("soletrando")) {
            vazio = aux.getTextoImagem().length() - 1;
        }else if(x.equals("silabas")){

            silabas = new ArrayList<String>();
            silabas.addAll(Arrays.asList(aux.getTextoImagem().split("-")));
            vazio = silabas.size()-1;
        }


        handler = new Handler();
        handler.postDelayed(this, 2500);

    }

    public void carregaElementoLetra(){
        Elemento e1 = new Elemento();
        e1.setImagem(R.drawable.casa);
        e1.setTextoImagem("CASA");
        imagens.add(e1);

        Elemento e2 = new Elemento();
        e2.setImagem(R.drawable.pato);
        e2.setTextoImagem("PATO");
        imagens.add(e2);

        Elemento e3 = new Elemento();
        e3.setImagem(R.drawable.vaca);
        e3.setTextoImagem("VACA");
        imagens.add(e3);

        Elemento e4 = new Elemento();
        e4.setImagem(R.drawable.mesa);
        e4.setTextoImagem("MESA");
        imagens.add(e4);

        Elemento e5 = new Elemento();
        e5.setImagem(R.drawable.lobo);
        e5.setTextoImagem("LOBO");
        imagens.add(e5);

        Elemento e6 = new Elemento();
        e6.setImagem(R.drawable.osso);
        e6.setTextoImagem("OSSO");
        imagens.add(e6);

        Elemento e7 = new Elemento();
        e7.setImagem(R.drawable.bola);
        e7.setTextoImagem("BOLA");
        imagens.add(e7);

        Elemento e8 = new Elemento();
        e8.setImagem(R.drawable.copo);
        e8.setTextoImagem("COPO");
        imagens.add(e8);

        Elemento e9 = new Elemento();
        e9.setImagem(R.drawable.gato);
        e9.setTextoImagem("GATO");
        imagens.add(e9);

        Elemento e10 = new Elemento();
        e10.setImagem(R.drawable.urso);
        e10.setTextoImagem("URSO");
        imagens.add(e10);
    }

    public void carregaElementoSilaba(){
        Elemento e1 = new Elemento();
        e1.setImagem(R.drawable.banana);
        e1.setTextoImagem("BA-NA-NA");
        imagens.add(e1);

        Elemento e2 = new Elemento();
        e2.setImagem(R.drawable.abelha);
        e2.setTextoImagem("A-BE-LHA");
        imagens.add(e2);

        Elemento e3 = new Elemento();
        e3.setImagem(R.drawable.janela);
        e3.setTextoImagem("JA-NE-LA");
        imagens.add(e3);

        Elemento e4 = new Elemento();
        e4.setImagem(R.drawable.oculos);
        e4.setTextoImagem("Ó-CU-LOS");
        imagens.add(e4);

        Elemento e5 = new Elemento();
        e5.setImagem(R.drawable.sapato);
        e5.setTextoImagem("SA-PA-TO");
        imagens.add(e5);

        Elemento e6 = new Elemento();
        e6.setImagem(R.drawable.piscina);
        e6.setTextoImagem("PIS-CI-NA");
        imagens.add(e6);

        Elemento e7 = new Elemento();
        e7.setImagem(R.drawable.tucano);
        e7.setTextoImagem("TU-CA-NO");
        imagens.add(e7);

        Elemento e8 = new Elemento();
        e8.setImagem(R.drawable.jacare);
        e8.setTextoImagem("JA-CA-RÉ");
        imagens.add(e8);

        Elemento e9 = new Elemento();
        e9.setImagem(R.drawable.abacaxi);
        e9.setTextoImagem("A-BA-CA-XI");
        imagens.add(e9);

        Elemento e10 = new Elemento();
        e10.setImagem(R.drawable.boneca);
        e10.setTextoImagem("BO-NE-CA");
        imagens.add(e10);
    }

    public void carregaBotoes(){

        btns.clear();

        if(x.equals("soletrando")) {
            botoesPalavra();
        }else if(x.equals("silabas")){
            botoesSilaba();
        }
    }

    public void botoesPalavra(){
        for(char c: aux.getTextoImagem().toCharArray()){
            Button atual = new Button(this);
            atual.setText(Character.toString(c));
            atual.setOnClickListener(this);
            btns.add(atual);
        }
    }

    public void botoesSilaba(){

        for(String s: silabas){
            Button atual = new Button(this);
            atual.setText(s);
            atual.setOnClickListener(this);
            btns.add(atual);
        }
    }

    public void carregaJogo(){

        carregaBotoes();

        Collections.shuffle(btns);

        principal.setCompoundDrawablesRelativeWithIntrinsicBounds(null,
                getResources().getDrawable(aux.getImagem()),null, null);

        principal.setClickable(false);

        int i = 0;
        for(Button b: btns){
            TextView t = new TextView(this);
            t.setId(10+i);
            b.setId(i);
            //t.setBackgroundColor(Color.rgb(255,253,208));
            t.setText("_");
            t.setTextSize(40);
            t.setTextColor(Color.BLACK);
            t.setPadding(0,0,80,0);
            botoes.addView(b);
            text.addView(t);
            i++;
        }
    }

    public void adiciona(String s){
        if(x.equals("soletrando")) {
            adicionaLetra(s.toCharArray()[0]);
        }else if(x.equals("silabas")){
            adicionaSilaba(s);
        }
    }

    public void adicionaLetra(char c){
        for(int i = 10; i<15; i++){
            TextView t = findViewById(i);
            if(t.getText() == "_"){
                t.setText(Character.toString(c));
                break;
            }
        }
    }

    public void adicionaSilaba(String s){
        for(int i = 10; i<15; i++){
            TextView t = findViewById(i);
            if(t.getText() == "_"){
                t.setText(s);
                break;
            }
        }
    }

    public void proximaFigura(){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {

            public void run() {

                if(!imagens.isEmpty()) {

                    imagens.remove(0);
                    aux = imagens.get(0);
                    text.removeAllViews();
                    botoes.removeAllViews();
                    silabas.clear();

                    carregaJogo();

                    int passo = progresso.getProgress()+1;
                    progresso.setProgress(passo);

                    if(x.equals("soletrando")) {
                        vazio = aux.getTextoImagem().length() - 1;
                    }else if(x.equals("silabas")){

                        silabas.addAll(Arrays.asList(aux.getTextoImagem().split("-")));

                        vazio = silabas.size()-1;
                    }

                }
            }
        }, 1500);
    }

    public void verifica(){
        if(x.equals("soletrando")) {
            verificaPalavra();
        }else if(x.equals("silabas")){
            verificaSilabas();
        }
    }

    public void verificaSilabas(){
        vazio = -1;
        ArrayList<String> palavra = new ArrayList<String>();

        ArrayList<String> certa = new ArrayList<String>();
        certa.addAll(Arrays.asList(aux.getTextoImagem().split("-")));

        for(int i = 10; i<=14; i++){

            TextView t = findViewById(i);

            if(t != null) {

                palavra.add(t.getText().toString());
            }
        }

        for(int i = 0; i<palavra.size(); i++){

            TextView t = findViewById(10 + i);
            Button b = btns.get(i);

            if(t != null && b != null) {

                if(!palavra.get(i).equals(certa.get(i))){

                    t.setText("_");
                    t.setTextColor(Color.rgb(101, 63, 33));

                    for (Button l : btns) {

                        if (l.getText().equals(palavra.get(i))) {

                            l.setVisibility(View.VISIBLE);
                            l.setClickable(true);
                            l.setBackgroundColor(Color.rgb(101, 63, 33)); //marrom
                            break;
                        }
                    }
                    vazio++;

                }
                else {

                    t.setTextColor(Color.BLACK);
                }

            }
        }

        if(vazio == -1){

            if(imagens.isEmpty()){
                Intent k = new Intent(this, Vitoria.class);
                startActivity(k);
            }
            else {
                proximaFigura();
            }
        }
    }

    public void verificaPalavra(){

        vazio = -1;
        String palavra = new String();
        String correta = aux.getTextoImagem();

        for(int i = 10; i<=14; i++){

            TextView t = findViewById(i);

            if(t != null) {

                palavra += t.getText();
            }
        }

        for(int i = 0; i<palavra.length(); i++){

            TextView t = findViewById(10 + i);
            Button b = btns.get(i);

            if(t != null && b != null) {

                if (palavra.charAt(i) != correta.charAt(i)) {

                    t.setText("_");
                    t.setTextColor(Color.rgb(101, 63, 33));

                    for (Button l : btns) {

                        if (l.getText().charAt(0) == palavra.charAt(i)) {

                            l.setVisibility(View.VISIBLE);
                            l.setClickable(true);
                            l.setBackgroundColor(Color.rgb(101, 63, 33)); //marrom
                            break;
                        }
                    }
                    vazio++;

                } else {

                    t.setTextColor(Color.BLACK);
                }
            }
        }

        if(vazio == -1){

            if(imagens.isEmpty()){
                Intent k = new Intent(this, Vitoria.class);
                startActivity(k);
            }
            else {
                proximaFigura();
            }
        }
    }

    @Override
    public void onClick(View view) {

        for (Button b : btns) {

            if (view.getId() == b.getId()) {

                b.setClickable(false);
                b.setVisibility(View.INVISIBLE);
                adiciona(b.getText().toString());

                if (vazio > 0) {

                    vazio--;

                } else {

                    verifica();
                }
            }
        }
    }

    @Override
    public void run() {
        progresso.setProgress(0);
        carregaJogo();
    }
}