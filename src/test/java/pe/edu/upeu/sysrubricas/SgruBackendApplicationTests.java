package pe.edu.upeu.sysrubricas;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import pe.edu.upeu.sysrubricas.dao.PlanDao;
import pe.edu.upeu.sysrubricas.dao.Plan_cursoDao;

@SpringBootTest
class SgruBackendApplicationTests {
@Autowired
private Plan_cursoDao plan_cursoDao;
	@Test
	void contextLoads() {
		System.out.println(plan_cursoDao.readCurso());
	}
}
