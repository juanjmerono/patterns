package es.um.atica.patterns.shared.domain;

import java.util.Arrays;

public enum GuiaDocenteIdioma {

    INGLES("I"), ESPANYOL("E");

    private String label;
    
    private GuiaDocenteIdioma(String l) { this.label = l; }
    
    public static GuiaDocenteIdioma valueOfLabel(String l) {
        return Arrays.stream(values())
            .filter(i -> l.equals(i.label))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("Idioma de guía no válido."));
    }

    public String label() { return label; }
}
