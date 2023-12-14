package es.um.atica.patterns.guia.domain.policy;

import es.um.atica.patterns.guia.domain.model.GuiaDocenteBuilder;
import es.um.atica.patterns.guia.domain.service.PresentationReadRepository;

public class PresentacionBuilderPolicy implements BuilderPolicy {

    private PresentationReadRepository presentationReadRepository;

    public PresentacionBuilderPolicy(PresentationReadRepository presentationReadRepository) {
        this.presentationReadRepository = presentationReadRepository;
    }

    @Override
    public boolean isApplicable(GuiaDocenteBuilder builder) {
        return true;
    }

    @Override
    public GuiaDocenteBuilder applyPolicy(GuiaDocenteBuilder builder) {
        // Presentación editable solo para guías normales
        String presentacion = "Presentación normal";
        if (builder.isTfg()) presentacion = presentationReadRepository.defaultPresentation("TFG");
        if (builder.isTfm()) presentacion = presentationReadRepository.defaultPresentation("TFM");
        if (builder.isPracticum()) presentacion = presentationReadRepository.defaultPresentation("PRT");
        return builder.presentacion(presentacion, !builder.isTfg() && !builder.isTfm() && !builder.isPracticum());
    }
    
}
