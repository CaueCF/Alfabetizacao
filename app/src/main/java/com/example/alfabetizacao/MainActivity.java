package com.example.alfabetizacao;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Runnable {

    private ArrayList<Button> btns;
    private Button principal;
    private ArrayList<Elemento> imagens;
    private LinearLayout botoes, text;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botoes = (LinearLayout) findViewById(R.id.layoutBotoes);
        text =  (LinearLayout) findViewById(R.id.layoutText);
        principal = (Button) findViewById(R.id.buttonImagem);

        imagens = new ArrayList<Elemento>();
        carregaElemento();
        Collections.shuffle(imagens);

        btns = new ArrayList<Button>();

        handler = new Handler();
        handler.postDelayed(this, 2500);

    }

    public void carregaElemento(){
        Elemento e1 = new Elemento();
        e1.setImagem(R.drawable.casa);
        e1.setTextoImagem("Casa");
        imagens.add(e1);

        Elemento e2 = new Elemento();
        e2.setImagem(R.drawable.pato);
        e2.setTextoImagem("Pato");
        imagens.add(e2);

        Elemento e3 = new Elemento();
        e3.setImagem(R.drawable.vaca);
        e3.setTextoImagem("Vaca");
        imagens.add(e3);

        Elemento e4 = new Elemento();
        e4.setImagem(R.drawable.mesa);
        e4.setTextoImagem("Mesa");
        imagens.add(e4);

        Elemento e5 = new Elemento();
        e5.setImagem(R.drawable.lobo);
        e5.setTextoImagem("Lobo");
        imagens.add(e5);

        Elemento e6 = new Elemento();
        e6.setImagem(R.drawable.osso);
        e6.setTextoImagem("Osso");
        imagens.add(e6);

        Elemento e7 = new Elemento();
        e7.setImagem(R.drawable.bola);
        e7.setTextoImagem("Bola");
        imagens.add(e7);

        Elemento e8 = new Elemento();
        e8.setImagem(R.drawable.copo);
        e8.setTextoImagem("Copo");
        imagens.add(e8);

        Elemento e9 = new Elemento();
        e9.setImagem(R.drawable.gato);
        e9.setTextoImagem("Gato");
        imagens.add(e9);

        Elemento e10 = new Elemento();
        e10.setImagem(R.drawable.urso);
        e10.setTextoImagem("Urso");
        imagens.add(e10);
    }



    public void carregaJogo(){

        principal.setCompoundDrawablesRelativeWithIntrinsicBounds(null,
                getResources().getDrawable(imagens.get(0).getImagem()),null, null);

        principal.setClickable(false);

        int i = 0;
        for(Button b: btns){
            TextView t = new TextView(this);
            t.setId(10+i);
            b.setId(i);
            t.setBackgroundColor(Color.RED);
            t.setText(b.getText());
            t.setTextSize(28);
            botoes.addView(b);
            text.addView(t);
            i++;
        }
    }

    public void adicionaLetra(char c){

    }

    @Override
    public void onClick(View view) {
        for(Button b: btns) {
            if (view.getId() == b.getId()) {

            }
        }
    }


    @Override
    public void run() {
        for(char c: imagens.get(0).getTextoImagem().toCharArray()){
            Button atual = new Button(this);
            atual.setText(Character.toString(c));
            atual.setOnClickListener(this);
            btns.add(atual);
        }

        Collections.shuffle(btns);

        carregaJogo();
    }
}