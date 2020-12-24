package pe.edu.upeu.sysrubricas.daoImp;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.parsing.BeanComponentDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.BeanProperty;

import oracle.jdbc.OracleTypes;
import pe.edu.upeu.sysrubricas.dao.CursoDao;
import pe.edu.upeu.sysrubricas.entity.Curso;

@Repository
public class CursoDaoImp implements CursoDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private SimpleJdbcCall simpleJdbcCall;

	@Override
	public List<Curso> Cursopy() {
		 simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName("D_CRUD_AVANCE_PY")
	                .withProcedureName("SPP_CURSO_AVANCE_PY").returningResultSet("CURSOR_CURSO", BeanPropertyRowMapper.newInstance(Curso.class));
	        return simpleJdbcCall.executeObject(List.class, Collections.emptyMap());
	}
	

}
