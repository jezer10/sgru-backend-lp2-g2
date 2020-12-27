package pe.edu.upeu.sysrubricas.daoImp;

import oracle.jdbc.internal.OracleTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.sysrubricas.dao.UtilsDao;

import java.util.Map;

@Repository
public class UtilsDaoImp implements UtilsDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	@Override
	public Map<String, Object> readAllCiclo() {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withCatalogName("D_CRUD_UTILS")
				.withProcedureName("SPP_READALL_CICLO")
				.declareParameters(new SqlOutParameter("CURSOR_CICLO", OracleTypes.CURSOR, new ColumnMapRowMapper()));
		return simpleJdbcCall.execute();
	}

	@Override
	public Map<String, Object> readAllGrupo() {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withCatalogName("D_CRUD_UTILS")
				.withProcedureName("SPP_READALL_GRUPO")
				.declareParameters(new SqlOutParameter("CURSOR_GRUPO", OracleTypes.CURSOR, new ColumnMapRowMapper()));
		return simpleJdbcCall.execute();
	}

	@Override
	public Map<String, Object> readAllTipoIns() {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withCatalogName("D_CRUD_UTILS")
				.withProcedureName("SPP_READALL_TIPOINS")
				.declareParameters(new SqlOutParameter("CURSOR_TIPOINS", OracleTypes.CURSOR, new ColumnMapRowMapper()));
		return simpleJdbcCall.execute();
	}

	@Override
	public Map<String, Object> readAllNCD() {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withCatalogName("D_CRUD_UTILS")
				.withProcedureName("SPP_READALL_NCD")
				.declareParameters(new SqlOutParameter("CURSOR_NCD", OracleTypes.CURSOR, new ColumnMapRowMapper()));
		return simpleJdbcCall.execute();
	}

	@Override
	public Map<String, Object> readAllNivComp() {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withCatalogName("D_CRUD_UTILS")
				.withProcedureName("SPP_READALL_NIVCOMP")
				.declareParameters(new SqlOutParameter("CURSOR_NIVCOMP", OracleTypes.CURSOR, new ColumnMapRowMapper()));
		return simpleJdbcCall.execute();
	}

	@Override
	public Map<String, Object> readAllNivLog() {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withCatalogName("D_CRUD_UTILS")
				.withProcedureName("SPP_READALL_NIVLOG")
				.declareParameters(new SqlOutParameter("CURSOR_NIVLOG", OracleTypes.CURSOR, new ColumnMapRowMapper()));
		return simpleJdbcCall.execute();
	}

}
