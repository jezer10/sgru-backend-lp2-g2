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
import pe.edu.upeu.sysrubricas.dao.Nivel_RubricaDao;
import pe.edu.upeu.sysrubricas.entity.NivelRubrica;

@Repository
public class Nivel_RubricaDaoImpl implements Nivel_RubricaDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	@Override
	public int create(NivelRubrica nr) {
		return jdbcTemplate.update("declare P_ST_TABLA NIVEL_RUBRICA%ROWTYPE; "
				+ "begin  P_ST_TABLA.NIVEL_LOGRO_ID:=?; P_ST_TABLA.INDICADOR_ID:=?; "
				+ "P_ST_TABLA.DESCRIPCION:=?; D_CRUD_NIVEL_RUBRICA.SPP_INS_NIVEL_RUBRICA(P_ST_TABLA);"
				+ "end;",
				nr.getNivel_logro_id(),
				nr.getIndicador_id(),
				nr.getDescripcion());
	}

	@Override
	public int update(NivelRubrica nr) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("declare P_ST_TABLA NIVEL_RUBRICA%ROWTYPE; "
				+ "begin  P_ST_TABLA.NIVEL_LOGRO_ID:=?; P_ST_TABLA.INDICADOR_ID:=?; "
				+ "P_ST_TABLA.DESCRIPCION:=?; D_CRUD_NIVEL_RUBRICA.SPP_UPD_NIVEL_RUBRICA(P_ST_TABLA);"
				+ "end;",
				nr.getNivel_rubrica_id(),
				nr.getNivel_logro_id(),
				nr.getIndicador_id(),
				nr.getDescripcion());
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("call D_CRUD_NIVEL_RUBRICA.SPP_DEL_NIVEL_RUBRICA(?)", id);
	}
	@Override
	public Map<String, Object> read(int id) {
		// TODO Auto-generated method stub
		System.out.println(id);
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
		.withCatalogName("D_CRUD_NIVEL_RUBRICA") //nombre del paquete
		.withProcedureName("SPP_READ_NIVEL_RUBRICA") //nombre del procedimiento
		.declareParameters(new SqlOutParameter("CURSOR_NIVEL_RUBRICA", OracleTypes.CURSOR, 
				new ColumnMapRowMapper()), new SqlParameter("ID", Types.INTEGER));
		SqlParameterSource in = new MapSqlParameterSource().addValue("ID", id);
		return simpleJdbcCall.execute(in);
	}

	@Override
	public Map<String, Object> readAll() {
		// TODO Auto-generated method stub
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withCatalogName("D_CRUD_NIVEL_RUBRICA") //nombre del paquete
				.withProcedureName("SPP_READALL_NIRU") //nombre del procedimiento
				.declareParameters(new SqlOutParameter("CURSOR_NIVEL_RUBRICA_NOMBRE", OracleTypes.CURSOR, 
						new ColumnMapRowMapper()));
				return simpleJdbcCall.execute();
	}

}
