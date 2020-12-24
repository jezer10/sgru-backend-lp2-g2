package pe.edu.upeu.sysrubricas.daoImp;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import oracle.jdbc.OracleTypes;
import pe.edu.upeu.sysrubricas.dao.Tipo_CompetenciaDao;

@Repository

public class Tipo_CompetenciaDaoImpl implements Tipo_CompetenciaDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	@Override
	public List<Map<String, Object>> readAll() {
		// TODO Auto-generated method stub
		List<Map<String,Object>> tipo_competencia= new ArrayList<>();
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withCatalogName("D_CRUD_TIPO_COMPETENCIA") 
				.withProcedureName("SPP_READALL_TIPO_COMPETENCIA") //nombre del procedimiento
				.declareParameters(new SqlOutParameter("CURSOR_TIPO_COMPETENCIAS", OracleTypes.REF_CURSOR, new ColumnMapRowMapper()));	
				Map<String, Object> map = simpleJdbcCall.execute();
				tipo_competencia.add(map);
		return tipo_competencia;
	}
	@Override
	
	public Map<String, Object> read(int id) {
		// TODO Auto-generated method stub
		System.out.println(id);
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
		.withCatalogName("D_CRUD_TIPO_COMPETENCIA") //nombre del paquete
		.withProcedureName("SPP_READ_TIPO_COMPETENCIA") //nombre del procedimiento
		.declareParameters(new SqlOutParameter("CURSOR_TIPO_COMPETENCIA", OracleTypes.CURSOR, 
				new ColumnMapRowMapper()), new SqlParameter("ID_TCOMP", Types.INTEGER));
		SqlParameterSource in = new MapSqlParameterSource().addValue("ID_TCOMP", id);
		return simpleJdbcCall.execute(in);
	}
}