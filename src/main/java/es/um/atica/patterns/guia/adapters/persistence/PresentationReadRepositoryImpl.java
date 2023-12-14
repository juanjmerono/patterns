package es.um.atica.patterns.guia.adapters.persistence;

import org.springframework.stereotype.Repository;

import es.um.atica.patterns.guia.domain.service.PresentationReadRepository;
import es.um.atica.patterns.shared.adapters.persistence.MemoryDatabase;

@Repository
public class PresentationReadRepositoryImpl implements PresentationReadRepository {

    private MemoryDatabase memoryDatabase;

    public PresentationReadRepositoryImpl(MemoryDatabase memoryDatabase) {
        this.memoryDatabase = memoryDatabase;
    }

    @Override
    public String defaultPresentation(String tipo) {
        return memoryDatabase.getPresentacion(tipo);
    }
    
}
