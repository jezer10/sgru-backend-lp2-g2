package pe.edu.upeu.sysrubricas.daoImp;

import oracle.jdbc.OracleTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.sysrubricas.dao.Plan_cursoDao;
import pe.edu.upeu.sysrubricas.entity.Plan_curso;

import java.sql.Types;
import java.util.Map;

@Repository
public class Plan_cursoDaoImpl implements Plan_cursoDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	@Override
	public int create(Plan_curso pc) {
		String sql = "declare v_pc plan_curso%rowtype; begin v_pc.plan_id:=?; v_pc.curso_id:=?; v_pc.ciclo:=?; D_CRUD_PLAN_CURSO.SPP_INS_PLAN_CURSO(v_pc); end;";
		return jdbcTemplate.update(sql, pc.getPlan_id(), pc.getCurso_id(), pc.getUtils_id());
	}

	@Override
	public int update(Plan_curso pc) {
		String sql = "declare v_pc plan_curso%rowtype; begin v_pc.plan_curso_id:=?; v_pc.plan_id=?; v_pc.curso_id:=?; v_pc.ciclo:=?; pc.estado:=1; D_CRUD_PLAN_CURSO.SPP_UPD_PLAN_CURSO(v_pc); end;";
		return jdbcTemplate.update(sql, pc.getPlan_curso_id(), pc.getPlan_id(), pc.getCurso_id(), pc.getUtils_id());
	}

	@Override
	public int delete(int id) {
		String sql="declare v_id plan_curso.plan_curso_id%type; begin v_id:=?; D_CRUD_PLAN_CURSO.SPP_DEL_PLAN_CURSO(v_id); end;";
		return jdbcTemplate.update(sql, id);
	}

	@Override
	public Map<String, Object> read(int id) {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
			.withCatalogName("D_CRUD_PLAN_CURSO")
			.withProcedureName("SPP_READ_PLAN_CURSO")
			.declareParameters(new SqlOutParameter("CURSOR_PLAN_CURSO", OracleTypes.CURSOR, new ColumnMapRowMapper()), new SqlParameter("id_inf", Types.INTEGER));
			SqlParameterSource in = new MapSqlParameterSource().addValue("ID", id);
		return simpleJdbcCall.execute(in);
	}

	@Override
	public Map<String, Object> readAll() {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
			.withCatalogName("D_CRUD_PLAN_CURSO")
			.withProcedureName("SPP_READALL_PLAN_CURSO")
			.declareParameters(new SqlOutParameter("CURSOR_PLAN_CURSO", OracleTypes.CURSOR, new ColumnMapRowMapper()));
		return simpleJdbcCall.execute();
	}

	@Override
	public Map<String, Object> readCurso() {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withCatalogName("D_CRUD_PLAN_CURSO")
				.withProcedureName("SPP_CURSOS")
				.declareParameters(new SqlOutParameter("CURSOR_CUR", OracleTypes.CURSOR, new ColumnMapRowMapper()));
			return simpleJdbcCall.execute();
	}

	@Override
	public Map<String, Object> readPlan() {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withCatalogName("D_CRUD_PLAN_CURSO")
				.withProcedureName("SPP_PLANES")
				.declareParameters(new SqlOutParameter("CURSOR_PL", OracleTypes.CURSOR, new ColumnMapRowMapper()));
			return simpleJdbcCall.execute();
	}

	@Override
	public Map<String, Object> readAll2() {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withCatalogName("D_CRUD_PLAN_CURSO")
				.withProcedureName("SPP_LISTAR_PLAN_CURSO_N")
				.declareParameters(new SqlOutParameter("CURSOR_PLAN_CURSO_N", OracleTypes.CURSOR, new ColumnMapRowMapper()));
			return simpleJdbcCall.execute();
	}

	@Override
	public Map<String, Object> readCiclo() {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withCatalogName("D_CRUD_UTILS")
				.withProcedureName("SPP_READALL_CICLO")
				.declareParameters(new SqlOutParameter("CURSOR_CICLO", OracleTypes.CURSOR, new ColumnMapRowMapper()));
			return simpleJdbcCall.execute();
	}
}
