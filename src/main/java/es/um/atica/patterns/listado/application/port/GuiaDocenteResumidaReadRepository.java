package es.um.atica.patterns.listado.application.port;

import java.util.List;

import es.um.atica.patterns.listado.domain.GuiaDocenteResumida;

public interface GuiaDocenteResumidaReadRepository {
    
    List<GuiaDocenteResumida> loadAsignaturasFromUser(String userId);

}
