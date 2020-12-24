package pe.edu.upeu.sysrubricas.serviceImp;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.sysrubricas.dao.UtilsDao;
import pe.edu.upeu.sysrubricas.service.UtilsService;
@Service
public class UtilsServiceImp implements UtilsService{
	@Autowired
	private UtilsDao utilsDao;
	@Override
	public Map<String, Object> readAllCiclo() {
		// TODO Auto-generated method stub
		return utilsDao.readAllCiclo();
	}

	@Override
	public Map<String, Object> readAllGrupo() {
		// TODO Auto-generated method stub
		return utilsDao.readAllGrupo();
	}

	@Override
	public Map<String, Object> readAllTipoIns() {
		// TODO Auto-generated method stub
		return utilsDao.readAllTipoIns();
	}

	@Override
	public Map<String, Object> readAllNCD() {
		// TODO Auto-generated method stub
		return utilsDao.readAllNCD();
	}

	@Override
	public Map<String, Object> readAllNivComp() {
		// TODO Auto-generated method stub
		return utilsDao.readAllNivComp();
	}

	@Override
	public Map<String, Object> readAllNivLog() {
		// TODO Auto-generated method stub
		return utilsDao.readAllNivLog();
	}

}
