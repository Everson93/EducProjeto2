package com.tcc.everson.educprojeto.entidades;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;
import com.tcc.everson.educprojeto.db.ConfiguracaoFirebase;

import java.util.HashMap;
import java.util.Map;

public class Usuarios {

    private String id;
    private String nome;
    private String Sobrenome;
    private String email;
    private String senha;
    private String Confirmasenha;

    public String getConfirmasenha() {
        return Confirmasenha;
    }

    public void setConfirmasenha(String confirmasenha) {
        Confirmasenha = confirmasenha;
    }

    public Usuarios() {
    }
    public void salvar(){
        DatabaseReference referenciaFirebase = ConfiguracaoFirebase.getReferenceFirebase();
        referenciaFirebase.child("usuario").child(String.valueOf(getId())).setValue(this);
    }
    @Exclude

    public Map<String,Object> toMap(){

        HashMap<String,Object> hashMapUsuario = new HashMap<>();

        hashMapUsuario.put("id",getId());
        hashMapUsuario.put("nome",getNome());
        hashMapUsuario.put("sobrenome",getSobrenome());
        hashMapUsuario.put("email",getEmail());
        hashMapUsuario.put("senha",getSenha());

        return hashMapUsuario;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getSobrenome() {
        return Sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        Sobrenome = sobrenome;
    }
}
