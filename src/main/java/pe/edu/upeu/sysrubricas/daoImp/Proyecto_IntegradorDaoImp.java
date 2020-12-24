package pe.edu.upeu.sysrubricas.daoImp;
import java.sql.Types;
import java.util.List;
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
import pe.edu.upeu.sysrubricas.dao.Proyecto_IntegradorDao;
import pe.edu.upeu.sysrubricas.entity.Proyecto_Integrador;
@Repository
public class Proyecto_IntegradorDaoImp implements Proyecto_IntegradorDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	@Override
	public int create(Proyecto_Integrador py) {
		String sql="declare v_py proyecto_integrador%rowtype; begin v_py.utils_id:=?; v_py.semestre_id:=?; v_py.n_grupos:=?; v_py.n_cursos:=?; v_py.persona_id:=?; d_crud_proyecto_integrador.spp_ins_proyecto_integrador(v_py); end;";
		return  jdbcTemplate.update(sql,py.getUtils_id(),py.getSemestre_id(),py.getN_grupos(),py.getN_cursos(),py.getPersona_id());
	}

	@Override
	public int update(Proyecto_Integrador py) {
		String sql="declare v_py proyecto_integrador%rowtype; begin v_py.PY_ID:=?; v_py.utils_id:=?; v_py.semestre_id:=?; v_py.n_grupos:=?; v_py.n_cursos:=?; v_py.persona_id:=?; d_crud_proyecto_integrador.spp_upd_proyecto_integrador(v_py); end;";
		return jdbcTemplate.update(sql,py.getPy_id(),py.getUtils_id(),py.getSemestre_id(),py.getN_grupos(),py.getN_cursos(),py.getPersona_id());
	}

	@Override
	public int delete(int id) {
		String sql="declare v_id proyecto_integrador.py_id%type; begin v_id:=?; d_crud_proyecto_integrador.spp_del_proyecto_integrador(v_id); end;";
		return jdbcTemplate.update(sql,id);
	}

	@Override
	public Map<String,Object>read(int id) {
		simpleJdbcCall=new SimpleJdbcCall(jdbcTemplate).withCatalogName("D_CRUD_PROYECTO_INTEGRADOR").withProcedureName("SPP_READ_PROYECTO_INTEGRADOR").declareParameters(new SqlOutParameter("CURSOR_PROYECTO_INTEGRADOR",OracleTypes.CURSOR,new ColumnMapRowMapper()),new SqlParameter("id_inf", Types.INTEGER));
		SqlParameterSource in = new MapSqlParameterSource().addValue("ID", id);
		return simpleJdbcCall.execute(in);
	}

	@Override
	public Map<String,Object>readAll() {
		simpleJdbcCall=new SimpleJdbcCall(jdbcTemplate).withCatalogName("D_CRUD_PROYECTO_INTEGRADOR").withProcedureName("SPP_READALL_PROY_INTEG").declareParameters(new SqlOutParameter("CURSOR_PROYECTO_INTEGRADOR",OracleTypes.CURSOR,new ColumnMapRowMapper()));
		return simpleJdbcCall.execute();
	}

	@Override
	public List<Map<String, Object>> list() {
		String sql="select * from proyecto_integrador";
		return jdbcTemplate.queryForList(sql);
	}
}