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
import pe.edu.upeu.sysrubricas.dao.Linea_PlanDao;
import pe.edu.upeu.sysrubricas.entity.Linea_Plan;
@Repository
public class Linea_PlanDaoImp implements Linea_PlanDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	@Override
	public int create(Linea_Plan l) {
		String sql="declare lp linea_plan%rowtype; begin lp.plan_id:=?; lp.lineas_pa_id:=?; d_crud_linea_plan.spp_ins_linea_plan(lp); end;";
		return jdbcTemplate.update(sql,l.getPlan_id(),l.getLineas_pa_id());
	}
	@Override
	public int update(Linea_Plan l) {
		String sql="declare lp linea_plan%rowtype; begin lp.linea_plan_id:=?; lp.plan_id:=?; lp.lineas_pa_id:=?; lp.estado:=1; d_crud_linea_plan.spp_upd_linea_plan(lp); end;";
		return jdbcTemplate.update(sql,l.getLinea_plan_id(),l.getPlan_id(),l.getLineas_pa_id());
	}
	@Override
	public int delete(int id) {
		String sql="declare v_id linea_plan.linea_plan_id%type; begin v_id:=?; d_crud_linea_plan.spp_del_linea_plan(v_id); end;";
		return jdbcTemplate.update(sql,id);
	}
	@Override
	public Map<String, Object> read(int id) {
		simpleJdbcCall=new SimpleJdbcCall(jdbcTemplate).withCatalogName("D_CRUD_LINEA_PLAN").withProcedureName("SPP_READ_LINEA_PLAN").declareParameters(new SqlOutParameter("CURSOR_LINEA_PLAN",OracleTypes.CURSOR,new ColumnMapRowMapper()),new SqlParameter("id_inf", Types.INTEGER));
		SqlParameterSource in = new MapSqlParameterSource().addValue("ID", id);
		return simpleJdbcCall.execute(in);
	}
	@Override
	public Map<String,Object>readAll() {
		simpleJdbcCall=new SimpleJdbcCall(jdbcTemplate).withCatalogName("D_CRUD_LINEA_PLAN").withProcedureName("SPP_READALL_LINEA_PLAN").declareParameters(new SqlOutParameter("CURSOR_LINEA_PLAN",OracleTypes.CURSOR,new ColumnMapRowMapper()));
		return simpleJdbcCall.execute();
	}
	@Override
	public List<Map<String,Object>>list() {
		String sql="select * from linea_plan;";
		return jdbcTemplate.queryForList(sql);
	}
}