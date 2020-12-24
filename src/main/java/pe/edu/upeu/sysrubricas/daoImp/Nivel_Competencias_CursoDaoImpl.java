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
import pe.edu.upeu.sysrubricas.dao.Nivel_Competencias_CursoDao;
import pe.edu.upeu.sysrubricas.entity.Nivel_Competencias_Curso;

@Repository

public class Nivel_Competencias_CursoDaoImpl  implements Nivel_Competencias_CursoDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;

	@Override
	public int create(Nivel_Competencias_Curso ncc) {
		// TODO Auto-generated method stub
		String sql = "DECLARE P_NIV_COM_CUR NIVEL_COMPETENCIAS_CURSO%ROWTYPE; BEGIN P_NIV_COM_CUR.nivel_competencias_id:=?; P_NIV_COM_CUR.plan_curso_id:=?; D_CRUD_NIV_COM_CUR.SPP_INS_NIV_COM_CUR(P_NIV_COM_CUR); END;";
		return jdbcTemplate.update(sql,ncc.getNivel_competencias_id(), ncc.getPlan_curso_id());
	}

	@Override
	public int update(Nivel_Competencias_Curso ncc) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("declare P_NIV_COM_CUR NIVEL_COMPETENCIAS_CURSO%ROWTYPE; "
				+ "begin P_NIV_COM_CUR.NIVEL_COMPETENCIAS_CURSO_ID:=?; " + "P_NIV_COM_CUR.NIVEL_COMPETENCIAS_ID:=?; "
				+ "P_NIV_COM_CUR.PLAN_CURSO_ID:=?; " + " \"D_CRUD_NIV_COM_CUR.SPP_UPD_NIV_COM_CUR(P_NIV_COM_CUR); end;",
				ncc.getNivel_competencias_curso_id(), ncc.getNivel_competencias_id(), ncc.getPlan_curso_id());
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		String sql="declare v_id NIVEL_COMPETENCIAS.NIVEL_COMPETENCIAS_ID%TYPE; begin v_id:=?; D_CRUD_NIV_COM_CUR.SPP_DEL_NIV_COM_CUR(v_id); end;";
		return jdbcTemplate.update(sql, id);
	}
	@Override
	public Map<String, Object> read(int id) {
		// TODO Auto-generated method stub
		System.out.println(id);
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName("D_CRUD_NIV_COM_CUR") // nombre del paquete
				.withProcedureName("SPP_READ_NIV_COM_CUR") // nombre del procedimiento
				.declareParameters(
						new SqlOutParameter("CURSOR_NIV_COM_CUR", OracleTypes.CURSOR, new ColumnMapRowMapper()),
						new SqlParameter("ID", Types.INTEGER));
		SqlParameterSource in = new MapSqlParameterSource().addValue("ID", id);
		return simpleJdbcCall.execute(in);
	}

	@Override
	public Map<String, Object> readAll() {
		// TODO Auto-generated method stub
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName("D_CRUD_NIV_COM_CUR")
				.withProcedureName("SPP_READALL_NIV_COM_CUR") // nombre del procedimiento
				.declareParameters(
						new SqlOutParameter("CURSOR_NIV_COM_CUR", OracleTypes.REF_CURSOR, new ColumnMapRowMapper()));
		return simpleJdbcCall.execute();
	}

	@Override
	public Map<String, Object> readCurso() {
		// TODO Auto-generated method stub
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName("D_CRUD_NIV_COM_CUR")
				.withProcedureName("SPP_READALL_PL_CU_CI")
				.declareParameters(new SqlOutParameter("CURSOR_PL_CU_CI", OracleTypes.CURSOR, new ColumnMapRowMapper()));
		return simpleJdbcCall.execute();

	}

	@Override
	public Map<String, Object> readPlan() {
		// TODO Auto-generated method stub
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName("D_CRUD_PLAN_CURSO")
				.withProcedureName("SPP_PLANES")
				.declareParameters(new SqlOutParameter("CURSOR_PL", OracleTypes.CURSOR, new ColumnMapRowMapper()));
		return simpleJdbcCall.execute();

	}

	@Override
	public Map<String, Object> readAll2() {
		// TODO Auto-generated method stub
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName("D_CRUD_NIV_COM_CUR")
				.withProcedureName("SPP_READLL_NOM") // nombre del procedimiento
				.declareParameters(
						new SqlOutParameter("CURSOR_NI_CUR_COM_NOMBRE", OracleTypes.REF_CURSOR, new ColumnMapRowMapper()));
		return simpleJdbcCall.execute();

	}

	@Override
	public Map<String, Object> readCiclo() {
		// TODO Auto-generated method stub
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName("D_CRUD_UTILS")
				.withProcedureName("SPP_READALL_CICLO")
				.declareParameters(new SqlOutParameter("CURSOR_CICLO", OracleTypes.CURSOR, new ColumnMapRowMapper()));
		return simpleJdbcCall.execute();

	}

	@Override
	public Map<String, Object> readTipo_comp() {
		// TODO Auto-generated method stub
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName("D_CRUD_TIPO_COMPETENCIA")
				.withProcedureName("SPP_READALL_COMPETENCIAS") // nombre del procedimiento
				.declareParameters(
						new SqlOutParameter("CURSOR_OMPETENCIAS", OracleTypes.REF_CURSOR, new ColumnMapRowMapper()));
		return simpleJdbcCall.execute();

	}

	@Override
	public Map<String, Object> readLinea() {
		// TODO Auto-generated method stub
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName("D_CRUD_LINEAS_PA")
				.withProcedureName("SPP_READALL_LINEAS_PA") // nombre del procedimiento
				.declareParameters(
						new SqlOutParameter("CURSOR_LINEAS_PA", OracleTypes.REF_CURSOR, new ColumnMapRowMapper()));
		return simpleJdbcCall.execute();

	}

	@Override
	public Map<String, Object> readCompetencia() {
		// TODO Auto-generated method stub
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName("D_CRUD_NIVEL_COMP")
				.withProcedureName("SPP_READALL_NICOM") // nombre del procedimiento
				.declareParameters(
						new SqlOutParameter("CURSOR_NICOM_NOMBRE", OracleTypes.REF_CURSOR, new ColumnMapRowMapper()));
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
