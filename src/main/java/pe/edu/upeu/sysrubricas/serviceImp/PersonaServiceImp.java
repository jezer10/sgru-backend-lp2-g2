package pe.edu.upeu.sysrubricas.serviceImp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.sysrubricas.dao.PersonaDao;
import pe.edu.upeu.sysrubricas.service.PersonaService;
@Service
public class PersonaServiceImp implements PersonaService{
	@Autowired
	private PersonaDao personaDao;
	@Override
	public List<Map<String, Object>> readAll() {
		// TODO Auto-generated method stub
		return personaDao.readall();
	}
	
}
