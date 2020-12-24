package pe.edu.upeu.sysrubricas.daoImp;

import java.sql.Types;
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
import pe.edu.upeu.sysrubricas.dao.AccesoDao;
import pe.edu.upeu.sysrubricas.entity.Acceso;
@Repository
public class AccesoDaoImpl implements AccesoDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	@Override
	public int create(Acceso a) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Acceso a) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Map<String, Object>> read(int id) {
		String SQL ="select a.accessname, a.url, a.icon,a.acceso_id from acceso a  JOIN rol_acceso ra ON (a.acceso_id = ra.acceso_id) JOIN rol r ON (ra.rol_id = r.rol_id) JOIN usuario_rol ur ON (r.rol_id = ur.rol_id)  JOIN usuario u ON ur.persona_id = u.persona_id WHERE u.persona_id=?";
		return jdbcTemplate.queryForList(SQL,new Object[] {id});
	}

	@Override
	public Map<String, Object> readAll(String username) {
		String SQL = "select a.accessname, a.url, a.icon from acceso a  JOIN rol_acceso ra ON (a.acceso_id = ra.acceso_id) JOIN rol r ON (ra.rol_id = r.rol_id) JOIN usuario_rol ur ON (r.rol_id = ur.rol_id)  JOIN usuario u ON ur.persona_id = u.persona_id WHERE u.persona_id=?";
		return jdbcTemplate.queryForMap(SQL);
	}

	@Override
	public List<Map<String, Object>> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> readAllSubMains(int id) {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName("d_crud_acceso")
				.withProcedureName("SPP_read_accesochild")
				.declareParameters(new SqlOutParameter("dato", OracleTypes.CURSOR, new ColumnMapRowMapper()),
						new SqlParameter("idcc", Types.INTEGER));
		SqlParameterSource in = new MapSqlParameterSource().addValue("ID", id);
		return simpleJdbcCall.execute(in);
	}

}
