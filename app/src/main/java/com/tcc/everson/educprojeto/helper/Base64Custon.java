package com.tcc.everson.educprojeto.helper;

import android.util.Base64;

public class Base64Custon {

    public static String codificadorBase64(String texto){
        return Base64.encodeToString(texto.getBytes(),Base64.DEFAULT).replaceAll("(\\n|\\r)","");
    }

    public static String decodificadorBase64(String textoCodificado){
        return new String(Base64.decode(textoCodificado,Base64.DEFAULT));
    }
}
