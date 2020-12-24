package pe.edu.upeu.sysrubricas.daoImp;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import oracle.jdbc.internal.OracleTypes;
import pe.edu.upeu.sysrubricas.dao.TipoDocumentoDao;
@Repository
public class TipoDocumentoDaoImp implements TipoDocumentoDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	@Override
	public Map<String, Object> readAll() {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withCatalogName("D_CRUD_TIPO_DOC")
				.withProcedureName("SPP_READALL_TIPO_DOC")
				.declareParameters(new SqlOutParameter("dato", OracleTypes.CURSOR, new ColumnMapRowMapper()));
		return simpleJdbcCall.execute();
	}

}
