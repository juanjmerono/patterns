package es.um.atica.patterns.guia.application.service;

import org.springframework.stereotype.Service;

import es.um.atica.patterns.guia.application.port.GuiaDocenteReadRepository;
import es.um.atica.patterns.guia.application.port.GuiaDocenteWriteRepository;
import es.um.atica.patterns.guia.domain.GuiaDocente;

@Service
public class GuiaDocenteService {
    
    private GuiaDocenteReadRepository guiaDocenteReadRepository;
    private GuiaDocenteWriteRepository guiaDocenteWriteRepository;

    public GuiaDocenteService(GuiaDocenteReadRepository guiaDocenteReadRepository, GuiaDocenteWriteRepository guiaDocenteWriteRepository) {
        this.guiaDocenteReadRepository = guiaDocenteReadRepository;
        this.guiaDocenteWriteRepository = guiaDocenteWriteRepository;
    }

    public GuiaDocente loadGuiaDocente(String cod, String tipo, int curso, String idioma) {
        return guiaDocenteReadRepository.loadGuiaDocente(cod, tipo, curso, idioma).orElse(null);
    }

    public GuiaDocente createGuiaDocente(String userId, String cod, String tipo, int curso, String idioma) {
        GuiaDocente gd = guiaDocenteReadRepository.loadGuiaDocente(cod, tipo, curso, idioma)
            .orElse(GuiaDocente.builder()
            .codigo(cod)
            .tipo(tipo)
            .curso(curso)
            .idioma(idioma)
            .build());
        return guiaDocenteWriteRepository.saveGuiaDocente(userId,gd);
    }

}
