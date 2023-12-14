package es.um.atica.patterns.listado.adapters.persistence;

import java.util.List;
import java.util.NoSuchElementException;

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
    public List<GuiaDocenteResumida> loadGuiasResumidasFromUser(String userId) {
        return memoryDatabase.getGuiasDocentesResumidas(userId);
    }

    @Override
    public GuiaDocenteResumida loadGuiaResumidaFromUser(String userId, String cod, String tipo, int curso, String idioma) {
        return memoryDatabase
            .getGuiasDocentesResumidas(userId)
            .stream()
            .filter(
                g -> 
                    g.codigoAsignatura().equals(cod) &&
                    g.tipoAsignatura().equals(tipo) &&
                    g.idioma().equals(idioma) &&
                    g.cursoAcademico() == curso
            )
            .findFirst()
            .orElseThrow(()->new NoSuchElementException("No existe la guía docente para el usuario."));
    }
    
}
