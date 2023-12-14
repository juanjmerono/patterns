package es.um.atica.patterns.listado.domain;

import java.util.Objects;

public class TitulacionDescripcion {

    private static final int MIN_LENGHT = 5;
    private static final int MAX_LENGHT = 250;

    private String descripcion;

    private TitulacionDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public static TitulacionDescripcion of (String descripcion) {
        Objects.requireNonNull(descripcion, String.format("La descripción [%s] de la titulación no puede ser nula.",descripcion));
        if (descripcion.isBlank()) throw new IllegalArgumentException(String.format("La descripción [%s] de la titulación no puede ser vacía.",descripcion));
        if (!descripcion.matches(String.format("[\\w\\W]{%d,%d}",MIN_LENGHT,MAX_LENGHT))) throw new IllegalArgumentException(String.format("La descripción [%s] de la titulación debe tener entre %d y %d caracteres.",descripcion,MIN_LENGHT,MAX_LENGHT));
        return new TitulacionDescripcion(descripcion);
    }

    public String value() { return descripcion; }

}
