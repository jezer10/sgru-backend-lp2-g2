package pe.edu.upeu.sysrubricas.daoImp;

import pe.edu.upeu.sysrubricas.dao.SemestreDao;

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
import pe.edu.upeu.sysrubricas.dao.SemestreDao;
import pe.edu.upeu.sysrubricas.entity.Semestre;

@Repository

public class SemestreDaoImpl implements SemestreDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;


	@Override
	public int create(Semestre s) {
		// TODO Auto-generated method stub
		String sql = "declare v_sem semestre%rowtype; begin v_sem.nombre:=?; D_CRUD_SEMESTRE.SPP_INS_SEMESTRE(v_sem); end;";
		return jdbcTemplate.update(sql, s.getNombre());
	}

	@Override
	public int update(Semestre s) {
		// TODO Auto-generated method stub
		String sql = "declare v_sem semestre%rowtype; begin v_sem.semestre_id:=?; v_sem.nombre:=?; v_sem.estado:=1; D_CRUD_SEMESTRE.SPP_UPD_SEMESTRE(v_sem); end;";
		return jdbcTemplate.update(sql, s.getSemestre_id(), s.getNombre());
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		String sql="declare v_id semestre.semestre_id%type; begin v_id:=?; D_CRUD_SEMESTRE.SPP_DEL_SEMESTRE(v_id); end;";
		return jdbcTemplate.update(sql, id);
	}
	
	@Override
    public Map<String, Object> read(int id) {
        // TODO Auto-generated method stub
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName("D_CRUD_SEMESTRE")
                .withProcedureName("SPP_READ_SEMESTRE")
                .declareParameters(new SqlOutParameter("dato", OracleTypes.CURSOR, new ColumnMapRowMapper()),
                        new SqlParameter("SEMESTRE_ID", Types.INTEGER));
        SqlParameterSource in = new MapSqlParameterSource().addValue("ID", id);
        return simpleJdbcCall.execute(in);
    }

    @Override
    public Map<String, Object> readAll() {
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName("D_CRUD_SEMESTRE")
                .withProcedureName("SPP_READALL_SEMESTRE")
                .declareParameters(new SqlOutParameter("dato", OracleTypes.CURSOR, new ColumnMapRowMapper()));
        return simpleJdbcCall.execute();
    }
	
}
