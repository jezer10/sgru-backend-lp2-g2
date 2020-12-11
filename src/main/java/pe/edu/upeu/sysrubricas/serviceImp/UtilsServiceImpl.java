package pe.edu.upeu.sysrubricas.serviceImp;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysrubricas.dao.UtilsDao;
import pe.edu.upeu.sysrubricas.entity.Utils;
import pe.edu.upeu.sysrubricas.service.UtilsService;

@Service
public class UtilsServiceImpl implements UtilsService{
	
	@Autowired
	private UtilsDao utilsdao;

	@Override
	public int create(Utils u) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Utils u) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Map<String, Object> read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> readAll() {
		// TODO Auto-generated method stub
		return utilsdao.readAll();
	}

}
