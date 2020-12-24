package pe.edu.upeu.sysrubricas.serviceImp;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysrubricas.dao.Py_GruposDao;
import pe.edu.upeu.sysrubricas.entity.Py_Grupos;
import pe.edu.upeu.sysrubricas.service.Py_GruposService;
@Service
public class Py_GruposServiceImp implements Py_GruposService{
	@Autowired
	private Py_GruposDao py_GruposDao;
	@Override
	public int create(Py_Grupos p) {
		return py_GruposDao.create(p);
	}

	@Override
	public int update(Py_Grupos p) {
		return py_GruposDao.update(p);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return py_GruposDao.delete(id);
	}

	@Override
	public Map<String, Object> read(int id) {
		// TODO Auto-generated method stub
		return py_GruposDao.read(id);
	}

	@Override
	public Map<String, Object> readAll() {
		// TODO Auto-generated method stub
		return py_GruposDao.readAll();
	}

	@Override
	public List<Map<String, Object>> list() {
		// TODO Auto-generated method stub
		return py_GruposDao.list();
	}
}