package com.tcc.everson.educprojeto.activitys;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.tcc.everson.educprojeto.entidades.Palavras;
import com.tcc.everson.educprojeto.R;
import com.tcc.everson.educprojeto.entidades.Replace;


public class JogoForcaActivity extends AppCompatActivity implements View.OnClickListener {

    private String palavraSecreta, tracos;
    private int nTentativas;
    private char letra;
    String splitPalavra;
    String splitTema;
    Palavras palavras;
    String teste;
    Context context = this;
    MediaPlayer audio,acertou,errou;

    TextView tvPalavra;
    TextView tvDica;
    ImageView forca;
    Button dica1,dica2,dica3;
    Button bA, bB, bC, bD, bE, bF, bG, bH, bI, bJ, bK, bL, bM,
            bN, bO, bP, bQ, bR, bS, bT, bU, bV, bW, bX, bY, bZ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo_forca);

        dica1 = findViewById(R.id.dica1);
        dica2 = findViewById(R.id.dica2);
        dica3 = findViewById(R.id.dica3);

       iniciarObjetos();
       iniciarJogo();

    }

    public void onClick(View v) {
        verificarClick(v);

        boolean acerto = verificarAcerto();

        if (!acerto) {
            nTentativas--;
            switch (nTentativas) {
                case 5:
                    forca.setImageResource(R.drawable.forca_0);
                    break;
                case 4:
                    forca.setImageResource(R.drawable.forca_1);
                    break;
                case 3:
                    forca.setImageResource(R.drawable.forca_2);
                    break;
                case 2:
                    forca.setImageResource(R.drawable.forca_3);
                    break;
                case 1:
                    forca.setImageResource(R.drawable.forca_4);
                    break;
                case 0:
                    forca.setImageResource(R.drawable.forca_5);
                    desabilitarBotoes();
                    errou.create(this,R.raw.silvioerro).start();
                    AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(JogoForcaActivity.this);
                    dialogBuilder.setTitle("Perdeu!")
                            .setMessage("A palavra secreta era: "+palavraSecreta+" \n Deseja jogar novamente?")
                            .setCancelable(false)
                            .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface arg0, int arg1) {
                                    Intent intent = getIntent();
                                    finish();
                                    startActivity(intent);
                                }
                            })
                            .setNegativeButton("Não", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface arg0, int arg1) {
                                    finish();
                                }
                            });
                    AlertDialog dialog = dialogBuilder.create();
                    dialog.show();
            }
        }

        if (Replace.replaceAll(tracos, " ", "").equalsIgnoreCase(palavraSecreta)) {
            desabilitarBotoes();
            acertou.create(this,R.raw.silvio).start();
            AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
            AlertDialog.Builder builder = dialogBuilder;
            builder.setTitle("Parabéns!");
            builder.setMessage("Deseja jogar novamente?");
            builder.setCancelable(false);
            builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface arg0, int arg1) {
                    Intent intent = getIntent();
                    finish();
                    startActivity(intent);
                }
            });
            builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface arg0, int arg1) {
                    finish();
                }
            });
            dialogBuilder.create().show();
        }
    }

    private void iniciarObjetos() {
        tvPalavra = findViewById(R.id.tvPalavra);
        tvDica = findViewById(R.id.tvDica);
        forca = findViewById(R.id.ivForca);

        bA = findViewById(R.id.bA);
        bB = findViewById(R.id.bB);
        bC = findViewById(R.id.bC);
        bD = findViewById(R.id.bD);
        bE = findViewById(R.id.bE);
        bF = findViewById(R.id.bF);
        bG = findViewById(R.id.bG);
        bH = findViewById(R.id.bH);
        bI = findViewById(R.id.bI);
        bJ = findViewById(R.id.bJ);
        bK = findViewById(R.id.bK);
        bL = findViewById(R.id.bL);
        bM = findViewById(R.id.bM);
        bN = findViewById(R.id.bN);
        bO = findViewById(R.id.bO);
        bP = findViewById(R.id.bP);
        bQ = findViewById(R.id.bQ);
        bR = findViewById(R.id.bR);
        bS = findViewById(R.id.bS);
        bT = findViewById(R.id.bT);
        bU = findViewById(R.id.bU);
        bV = findViewById(R.id.bV);
        bW = findViewById(R.id.bW);
        bX = findViewById(R.id.bX);
        bY = findViewById(R.id.bY);
        bZ = findViewById(R.id.bZ);
        bA.setOnClickListener(this);
        bB.setOnClickListener(this);
        bC.setOnClickListener(this);
        bD.setOnClickListener(this);
        bE.setOnClickListener(this);
        bF.setOnClickListener(this);
        bG.setOnClickListener(this);
        bH.setOnClickListener(this);
        bI.setOnClickListener(this);
        bJ.setOnClickListener(this);
        bK.setOnClickListener(this);
        bL.setOnClickListener(this);
        bM.setOnClickListener(this);
        bN.setOnClickListener(this);
        bO.setOnClickListener(this);
        bP.setOnClickListener(this);
        bQ.setOnClickListener(this);
        bR.setOnClickListener(this);
        bS.setOnClickListener(this);
        bT.setOnClickListener(this);
        bU.setOnClickListener(this);
        bV.setOnClickListener(this);
        bW.setOnClickListener(this);
        bX.setOnClickListener(this);
        bY.setOnClickListener(this);
        bZ.setOnClickListener(this);
    }

    private void verificarClick(View v) {
        switch (v.getId()) {
            case R.id.bA:
                bA.setEnabled(false); letra = 'A'; break;
            case R.id.bB:
                bB.setEnabled(false); letra = 'B'; break;
            case R.id.bC:
                bC.setEnabled(false); letra = 'C'; break;
            case R.id.bD:
                bD.setEnabled(false); letra = 'D'; break;
            case R.id.bE:
                bE.setEnabled(false); letra = 'E'; break;
            case R.id.bF:
                bF.setEnabled(false); letra = 'F'; break;
            case R.id.bG:
                bG.setEnabled(false); letra = 'G'; break;
            case R.id.bH:
                bH.setEnabled(false); letra = 'H'; break;
            case R.id.bI:
                bI.setEnabled(false); letra = 'I'; break;
            case R.id.bJ:
                bJ.setEnabled(false); letra = 'J'; break;
            case R.id.bK:
                bK.setEnabled(false); letra = 'K'; break;
            case R.id.bL:
                bL.setEnabled(false); letra = 'L'; break;
            case R.id.bM:
                bM.setEnabled(false); letra = 'M'; break;
            case R.id.bN:
                bN.setEnabled(false); letra = 'N'; break;
            case R.id.bO:
                bO.setEnabled(false); letra = 'O'; break;
            case R.id.bP:
                bP.setEnabled(false); letra = 'P'; break;
            case R.id.bQ:
                bQ.setEnabled(false); letra = 'Q'; break;
            case R.id.bR:
                bR.setEnabled(false); letra = 'R'; break;
            case R.id.bS:
                bS.setEnabled(false); letra = 'S'; break;
            case R.id.bT:
                bT.setEnabled(false); letra = 'T'; break;
            case R.id.bU:
                bU.setEnabled(false); letra = 'U'; break;
            case R.id.bV:
                bV.setEnabled(false); letra = 'V'; break;
            case R.id.bW:
                bW.setEnabled(false); letra = 'W'; break;
            case R.id.bX:
                bX.setEnabled(false); letra = 'X'; break;
            case R.id.bY:
                bY.setEnabled(false); letra = 'Y'; break;
            case R.id.bZ:
                bZ.setEnabled(false); letra = 'Z'; break;
        }
    }

    private void habilitarBotoes() {
        bA.setEnabled(true);
        bB.setEnabled(true);
        bC.setEnabled(true);
        bD.setEnabled(true);
        bE.setEnabled(true);
        bF.setEnabled(true);
        bG.setEnabled(true);
        bH.setEnabled(true);
        bI.setEnabled(true);
        bJ.setEnabled(true);
        bK.setEnabled(true);
        bL.setEnabled(true);
        bM.setEnabled(true);
        bN.setEnabled(true);
        bO.setEnabled(true);
        bP.setEnabled(true);
        bQ.setEnabled(true);
        bR.setEnabled(true);
        bS.setEnabled(true);
        bT.setEnabled(true);
        bU.setEnabled(true);
        bV.setEnabled(true);
        bW.setEnabled(true);
        bX.setEnabled(true);
        bY.setEnabled(true);
        bZ.setEnabled(true);
    }

    private void desabilitarBotoes() {
        bA.setEnabled(false);
        bB.setEnabled(false);
        bC.setEnabled(false);
        bD.setEnabled(false);
        bE.setEnabled(false);
        bF.setEnabled(false);
        bG.setEnabled(false);
        bH.setEnabled(false);
        bI.setEnabled(false);
        bJ.setEnabled(false);
        bK.setEnabled(false);
        bL.setEnabled(false);
        bM.setEnabled(false);
        bN.setEnabled(false);
        bO.setEnabled(false);
        bP.setEnabled(false);
        bQ.setEnabled(false);
        bR.setEnabled(false);
        bS.setEnabled(false);
        bT.setEnabled(false);
        bU.setEnabled(false);
        bV.setEnabled(false);
        bW.setEnabled(false);
        bX.setEnabled(false);
        bY.setEnabled(false);
        bZ.setEnabled(false);
    }

    public void iniciarJogo() {
        String msg = Palavras.sorteio();
        String[] palavra = msg.split("-");  //split divide uma string pelo caracter passado por parametro
        splitPalavra = palavra[0];                //primeira palavra dividida pelo split na primeira posicao do array
        splitTema = palavra[1];                   //segunda palavra do split na segunda posicao do array
        palavraSecreta = splitPalavra;
        tvDica.setText(splitTema);
        final String dicaA = splitPalavra.substring(0,1);
        final String dicaB = splitPalavra.substring(1,2);
        int tamanho = splitPalavra.length();
        final String dicaC= splitPalavra.substring(tamanho-1, tamanho);



        dica1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int dicaN1 = getResources().getIdentifier("letra".concat(dicaA).toLowerCase(),"raw", "com.tcc.everson.educprojeto");
                setAudio(dicaN1);
            }
        });
        dica2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int dicaN1 = getResources().getIdentifier("letra".concat(dicaB).toLowerCase(),"raw", "com.tcc.everson.educprojeto");
                setAudio(dicaN1);

            }
        });
        dica3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int dicaN1 = getResources().getIdentifier("letra".concat(dicaC).toLowerCase(),"raw","com.tcc.everson.educprojeto");
                setAudio(dicaN1);

            }
        });


        procedimentosInicio();
    }

    private void procedimentosInicio() {
        nTentativas = 6;
        tracos = "";
        letra = ' ';
        for (int x = 0; x < palavraSecreta.length(); x++) {
            if (palavraSecreta.charAt(x) == '-') {
                tracos += " - ";
            }else if (palavraSecreta.charAt(x) == ' ') {
                tracos += "   ";
            }else {
                tracos += " _ ";
            }
        }
        habilitarBotoes();
        tvPalavra.setText(tracos);
        forca.setImageResource(R.drawable.f);
    }

    private boolean verificarAcerto() {
        boolean acerto = false;
        for (int x = 0; x < palavraSecreta.length(); x++) {
            char tmp = ' ';
            char vogal = palavraSecreta.charAt(x);
            if (vogal == 'Á') tmp = 'A';
            if (vogal == 'Ã') tmp = 'A';
            if (vogal == 'À') tmp = 'A';
            if (vogal == 'É') tmp = 'E';
            if (vogal == 'Í') tmp = 'I';
            if (vogal == 'Ó') tmp = 'O';
            if (vogal == 'Ô') tmp = 'O';
            if (vogal == 'Õ') tmp = 'O';
            if (vogal == 'Ú') tmp = 'U';
            if (vogal == 'Ç') tmp = 'C';
            if (vogal == letra || tmp == letra) {
                tracos = tracos.substring(0, 3 * x + 1) + vogal + tracos.substring(3 * x + 2);
                acerto = true;
            }
        }
        tvPalavra.setText(tracos);

        return acerto;
    }

    public void setAudio(int letras){
        audio.create(this,letras).start();
    }
}
