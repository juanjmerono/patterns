package es.um.atica.patterns.listado.domain;

import java.util.Objects;

public class TitulacionCodigo {

    private String codigo;

    private TitulacionCodigo(String codigo) {
        this.codigo = codigo;
    }

    public static TitulacionCodigo of (String codigo) {
        Objects.requireNonNull(codigo, String.format("El código [%s] de la titulación no puede ser nulo.",codigo));
        if (codigo.isBlank()) throw new IllegalArgumentException(String.format("El código [%s] de la titulación no puede ser vacío.",codigo));
        if (!codigo.matches("[0-9]{3}")) throw new IllegalArgumentException(String.format("El código [%s] de la titulación",codigo));
        return new TitulacionCodigo(codigo);
    }

    public String value() { return codigo; }

}
