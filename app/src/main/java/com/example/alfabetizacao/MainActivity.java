package com.example.alfabetizacao;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //public ArrayList<Button> btns;
    private Button l1, l2, l3, l4;
    private TextView palavra;
    private ArrayList<Elemento> imagens;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imagens = new ArrayList<Elemento>();
        carregaElemento();


    }

    public void carregaElemento(){
        Elemento e1 = new Elemento();
        e1.setImagem(R.drawable.casa);
        e1.setTextoImagem("Casa");
        imagens.add(e1);



    }


}