package es.um.atica.patterns.listado.domain;

public class GuiaDocenteResumidaBuilder {
    
    private String codigoTitulacion;
    private String descripcionTitulacion;

    private String codigoAsignatura;
    private String descripcionAsignatura;

    private int curso;
    private String idioma = "E"; // Default value
    private String estado;
    private String tipo;
    private String categoria;

    private boolean itinerario = false;
    private boolean bilingue = false;
    private boolean centroAdscrito = false;


    public GuiaDocenteResumidaBuilder codigoTitulacion(String codigoTitulacion) {
        this.codigoTitulacion = codigoTitulacion;
        return this;
    }

    public GuiaDocenteResumidaBuilder descripcionTitulacion(String descripcionTitulacion) {
        this.descripcionTitulacion = descripcionTitulacion;
        return this;
    }

    public GuiaDocenteResumidaBuilder codigoAsignatura(String codigoAsignatura) {
        this.codigoAsignatura = codigoAsignatura;
        return this;
    }

    public GuiaDocenteResumidaBuilder descripcionAsignatura(String descripcionAsignatura) {
        this.descripcionAsignatura = descripcionAsignatura;
        return this;
    }

    public GuiaDocenteResumidaBuilder tipo(String tipo) {
        this.tipo = tipo;
        return this;
    }

    public GuiaDocenteResumidaBuilder categoria(String categoria) {
        this.categoria = categoria;
        return this;
    }

    public GuiaDocenteResumidaBuilder curso(int curso) {
        this.curso = curso;
        return this;
    }

    public GuiaDocenteResumidaBuilder idioma(String idioma) {
        this.idioma = idioma;
        return this;
    }

    public GuiaDocenteResumidaBuilder estado(String estado) {
        this.estado = estado;
        return this;
    }

    public GuiaDocenteResumidaBuilder itinerario(boolean itinerario) {
        this.itinerario = itinerario;
        return this;
    }

    public GuiaDocenteResumidaBuilder bilingue(boolean bilingue) {
        this.bilingue = bilingue;
        return this;
    }
    public GuiaDocenteResumidaBuilder centroAdscrito(boolean centroAdscrito) {
        this.centroAdscrito = centroAdscrito;
        return this;
    }

    public GuiaDocenteResumida build() {
        // Valida que el builder tiene lo necesario para construir un objeto
        return GuiaDocenteResumida.of(this);
    }

    public String codigoTitulacion() { return codigoTitulacion; }
    public String descripcionTitulacion() { return descripcionTitulacion; }
    public String codigoAsignatura() { return codigoAsignatura; }
    public String descripcionAsignatura() { return descripcionAsignatura; }
    public String idioma() { return idioma; }
    public String tipo() { return tipo; }
    public String categoria() { return categoria; }
    public int curso() { return curso; }
    public String estado() { return estado.toString(); }
    public boolean itinerario() { return itinerario; }
    public boolean bilingue() { return bilingue; }
    public boolean centroAdscrito() { return centroAdscrito; }

}
