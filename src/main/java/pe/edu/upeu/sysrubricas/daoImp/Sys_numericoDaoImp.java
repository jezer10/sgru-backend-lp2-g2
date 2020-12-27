package pe.edu.upeu.sysrubricas.daoImp;

import oracle.jdbc.OracleTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.sysrubricas.dao.Sys_numericoDao;
import pe.edu.upeu.sysrubricas.entity.Sys_numerico;

import java.sql.Types;
import java.util.Map;

@Repository
public class Sys_numericoDaoImp implements Sys_numericoDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private SimpleJdbcCall simpleJdbcCall;

	@Override
	public int create(Sys_numerico snum) {
		// TODO Auto-generated method stub
		String sql = "declare snum sys_numerico%rowtype; begin snum.nombre:=?; D_CRUD_SYS_NUMERICO.SPP_INS_SYS_NUMERICO(snum); end;";
        return jdbcTemplate.update(sql, snum.getNombre());
	}

	@Override
	public int update(Sys_numerico snum) {
		// TODO Auto-generated method stub
		String sql = "declare snum sys_numerico%rowtype; begin snum.sys_numerico_id:=?; snum.nombre:=?; snum.estado:=1; D_CRUD_SYS_NUMERICO.SPP_UPD_SYS_NUMERICO(snum); end;";
        return jdbcTemplate.update(sql, snum.getSys_numerico_id(), snum.getNombre());
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		String sql="declare v_id sys_numerico.sys_numerico_id%type; begin v_id:=?; D_CRUD_SYS_NUMERICO.SPP_DEL_SYS_NUMERICO(v_id); end;";
	    return jdbcTemplate.update(sql, id);
	}

	@Override
    public Map<String, Object> read(int id) {
        // TODO Auto-generated method stub
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName("D_CRUD_SYS_NUMERICO")
                .withProcedureName("SPP_READ_SYS_NUMERICO")
                .declareParameters(new SqlOutParameter("dato", OracleTypes.CURSOR, new ColumnMapRowMapper()),
                        new SqlParameter("idcc", Types.INTEGER));
        SqlParameterSource in = new MapSqlParameterSource().addValue("ID_SYS_NUMERICO", id);
        return simpleJdbcCall.execute(in);
    }

    @Override
    public Map<String, Object> readAll() {
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName("D_CRUD_SYS_NUMERICO")
                .withProcedureName("SPP_READALL_SYS_NUMERICO")
                .declareParameters(new SqlOutParameter("dato", OracleTypes.CURSOR, new ColumnMapRowMapper()));
        return simpleJdbcCall.execute();
    }
}
