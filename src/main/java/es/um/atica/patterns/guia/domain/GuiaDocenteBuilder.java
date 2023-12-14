package es.um.atica.patterns.guia.domain;

import java.util.ArrayList;
import java.util.List;

import es.um.atica.patterns.shared.domain.GuiaDocenteEstado;

public class GuiaDocenteBuilder {
    
    private String codigo;
    private String tipo;
    private int curso;
    private String idioma = "E"; // Default value
    private String estado = GuiaDocenteEstado.NOCUMPLIMENTADA.name();
    private Presentacion presentacion;
    private List<String> resultados = new ArrayList<>();
    private List<Competencia> competencias = new ArrayList<>();

    public GuiaDocenteBuilder codigo(String codigo) {
        this.codigo = codigo;
        return this;
    }

    public GuiaDocenteBuilder tipo(String tipo) {
        this.tipo = tipo;
        return this;
    }

    public GuiaDocenteBuilder curso(int curso) {
        this.curso = curso;
        return this;
    }

    public GuiaDocenteBuilder idioma(String idioma) {
        this.idioma = idioma;
        return this;
    }

    public GuiaDocenteBuilder estado(String estado) {
        this.estado = estado;
        return this;
    }

    public GuiaDocenteBuilder presentacion(String presentacion, boolean isTF) {
        this.presentacion = Presentacion.of(presentacion,isTF);
        return this;
    }

    public GuiaDocenteBuilder addResultado(String resultado) {
        this.resultados.add(resultado);
        return this;
    }

    public GuiaDocenteBuilder addCompetencia(String tipo, String texto) {
        this.competencias.add(Competencia.of(tipo,texto));
        return this;
    }

    public GuiaDocente build() {
        // Valida que el builder tiene lo necesario para construir un objeto RD822
        if (this.competencias.size()>0) return null;
        return GuiaDocente.build(this);
    }

    public String codigo() { return codigo; }
    public String idioma() { return idioma; }
    public String tipo() { return tipo; }
    public int curso() { return curso; }
    public String estado() { return estado.toString(); }
    public Presentacion presentacion() { return presentacion; }
    public List<String> resultados() { return resultados; }
    public List<Competencia> competencias() { return competencias; }

}
