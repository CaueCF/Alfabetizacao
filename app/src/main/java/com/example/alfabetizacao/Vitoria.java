package com.example.alfabetizacao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Vitoria extends AppCompatActivity implements View.OnClickListener {

    private Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vitoria);

        b = (Button) findViewById(R.id.telaPrincipal);
        b.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == b){
            Intent i = new Intent(this, TelaPrincipal.class);
            startActivity(i);
        }
    }
}