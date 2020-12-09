package pe.edu.upeu.sysrubricas.serviceImp;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysrubricas.dao.LineaPADao;
import pe.edu.upeu.sysrubricas.entity.LineaPA;
import pe.edu.upeu.sysrubricas.service.LineaPAService;
@Service
public class LineaPAServiceImp implements LineaPAService{
	@Autowired
	private LineaPADao lineaPADao;
	@Override
	public int create(LineaPA l) {
		// TODO Auto-generated method stub
		return lineaPADao.create(l);
	}

	@Override
	public int update(LineaPA l) {
		// TODO Auto-generated method stub
		return lineaPADao.update(l);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return lineaPADao.delete(id);
	}

	@Override
	public Map<String,Object>read(int id) {
		// TODO Auto-generated method stub
		return lineaPADao.read(id);
	}

	@Override
	public Map<String,Object>readAll() {
		// TODO Auto-generated method stub
		return lineaPADao.readAll();
	}

	@Override
	public List<Map<String,Object>>list() {
		// TODO Auto-generated method stub
		return lineaPADao.list();
	}
}