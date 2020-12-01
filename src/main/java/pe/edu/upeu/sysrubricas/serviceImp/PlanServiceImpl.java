package pe.edu.upeu.sysrubricas.serviceImp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.sysrubricas.dao.PlanDao;
import pe.edu.upeu.sysrubricas.entity.Plan;
import pe.edu.upeu.sysrubricas.service.PlanService;

@Service
public class PlanServiceImpl implements PlanService{
	@Autowired
	private PlanDao planDao;
	@Override
	public int create(Plan p) {
		return planDao.create(p);
	}

	@Override
	public int update(Plan p) {
		return planDao.update(p);
	}

	@Override
	public int delete(int id) {
		return planDao.delete(id);
	}

	@Override
	public Map<String, Object> read(int id) {
		return planDao.read(id);
	}

	@Override
	public Map<String, Object> readAll() {
		return planDao.readAll();
	}

	@Override
	public List<Map<String, Object>> list() {
		return planDao.list();
	}
	
}
