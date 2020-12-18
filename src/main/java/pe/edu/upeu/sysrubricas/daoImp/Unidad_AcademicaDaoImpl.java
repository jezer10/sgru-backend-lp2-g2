package pe.edu.upeu.sysrubricas.daoImp;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import oracle.jdbc.OracleTypes;
import pe.edu.upeu.sysrubricas.dao.Unidad_AcademicaDao;

@Repository

public class Unidad_AcademicaDaoImpl implements Unidad_AcademicaDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	
	@Override
	public Map<String, Object> read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> readAll() {
		// TODO Auto-generated method stub
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withCatalogName("D_CRUD_UNIDAD_ACADEMICA") //nombre del paquete
				.withProcedureName("SPP_READALL_UNIDAD_ACADEMICA") //nombre del procedimiento
				.declareParameters(new SqlOutParameter("CURSOR_UNIDAD_ACADEMICA", OracleTypes.CURSOR, 
						new ColumnMapRowMapper()));
				return simpleJdbcCall.execute();
	}

}
