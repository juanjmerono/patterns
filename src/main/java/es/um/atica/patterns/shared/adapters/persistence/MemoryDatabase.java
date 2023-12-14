package es.um.atica.patterns.shared.adapters.persistence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import es.um.atica.patterns.guia.domain.GuiaDocente;
import es.um.atica.patterns.listado.domain.GuiaDocenteResumida;

@Service
public class MemoryDatabase {

    private Map<String,List<GuiaDocenteResumida>> databaseSummary = new HashMap<>();
    private List<GuiaDocente> database = new ArrayList<>();

    public MemoryDatabase() {
        List<GuiaDocenteResumida> list = new ArrayList<>();
        GuiaDocenteResumida gdr = GuiaDocenteResumida.builder()
            .codigoTitulacion("123")
            .descripcionTitulacion("Mi titulacion")
            .codigoAsignatura("1234")
            .descripcionAsignatura("Mi asignatura")
            .tipo("G")
            .curso(2023)
            .categoria("NOR")
            .idioma("E")
            .estado("NOCUMPLIMENTADA")
            .build();
        list.add(gdr);
        databaseSummary.put("12345678", list);
        database.add(GuiaDocente.builder()
            .codigo("1234")
            .tipo("G")
            .curso(2023)
            .presentacion("Texto Presentación", true)
            .estado("PUBLICADA")
            .build());

    }

    public List<GuiaDocenteResumida> getGuiaDocenteResumida(String userId) {
        return databaseSummary.getOrDefault(userId, Collections.emptyList());
    }

    public Optional<GuiaDocente> getGuiaDocente(String codigoAsignatura, String tipo, int curso, String idioma) {
        return database.stream()
            .filter(
                g -> 
                    g.codigoAsignatura().equals(codigoAsignatura) &&
                    g.tipoAsignatura().equals(tipo) &&
                    g.idiomaGuia().equals(idioma) &&
                    g.cursoAcademico() == curso
            )
            .findFirst();
    }
    
    public GuiaDocente save(String userId, GuiaDocente guia) {
        List<GuiaDocenteResumida> list = databaseSummary.getOrDefault(userId, new ArrayList<>());
        list.add(GuiaDocenteResumida.builder()
            .codigoTitulacion("123")
            .descripcionTitulacion("Mi titulacion")
            .codigoAsignatura(guia.codigoAsignatura())
            .descripcionAsignatura("Mi asignatura")
            .tipo(guia.tipoAsignatura())
            .curso(guia.cursoAcademico())
            .categoria("NOR")
            .idioma(guia.idiomaGuia())
            .estado(guia.estado())
            .build());
        database.add(guia);
        return guia;
    }

}
