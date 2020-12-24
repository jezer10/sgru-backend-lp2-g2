package pe.edu.upeu.sysrubricas.serviceImp;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysrubricas.dao.Linea_PlanDao;
import pe.edu.upeu.sysrubricas.entity.Linea_Plan;
import pe.edu.upeu.sysrubricas.service.Linea_PlanService;
@Service
public class Linea_PlanServiceImp implements Linea_PlanService{
	@Autowired
	private Linea_PlanDao linea_PlanDao;
	@Override
	public int create(Linea_Plan l) {
		return linea_PlanDao.create(l);
	}
	@Override
	public int update(Linea_Plan l) {
		return linea_PlanDao.update(l);
	}

	@Override
	public int delete(int id) {
		return linea_PlanDao.delete(id);
	}

	@Override
	public Map<String, Object> read(int id) {
		// TODO Auto-generated method stub
		return linea_PlanDao.read(id);
	}

	@Override
	public Map<String, Object> readAll() {
		// TODO Auto-generated method stub
		return linea_PlanDao.readAll();
	}

	@Override
	public List<Map<String, Object>> list() {
		// TODO Auto-generated method stub
		return linea_PlanDao.list();
	}
}