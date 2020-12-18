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
import pe.edu.upeu.sysrubricas.dao.Nivel_CompetenciaDao;
import pe.edu.upeu.sysrubricas.entity.Nivel_Competencias;

@Repository
public class Nivel_CompetenciaDaoImpl implements Nivel_CompetenciaDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	@Override
	public int create(Nivel_Competencias nc) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("declare P_NIVEL_COMP NIVEL_COMPETENCIAS%ROWTYPE; "
				+ "begin P_NIVEL_COMP.NIVEL_COMPETENCIAS_ID:=?; "
				+ "P_NIVEL_COMP.COMPETENCIAS_ID:=?; "
				+ "P_NIVEL_COMP.UTILS_ID:=?; "
				+ " \"D_CRUD_NIVEL_COMP.SPP_INS_NIVEL_COMP(P_NIVEL_COMP); end;",
				nc.getNivel_competencias_id(),
				nc.getCompetencias_id(), 
				nc.getUtils_id()
				);
	}
	@Override
	public int update(Nivel_Competencias nc) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("declare P_NIVEL_COMP NIVEL_COMPETENCIAS%ROWTYPE; "
				+ "begin P_NIVEL_COMP.NIVEL_COMPETENCIAS_ID:=?; "
				+ "P_NIVEL_COMP.COMPETENCIAS_ID:=?; "
				+ "P_NIVEL_COMP.UTILS_ID:=?; "
				+ "D_CRUD_NIVEL_COMP.SPP_UPD_NIVEL_COMP(P_NIVEL_COMP); end;",
				nc.getNivel_competencias_id(),
				nc.getCompetencias_id(), 
				nc.getUtils_id()
				);
	}
	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("call D_CRUD_NIVEL_COMP.SPP_DEL_NIVEL_COMP(?)", id);
	}
	@Override
	public Map<String, Object> read(int id) {
		// TODO Auto-generated method stub
		System.out.println(id);
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
		.withCatalogName("D_CRUD_NIVEL_COMP") //nombre del paquete
		.withProcedureName("SPP_READ_NIVEL_COMP") //nombre del procedimiento
		.declareParameters(new SqlOutParameter("CURSOR_NIVEL_COMP", OracleTypes.CURSOR, 
				new ColumnMapRowMapper()), new SqlParameter("ID", Types.INTEGER));
		SqlParameterSource in = new MapSqlParameterSource().addValue("ID", id);
		return simpleJdbcCall.execute(in);
	}
	@Override
	public List<Map<String, Object>> readAll() {
		// TODO Auto-generated method stub
		List<Map<String,Object>> nivel_competencia = new ArrayList<>();
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withCatalogName("D_CRUD_NIVEL_COMP") 
				.withProcedureName("SPP_READALL_NICOM") //nombre del procedimiento
				.declareParameters(new SqlOutParameter("CURSOR_NICOM_NOMBRE", OracleTypes.REF_CURSOR, new ColumnMapRowMapper()));	
				Map<String, Object> map = simpleJdbcCall.execute();
				nivel_competencia.add(map);
		return nivel_competencia;
	}
}
