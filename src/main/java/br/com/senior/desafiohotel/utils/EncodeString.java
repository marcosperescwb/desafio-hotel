package br.com.senior.desafiohotel.utils;

public class EncodeString {

    public static String converter(String palavra){                                         // Tratamento dos caracteres
        char caracter;
        StringBuffer n = new StringBuffer(palavra.length());
        for (int i = 0 ; i < palavra.length(); i++) {
            caracter = palavra.charAt(i);
            switch (caracter) {
                case '+':
                    n.append(" ");
                    break;
                default:
                    n.append(caracter);
            }
        }
        return n.toString();
    }
}
