package es.um.atica.patterns.guia.application.port;

import es.um.atica.patterns.guia.domain.model.GuiaDocente;

public interface GuiaDocenteWriteRepository {
    
    GuiaDocente saveGuiaDocente(String userId, GuiaDocente guia);

}
