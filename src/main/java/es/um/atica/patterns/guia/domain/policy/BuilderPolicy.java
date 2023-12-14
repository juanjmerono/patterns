package es.um.atica.patterns.guia.domain.policy;

import es.um.atica.patterns.guia.domain.model.GuiaDocenteBuilder;

public interface BuilderPolicy {
    
    boolean isApplicable(GuiaDocenteBuilder builder);
    GuiaDocenteBuilder applyPolicy(GuiaDocenteBuilder builder);

}
