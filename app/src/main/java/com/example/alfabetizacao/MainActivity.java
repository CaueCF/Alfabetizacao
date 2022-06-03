package com.example.alfabetizacao;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ArrayList<Button> btns;
    private Button principal;
    private ArrayList<Elemento> imagens;
    private LinearLayout botoes, text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botoes = (LinearLayout) findViewById(R.id.layoutBotoes);
        text =  (LinearLayout) findViewById(R.id.layoutText);
        principal = (Button) findViewById(R.id.buttonImagem);

        imagens = new ArrayList<Elemento>();
        carregaElemento();

        for(char c: imagens.get(0).getTextoImagem().toCharArray()){
            Button atual = new Button(this);
            atual.setText(c);
            atual.setOnClickListener(this);
            btns.add(atual);
        }

        Collections.shuffle(btns);

        carregaJogo();

    }

    public void carregaElemento(){
        Elemento e1 = new Elemento();
        e1.setImagem(R.drawable.casa);
        e1.setTextoImagem("Casa");
        imagens.add(e1);
    }

    public void carregaJogo(){

        principal.setCompoundDrawablesRelativeWithIntrinsicBounds(null,
                getResources().getDrawable(imagens.get(0).getImagem()),null, null);

        int i = 0;
        for(Button b: btns){

            botoes.addView(b);
            TextView t = new TextView(this);
            t.setId(10+i);
            b.setId(i);
            text.addView(t);
            i++;
        }
    }

    public void adicionaLetra(char c){
    }

    @Override
    public void onClick(View view) {

    }



}