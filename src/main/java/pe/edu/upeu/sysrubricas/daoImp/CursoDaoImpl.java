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
import pe.edu.upeu.sysrubricas.dao.CursoDao;
import pe.edu.upeu.sysrubricas.entity.Curso;

@Repository
public class CursoDaoImpl implements CursoDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	@Override
	public int create(Curso c) {
		String sql = "declare v_c curso%rowtype; begin v_c.nombre:=?; v_c.cr:=?; v_c.ht:=?; v_c.hp:=?; D_CRUD_CURSO.SPP_INS_CURSO(v_c); end;";
		return jdbcTemplate.update(sql, c.getNombre(), c.getCr(), c.getHt(), c.getHp());
	}

	@Override
	public int update(Curso c) {
		String sql = "declare v_c curso%rowtype; begin v_c.curso_id:=?; v_c.nombre:=?; v_c.cr:=?; v_c.ht:=?; v_c.hp:=?; v_c.estado:=1; D_CRUD_CURSO.SPP_UPD_CURSO(v_c); end;";
		return jdbcTemplate.update(sql, c.getCurso_id(), c.getNombre(), c.getCr(), c.getHt(), c.getHp());
	}

	@Override
	public int delete(int id) {
		String sql="declare v_id curso.curso_id%type; begin v_id:=?; D_CRUD_CURSO.SPP_DEL_CURSO(v_id); end;";
		return jdbcTemplate.update(sql, id);
	}
	
	@Override
	public Map<String, Object> read(int id) {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
			.withCatalogName("D_CRUD_CURSO")
			.withProcedureName("SPP_READ_CURSO")
			.declareParameters(new SqlOutParameter("CURSOR_CURSO", OracleTypes.CURSOR, new ColumnMapRowMapper()), new SqlParameter("id_inf", Types.INTEGER));
			SqlParameterSource in = new MapSqlParameterSource().addValue("ID", id);
		return simpleJdbcCall.execute(in);
	}

	@Override
	public Map<String, Object> readAll() {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
			.withCatalogName("D_CRUD_CURSO")
			.withProcedureName("SPP_READALL_CURSO")
			.declareParameters(new SqlOutParameter("CURSOR_CURSO", OracleTypes.CURSOR, new ColumnMapRowMapper()));
		return simpleJdbcCall.execute();
	}

	@Override
	public List<Map<String, Object>> list() {
		String sql = "select * from curso";
		return jdbcTemplate.queryForList(sql);
	}

}
