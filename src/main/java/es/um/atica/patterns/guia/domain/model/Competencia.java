package es.um.atica.patterns.guia.domain.model;

public class Competencia {
    
    private String texto;
    private CompetenciaTipo tipo;

    private Competencia(String texto, CompetenciaTipo tipo) {
        this.texto = texto; this.tipo = tipo;
    }

    public static Competencia of(String tipo, String texto) {
        return new Competencia(texto, CompetenciaTipo.valueOfLabel(tipo));
    }

    public String texto() { return texto; }
    public String tipo() { return tipo.toString(); }

}
