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
import pe.edu.upeu.sysrubricas.dao.PlanDao;
import pe.edu.upeu.sysrubricas.entity.Plan;

@Repository
public class PlanDaoImpl implements PlanDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	@Override
	public int create(Plan p) {
		String sql = "declare v_p plan%rowtype; begin v_p.ua_id:=?; v_p.nombre:=?; v_p.f_ini:=?; v_p.f_fin:=?; D_CRUD_CURSO.SPP_INS_CURSO(v_p); end;";
		return jdbcTemplate.update(sql, p.getUa_id(), p.getNombre(), p.getF_ini(), p.getF_fin());
	}

	@Override
	public int update(Plan p) {
		String sql = "declare v_p plan%rowtype; begin v_p.plan_id:=?; v_p.ua_id:=?; v_p.nombre:=?; v_p.f_ini:=?; v_p.f_fin:=?; v_p.estado:=1; D_CRUD_PLAN.SPP_UPD_PLAN(v_p); end;";
		return jdbcTemplate.update(sql, p.getPlan_id(), p.getUa_id(), p.getNombre(), p.getF_ini(), p.getF_fin());
	}

	@Override
	public int delete(int id) {
		String sql="declare v_p plan.plan_id%type; begin v_p:=?; D_CRUD_PLAN.SPP_DEL_PLAN(v_p); end;";
		return jdbcTemplate.update(sql, id);
	}

	@Override
	public Map<String, Object> read(int id) {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
			.withCatalogName("D_CRUD_PLAN")
			.withProcedureName("SPP_READ_PLAN")
			.declareParameters(new SqlOutParameter("CURSOR_PLAN", OracleTypes.CURSOR, new ColumnMapRowMapper()), new SqlParameter("id_inf", Types.INTEGER));
			SqlParameterSource in = new MapSqlParameterSource().addValue("ID", id);
		return simpleJdbcCall.execute(in);
	}

	@Override
	public Map<String, Object> readAll() {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
			.withCatalogName("D_CRUD_PLAN")
			.withProcedureName("SPP_READALL_PLAN")
			.declareParameters(new SqlOutParameter("CURSOR_PLAN", OracleTypes.CURSOR, new ColumnMapRowMapper()));
		return simpleJdbcCall.execute();
	}

	@Override
	public List<Map<String, Object>> list() {
		String sql = "select * from plan";
		return jdbcTemplate.queryForList(sql);
	}


}
