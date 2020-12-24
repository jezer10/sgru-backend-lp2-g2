package pe.edu.upeu.sysrubricas.serviceImp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.sysrubricas.dao.ArchivosDao;
import pe.edu.upeu.sysrubricas.entity.Archivos;
import pe.edu.upeu.sysrubricas.service.ArchivosService;
@Service
public class ArchivosServiceImpl implements ArchivosService{
@Autowired
private ArchivosDao archivosDao;
	@Override
	public int create(Archivos ar) {
		return archivosDao.create(ar);
	}

	@Override
	public int update(Archivos ar) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Map<String, Object>> read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
