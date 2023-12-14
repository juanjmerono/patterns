package es.um.atica.patterns.guia.application.port;

import java.util.Optional;

import es.um.atica.patterns.guia.domain.model.GuiaDocente;

public interface GuiaDocenteReadRepository {
    Optional<GuiaDocente> loadGuiaDocente(String codigoAsignatura, String tipo, int curso, String idioma);
}
