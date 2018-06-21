package com.tcc.everson.educprojeto.activitys;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;
import com.tcc.everson.educprojeto.R;
import com.tcc.everson.educprojeto.db.ConfiguracaoFirebase;
import com.tcc.everson.educprojeto.entidades.Usuarios;
import com.tcc.everson.educprojeto.helper.Base64Custon;
import com.tcc.everson.educprojeto.helper.Preferencias;

public class CadastrosActivity extends AppCompatActivity {

    EditText edtNome,edtSobrenome,edtEmail,edtSenha,edtConfrimaSenha;
    Button cadastrar;
    Context context = this;
    Usuarios usuarios;
    FirebaseAuth autenticacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastros);

        edtNome = findViewById(R.id.edtnome);
        edtSobrenome = findViewById(R.id.edtSobreNome);
        edtEmail = findViewById(R.id.edtEmail);
        edtSenha = findViewById(R.id.edtSenha);
        edtConfrimaSenha = findViewById(R.id.edtConfirmarSenha);
        cadastrar = findViewById(R.id.cadastar);

        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validaCampos();
                if (edtSenha.getText().toString().equals(edtConfrimaSenha.getText().toString())){

                    usuarios = new Usuarios();
                    usuarios.setNome(edtNome.getText().toString());
                    usuarios.setSobrenome(edtSobrenome.getText().toString());
                    usuarios.setEmail(edtEmail.getText().toString());
                    usuarios.setSenha(edtSenha.getText().toString());
                    usuarios.setConfirmasenha(edtConfrimaSenha.getText().toString());

                    cadastrarUsuario();


                }else{
                    Toast.makeText(context,"Senhas não conferem",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    private void cadastrarUsuario(){

        autenticacao = ConfiguracaoFirebase.getAutenticacao();
        autenticacao.createUserWithEmailAndPassword(usuarios.getEmail(),
                usuarios.getSenha()).addOnCompleteListener((Activity) context, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(context,"Usuario Cadastrado com Sucesso",Toast.LENGTH_LONG).show();

                    String identificadorUsuario = Base64Custon.codificadorBase64(usuarios.getEmail());
                    FirebaseUser usuarioFirebase = task.getResult().getUser();
                    usuarios.setId(identificadorUsuario);
                    usuarios.salvar();

                    Preferencias preferencias = new Preferencias(CadastrosActivity.this);
                    preferencias.salvarUsuarioPreferencias(identificadorUsuario,usuarios.getNome());

                    abrirLogin();

                }else{
                    String erroExcecao = "";

                    try {
                        throw task.getException();
                    }catch (FirebaseAuthWeakPasswordException e ){
                        erroExcecao = "Digite uma Senha mais forte, contedo letras !!";
                    }catch (FirebaseAuthInvalidCredentialsException e ){
                        erroExcecao = "O email digitado e inválido !!";
                    }catch (FirebaseAuthUserCollisionException e ){
                        erroExcecao = "Email ja cadastrado tente novamente !!";
                    }catch (Exception e ){
                        erroExcecao = "Erro ao Efetua Cadastro !!";
                        e.printStackTrace();
                    }
                    Toast.makeText(context,"Erro: "+erroExcecao,Toast.LENGTH_LONG).show();
                }
            }
        });

    }
    public void abrirLogin(){
        Intent login = new Intent(context,MenuActivity.class);
        startActivity(login);
        finish();
    }
    private boolean validaCampos(){

        boolean teste = false;
        String nome = edtNome.getText().toString();
        String senha = edtSenha.getText().toString();
        String email = edtEmail.getText().toString();
        String confirmaSenha = edtConfrimaSenha.getText().toString();
        String sobreNome = edtSobrenome.getText().toString();


        if (campoVazio(nome)){
            edtNome.requestFocus();
            teste = true;
        }else if(campoVazio(senha)){
            edtSenha.requestFocus();
            teste = true;
        }else if(campoVazio(email)){
            edtEmail.requestFocus();
            teste = true;
        }else if(campoVazio(confirmaSenha)){
            edtConfrimaSenha.requestFocus();
            teste = true;
        }else if(campoVazio(sobreNome)){
            edtSobrenome.requestFocus();
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
}
