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
import pe.edu.upeu.sysrubricas.dao.Docente_EvaluadorDao;
import pe.edu.upeu.sysrubricas.entity.Docente_Evaluador;
@Repository
public class Docente_EvaluadorDaoImp implements Docente_EvaluadorDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simplejdbcCall;
	@Override
	public int create(Docente_Evaluador de) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("call D_CRUD_DOCENTE_EVALUADOR.SPP_INS_DOCENTE_EVALUADOR(?,?,?,?,?)", de.getPersona_id(),
				de.getTipo_evaluador_id(), de.getCorreo_trabajo(), de.getGrado_academico(), de.getEstado());
	}
	@Override
	public int update(Docente_Evaluador de) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("call D_CRUD_DOCENTE_EVALUADOR.SPP_UPD_DOCENTE_EVALUADOR(?,?,?,?,?)", de.getPersona_id(),
				de.getTipo_evaluador_id(), de.getCorreo_trabajo(), de.getGrado_academico(), de.getEstado());
	}
	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("call D_CRUD_DOCENTE_EVALUADOR.SPP_DEL_DOCENTE_EVALUADOR(?)", id);
	}
	@Override
	public Map<String, Object> read(int id) {
		// TODO Auto-generated method stub
		simplejdbcCall=new SimpleJdbcCall(jdbcTemplate).withCatalogName("D_CRUD_DOCENTE_EVALUADOR").withProcedureName("SPP_READ_DOCENTE_EVALUADOR").declareParameters(new SqlOutParameter("CURSOR_DOCENTE_EVALUADOR", OracleTypes.CURSOR, new ColumnMapRowMapper()), new SqlParameter("IDPERSONA", Types.INTEGER));
		SqlParameterSource in=new MapSqlParameterSource().addValue("IDPERSONA", id);
		return simplejdbcCall.execute(in);
	}
	@Override
	public Map<String, Object> readAll() {
		// TODO Auto-generated method stub
		simplejdbcCall=new SimpleJdbcCall(jdbcTemplate).withCatalogName("D_CRUD_DOCENTE_EVALUADOR").withProcedureName("SPP_READALL_DOCENTE_EVALUADOR").declareParameters(new SqlOutParameter("CURSOR_DOCENTE_EVALUADOR", OracleTypes.CURSOR, new ColumnMapRowMapper()));
		return simplejdbcCall.execute();
	}
}