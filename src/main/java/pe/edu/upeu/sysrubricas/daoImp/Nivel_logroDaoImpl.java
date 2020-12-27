package pe.edu.upeu.sysrubricas.daoImp;

import oracle.jdbc.OracleTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.sysrubricas.dao.Nivel_logroDao;
import pe.edu.upeu.sysrubricas.entity.Nivel_logro;

import java.sql.Types;
import java.util.Map;

@Repository

public class Nivel_logroDaoImpl implements Nivel_logroDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;

	@Override
	public int create(Nivel_logro l) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Nivel_logro l) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
    public Map<String, Object> read(int id) {
        // TODO Auto-generated method stub
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName("D_CRUD_NIVEl_LOGRO")
                .withProcedureName("SPP_READ_NIVEL_LOGRO")
                .declareParameters(new SqlOutParameter("dato", OracleTypes.CURSOR, new ColumnMapRowMapper()),
                        new SqlParameter("NIVEL_LOGRO_ID", Types.INTEGER));
        SqlParameterSource in = new MapSqlParameterSource().addValue("NIVEL_LOGRO_ID", id);
        return simpleJdbcCall.execute(in);
    }

    @Override
    public Map<String, Object> readAll() {
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName("D_CRUD_NIVEl_LOGRO")
                .withProcedureName("SPP_READALL_NIVEL_LOGRO")
                .declareParameters(new SqlOutParameter("dato", OracleTypes.CURSOR, new ColumnMapRowMapper()));
        return simpleJdbcCall.execute();
    }
}
