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
import pe.edu.upeu.sysrubricas.dao.Grupos_EstudianteDao;
import pe.edu.upeu.sysrubricas.entity.Grupos_Estudiante;
@Repository
public class Grupos_EstudianteDaoImp implements Grupos_EstudianteDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	@Override
	public int create(Grupos_Estudiante ge) {
		String sql="declare v_ge grupos_estudiante%rowtype; begin v_ge.py_grupo_id:=?; v_ge.persona_id:=?; d_crud_gru_est.spp_ins_gru_est(v_ge); end;";
		return jdbcTemplate.update(sql,ge.getPy_grupo_id(),ge.getPersona_id());
	}
	@Override
	public int update(Grupos_Estudiante ge) {
		String sql="declare v_ge grupos_estudiante%rowtype; begin v_ge.gr_es_id:=?; v_ge.py_grupo_id:=?; v_ge.persona_id:=?; d_crud_gru_est.spp_upd_gru_est(v_ge); end;";
		return jdbcTemplate.update(sql,ge.getGr_es_id(),ge.getPy_grupo_id(),ge.getPersona_id());
	}
	@Override
	public int delete(int id) {
		String sql="declare v_id grupos_estudiante.gr_es_id%type; begin v_id:=?; d_crud_gru_est.spp_del_gru_est(v_id); end;";
		return jdbcTemplate.update(sql,id);
	}
	@Override
	public Map<String,Object>read(int id) {
		simpleJdbcCall=new SimpleJdbcCall(jdbcTemplate).withCatalogName("D_CRUD_GRU_EST").withProcedureName("SPP_READ_GRU_EST").declareParameters(new SqlOutParameter("CURSOR_GRU_EST",OracleTypes.CURSOR,new ColumnMapRowMapper()),new SqlParameter("id_inf", Types.INTEGER));
		SqlParameterSource in = new MapSqlParameterSource().addValue("ID", id);
		return simpleJdbcCall.execute(in);
	}
	@Override
	public Map<String,Object>readAll() {
		simpleJdbcCall=new SimpleJdbcCall(jdbcTemplate).withCatalogName("D_CRUD_GRU_EST").withProcedureName("SPP_READ_GRU_EST").declareParameters(new SqlOutParameter("CURSOR_GRU_EST",OracleTypes.CURSOR,new ColumnMapRowMapper()));
		return simpleJdbcCall.execute();
	}
	@Override
	public List<Map<String,Object>>list() {
		String sql="select * from grupos_estudiante";
		return jdbcTemplate.queryForList(sql);
	}
}