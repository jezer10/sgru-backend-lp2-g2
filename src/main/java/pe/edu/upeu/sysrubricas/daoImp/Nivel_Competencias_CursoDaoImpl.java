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
import pe.edu.upeu.sysrubricas.dao.Nivel_Competencias_CursoDao;
import pe.edu.upeu.sysrubricas.entity.Nivel_Competencias_Curso;

@Repository

public class Nivel_Competencias_CursoDaoImpl implements Nivel_Competencias_CursoDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	@Override
	public int create(Nivel_Competencias_Curso ncc) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("declare P_NIV_COM_CUR NIVEL_COMPETENCIAS_CURSO%ROWTYPE; "				
				+ "P_NIV_COM_CUR.NIVEL_COMPETENCIAS_ID:=?; "
				+ "P_NIV_COM_CUR.PLAN_CURSO_ID:=?; "
				+ " \"D_CRUD_NIV_COM_CUR.SPP_INS_NIV_COM_CUR(P_NIV_COM_CUR); end;",				
				ncc.getNivel_competencias_id(), 
				ncc.getPlan_curso_id()
				);
	}
	@Override
	public int update(Nivel_Competencias_Curso ncc) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("declare P_NIV_COM_CUR NIVEL_COMPETENCIAS_CURSO%ROWTYPE; "
				+ "begin P_NIV_COM_CUR.NIVEL_COMPETENCIAS_CURSO_ID:=?; "
				+ "P_NIV_COM_CUR.NIVEL_COMPETENCIAS_ID:=?; "
				+ "P_NIV_COM_CUR.PLAN_CURSO_ID:=?; "
				+ " \"D_CRUD_NIV_COM_CUR.SPP_UPD_NIV_COM_CUR(P_NIV_COM_CUR); end;",
				ncc.getNivel_competencias_curso_id(),
				ncc.getNivel_competencias_id(), 
				ncc.getPlan_curso_id()
				);
	}
	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("call D_CRUD_NIV_COM_CUR.P_NIV_COM_CUR(?)", id);
	}
	@Override
	public Map<String, Object> read(int id) {
		// TODO Auto-generated method stub
		System.out.println(id);
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
		.withCatalogName("D_CRUD_NIV_COM_CUR") //nombre del paquete
		.withProcedureName("SPP_READ_NIV_COM_CUR") //nombre del procedimiento
		.declareParameters(new SqlOutParameter("CURSOR_NIV_COM_CUR", OracleTypes.CURSOR, 
				new ColumnMapRowMapper()), new SqlParameter("ID", Types.INTEGER));
		SqlParameterSource in = new MapSqlParameterSource().addValue("ID", id);
		return simpleJdbcCall.execute(in);
	}
	@Override
	public List<Map<String, Object>> readAll() {
		// TODO Auto-generated method stub
		List<Map<String,Object>> nivel_competencia_curso = new ArrayList<>();
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withCatalogName("D_CRUD_NIV_COM_CUR") 
				.withProcedureName("SPP_READALL_NIV_COM_CUR") //nombre del procedimiento
				.declareParameters(new SqlOutParameter("CURSOR_NIV_COM_CUR", OracleTypes.REF_CURSOR, new ColumnMapRowMapper()));	
				Map<String, Object> map = simpleJdbcCall.execute();
				nivel_competencia_curso.add(map);
		return nivel_competencia_curso;
	}

	
	
}
