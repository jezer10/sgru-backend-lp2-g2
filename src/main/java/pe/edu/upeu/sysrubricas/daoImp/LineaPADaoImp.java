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
import pe.edu.upeu.sysrubricas.dao.LineaPADao;
import pe.edu.upeu.sysrubricas.entity.LineaPA;

import java.sql.Types;
import java.util.List;
import java.util.Map;

@Repository
public class LineaPADaoImp implements LineaPADao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	@Override
	public int create(LineaPA l) {
		String sql="declare v_lpa lineas_pa%rowtype; begin v_lpa.nombre:=?; D_CRUD_LINEAS_PA.SPP_INS_LINEAS_PA(v_lpa); end;";
		return jdbcTemplate.update(sql,l.getNombre());
	}
	@Override
	public int update(LineaPA l) {
		String sql="declare v_lpa lineas_pa%rowtype; begin v_lpa.lineas_pa_id:=?; v_lpa.nombre:=?; v_lpa.estado:=1; D_CRUD_LINEAS_PA.SPP_UPD_LINEAS_PA(v_lpa); end;";
		return jdbcTemplate.update(sql, l.getLineas_pa_id(),l.getNombre());
	}
	@Override
	public int delete(int id) {
		String sql="declare v_id lineas_pa.lineas_pa_id%type; begin v_id:=?; D_CRUD_LINEAS_PA.SPP_DEL_LINEAS_PA(v_id); end;";
		return jdbcTemplate.update(sql,id);
	}
	@Override
	public Map<String,Object>read(int id) {
		simpleJdbcCall=new SimpleJdbcCall(jdbcTemplate).withCatalogName("D_CRUD_LINEAS_PA").withProcedureName("SPP_READ_LINEAS_PA").declareParameters(new SqlOutParameter("CURSOR_LINEAS_PA",OracleTypes.CURSOR,new ColumnMapRowMapper()),new SqlParameter("id_inf", Types.INTEGER));
		SqlParameterSource in = new MapSqlParameterSource().addValue("ID", id);
		return simpleJdbcCall.execute(in);
	}
	@Override
	public Map<String,Object>readAll() {
		simpleJdbcCall=new SimpleJdbcCall(jdbcTemplate).withCatalogName("D_CRUD_LINEAS_PA").withProcedureName("SPP_READALL_LINEAS_PA").declareParameters(new SqlOutParameter("CURSOR_LINEAS_PA",OracleTypes.CURSOR,new ColumnMapRowMapper()));
		return simpleJdbcCall.execute();
	}
	@Override
	public List<Map<String,Object>>list() {
		String sql = "select * from lineas_pa";
		return jdbcTemplate.queryForList(sql);
	}
}