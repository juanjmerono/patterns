package es.um.atica.patterns.listado.domain;

import es.um.atica.patterns.shared.domain.AsignaturaCodigo;
import es.um.atica.patterns.shared.domain.CursoAcademico;
import es.um.atica.patterns.shared.domain.GuiaDocenteEstado;
import es.um.atica.patterns.shared.domain.GuiaDocenteIdioma;
import es.um.atica.patterns.shared.domain.AsignaturaTipo;

public class GuiaDocenteResumida {
    
    private Titulacion titulacion;
    private AsignaturaCodigo codigoAsignatura;
    private AsignaturaDescripcion descripcionAsignatura;
    private AsignaturaTipo tipoAsignatura;
    private CursoAcademico cursoAcademico;
    private AsignaturaCategoria categoria;
    private GuiaDocenteIdioma idioma;
    private GuiaDocenteEstado estado;
    private boolean itinerario;
    private boolean bilingue;
    private boolean centroAdscrito;

    private GuiaDocenteResumida(GuiaDocenteResumidaBuilder builder) {
        this.titulacion = Titulacion.of(builder.codigoTitulacion(),builder.descripcionTitulacion());
        this.codigoAsignatura = AsignaturaCodigo.of(builder.codigoAsignatura()); 
        this.descripcionAsignatura = AsignaturaDescripcion.of(builder.descripcionAsignatura());
        this.tipoAsignatura = AsignaturaTipo.valueOfLabel(builder.tipo());
        this.cursoAcademico = CursoAcademico.of(builder.curso());
        this.categoria = AsignaturaCategoria.valueOfLabel(builder.categoria());
        this.idioma = GuiaDocenteIdioma.valueOfLabel(builder.idioma());
        this.estado = GuiaDocenteEstado.valueOf(builder.estado());
        this.itinerario = builder.itinerario();
        this.bilingue = builder.bilingue();
        this.centroAdscrito = builder.centroAdscrito();
    }

    public static GuiaDocenteResumida of (GuiaDocenteResumidaBuilder builder) {
        return new GuiaDocenteResumida(builder);
    }

    public static GuiaDocenteResumidaBuilder builder() { 
        return new GuiaDocenteResumidaBuilder(); 
    }

    public String codigoTitulacion() { return titulacion.codigo(); }
    public String descripcionTitulacion() { return titulacion.descripcion(); }

    public String codigoAsignatura() { return codigoAsignatura.value(); }
    public String descripcionAsignatura() { return descripcionAsignatura.value(); }
    public String tipoAsignatura() { return tipoAsignatura.label(); }
    public String idioma() { return idioma.label(); }
    public String estado() { return estado.name(); }
    public int cursoAcademico() { return cursoAcademico.value(); }
    public boolean isTf() { return AsignaturaCategoria.TFG.equals(categoria) || AsignaturaCategoria.TFM.equals(categoria); }
    public boolean isPracticum() { return AsignaturaCategoria.PRACTICUM.equals(categoria); }
    public boolean isBilingue() { return bilingue; }
    public boolean isItinerario() { return itinerario; }
    public boolean isCentroAdscrito() { return centroAdscrito; }

}
