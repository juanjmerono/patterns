package es.um.atica.patterns.guia.domain.policy;

import es.um.atica.patterns.guia.domain.model.GuiaDocenteBuilder;

public class CompetenciaBuilderPolicy implements BuilderPolicy {

    @Override
    public boolean isApplicable(GuiaDocenteBuilder builder) {
        return builder.isRD1393();
    }

    @Override
    public GuiaDocenteBuilder applyPolicy(GuiaDocenteBuilder builder) {
        return builder
            .addCompetencia("B","Competencia básica")
            .addCompetencia("G","Competencia general")
            .addCompetencia("E","Competencia específica")
            .addCompetencia("T", "Competencia transversal");
    }
    
}
