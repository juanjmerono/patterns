package es.um.atica.patterns.guia.domain;

import java.util.Arrays;

public enum CompetenciaTipo {
    BASICA("B"), GENERAL("G"), ESPECIFICA("E"), TRANSVERSAL("T");

	private String label;

	private CompetenciaTipo(String l) { this.label = l; }

	public static CompetenciaTipo valueOfLabel(String l) {
		return Arrays.stream(values()).filter(i -> l.equals(i.label)).findFirst()
					.orElseThrow(() -> new IllegalArgumentException("Tipo competencia no válido."));
	}

	public String label() { return label; }

}
