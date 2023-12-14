package es.um.atica.patterns.listado.adapters.persistence;

import java.util.List;

import org.springframework.stereotype.Repository;

import es.um.atica.patterns.listado.application.port.GuiaDocenteResumidaReadRepository;
import es.um.atica.patterns.listado.domain.GuiaDocenteResumida;
import es.um.atica.patterns.shared.adapters.persistence.MemoryDatabase;

@Repository
public class GuiaDocenteResumidaReadRepositoryImpl implements GuiaDocenteResumidaReadRepository {

    private MemoryDatabase memoryDatabase;

    public GuiaDocenteResumidaReadRepositoryImpl(MemoryDatabase memoryDatabase) {
        this.memoryDatabase = memoryDatabase;
    }

    @Override
    public List<GuiaDocenteResumida> loadAsignaturasFromUser(String userId) {
        return memoryDatabase.getGuiaDocenteResumida(userId);
    }
    
}
