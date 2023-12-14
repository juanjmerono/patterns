package es.um.atica.patterns.shared.domain;

public class CursoAcademico {

    private int curso;

    private CursoAcademico(int curso) {
        this.curso = curso;
    }

    public static CursoAcademico of(int curso) {
        if (curso<0) throw new IllegalArgumentException("Curso académico no válido.");
        return new CursoAcademico(curso);
    }

    public int value() { return curso; }
}
