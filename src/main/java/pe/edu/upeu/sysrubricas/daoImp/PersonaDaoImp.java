package pe.edu.upeu.sysrubricas.daoImp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import pe.edu.upeu.sysrubricas.dao.PersonaDao;
@Repository
public class PersonaDaoImp implements PersonaDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public List<Map<String, Object>> readall() {
		// TODO Auto-generated method stub
		String sql="select * from persona";
		return jdbcTemplate.queryForList(sql);
	}

}
