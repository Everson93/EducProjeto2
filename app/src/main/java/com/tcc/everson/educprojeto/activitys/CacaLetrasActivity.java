package com.tcc.everson.educprojeto.activitys;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.tcc.everson.educprojeto.R;

import java.util.Random;

public class CacaLetrasActivity extends AppCompatActivity {
        Button bA, bB, bC, bD, bE, bF, bG,
                b1, b2, b3, b4, b5, b6, b7,
                c1, c2, c3, c4, c5, c6, c7,
                bH, bI, bJ, bK, bL, bM, bN,
                a1, a2, a3, a4, a5, a6, a7,
                bO, bP, bQ, bR, bS, bT, bU;
        int chance = 3;
        int acerto;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_caca_letras);

            bA = findViewById(R.id.bA);
            bB = findViewById(R.id.bB);
            bC = findViewById(R.id.bC);
            bD = findViewById(R.id.bD);
            bE = findViewById(R.id.bE);
            bF = findViewById(R.id.bF);
            bG = findViewById(R.id.bG);

            b1 = findViewById(R.id.b1);
            b2 = findViewById(R.id.b2);
            b3 = findViewById(R.id.b3);
            b4 = findViewById(R.id.b4);
            b5 = findViewById(R.id.b5);
            b6 = findViewById(R.id.b6);
            b7 = findViewById(R.id.b7);

            c1 = findViewById(R.id.c1);
            c2 = findViewById(R.id.c2);
            c3 = findViewById(R.id.c3);
            c4 = findViewById(R.id.c4);
            c5 = findViewById(R.id.c5);
            c6 = findViewById(R.id.c6);
            c7 = findViewById(R.id.c7);

            bH = findViewById(R.id.bH);
            bI = findViewById(R.id.bI);
            bJ = findViewById(R.id.bJ);
            bK = findViewById(R.id.bK);
            bL = findViewById(R.id.bL);
            bM = findViewById(R.id.bM);
            bN = findViewById(R.id.bN);

            a1 = findViewById(R.id.a1);
            a2 = findViewById(R.id.a2);
            a3 = findViewById(R.id.a3);
            a4 = findViewById(R.id.a4);
            a5 = findViewById(R.id.a5);
            a6 = findViewById(R.id.a6);
            a7 = findViewById(R.id.a7);

            bO = findViewById(R.id.bO);
            bP = findViewById(R.id.bP);
            bQ = findViewById(R.id.bQ);
            bR = findViewById(R.id.bR);
            bS = findViewById(R.id.bS);
            bT = findViewById(R.id.bT);
            bU = findViewById(R.id.bU);

            setarBotoes();
        }


        public boolean confereBotao(Button button) {
            boolean resultado;

            if (button.getText().toString() == "b") {
                acerto ++;
                PorterDuffColorFilter colorFilter = new PorterDuffColorFilter(Color.GREEN, PorterDuff.Mode.MULTIPLY);
                button.getBackground().setColorFilter(colorFilter);
                resultado = true;
                if (acerto==3){
                    AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(CacaLetrasActivity.this);
                    dialogBuilder.setTitle("Parabéns você acertou 3 vezes!")
                            .setMessage("Deseja jogar novamente?")
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
            } else {
                chance --;
                PorterDuffColorFilter colorFilter = new PorterDuffColorFilter(Color.RED, PorterDuff.Mode.MULTIPLY);
                button.getBackground().setColorFilter(colorFilter);
                if (chance == 0) {
                    AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(CacaLetrasActivity.this);
                    dialogBuilder.setTitle("Perdeu!")
                            .setMessage("Deseja jogar novamente?")
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
                resultado = false;
            }

            return resultado;
        }

        public void setarBotoes() {
            bA.setText(embaralha());
            bB.setText(embaralha());
            bC.setText(embaralha());
            bD.setText(embaralha());
            bE.setText(embaralha());
            bF.setText(embaralha());
            bG.setText(embaralha());

            b1.setText(embaralha());
            b2.setText(embaralha());
            b3.setText(embaralha());
            b4.setText(embaralha());
            b5.setText(embaralha());
            b6.setText(embaralha());
            b7.setText(embaralha());

            c1.setText(embaralha());
            c2.setText(embaralha());
            c3.setText(embaralha());
            c4.setText(embaralha());
            c5.setText(embaralha());
            c6.setText(embaralha());
            c7.setText(embaralha());

            bH.setText(embaralha());
            bI.setText(embaralha());
            bJ.setText(embaralha());
            bK.setText(embaralha());
            bL.setText(embaralha());
            bM.setText(embaralha());
            bN.setText(embaralha());

            a1.setText(embaralha());
            a2.setText(embaralha());
            a3.setText(embaralha());
            a4.setText(embaralha());
            a5.setText(embaralha());
            a6.setText(embaralha());
            a7.setText(embaralha());

            bO.setText(embaralha());
            bP.setText(embaralha());
            bQ.setText(embaralha());
            bR.setText(embaralha());
            bS.setText(embaralha());
            bT.setText(embaralha());
            bU.setText(embaralha());
        }

        public String embaralha() {
            Random random = new Random();
            int numero = random.nextInt(33);
            String letra = "";

            switch (numero) {
                case 0: letra="a";
                break;
                case 1: letra="b";
                break;
                case 2: letra="c";
                break;
                case 3: letra="d";
                break;
                case 4: letra="e";
                break;
                case 5: letra="f";
                break;
                case 6: letra="g";
                break;
                case 7: letra="h";
                break;
                case 8: letra="i";
                break;
                case 9: letra="j";
                break;
                case 10: letra="k";
                break;
                case 11: letra="l";
                break;
                case 12: letra="m";
                break;
                case 13: letra="n";
                break;
                case 14: letra="o";
                break;
                case 15: letra="p";
                break;
                case 16: letra="q";
                break;
                case 17: letra="r";
                break;
                case 18: letra="s";
                break;
                case 19: letra="t";
                break;
                case 20: letra="u";
                break;
                case 21: letra="v";
                break;
                case 22: letra="w";
                break;
                case 23: letra="x";
                break;
                case 24: letra="y";
                break;
                case 25: letra="z";
                break;
                case 26: letra="b";
                break;
                case 27: letra="b";
                break;
                case 28: letra="d";
                break;
                case 29: letra="b";
                    break;
                case 30: letra="b";
                    break;
                case 31: letra="d";
                    break;
                case 32: letra="d";
                    break;
                case 33: letra="d";
                    break;
            }
            return letra;
        }

        public void click1(View view) {
            confereBotao(bA);
        }

        public void click2(View view) {
            confereBotao(bB);
        }

        public void click3(View view) {
            confereBotao(bC);
        }

        public void click4(View view) {
            confereBotao(bD);
        }

        public void click5(View view) {
            confereBotao(bE);
        }

        public void click6(View view) {
            confereBotao(bF);
        }

        public void click7(View view) {
            confereBotao(bG);
        }

        public void click8(View view) {
            confereBotao(b7);
        }

        public void click9(View view) {
            confereBotao(b6);
        }

        public void click10(View view) {
            confereBotao(b5);
        }

        public void click11(View view) {
            confereBotao(b4);
        }

        public void click12(View view) {
            confereBotao(b3);
        }

        public void click13(View view) {
            confereBotao(b2);
        }

        public void click14(View view) {
            confereBotao(b1);
        }

        public void click15(View view) {
            confereBotao(c7);
        }

        public void click16(View view) {
            confereBotao(c6);
        }

        public void click17(View view) {
            confereBotao(c5);
        }

        public void click18(View view) {
            confereBotao(c4);
        }

        public void click19(View view) {
            confereBotao(c3);
        }

        public void click20(View view) {
            confereBotao(c2);
        }

        public void click21(View view) {
            confereBotao(c1);
        }

        public void click22(View view) {
            confereBotao(bH);
        }

        public void click23(View view) {
            confereBotao(bI);
        }

        public void click24(View view) {
            confereBotao(bJ);
        }

        public void click25(View view) {
            confereBotao(bK);
        }

        public void click26(View view) {
            confereBotao(bL);
        }

        public void click27(View view) {
            confereBotao(bM);
        }

        public void click28(View view) {
            confereBotao(bN);
        }

        public void click29(View view) {
            confereBotao(a7);
        }

        public void click30(View view) {
            confereBotao(a6);
        }

        public void click31(View view) {
            confereBotao(a5);
        }

        public void click32(View view) {
            confereBotao(a4);
        }

        public void click33(View view) {
            confereBotao(a3);
        }

        public void click34(View view) {
            confereBotao(a2);
        }

        public void click35(View view) {
            confereBotao(a1);
        }

        public void click36(View view) {
            confereBotao(bO);
        }

        public void click37(View view) {
            confereBotao(bP);
        }

        public void click38(View view) {
            confereBotao(bQ);
        }

        public void click39(View view) {
            confereBotao(bR);
        }

        public void click40(View view) {
            confereBotao(bS);
        }

        public void click41(View view) {
            confereBotao(bT);
        }

        public void click42(View view) {
            confereBotao(bU);
        }

        public void voltar(View view) {
            finish();
        }
    }
