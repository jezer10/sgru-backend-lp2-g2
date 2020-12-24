package pe.edu.upeu.sysrubricas.serviceImp;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.sysrubricas.dao.PersonaDao;
import pe.edu.upeu.sysrubricas.entity.Persona;
import pe.edu.upeu.sysrubricas.service.PersonaService;
import pe.edu.upeu.sysrubricas.sql.SqlInstrumento;
@Service
public class PersonaServiceImp implements PersonaService{
	@Autowired
	private PersonaDao personaDao;

	@Override
	public void create(SqlInstrumento instrumento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(SqlInstrumento instrumento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return personaDao.delete(id);
	}

	@Override
	public Persona read(int id) {
		// TODO Auto-generated method stub
		return personaDao.read(id);
	}

	@Override
	public Map<String, Object> readAll() {
		// TODO Auto-generated method stub
		return personaDao.readAll();
	}

	
}
