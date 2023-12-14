package es.um.atica.patterns.shared.domain;

import java.util.Objects;

public class AsignaturaCodigo {
    
    private String codigo;

    private AsignaturaCodigo(String codigo) {
        this.codigo = codigo;
    }

    public static AsignaturaCodigo of(String codigo) {
        Objects.requireNonNull(codigo, String.format("El código [%s] de asignatura no puede ser nulo.",codigo));
        if (!codigo.matches("[A-Z0-9]{4}")) throw new IllegalArgumentException(String.format("El código [%s] de asignatura no se ajsuta al formato.",codigo));
        return new AsignaturaCodigo(codigo);
    }

    public String value() { return codigo; }

}
