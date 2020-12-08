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
import pe.edu.upeu.sysrubricas.dao.Py_GruposDao;
import pe.edu.upeu.sysrubricas.entity.Py_Grupos;
@Repository
public class Py_GruposDaoImp implements Py_GruposDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	@Override
	public int create(Py_Grupos p) {
		String sql="declare pg py_grupos%rowtype; begin pg.utils_id:=?; pg.py_id:=?; pg.nombre_py:=?; d_crud_py_grupos.spp_ins_py_grupos(pg); end;";
		return jdbcTemplate.update(sql,p.getUtils_id(),p.getPy_id(),p.getNombre_py());
	}
	@Override
	public int update(Py_Grupos p) {
		String sql="declare pg py_grupos%rowtype; begin pg.py_grupo_id:=?; pg.utils_id:=?; pg.py_id:=?; pg.nombre_py:=?; d_crud_py_grupos.spp_upd_py_grupos(pg); end;";
		return jdbcTemplate.update(sql,p.getPy_grupo_id(),p.getUtils_id(),p.getPy_id(),p.getNombre_py());
	}
	@Override
	public int delete(int id) {
		String sql="declare v_id py_grupos.py_grupo_id%type; begin v_id:=?; d_crud_py_grupos.spp_del_py_grupos(v_id); end;";
		return jdbcTemplate.update(sql,id);
	}
	@Override
	public Map<String,Object>read(int id) {
		simpleJdbcCall=new SimpleJdbcCall(jdbcTemplate).withCatalogName("D_CRUD_PY_GRUPOS").withProcedureName("SPP_READ_PY_GRUPOS").declareParameters(new SqlOutParameter("CURSOR_PY_GRUPOS",OracleTypes.CURSOR,new ColumnMapRowMapper()),new SqlParameter("id_inf", Types.INTEGER));
		SqlParameterSource in = new MapSqlParameterSource().addValue("ID", id);
		return simpleJdbcCall.execute(in);
	}
	@Override
	public Map<String, Object> readAll() {
		simpleJdbcCall=new SimpleJdbcCall(jdbcTemplate).withCatalogName("D_CRUD_PY_GRUPOS").withProcedureName("SPP_READALL_PY_GRUPOS").declareParameters(new SqlOutParameter("CURSOR_PY_GRUPOS",OracleTypes.CURSOR,new ColumnMapRowMapper()));
		return simpleJdbcCall.execute();
	}
	@Override
	public List<Map<String, Object>> list() {
		String sql="select * from py_grupos;";
		return jdbcTemplate.queryForList(sql);
	}
}