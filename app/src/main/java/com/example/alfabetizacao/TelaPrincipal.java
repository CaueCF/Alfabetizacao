package com.example.alfabetizacao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaPrincipal extends AppCompatActivity implements View.OnClickListener {

    private Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        b = (Button) findViewById(R.id.soletrando);
        b.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v == b){
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }
    }
}