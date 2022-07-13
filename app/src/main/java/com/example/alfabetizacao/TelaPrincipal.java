package com.example.alfabetizacao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TelaPrincipal extends AppCompatActivity implements View.OnClickListener {

    private Button b,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        b = (Button) findViewById(R.id.soletrando);
        b.setOnClickListener(this);

        b2 = (Button) findViewById(R.id.silabas);
        b2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v == b) {

            String valor = new String("soletrando");
            Intent i = new Intent (this, MainActivity.class);
            Bundle so = new Bundle();
            so.putString("soletrando", valor);
            i.putExtras(so);
            startActivity(i);

        }else if(v==b2){

            String valor = new String("silabas");
            Intent i = new Intent (this, MainActivity.class);
            Bundle si = new Bundle();
            si.putString("silabas", valor);
            i.putExtras(si);
            startActivity(i);
        }
       // if(v == b){
         //   Intent i = new Intent(this, MainActivity.class);
           // startActivity(i);

        //}else if(v == b2){
          //  Intent i = new Intent(this, MainActivity.class);
            //startActivity(i);
        //}
    }

    private void getText() {
    }
}