package es.um.atica.patterns.guia.domain;

public class Resultado {
    
    private String texto;

    private Resultado(String texto) {
        this.texto = texto;
    }

    public static Resultado of(String texto) {
        return new Resultado(texto);
    }

    public String texto() { return texto; }

}
