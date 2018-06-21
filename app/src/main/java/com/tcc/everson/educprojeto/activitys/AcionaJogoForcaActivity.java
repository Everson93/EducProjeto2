package com.tcc.everson.educprojeto.activitys;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.tcc.everson.educprojeto.R;
import com.tcc.everson.educprojeto.activitys.JogoForcaActivity;

public class AcionaJogoForcaActivity extends AppCompatActivity implements View.OnClickListener{

    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aciona_jogo_forca);

        Button bStart1 = findViewById(R.id.bStart1);
        Button bSair   = findViewById(R.id.bSair);
        bStart1.setOnClickListener(this);
        bSair.setOnClickListener( this);

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bStart1:
                Intent i = new Intent(this, JogoForcaActivity.class);
                startActivity(i);
                break;
            case R.id.bSair:
                finish();
        }
    }
}
