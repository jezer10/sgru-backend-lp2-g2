package pe.edu.upeu.sysrubricas.serviceImp;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.sysrubricas.dao.CompetenciaDao;
import pe.edu.upeu.sysrubricas.entity.Competencias;
import pe.edu.upeu.sysrubricas.service.CompetenciaService;

@Service

public class CompetenciaServiceImpl implements CompetenciaService{
	@Autowired
	public CompetenciaDao competenciadao;
	
	public int create(Competencias c) {
		// TODO Auto-generated method stub
		return competenciadao.create(c);
		}
	@Override
	public int update(Competencias c) {
		// TODO Auto-generated method stub
		return competenciadao.update(c);
	}
	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return competenciadao.delete(id);
	}
	@Override
	public Map<String, Object> read(int id) {
		// TODO Auto-generated method stub
		return competenciadao.read(id);
	}
	@Override
	public Map<String, Object> readAll() {
		// TODO Auto-generated method stub
		return competenciadao.readAll();
	}
}
