package com.tcc.everson.educprojeto.entidades;

import java.util.Random;

public class Palavras {

    private static String[] esportes = new String[] {
            "FUTEBOL", "TENIS", "VOLEI",
            "GOLFE", "BASQUETE", "HANDEBOL"
    };

    private static String[] paises = new String[] {
            "JAPÃO", "BRASIL", "CHINA",
            "PORTUGAL", "ALEMANHA", "ITALIA"
    };

    private static String[] animais = new String[] {
            "ELEFANTE", "ZEBRA", "MACACO",
            "CACHORRO", "GATO", "CAVALO"
    };

    private static String[] transportes = new String[] {
            "AVIÃO", "AERONAVE", "AUTOMÓVEL",
            "MOTOCICLETA", "BICICLETA", "NAVIO"
    };

    private static String[][] temas = new String[][] {
            esportes, paises, animais, transportes
    };

    public static int sorteioTema(){                     //sorteia um numero dependendo da quantidade de posicoes no array
        int randomTema = new Random().nextInt(temas.length);
        return randomTema;
    }

    public static int sorteioPalavra(){                  //sorteia um numero dependendo da quantidade de posicoes no array
        int randomPalavra = new Random().nextInt(animais.length);
        return randomPalavra;
    }

    public static String sorteio() {
        int numeroTema = sorteioTema();
        int numeroPalavra = sorteioPalavra();
        String tema = "";
        switch (numeroTema) {
            case 0 :
                tema = "ESPORTES";
                break;
            case 1 :
                tema = "PAISES";
                break;
            case 2 :
                tema = "ANIMAIS";
                break;
            case 3 :
                tema = "TRANSPORTES";
                break;
        }
        String palavraSorteada = temas[numeroTema][numeroPalavra];
        return palavraSorteada+ "-" + tema;
    }


}

