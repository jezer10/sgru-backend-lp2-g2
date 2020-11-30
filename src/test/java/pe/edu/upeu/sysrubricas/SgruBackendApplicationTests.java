package pe.edu.upeu.sysrubricas;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import pe.edu.upeu.sysrubricas.dao.Nivel_logroDao;

@SpringBootTest
class SgruBackendApplicationTests {
	@Autowired
	private Nivel_logroDao nivel_logroDao;

	@Test
	void contextLoads() {
		System.out.println(nivel_logroDao.readAll());
		
	}

}
