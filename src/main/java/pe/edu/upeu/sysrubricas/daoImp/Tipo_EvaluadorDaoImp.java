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
import oracle.jdbc.internal.OracleTypes;
import pe.edu.upeu.sysrubricas.dao.Tipo_EvaluadorDao;
import pe.edu.upeu.sysrubricas.entity.Tipo_Evaluador;
@Repository
public class Tipo_EvaluadorDaoImp implements Tipo_EvaluadorDao{
	@Autowired
	private JdbcTemplate jdbctemplate;
	private SimpleJdbcCall simplejdbcCall;
	@Override
	public int create(Tipo_Evaluador te) {
		// TODO Auto-generated method stub
		return jdbctemplate.update("call D_CRUD_TIPO_EVALUADOR.SPP_INS_TIPO_EVALUADOR(?)", te.getNombre());
	}
	@Override
	public int update(Tipo_Evaluador te) {
		// TODO Auto-generated method stub
		return jdbctemplate.update("call D_CRUD_TIPO_EVALUADOR.SPP_UPD_TIPO_EVALUADOR(?,?)", te.getTipo_evaluador_id(), te.getNombre());
	}
	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return jdbctemplate.update("call D_CRUD_TIPO_EVALUADOR.SPP_DEL_TIPO_EVALUADOR(?)", id);
	}
	@Override
	public Map<String, Object> read(int id) {
		// TODO Auto-generated method stub
		simplejdbcCall=new SimpleJdbcCall(jdbctemplate).withCatalogName("D_CRUD_TIPO_EVALUADOR").withProcedureName("SPP_READ_TIPO_EVALUADOR").declareParameters(new SqlOutParameter("CURSOR_TIPO_EVALUADOR", OracleTypes.CURSOR, new ColumnMapRowMapper()),new SqlParameter("ID_TIPO_EVALUADOR", Types.INTEGER));
		SqlParameterSource in = new MapSqlParameterSource().addValue("ID_TIPO_EVALUADOR", id);
		return simplejdbcCall.execute(in);
	}
	@Override
	public Map<String, Object> readAll() {
		// TODO Auto-generated method stub
		simplejdbcCall=new SimpleJdbcCall(jdbctemplate).withCatalogName("D_CRUD_TIPO_EVALUADOR").withProcedureName("SPP_READALL_TIPO_EVALUADOR").declareParameters(new SqlOutParameter("CURSOR_TIPO_EVALUADOR", OracleTypes.CURSOR, new ColumnMapRowMapper()));
		return simplejdbcCall.execute();
	}
}