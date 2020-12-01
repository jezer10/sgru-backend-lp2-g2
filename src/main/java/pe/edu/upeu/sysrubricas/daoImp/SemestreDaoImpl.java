package pe.edu.upeu.sysrubricas.daoImp;

import java.sql.Types;
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
import pe.edu.upeu.sysrubricas.dao.SemestreDao;
import pe.edu.upeu.sysrubricas.entity.Semestre;

@Repository
public class SemestreDaoImpl implements SemestreDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;


	@Override
	public int create(Semestre s) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Semestre s) {
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
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName("D_CRUD_SEMESTRE")
                .withProcedureName("SPP_READ_SEMESTRE")
                .declareParameters(new SqlOutParameter("dato", OracleTypes.CURSOR, new ColumnMapRowMapper()),
                        new SqlParameter("SEMESTRE_ID", Types.INTEGER));
        SqlParameterSource in = new MapSqlParameterSource().addValue("SEMESTRE_ID", id);
        return simpleJdbcCall.execute(in);
    }

    @Override
    public Map<String, Object> readAll() {
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName("D_CRUD_SEMESTRE")
                .withProcedureName("SPP_READALL_SEMESTRE")
                .declareParameters(new SqlOutParameter("dato", OracleTypes.CURSOR, new ColumnMapRowMapper()));
        return simpleJdbcCall.execute();
    }

	
}
