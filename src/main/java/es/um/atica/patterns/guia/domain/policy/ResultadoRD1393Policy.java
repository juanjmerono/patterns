package es.um.atica.patterns.guia.domain.policy;

import es.um.atica.patterns.guia.domain.model.GuiaDocenteBuilder;

public class ResultadoRD1393Policy implements BuilderPolicy {

    @Override
    public boolean isApplicable(GuiaDocenteBuilder builder) {
        return builder.isRD1393();
    }

    @Override
    public GuiaDocenteBuilder applyPolicy(GuiaDocenteBuilder builder) {
        return builder.addResultado("Resultado RD1393");
    }
    
}
