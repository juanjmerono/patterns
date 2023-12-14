package es.um.atica.patterns.guia.domain.policy;

import es.um.atica.patterns.guia.domain.model.GuiaDocenteBuilder;

public class ResultadoRD822Policy implements BuilderPolicy {

    @Override
    public boolean isApplicable(GuiaDocenteBuilder builder) {
        return builder.isRD822();
    }

    @Override
    public GuiaDocenteBuilder applyPolicy(GuiaDocenteBuilder builder) {
        return builder.addResultado("Resultado RD822");
    }
    
}
