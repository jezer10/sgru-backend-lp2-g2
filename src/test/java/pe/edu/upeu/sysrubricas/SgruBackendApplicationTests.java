package pe.edu.upeu.sysrubricas;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import org.springframework.test.context.jdbc.Sql;
import pe.edu.upeu.sysrubricas.dao.*;
import pe.edu.upeu.sysrubricas.service.CompetenciaLineaService;
import pe.edu.upeu.sysrubricas.sql.SqlPregunta;

import java.math.BigDecimal;
import java.sql.SQLException;


@SpringBootTest
class SgruBackendApplicationTests {

	@Autowired
	private InstrumentoDao instrumentoDao;
	@Autowired
	private Sys_numericoDao sys_numericoDao;
	@Autowired
	private CompetenciaLineaService competenciaLineaDao;
	@Autowired
	private PreguntaDao preguntaDao;

@Autowired
private PlanDao planDao;

	@Test
	void contextLoads() throws SQLException {
		//System.out.println(competenciaLineaDao.getCompetenciasLinea(1));
		//System.out.println(instrumentoDao.getInstrumentos());
//		SqlPregunta pregunta = new SqlPregunta();
//		pregunta.setEstado("1");
//		pregunta.setNombre("xxxx");
//		pregunta.setPeso(BigDecimal.valueOf(20));
//		pregunta.setInstrumento_id(BigDecimal.valueOf(403));
//		System.out.println(preguntaDao.createPregunta(pregunta));
		System.out.println(preguntaDao.getPreguntas());
	}
}
