package pe.edu.upeu.sysrubricas;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import pe.edu.upeu.sysrubricas.dao.PlanDao;

@SpringBootTest
class SgruBackendApplicationTests {
@Autowired
private PlanDao planDao;
	@Test
	void contextLoads() {
		System.out.println(planDao.readFacultad(1));
	}
}
