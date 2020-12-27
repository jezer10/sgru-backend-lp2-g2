package pe.edu.upeu.sysrubricas.daoImp;

import oracle.jdbc.internal.OracleTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.sysrubricas.dao.DocenteEvaluadorPersonaDao;
import pe.edu.upeu.sysrubricas.entity.DocenteEvaluadorPersona;

import java.sql.Types;
import java.util.Map;

@Repository
public class DocenteEvaluadorPersonaDaoImp implements DocenteEvaluadorPersonaDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;

	@Override
	public int create(DocenteEvaluadorPersona d) {
		String sql = "declare v_p persona%rowtype; v_de docente_evaluador%rowtype; begin v_p.nombres:=?; v_p.apellidos:=?; v_p.tipo_doc_id:=?; v_p.n_doc:=?; v_p.sexo:=?; v_p.fecha_nac:=to_date(?,'YYYY-MM-DD'); v_p.correo:=?; v_p.telefono:=?; v_p.estado_civil_id:=?; v_de.persona_id:=D_CRUD_PERSONA.SPP_INS_PERSONA(v_p); v_de.tipo_evaluador_id:=?; v_de.correo_trabajo:=?; v_de.grado_academico:=?; D_CRUD_DOCENTE_EVALUADOR.SPP_INS_DOCENTE_EVALUADOR(v_de); end;";
		return jdbcTemplate.update(sql, d.getNombres(), d.getApellidos(), d.getTipo_doc_id(), d.getN_doc(), d.getSexo(),
				d.getFecha_nac(), d.getCorreo(), d.getTelefono(), d.getEstado_civil_id(), d.getTipo_evaluador_id(),
				d.getCorreo_trabajo(), d.getGrado_academico());
	}

	@Override
	public int update(DocenteEvaluadorPersona d) {
		String sql = "declare v_p persona%rowtype; v_de docente_evaluador%rowtype;v_id docente_evaluador.persona_id%type:=?; begin v_de.persona_id:=v_id;v_p.persona_id:=v_id; v_p.nombres:=?; v_p.apellidos:=?; v_p.tipo_doc_id:=?; v_p.n_doc:=?; v_p.sexo:=?; v_p.fecha_nac:=to_date(?,'YYYY-MM-DD'); v_p.correo:=?; v_p.telefono:=?; v_p.estado_civil_id:=?; v_de.persona_id:=D_CRUD_PERSONA.SPF_UPD_PERSONA(v_p); v_de.tipo_evaluador_id:=?; v_de.correo_trabajo:=?; v_de.grado_academico:=?; D_CRUD_DOCENTE_EVALUADOR.SPP_UPD_DOCENTE_EVALUADOR(v_de); end;";
		return jdbcTemplate.update(sql, d.getPersona_id(), d.getNombres(), d.getApellidos(), d.getTipo_doc_id(),
				d.getN_doc(), d.getSexo(), d.getFecha_nac(), d.getCorreo(), d.getTelefono(), d.getEstado_civil_id(),
				d.getTipo_evaluador_id(), d.getCorreo_trabajo(), d.getGrado_academico());
	}

	@Override
	public int delete(int id) {
		int p;
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName("d_crud_dep").withProcedureName("SPP_DEL_dep")
				.declareParameters(new SqlParameter("ID", Types.INTEGER), new SqlOutParameter("P_OK", Types.INTEGER));
		Map<String, Object> out = simpleJdbcCall.execute(id);
		p = (int) out.get("P_OK");
		return p;
	}

	@Override
	public Map<String, Object> read(int id) {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName("d_crud_dep")
				.withProcedureName("SPP_READ_DEP")
				.declareParameters(new SqlOutParameter("dato", OracleTypes.CURSOR, new ColumnMapRowMapper()),
						new SqlParameter("idcc", Types.INTEGER));
		SqlParameterSource in = new MapSqlParameterSource().addValue("ID", id);
		return simpleJdbcCall.execute(in);
	}

	@Override
	public Map<String, Object> readAllDocente() {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName("d_crud_dep")
				.withProcedureName("spp_readall_d")
				.declareParameters(new SqlOutParameter("dato", OracleTypes.CURSOR, new ColumnMapRowMapper()));
		return simpleJdbcCall.execute();
	}

	@Override
	public Map<String, Object> readAllEvaluadorExterno() {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName("d_crud_dep")
				.withProcedureName("spp_readall_ev")
				.declareParameters(new SqlOutParameter("dato", OracleTypes.CURSOR, new ColumnMapRowMapper()));
		return simpleJdbcCall.execute();
	}

	@Override
	public Map<String, Object> readAllExpertoExterno() {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName("d_crud_dep")
				.withProcedureName("spp_readall_ep")
				.declareParameters(new SqlOutParameter("dato", OracleTypes.CURSOR, new ColumnMapRowMapper()));
		return simpleJdbcCall.execute();
	}

	@Override
	public Map<String, Object> readAllEvaluadorHB() {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName("d_crud_dep")
				.withProcedureName("spp_readall_ehb")
				.declareParameters(new SqlOutParameter("dato", OracleTypes.CURSOR, new ColumnMapRowMapper()));
		return simpleJdbcCall.execute();
	}

	@Override
	public Map<String, Object> readAll() {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName("d_crud_dep")
				.withProcedureName("spp_readall_dep")
				.declareParameters(new SqlOutParameter("dato", OracleTypes.CURSOR, new ColumnMapRowMapper()));
		return simpleJdbcCall.execute();
	}

}
