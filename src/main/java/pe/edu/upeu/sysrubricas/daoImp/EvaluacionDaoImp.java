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
import pe.edu.upeu.sysrubricas.dao.EvaluacionDao;
import pe.edu.upeu.sysrubricas.entity.Evaluacion;

@Repository
public class EvaluacionDaoImp implements EvaluacionDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private SimpleJdbcCall simpleJdbcCall;

	@Override
	public int create(Evaluacion eva) {
		// TODO Auto-generated method stub
		String sql = "declare eva evaluacion%rowtype; begin eva.nivel_rubrica_id:=?; eva.est_persona_id:=?; eva.eva_persona_id:=?; D_CRUD_EVALUACION.SPP_INS_EVALUACION(eva); end;";
        return jdbcTemplate.update(sql, eva.getNivel_rubrica_id(), eva.getEst_persona_id(), eva.getEva_persona_id());
	}

	@Override
	public int update(Evaluacion eva) {
		// TODO Auto-generated method stub
		String sql = "declare eva evaluacion%rowtype; begin eva.evaluacion_id:=?; eva.nivel_rubrica_id:=?; eva.est_persona_id:=?; eva.eva_persona_id:=?; eva.estado:=1; D_CRUD_EVALUACION.SPP_UPD_EVALUACION(eva); end;";
        return jdbcTemplate.update(sql, eva.getEvaluacion_id(), eva.getNivel_rubrica_id(), eva.getEst_persona_id(), eva.getEva_persona_id());
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		String sql="declare v_id evaluacion.evaluacion_id%type; begin v_id:=?; D_CRUD_EVALUACION.SPP_DEL_EVALUACION(v_id); end;";
	    return jdbcTemplate.update(sql, id);
	}

	@Override
    public Map<String, Object> read(int id) {
        // TODO Auto-generated method stub
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName("D_CRUD_EVALUACION")
                .withProcedureName("SPP_READ_EVALUACION")
                .declareParameters(new SqlOutParameter("dato", OracleTypes.CURSOR, new ColumnMapRowMapper()),
                        new SqlParameter("idcc", Types.INTEGER));
        SqlParameterSource in = new MapSqlParameterSource().addValue("ID_EVALUACION", id);
        return simpleJdbcCall.execute(in);
    }

    @Override
    public Map<String, Object> readAll() {
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName("D_CRUD_EVALUACION")
                .withProcedureName("SPP_READALL_EVALUACION")
                .declareParameters(new SqlOutParameter("dato", OracleTypes.CURSOR, new ColumnMapRowMapper()));
        return simpleJdbcCall.execute();
    }

}
