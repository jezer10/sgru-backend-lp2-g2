package pe.edu.upeu.sysrubricas.daoImp;

import oracle.jdbc.internal.OracleTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.sysrubricas.dao.InformeDao;

import java.sql.Types;
import java.util.Map;

@Repository
public class InformeDaoImp implements InformeDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;

	@Override
	public Map<String, Object> readInformeGeneral(int ua_id, int semestre_id) {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName("D_CRUD_INFORMES")
				.withProcedureName("SPP_READALL_INFORMES_G")
				.declareParameters(new SqlOutParameter("dato", OracleTypes.CURSOR, new ColumnMapRowMapper()),
						new SqlParameter("ID_UA", Types.INTEGER), new SqlParameter("ID_S", Types.INTEGER));
		SqlParameterSource in = new MapSqlParameterSource().addValue("ID_UA", ua_id).addValue("ID_S", semestre_id);
		return simpleJdbcCall.execute(in);
	}

	@Override
	public Map<String, Object> readInformeIndividual(int ua_id, int semestre_id, int utils_id) {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName("D_CRUD_INFORMES")
				.withProcedureName("SPP_READALL_INFORMES_I")
				.declareParameters(new SqlOutParameter("dato", OracleTypes.CURSOR, new ColumnMapRowMapper()),
						new SqlParameter("ID_UA", Types.INTEGER), new SqlParameter("ID_S", Types.INTEGER),
						new SqlParameter("ID_U", Types.INTEGER));
		SqlParameterSource in = new MapSqlParameterSource().addValue("ID_UA", ua_id).addValue("ID_S", semestre_id)
				.addValue("ID_U", utils_id);
		return simpleJdbcCall.execute(in);
	}

	@Override
	public Map<String, Object> readAllInformeUAC() {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName("D_CRUD_INFORMES")
				.withProcedureName("SPP_READALL_I_UA_C")
				.declareParameters(new SqlOutParameter("dato", OracleTypes.CURSOR, new ColumnMapRowMapper()));
		return simpleJdbcCall.execute();
	}

	@Override
	public Map<String, Object> readAllInformeUAF(int id) {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName("D_CRUD_INFORMES")
				.withProcedureName("SPP_READALL_I_UA_F")
				.declareParameters(new SqlOutParameter("dato", OracleTypes.CURSOR, new ColumnMapRowMapper()),
						new SqlParameter("ID", Types.INTEGER));
		SqlParameterSource in = new MapSqlParameterSource().addValue("ID", id);
		return simpleJdbcCall.execute(in);
	}

	@Override
	public Map<String, Object> readAllInformeUAPA(int id) {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName("D_CRUD_INFORMES")
				.withProcedureName("SPP_READALL_I_UA_PA")
				.declareParameters(new SqlOutParameter("dato", OracleTypes.CURSOR, new ColumnMapRowMapper()),
						new SqlParameter("ID", Types.INTEGER));
		SqlParameterSource in = new MapSqlParameterSource().addValue("ID", id);
		return simpleJdbcCall.execute(in);
	}

	@Override
	public Map<String, Object> readAllInformeS(int id) {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName("D_CRUD_INFORMES")
				.withProcedureName("SPP_READALL_I_S")
				.declareParameters(new SqlOutParameter("dato", OracleTypes.CURSOR, new ColumnMapRowMapper()),
						new SqlParameter("ID", Types.INTEGER));
		SqlParameterSource in = new MapSqlParameterSource().addValue("ID", id);
		return simpleJdbcCall.execute(in);
	}

	@Override
	public Map<String, Object> readAllInformeC(int id) {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName("D_CRUD_INFORMES")
				.withProcedureName("SPP_READALL_I_C")
				.declareParameters(new SqlOutParameter("dato", OracleTypes.CURSOR, new ColumnMapRowMapper()),
						new SqlParameter("ID", Types.INTEGER));
		SqlParameterSource in = new MapSqlParameterSource().addValue("ID", id);
		return simpleJdbcCall.execute(in);
	}

}
