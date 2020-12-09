package pe.edu.upeu.sysrubricas.serviceImp;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysrubricas.dao.Proyecto_IntegradorDao;
import pe.edu.upeu.sysrubricas.entity.Proyecto_Integrador;
import pe.edu.upeu.sysrubricas.service.Proyecto_IntegradorService;
@Service
public class Proyecto_IntegradorServiceImp implements Proyecto_IntegradorService{
	@Autowired
	private Proyecto_IntegradorDao proyecto_IntegradorDao;
	@Override
	public int create(Proyecto_Integrador py) {
		// TODO Auto-generated method stub
		return proyecto_IntegradorDao.create(py);
	}

	@Override
	public int update(Proyecto_Integrador py) {
		// TODO Auto-generated method stub
		return proyecto_IntegradorDao.update(py);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return proyecto_IntegradorDao.delete(id);
	}

	@Override
	public Map<String, Object> read(int id) {
		// TODO Auto-generated method stub
		return proyecto_IntegradorDao.read(id);
	}

	@Override
	public Map<String, Object> readAll() {
		// TODO Auto-generated method stub
		return proyecto_IntegradorDao.readAll();
	}

	@Override
	public List<Map<String, Object>> list() {
		// TODO Auto-generated method stub
		return proyecto_IntegradorDao.list();
	}
}