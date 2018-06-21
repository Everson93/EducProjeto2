package com.tcc.everson.educprojeto.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.tcc.everson.educprojeto.R;

public class JogosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogos);
    }

    public void jogoForca(View view){

        Intent jogoForca = new Intent(this, AcionaJogoForcaActivity.class);
        startActivity(jogoForca);

    }

    public void fechar(View view) {
        finish();
    }

    public void jogoCaca(View view) {
        Intent jogoCaca = new Intent(this, CacaLetrasActivity.class);
        startActivity(jogoCaca);
    }
}
