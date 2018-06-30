package com.tcc.everson.educprojeto.activitys;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.tcc.everson.educprojeto.R;
import com.tcc.everson.educprojeto.db.ConfiguracaoFirebase;
import com.tcc.everson.educprojeto.entidades.Usuarios;

public class MenuActivity extends AppCompatActivity {

    TextView cadastrar;
    EditText usuarioEntra,senhaEntra;
    Button cadastro;
    public RelativeLayout logar;
    private FirebaseAuth autenticacao;
    private Usuarios usuarios;
    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        cadastrar = findViewById(R.id.cadastar);
        usuarioEntra = findViewById(R.id.usuarioLoga);
        senhaEntra = findViewById(R.id.senhaLoga);
        logar = findViewById(R.id.logar);

        logar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (!validaCampos()) {
                    if (verificaConexao()) {
                        return;


                    } else {
                        usuarios = new Usuarios();
                        usuarios.setEmail(usuarioEntra.getText().toString());
                        usuarios.setSenha(senhaEntra.getText().toString());

                        loginvalida();

                    }

                }else{
                    validaCampos();
                }
            }
        });

        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cadastro = new Intent(context, CadastrosActivity.class);
                startActivity(cadastro);
                finish();
            }
        });
    }
    private void loginvalida(){
        autenticacao = ConfiguracaoFirebase.getAutenticacao();
        autenticacao.signInWithEmailAndPassword(usuarios.getEmail(),usuarios.getSenha()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    abrirMenu();
                    Toast.makeText(context,"Login Efetuado com Sucesso!!",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(context,"Login Errado verifique Email ou Senha!!",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    private void abrirMenu(){
        Intent menujogos = new Intent(context,JogosActivity.class);
        startActivity(menujogos);
        finish();
    }
    private boolean validaCampos(){

        boolean teste = false;
        String nome = usuarioEntra.getText().toString();
        String senha = senhaEntra.getText().toString();


        if (campoVazio(nome)){
            usuarioEntra.requestFocus();
            teste = true;
        }else if(campoVazio(senha)){
            senhaEntra.requestFocus();
            teste = true;
        }
        if (teste){
            AlertDialog.Builder menssagem = new AlertDialog.Builder(this);
            menssagem.setTitle("Aviso");
            menssagem.setMessage("Há campos vazios ou inválidos!!");
            menssagem.setNeutralButton("OK", null);
            menssagem.show();
        }
        return teste;
    }
    private boolean campoVazio(String campo){

        boolean resultado = (TextUtils.isEmpty(campo) || campo.trim().isEmpty());//verifica se esta vazio e sem espaços
        return resultado;

    }
    public  boolean verificaConexao() {
        boolean conectado;
        ConnectivityManager conectivtyManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (conectivtyManager.getActiveNetworkInfo() != null
                && conectivtyManager.getActiveNetworkInfo().isAvailable()
                && conectivtyManager.getActiveNetworkInfo().isConnected()) {
            conectado = true;
        } else {
            conectado = false;
            Toast.makeText(this,"Verefique conexão!!",Toast.LENGTH_SHORT).show();
        }
        return conectado;
    }
}
