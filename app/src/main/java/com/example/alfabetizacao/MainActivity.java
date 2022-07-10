package com.example.alfabetizacao;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botoes = (LinearLayout) findViewById(R.id.layoutBotoes);
        text =  (LinearLayout) findViewById(R.id.layoutText);
        principal = (Button) findViewById(R.id.buttonImagem);
        progresso = (ProgressBar) findViewById(R.id.progressBar);

        progresso.setPadding(100,0,100,0);

        imagens = new ArrayList<Elemento>();
        carregaElemento();
        Collections.shuffle(imagens);

        progresso.setMax(imagens.size());

        aux = imagens.get(0);
        btns = new ArrayList<Button>();
        vazio = aux.getTextoImagem().length()-1;

        handler = new Handler();
        handler.postDelayed(this, 2500);

    }

    public void carregaElemento(){
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

    public void carregaJogo(){

        for(char c: aux.getTextoImagem().toCharArray()){
            Button atual = new Button(this);
            atual.setText(Character.toString(c));
            atual.setOnClickListener(this);
            btns.add(atual);
        }

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

    public void adicionaLetra(char c){
        for(int i = 10; i<15; i++){
            TextView t = findViewById(i);
            if(t.getText() == "_"){
                t.setText(Character.toString(c));
                break;
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

                    /*for(Button l: btns){

                        if(l.getText().charAt(0)==palavra.charAt(i)){

                            b.setBackgroundColor(Color.GREEN);
                            b.setTextColor(Color.BLACK);
                            break;
                        }
                    }*/

                }
            }
        }

        if(vazio == -1){

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {

                public void run() {

                    if(!imagens.isEmpty()) {

                        imagens.remove(0);
                        aux = imagens.get(0);
                        text.removeAllViews();
                        botoes.removeAllViews();
                        btns.clear();

                        carregaJogo();

                        int passo = progresso.getProgress()+1;
                        progresso.setProgress(passo);
                        vazio = aux.getTextoImagem().length() - 1;
                    }
                }
            }, 5000);
        }
    }

    @Override
    public void onClick(View view) {

        for (Button b : btns) {

            if (view.getId() == b.getId()) {

                b.setClickable(false);
                b.setVisibility(View.INVISIBLE);
                adicionaLetra(b.getText().charAt(0));

                if (vazio > 0) {

                    vazio--;

                } else {

                    verificaPalavra();
                }
            }
        }
    }

    @Override
    public void run() {
        carregaJogo();
        progresso.setProgress(0);
    }
}