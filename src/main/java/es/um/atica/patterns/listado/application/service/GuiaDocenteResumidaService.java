package es.um.atica.patterns.listado.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import es.um.atica.patterns.listado.application.port.GuiaDocenteResumidaReadRepository;
import es.um.atica.patterns.listado.domain.GuiaDocenteResumida;

@Service
public class GuiaDocenteResumidaService {
    
    private GuiaDocenteResumidaReadRepository guiaDocenteResumidaReadRepository;

    public GuiaDocenteResumidaService(GuiaDocenteResumidaReadRepository guiaDocenteResumidaReadRepository) {
        this.guiaDocenteResumidaReadRepository = guiaDocenteResumidaReadRepository;
    }

    public List<GuiaDocenteResumida> loadGuiasResumidasFromUser(String userId) {
        return guiaDocenteResumidaReadRepository.loadGuiasResumidasFromUser(userId);
    }

    public GuiaDocenteResumida loadGuiaResumidaFromUser(String userId, String cod, String tipo, int curso, String idioma) {
        return guiaDocenteResumidaReadRepository.loadGuiaResumidaFromUser(userId, cod, tipo, curso, idioma);
    }

}
