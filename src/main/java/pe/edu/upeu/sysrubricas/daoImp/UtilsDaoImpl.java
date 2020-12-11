package pe.edu.upeu.sysrubricas.daoImp;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import oracle.jdbc.OracleTypes;
import pe.edu.upeu.sysrubricas.dao.UtilsDao;
import pe.edu.upeu.sysrubricas.entity.Utils;

@Repository
public class UtilsDaoImpl implements UtilsDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;

	@Override
	public int create(Utils u) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Utils u) {
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
		return null;
	}

	@Override
    public Map<String, Object> readAll() {
	        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName("D_CRUD_UTILS")
	                .withProcedureName("SPP_READALL_NIVCOMP")
	                .declareParameters(new SqlOutParameter("dato", OracleTypes.CURSOR, new ColumnMapRowMapper()));
	        return simpleJdbcCall.execute();
	    }

}
