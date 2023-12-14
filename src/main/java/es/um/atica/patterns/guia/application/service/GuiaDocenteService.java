package es.um.atica.patterns.guia.application.service;

import org.springframework.stereotype.Service;

import es.um.atica.patterns.guia.application.port.GuiaDocenteReadRepository;
import es.um.atica.patterns.guia.application.port.GuiaDocenteWriteRepository;
import es.um.atica.patterns.guia.domain.model.GuiaDocente;
import es.um.atica.patterns.guia.domain.policy.BuilderPolicyList;
import es.um.atica.patterns.guia.domain.service.PresentationReadRepository;
import es.um.atica.patterns.listado.application.service.GuiaDocenteResumidaService;
import es.um.atica.patterns.listado.domain.GuiaDocenteResumida;

@Service
public class GuiaDocenteService {
    
    private GuiaDocenteReadRepository guiaDocenteReadRepository;
    private GuiaDocenteWriteRepository guiaDocenteWriteRepository;
    private GuiaDocenteResumidaService guiaDocenteResumidaService;
    private PresentationReadRepository presentationReadRepository;


    public GuiaDocenteService(GuiaDocenteReadRepository guiaDocenteReadRepository, 
        GuiaDocenteWriteRepository guiaDocenteWriteRepository,
        GuiaDocenteResumidaService guiaDocenteResumidaService,
        PresentationReadRepository presentationReadRepository) {
        this.guiaDocenteReadRepository = guiaDocenteReadRepository;
        this.guiaDocenteWriteRepository = guiaDocenteWriteRepository;
        this.guiaDocenteResumidaService = guiaDocenteResumidaService;
        this.presentationReadRepository = presentationReadRepository;
    }

    public GuiaDocente loadGuiaDocente(String cod, String tipo, int curso, String idioma) {
        return guiaDocenteReadRepository.loadGuiaDocente(cod, tipo, curso, idioma).orElse(null);
    }

    public GuiaDocente createGuiaDocente(String userId, String cod, String tipo, int curso, String idioma) {
        GuiaDocenteResumida gdr = guiaDocenteResumidaService.loadGuiaResumidaFromUser(userId, cod, tipo, curso, idioma);
        BuilderPolicyList builderPolicyList = new BuilderPolicyList(presentationReadRepository);
        GuiaDocente gd = guiaDocenteReadRepository
            .loadGuiaDocente(cod, tipo, curso, idioma)
            .orElse(GuiaDocente.builder()
                .codigo(cod)
                .tipo(tipo)
                .curso(curso)
                .idioma(idioma)
                .categoria(gdr.categoria())
                .isRD822(false)
                .buildWithDefaultPolicies(builderPolicyList));
        return guiaDocenteWriteRepository.saveGuiaDocente(userId,gd);
    }

}
