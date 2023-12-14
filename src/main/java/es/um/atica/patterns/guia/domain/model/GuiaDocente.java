package es.um.atica.patterns.guia.domain.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import es.um.atica.patterns.shared.domain.AsignaturaCodigo;
import es.um.atica.patterns.shared.domain.CursoAcademico;
import es.um.atica.patterns.shared.domain.GuiaDocenteEstado;
import es.um.atica.patterns.shared.domain.GuiaDocenteIdioma;
import es.um.atica.patterns.shared.domain.AsignaturaTipo;

/**
 * GuiaDocente:
 *  - RD822: Tiene resultados y no tiene competencias
 *  - RD1393: Tiene competencias y resultados
 *  - TF: La presetación no es editable
 *  - Normal: La presentación es editable
 */
public class GuiaDocente {
    
    private AsignaturaCodigo codigoAsignatura;
    private AsignaturaTipo tipoAsignatura;
    private CursoAcademico cursoAcademico;
    private GuiaDocenteIdioma idioma;
    private GuiaDocenteEstado estado;
    private Presentacion presentacion;
    private List<Competencia> competencias;
    private List<Resultado> resultados;

    private GuiaDocente(GuiaDocenteBuilder builder) {
        // Valores requeridos siempre y comunes a todas las guias
        this.codigoAsignatura = AsignaturaCodigo.of(builder.codigo());
        this.tipoAsignatura = AsignaturaTipo.valueOfLabel(builder.tipo());
        this.cursoAcademico = CursoAcademico.of(builder.curso());
        this.idioma = GuiaDocenteIdioma.valueOfLabel(builder.idioma());
        this.estado = GuiaDocenteEstado.valueOf(builder.estado());
        this.presentacion = builder.presentacion();
        this.resultados = builder.resultados().stream().map(Resultado::of).collect(Collectors.toList());
        this.competencias = builder.competencias();
    }

    public static GuiaDocente build(GuiaDocenteBuilder builder) {
        return new GuiaDocente(builder);
    }

    public static GuiaDocenteBuilder builder() {
        return new GuiaDocenteBuilder();
    }

    public String codigoAsignatura() { return codigoAsignatura.value(); }
    public String tipoAsignatura() { return tipoAsignatura.label(); }
    public int cursoAcademico() { return cursoAcademico.value(); }
    public String idiomaGuia() { return idioma.label(); }
    public String estado() { return estado.toString(); }
    public String presentacion() { return presentacion.texto(); }
    public boolean isPresentacionEditable() { return presentacion.isEditable(); }
    public List<String> resultadosAprendizaje() { 
        return (resultados!=null) ? resultados.stream().map(r -> r.texto()).collect(Collectors.toList()) : Collections.emptyList(); 
    }

    public List<String> competencias(CompetenciaTipo tipo) { 
        return (competencias!=null) ? 
            competencias.stream()
                .filter(c -> tipo==null || c.tipo().equals(tipo.toString()))
                .map(c -> c.texto())
                .collect(Collectors.toList()) 
            : Collections.emptyList(); 
    }

}
