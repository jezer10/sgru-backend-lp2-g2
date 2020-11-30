package pe.edu.upeu.sysrubricas;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import pe.edu.upeu.sysrubricas.dao.EvaluacionDao;

@SpringBootTest
class SgruBackendApplicationTests {
	
	@Autowired
	private EvaluacionDao evaluacionDao;

	@Test
	void contextLoads() {
		System.out.println(evaluacionDao.readAll());
	}

}
