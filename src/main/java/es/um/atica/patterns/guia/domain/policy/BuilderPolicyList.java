package es.um.atica.patterns.guia.domain.policy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import es.um.atica.patterns.guia.domain.model.GuiaDocenteBuilder;
import es.um.atica.patterns.guia.domain.service.PresentationReadRepository;

public class BuilderPolicyList {
    
    private List<BuilderPolicy> policies;

    public BuilderPolicyList(PresentationReadRepository presentationReadRepository) {
        policies = Arrays.asList(
            new PresentacionBuilderPolicy(presentationReadRepository),
            new CompetenciaBuilderPolicy(),
            new ResultadoRD822Policy(),
            new ResultadoRD1393Policy()
        );
    }

    public List<BuilderPolicy> applicablePolicies(GuiaDocenteBuilder builder) {
        return policies.stream().filter(p->p.isApplicable(builder)).collect(Collectors.toList());
    }    

}
