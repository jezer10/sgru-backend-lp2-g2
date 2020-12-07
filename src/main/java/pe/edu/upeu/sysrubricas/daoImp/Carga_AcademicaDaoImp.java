package pe.edu.upeu.sysrubricas.daoImp;

import java.sql.Types;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import oracle.jdbc.internal.OracleTypes;
import pe.edu.upeu.sysrubricas.dao.Carga_AcademicaDao;
import pe.edu.upeu.sysrubricas.entity.Carga_Academica;

@Repository
public class Carga_AcademicaDaoImp implements Carga_AcademicaDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simplejdbcCall;
	
	@Override
	public int create(Carga_Academica ca) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("call D_CRUD_CARGA_ACADEMICA.SPP_INS_CARGA_ACADEMICA(?,?,?,?,?,?) ", ca.getPersona_id(),
				     ca.getSemestre_id(), ca.getCarga_academica_id(), ca.getPlan_curso_id(),ca.getEstado(), ca.getGrupo());
	}
	
	@Override
	public int update(Carga_Academica ca) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("call D_CRUD_CARGA_ACADEMICA.SPP_UPD_CARGA_ACADEMICA(?,?,?,?,?,?)", ca.getPersona_id(), 
		   ca.getCarga_academica_id(), ca.getSemestre_id(), ca.getPlan_curso_id(), ca.getEstado(), ca.getGrupo());
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("call D_CRUD_CARGA_ACADEMICA.SPP_DEL_CARGA_ACADEMICA(?)", id);
	}

	@Override
	public Map<String, Object> read(int id) {
		// TODO Auto-generated method stub
		simplejdbcCall=new SimpleJdbcCall(jdbcTemplate).withCatalogName("D_CRUD_CARGA_ACADEMICA").withProcedureName("SPP_READ_CARGA_ACADEMICA").declareParameters(new SqlOutParameter("CURSOR_CA", OracleTypes.CURSOR, new ColumnMapRowMapper()), new SqlOutParameter("ID CARGA_ACADEMICA", Types.INTEGER));
		SqlParameterSource in=new MapSqlParameterSource().addValue("ID CARGA_ACADEMICA", id);
		return simplejdbcCall.execute(in);
	}

	@Override
	public Map<String, Object> readAll() {
		// TODO Auto-generated method stub
		simplejdbcCall=new SimpleJdbcCall(jdbcTemplate).withCatalogName("D_CRUD_CARGA_ACADEMICA").withProcedureName("SPP_READALL_CARGA_ACADEMICA").declareParameters(new SqlOutParameter("CURSOR_CA", OracleTypes.CURSOR, new ColumnMapRowMapper()));
		return simplejdbcCall.execute();
	}
}
