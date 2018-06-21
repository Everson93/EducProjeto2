package com.tcc.everson.educprojeto.helper;

import android.content.Context;
import android.content.SharedPreferences;

public class Preferencias {

    private Context context;
    private SharedPreferences preferences;
    private String NOME_ARQUIVO = "projetoEduc.preferencias";
    private int MODE = 0;
    private SharedPreferences.Editor editor;

    private final String CHAVE_INDENTIFICADOR = "identificaUsuarioLogado";
    private final String CHAVE_NOME = "nomeUsuarioLogado";

    public Preferencias(Context context) {
        this.context = context;
        preferences = context.getSharedPreferences(NOME_ARQUIVO,MODE);

        editor = preferences.edit();
    }

    public  void salvarUsuarioPreferencias(String indenficadorUsuario,String nomeUsuario){
        editor.putString(CHAVE_INDENTIFICADOR,indenficadorUsuario);
        editor.putString(CHAVE_NOME,nomeUsuario);
        editor.commit();
    }
    public String getIdentificador(){
        return preferences.getString(CHAVE_INDENTIFICADOR,null);
    }
    public String getNome(){
        return preferences.getString(CHAVE_NOME,null);
    }
}
