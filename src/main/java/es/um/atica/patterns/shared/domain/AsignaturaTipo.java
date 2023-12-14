package es.um.atica.patterns.shared.domain;

import java.util.Arrays;

public enum AsignaturaTipo {
    GRADO("G"),POSGRADO("P"); 

    private String label;
    
    private AsignaturaTipo(String l) { this.label = l; }
    
    public static AsignaturaTipo valueOfLabel(String l) {
        return Arrays.stream(values())
            .filter(i -> l.equals(i.label))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("Tipo asignatura no válido."));
    }

    public String label() { return label; }

}
