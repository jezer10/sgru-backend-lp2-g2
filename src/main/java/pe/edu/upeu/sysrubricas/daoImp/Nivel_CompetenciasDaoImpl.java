package pe.edu.upeu.sysrubricas.daoImp;

import java.sql.Types;
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
import pe.edu.upeu.sysrubricas.dao.Nivel_CompetenciasDao;
import pe.edu.upeu.sysrubricas.entity.Nivel_Competencias;

@Repository

public class Nivel_CompetenciasDaoImpl implements Nivel_CompetenciasDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	@Override
	public int create(Nivel_Competencias nc) {
		// TODO Auto-generated method stub
		String sql = "DECLARE P_NIVEL_COMP NIVEL_COMPETENCIAS%ROWTYPE; BEGIN P_NIVEL_COMP.competencias_id:=?; P_NIVEL_COMP.utils_id:=?; D_CRUD_NIVEL_COMP.SPP_INS_NIVEL_COMP(P_NIVEL_COMP); END;";
		return jdbcTemplate.update(sql,nc.getCompetencias_id(), nc.getUtils_id());
	
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
	public Map<String, Object> readAll() {
		// TODO Auto-generated method stub
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName("D_CRUD_NIVEL_COMP")
				.withProcedureName("SPP_READALL_NIVEL_COMP") // nombre del procedimiento
				.declareParameters(
						new SqlOutParameter("CURSOR_NIVEL_COMP", OracleTypes.REF_CURSOR, new ColumnMapRowMapper()));
		return simpleJdbcCall.execute();
	}
	@Override
	public Map<String, Object> readNivelCompetencia() {
		// TODO Auto-generated method stub
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName("D_CRUD_NIVEL_COMP")
				.withProcedureName("SPP_READALL_NICOM") // nombre del procedimiento
				.declareParameters(
						new SqlOutParameter("CURSOR_NICOM_NOMBRE", OracleTypes.REF_CURSOR, new ColumnMapRowMapper()));
		return simpleJdbcCall.execute();

	}
	@Override
	public Map<String, Object> readCompetencia() {
		// TODO Auto-generated method stub
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName("D_CRUD_COMPETENCIAS")
				.withProcedureName("SPP_READLL_NOMBRE") // nombre del procedimiento
				.declareParameters(
						new SqlOutParameter("CURSOR_COMP_NOMBRE", OracleTypes.REF_CURSOR, new ColumnMapRowMapper()));
		return simpleJdbcCall.execute();

	}
	@Override
	public Map<String, Object> readNivel() {
		// TODO Auto-generated method stub
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName("D_CRUD_UTILS")
				.withProcedureName("SPP_READALL_NIVCOMP") // nombre del procedimiento
				.declareParameters(
						new SqlOutParameter("CURSOR_NIVCOMP", OracleTypes.REF_CURSOR, new ColumnMapRowMapper()));
		return simpleJdbcCall.execute();

	}
	
}
