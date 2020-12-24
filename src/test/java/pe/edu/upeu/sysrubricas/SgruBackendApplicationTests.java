package pe.edu.upeu.sysrubricas;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import pe.edu.upeu.sysrubricas.dao.Sys_numericoDao;
import pe.edu.upeu.sysrubricas.dao.PlanDao;


@SpringBootTest
class SgruBackendApplicationTests {

	
	@Autowired
	private Sys_numericoDao sys_numericoDao;


@Autowired
private PlanDao planDao;

	@Test
	void contextLoads() {

		System.out.println(sys_numericoDao.readAll());

		System.out.println(planDao.readFacultad(1));

	}
}
