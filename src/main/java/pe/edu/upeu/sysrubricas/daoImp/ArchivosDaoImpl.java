package pe.edu.upeu.sysrubricas.daoImp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import pe.edu.upeu.sysrubricas.dao.ArchivosDao;
import pe.edu.upeu.sysrubricas.entity.Archivos;
@Repository
public class ArchivosDaoImpl implements ArchivosDao{
@Autowired
private JdbcTemplate jdbcTemplate;
	@Override
	public int create(Archivos ar) {
		// TODO Auto-generated method stub
		String SQL="insert into archivos (idarchivos, nombre, url, idusuario) values(null,?,?,?)";
		return jdbcTemplate.update(SQL, ar.getNombre(),ar.getUrl());
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
