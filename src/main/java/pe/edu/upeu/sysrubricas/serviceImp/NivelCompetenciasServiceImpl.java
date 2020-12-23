package pe.edu.upeu.sysrubricas.serviceImp;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.sysrubricas.dao.Nivel_CompetenciasDao;
import pe.edu.upeu.sysrubricas.entity.Nivel_Competencias;
import pe.edu.upeu.sysrubricas.service.Nivel_CompetenciasService;

@Service

public class NivelCompetenciasServiceImpl implements Nivel_CompetenciasService{
	@Autowired
	public Nivel_CompetenciasDao nivel_competenciaDao;

	@Override
	public int create(Nivel_Competencias nc) {
		// TODO Auto-generated method stub
		return nivel_competenciaDao.create(nc);
	}

	@Override
	public int update(Nivel_Competencias nc) {
		// TODO Auto-generated method stub
		return nivel_competenciaDao.update(nc);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return nivel_competenciaDao.delete(id);
	}

	@Override
	public Map<String, Object> read(int id) {
		// TODO Auto-generated method stub
		return nivel_competenciaDao.read(id);
	}
	@Override
	public Map<String, Object> readAll() {
		// TODO Auto-generated method stub
		return nivel_competenciaDao.readAll();
	}
	@Override
	public 	Map<String, Object> readNivelCompetencia() {
		// TODO Auto-generated method stub
		return nivel_competenciaDao.readNivelCompetencia();
	}
	
	@Override
	public 	Map<String, Object> readCompetencia() {
		// TODO Auto-generated method stub
		return nivel_competenciaDao.readCompetencia();
	}
	@Override
	public 	Map<String, Object> readNivel() {
		// TODO Auto-generated method stub
		return nivel_competenciaDao.readNivel();
	}
	
	

	
}
