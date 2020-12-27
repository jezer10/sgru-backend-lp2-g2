package pe.edu.upeu.sysrubricas.daoImp;

import oracle.jdbc.OracleTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.sysrubricas.dao.SemestreDao;
import pe.edu.upeu.sysrubricas.entity.Semestre;

import java.sql.Types;
import java.util.Collections;
import java.util.List;
import java.util.Map;

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

	@Override
	public List<Semestre> getSemestres() {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withCatalogName("D_CRUD_SEMESTRE")
				.withProcedureName("SPP_READALL_SEMESTRE")
				.returningResultSet("CURSOR_SEMESTRE",
						BeanPropertyRowMapper.newInstance(Semestre.class));
		return simpleJdbcCall.executeObject(List.class, Collections.emptyMap());
	}

}
