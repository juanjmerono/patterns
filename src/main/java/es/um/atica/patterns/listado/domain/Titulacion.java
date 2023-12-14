package es.um.atica.patterns.listado.domain;

public class Titulacion {
    
    private TitulacionCodigo codigo;
    private TitulacionDescripcion descripcion;

    private Titulacion(TitulacionCodigo codigo, TitulacionDescripcion descripcion) {
        this.codigo = codigo; this.descripcion = descripcion;
    }

    public static Titulacion of (String codigo, String descripcion) {
        return new Titulacion(TitulacionCodigo.of(codigo), TitulacionDescripcion.of(descripcion));
    }

    public String codigo() { return codigo.value(); }
    public String descripcion() { return descripcion.value(); }

}
