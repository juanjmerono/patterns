package es.um.atica.patterns.guia.domain.model;

public class Presentacion {
    
    private String texto;
    private boolean editable;

    protected Presentacion(String texto, boolean editable) {
        this.texto = texto; this.editable = editable;
    }

    public static Presentacion of(String texto, boolean editable) {
        return new Presentacion(texto, editable);
    }

    public boolean isEditable() { return editable; }
    public String texto() { return texto; }

}
