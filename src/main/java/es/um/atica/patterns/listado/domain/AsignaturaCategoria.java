package es.um.atica.patterns.listado.domain;

import java.util.Arrays;

public enum AsignaturaCategoria {
    NORMAL("NOR"), TFG("TFG"), TFM("TFM"), PRACTICUM("PRT"); 

    private String label;
    
    private AsignaturaCategoria(String l) { this.label = l; }
    
    public static AsignaturaCategoria valueOfLabel(String l) {
        return Arrays.stream(values())
            .filter(i -> l.equals(i.label))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("Modalidad asignatura no válido."));
    }

    public String label() { return label; }

}
