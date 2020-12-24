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
import pe.edu.upeu.sysrubricas.dao.Proyecto_cargaDao;
import pe.edu.upeu.sysrubricas.entity.Proyecto_carga;

@Repository
public class Proyecto_cargaDaoImp implements Proyecto_cargaDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private SimpleJdbcCall simpleJdbcCall;

	@Override
	public List<Proyecto_carga> Cursopy() {
		 simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName("D_CRUD_AVANCE_PY")
	                .withProcedureName("SPP_CURSO_AVANCE_PY").returningResultSet("CURSOR_CURSO", BeanPropertyRowMapper.newInstance(Proyecto_carga.class));
	        return simpleJdbcCall.executeObject(List.class, Collections.emptyMap());
	}
	

}
