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
import pe.edu.upeu.sysrubricas.dao.EstudianteDao;
import pe.edu.upeu.sysrubricas.entity.Estudiante;
@Repository
public class EstudianteDaoImp implements EstudianteDao{
	@Autowired
	private JdbcTemplate jdbctemplate;
	private SimpleJdbcCall simplejdbcCall;
	@Override
	public int create(Estudiante e) {
		// TODO Auto-generated method stub
		return jdbctemplate.update("call D_CRUD_ESTUDIANTE.SPP_INS_ESTUDIANTE(?,?,?,?)", e.getPersona_id(),
				e.getCodigo_estudiante(), e.getCorreo_insti(), e.getEstado());
	}
	@Override
	public int update(Estudiante e) {
		// TODO Auto-generated method stub
		return jdbctemplate.update("call D_CRUD_ESTUDIANTE.SPP_UPD_ESTUDIANTE(?,?,?,?)", e.getPersona_id(),
				e.getCodigo_estudiante(), e.getCorreo_insti(), e.getEstado());
	}
	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return jdbctemplate.update("call D_CRUD_ESTUDIANTE.SPP_DEL_ESTUDIANTE(?)", id);
	}
	@Override
	public Map<String, Object> read(int id) {
		// TODO Auto-generated method stub
		simplejdbcCall=new SimpleJdbcCall(jdbctemplate).withCatalogName("D_CRUD_ESTUDIANTE").withProcedureName("SPP_READ_ESTUDIANTE").declareParameters(new SqlOutParameter("CURSOR_ESTUDIANTE", OracleTypes.CURSOR, new ColumnMapRowMapper()), new SqlParameter("ID_PERSONA", Types.INTEGER));
		SqlParameterSource in=new MapSqlParameterSource().addValue("ID_PERSONA", id);
		return simplejdbcCall.execute(in);
	}
	@Override
	public Map<String, Object> readAll() {
		// TODO Auto-generated method stub
		simplejdbcCall=new SimpleJdbcCall(jdbctemplate).withCatalogName("D_CRUD_ESTUDIANTE").withProcedureName("SPP_READALL_ESTUDIANTE").declareParameters(new SqlOutParameter("CURSOR_ESTUDIANTE", OracleTypes.CURSOR, new ColumnMapRowMapper()));
		return simplejdbcCall.execute();
	}
}