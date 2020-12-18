package pe.edu.upeu.sysrubricas.daoImp;

import java.sql.Types;
import java.util.ArrayList;
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
import pe.edu.upeu.sysrubricas.dao.Competencia_LineaDao;
import pe.edu.upeu.sysrubricas.entity.Competencia_Linea;
@Repository
public class Competencia_LineaDaoImpl implements Competencia_LineaDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	@Override
	public List<Map<String, Object>> readAll() {
		// TODO Auto-generated method stub
		List<Map<String,Object>> competencia_linea = new ArrayList<>();
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withCatalogName("D_CRUD_COMPETENCIA_LINEA") 
				.withProcedureName("SPP_READLL_NOM") //nombre del procedimiento
				.declareParameters(new SqlOutParameter("CURSOR_COMLI_NOMBRE", OracleTypes.REF_CURSOR, new ColumnMapRowMapper()));	
				Map<String, Object> map = simpleJdbcCall.execute();
				competencia_linea.add(map);
		return competencia_linea;
	}
	@Override
	public int create(Competencia_Linea cl) {
		// TODO Auto-generated method stub
		
		return jdbcTemplate.update("declare P_C COMPETENCIA_LINEA%ROWTYPE; "
				+ "begin  P_C.COMPETENCIAS_ID:=?; P_C.LINEA_PLAN_ID:=?; "
				+ "D_CRUD_COMPETENCIA_LINEA.SPP_INS_COMPETENCIA_LINEA(P_C); end;",
				cl.getCompetencias_id(),
				cl.getLinea_plan_id());
			
	}
	@Override
	public int update(Competencia_Linea cl) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("declare P_C COMPETENCIA_LINEA%ROWTYPE; "
				+ "begin  P_C.CL_ID:=?; P_C.COMPETENCIAS_ID:=?; P_C.LINEA_PLAN_ID:=?; "
				+ "D_CRUD_COMPETENCIA_LINEA.SPP_INS_COMPETENCIA_LINEA(P_C); end;",
				cl.getCl_id(),
				cl.getCompetencias_id(),
				cl.getLinea_plan_id());
	}
	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("call D_CRUD_COMPETENCIA_LINEA.SPP_DEL_COMPETENCIA_LINEA(?)", id);
	}
	@Override
	public Map<String, Object> read(int id) {
		// TODO Auto-generated method stub
		System.out.println(id);
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
		.withCatalogName("D_CRUD_COMPETENCIA_LINEA") //nombre del paquete
		.withProcedureName("SPP_READ_COMPETENCIA_LINEA") //nombre del procedimiento
		.declareParameters(new SqlOutParameter("CURSOR_COMPETENCIA_LINEA", OracleTypes.CURSOR, 
				new ColumnMapRowMapper()), new SqlParameter("ID", Types.INTEGER));
		SqlParameterSource in = new MapSqlParameterSource().addValue("ID", id);
		return simpleJdbcCall.execute(in);
	}

}
