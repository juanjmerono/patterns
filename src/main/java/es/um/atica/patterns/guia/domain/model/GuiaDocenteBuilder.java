package es.um.atica.patterns.guia.domain.model;

import java.util.ArrayList;
import java.util.List;

import es.um.atica.patterns.guia.domain.policy.BuilderPolicyList;
import es.um.atica.patterns.shared.domain.AsignaturaCategoria;
import es.um.atica.patterns.shared.domain.GuiaDocenteEstado;

public class GuiaDocenteBuilder {
    
    // Apartados fijos o datos necesarios para construir la guia
    private String codigo;
    private String tipo;
    private int curso;
    private String idioma = "E"; // Default value
    private String estado = GuiaDocenteEstado.NOCUMPLIMENTADA.name(); // Default value
    private String categoria;
    private boolean isRD822 = false;

    // Apartados variables
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

    public GuiaDocenteBuilder presentacion(String presentacion, boolean isEditable) {
        this.presentacion = Presentacion.of(presentacion,isEditable);
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

    public GuiaDocenteBuilder categoria(String categoria) {
        this.categoria = categoria;
        return this;
    }

    public GuiaDocenteBuilder isRD822(boolean isRD822) {
        this.isRD822 = isRD822;
        return this;
    }

    public GuiaDocente build() {
        // Valida que el builder tiene lo necesario para construir un objeto correcto
        return GuiaDocente.build(this);
    }

    public GuiaDocente buildWithDefaultPolicies(BuilderPolicyList policyList) {
        // Valida que el builder tiene lo necesario para construir un objeto correcto
        // Inicializa el builder según las políticas aplicables
        policyList
            .applicablePolicies(this)
            .stream()
            .forEach(p->p.applyPolicy(this));
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
    public boolean isTfg() { return AsignaturaCategoria.TFG.label().equals(categoria); }
    public boolean isTfm() { return AsignaturaCategoria.TFM.label().equals(categoria); }
    public boolean isPracticum() { return AsignaturaCategoria.PRACTICUM.label().equals(categoria); }
    public boolean isRD822() { return isRD822; }
    public boolean isRD1393() { return !isRD822; }

}
