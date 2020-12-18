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
import pe.edu.upeu.sysrubricas.dao.IndicadorDao;
import pe.edu.upeu.sysrubricas.entity.Indicador;
@Repository

public class IndicadorDaoImpl implements IndicadorDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	
	@Override
	public int create(Indicador i) {
		// TODO Auto-generated method stub
		
		return jdbcTemplate.update("declare P_INDICADOR INDICADOR%ROWTYPE;"
				+ " begin  P_INDICADOR.RUBRICA_ID:=?; "
				+ "P_INDICADOR.NOMBRE:=?; P_INDICADOR.PESO:=?; "
				+ "D_CRUD_INDICADOR.SPP_INS_INDICADOR(P_INDICADOR); end;",
				i.getRubrica_id(),
				i.getNombre(),
				i.getPeso());
	}

	@Override
	public int update(Indicador i) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("declare P_INDICADOR INDICADOR%ROWTYPE; "
				+ " begin  P_INDICADOR.RUBRICA_ID:=?; "
				+ "P_INDICADOR.NOMBRE:=?; P_INDICADOR.PESO:=?; "
				+ "D_CRUD_INDICADOR.SPP_INS_INDICADOR(P_INDICADOR); end;",
				i.getIndicador_id(),
				i.getRubrica_id(),
				i.getNombre(),
				i.getPeso());
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("call D_CRUD_INDICADOR.SPP_DEL_INDICADOR(?)", id);
	}

	@Override
	public Map<String, Object> read(int id) {
		// TODO Auto-generated method stub
		System.out.println(id);
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
		.withCatalogName("D_CRUD_INDICADOR") //nombre del paquete
		.withProcedureName("SPP_READ_INDICADOR") //nombre del procedimiento
		.declareParameters(new SqlOutParameter("CURSOR_INDICADOR", OracleTypes.CURSOR, 
				new ColumnMapRowMapper()), new SqlParameter("ID", Types.INTEGER));
		SqlParameterSource in = new MapSqlParameterSource().addValue("ID", id);
		return simpleJdbcCall.execute(in);
	}

	@Override
	public Map<String, Object> readAll() {
		// TODO Auto-generated method stub
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withCatalogName("D_CRUD_INDICADOR") //nombre del paquete
				.withProcedureName("SPP_READALL_INDICADOR") //nombre del procedimiento
				.declareParameters(new SqlOutParameter("CURSOR_INDICADOR", OracleTypes.CURSOR, 
						new ColumnMapRowMapper()));
				return simpleJdbcCall.execute();
	}
	
}

