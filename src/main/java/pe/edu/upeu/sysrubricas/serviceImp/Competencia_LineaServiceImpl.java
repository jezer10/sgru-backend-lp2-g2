package pe.edu.upeu.sysrubricas.serviceImp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.sysrubricas.dao.Competencia_LineaDao;
import pe.edu.upeu.sysrubricas.entity.Competencia_Linea;
import pe.edu.upeu.sysrubricas.service.Competencia_LineaService;
@Service

public class Competencia_LineaServiceImpl implements Competencia_LineaService{
	@Autowired
	public Competencia_LineaDao competencia_lineaDao;
	@Override
	public List<Map<String, Object>> readAll() {
		// TODO Auto-generated method stub
		return competencia_lineaDao.readAll();
	}
	@Override
	public int create(Competencia_Linea cl) {
		// TODO Auto-generated method stub
		return competencia_lineaDao.create(cl);
	}
	@Override
	public int update(Competencia_Linea cl) {
		// TODO Auto-generated method stub
		return competencia_lineaDao.update(cl);
	}
	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return competencia_lineaDao.delete(id);
	}
	@Override
	public Map<String, Object> read(int id) {
		// TODO Auto-generated method stub
		return competencia_lineaDao.read(id);
	}

}

