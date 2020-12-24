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
import pe.edu.upeu.sysrubricas.dao.Avance_pyDao;
import pe.edu.upeu.sysrubricas.entity.Avance_py;

@Repository
public class Avance_pyDaoImp implements Avance_pyDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private SimpleJdbcCall simpleJdbcCall;
	
	@Override
	public int create(Avance_py apy) {
		// TODO Auto-generated method stub
		String sql = "declare apy avance_py%rowtype; begin apy.py_id:=?; apy.titulo:=?; apy.fecha_inicio:=to_date(?,'YYYY-MM-DD HH:MI'); apy.fecha_fin:=to_date(?,'YYYY-MM-DD HH:MI'); apy.tipo:=?; apy.adjunto:=?; apy.py_carga_id:=?; apy.descripcion:=?; D_CRUD_AVANCE_PY.SPP_INS_AVANCE_PY(apy); end;";
        return jdbcTemplate.update(sql, apy.getPy_id(), apy.getTitulo(), apy.getFecha_inicio(), apy.getFecha_fin(), apy.getTipo(), apy.getAdjunto(), apy.getPy_carga_id(), apy.getDescripcion());
	}

	@Override
	public int update(Avance_py apy) {
		// TODO Auto-generated method stub
		String sql = "declare apy avance_py%rowtype; begin apy.avance_py_id:=?; apy.py_id:=?; apy.titulo:=?; apy.fecha_inicio:=to_date(?,'YYYY-MM-DD HH24:MI'); apy.fecha_fin:=to_date(?,'YYYY-MM-DD HH24:MI'); apy.tipo:=?; apy.adjunto:=?; apy.py_carga_id:=?; apy.descripcion:=?; apy.estado:=1; D_CRUD_AVANCE_PY.SPP_UPD_AVANCE_PY(apy); end;";
        return jdbcTemplate.update(sql, apy.getAvance_py_id(), apy.getPy_id(), apy.getTitulo(), apy.getFecha_inicio(), apy.getFecha_fin(), apy.getTipo(), apy.getAdjunto(), apy.getPy_carga_id(), apy.getDescripcion());
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		String sql="declare v_id avance_py.avance_py_id%type; begin v_id:=?; D_CRUD_AVANCE_PY.SPP_DEL_AVANCE_PY(v_id); end;";
	    return jdbcTemplate.update(sql, id);
	}

	@Override
    public Map<String, Object> read(int id) {
        // TODO Auto-generated method stub
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName("D_CRUD_AVANCE_PY")
                .withProcedureName("SPP_READ_AVANCE_PY")
                .declareParameters(new SqlOutParameter("dato", OracleTypes.CURSOR, new ColumnMapRowMapper()),
                        new SqlParameter("idcc", Types.INTEGER));
        SqlParameterSource in = new MapSqlParameterSource().addValue("ID", id);
        return simpleJdbcCall.execute(in);
    }

    @Override
    public Map<String, Object> readAll() {
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName("D_CRUD_AVANCE_PY")
                .withProcedureName("SPP_READALL_AVANCE_PY")
                .declareParameters(new SqlOutParameter("dato", OracleTypes.CURSOR, new ColumnMapRowMapper()));
        return simpleJdbcCall.execute();
    }

}
