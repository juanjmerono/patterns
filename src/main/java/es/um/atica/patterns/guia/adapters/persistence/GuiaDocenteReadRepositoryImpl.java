package es.um.atica.patterns.guia.adapters.persistence;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import es.um.atica.patterns.guia.application.port.GuiaDocenteReadRepository;
import es.um.atica.patterns.guia.application.port.GuiaDocenteWriteRepository;
import es.um.atica.patterns.guia.domain.model.GuiaDocente;
import es.um.atica.patterns.shared.adapters.persistence.MemoryDatabase;

@Repository
public class GuiaDocenteReadRepositoryImpl implements GuiaDocenteReadRepository, GuiaDocenteWriteRepository {

    private MemoryDatabase memoryDatabase;

    public GuiaDocenteReadRepositoryImpl(MemoryDatabase memoryDatabase) {
        this.memoryDatabase = memoryDatabase;
    }


    @Override
    public Optional<GuiaDocente> loadGuiaDocente(String codigoAsignatura, String tipo, int curso, String idioma) {
        return memoryDatabase.getGuiaDocente(codigoAsignatura, tipo, curso, idioma);
    }


    @Override
    public GuiaDocente saveGuiaDocente(String userId, GuiaDocente guia) {
        return memoryDatabase.save(userId, guia);
    }
    
}
