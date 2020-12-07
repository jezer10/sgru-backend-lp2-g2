package pe.edu.upeu.sysrubricas;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import pe.edu.upeu.sysrubricas.dao.Nivel_logroDao;
import pe.edu.upeu.sysrubricas.dao.SemestreDao;

@SpringBootTest
class SgruBackendApplicationTests {
	@Autowired
	private SemestreDao semestreDao;

	@Test
	void contextLoads() {
		System.out.println(semestreDao.delete(22));
		
	}

}
