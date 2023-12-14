package es.um.atica.patterns.listado.application.port;

import java.util.List;

import es.um.atica.patterns.listado.domain.GuiaDocenteResumida;

public interface GuiaDocenteResumidaReadRepository {
    
    List<GuiaDocenteResumida> loadGuiasResumidasFromUser(String userId);
    GuiaDocenteResumida loadGuiaResumidaFromUser(String userId, String cod, String tipo, int curso, String idioma);

}
