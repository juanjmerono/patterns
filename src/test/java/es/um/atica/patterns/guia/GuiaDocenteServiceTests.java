package es.um.atica.patterns.guia;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import es.um.atica.patterns.guia.application.service.GuiaDocenteService;
import es.um.atica.patterns.guia.domain.GuiaDocente;

@SpringBootTest
public class GuiaDocenteServiceTests {
    
	@Autowired
	private GuiaDocenteService guiaDocenteService;

	@Test
	void testDetalleGuia() {
		GuiaDocente guia = guiaDocenteService.loadGuiaDocente("1234", "G", 2023, "E");
		assertNotNull(guia);
	}

	@Test
	void testCreateGuia() {
		GuiaDocente gd = guiaDocenteService.createGuiaDocente("12345679", "4321", "G", 2023, "E");
		assertNotNull(gd);
	}

}
