package es.um.atica.patterns.guiaresumida;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import es.um.atica.patterns.listado.application.service.GuiaDocenteResumidaService;
import es.um.atica.patterns.listado.domain.GuiaDocenteResumida;

@SpringBootTest
class GuiaDocenteResumidaServiceTests {

	@Autowired
	private GuiaDocenteResumidaService guiaDocenteResumidaService;

	@Test
	void testListaGuias() {
		List<GuiaDocenteResumida> list = guiaDocenteResumidaService.loadGuiasResumidasFromUser("12345678");
		assertNotNull(list);
		assertEquals(1,list.size());
		assertEquals("1234",list.get(0).codigoAsignatura());
		assertEquals(false,list.get(0).isTf());
	}

}
