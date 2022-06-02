package com.example.alfabetizacao;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ArrayList<Button> btns;
    private Button l1, l2, l3, l4;
    private TextView palavra;
    private ArrayList<Elemento> imagens;
    private LinearLayout imagem, botoes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imagem = (LinearLayout) findViewById(R.id.layoutImagem);
        botoes = (LinearLayout) findViewById(R.id.layoutBotoes);

        imagens = new ArrayList<Elemento>();
        carregaElemento();

        for(char c: imagens.get(0).getTextoImagem().toCharArray()){
            Button atual = new Button(this);
            atual.setText(c);
            atual.setOnClickListener(this);
            btns.add(atual);
        }

        Collections.shuffle(btns);

    }

    public void carregaElemento(){
        Elemento e1 = new Elemento();
        e1.setImagem(R.drawable.casa);
        e1.setTextoImagem("Casa");
        imagens.add(e1);
    }


    @Override
    public void onClick(View view) {

    }



}