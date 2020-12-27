package pe.edu.upeu.sysrubricas.daoImp;

import com.google.gson.Gson;
import oracle.jdbc.internal.OracleTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import pe.edu.upeu.sysrubricas.dao.RolDao;
import pe.edu.upeu.sysrubricas.entity.Rol;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Component
public class RolDaoImpl implements RolDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;
	Gson gson = new Gson();

	@Override
	public Map<String, Object> read(int id) {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName("d_crud_rol") // nombre del paquete
				.withProcedureName("SPP_read_rol") // nombre del procedimiento
				.declareParameters(
						new SqlOutParameter("cursor_roles", OracleTypes.REF_CURSOR, new ColumnMapRowMapper()),
						new SqlParameter("id", OracleTypes.NUMBER));
		SqlParameterSource in = new MapSqlParameterSource().addValue("id", id);
		Map<String, Object> map = simpleJdbcCall.execute(in);
		return map;
	}

	@Override
	public Map<String, Object> readAll() {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName("d_crud_rol") // nombre del paquete
				.withProcedureName("SPP_READALL_rol") // nombre del procedimiento
				.declareParameters(
						new SqlOutParameter("cursor_roles", OracleTypes.REF_CURSOR, new ColumnMapRowMapper()));
		Map<String, Object> map = simpleJdbcCall.execute();
		return map;
	}

	@Override
	public int create(Rol r) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("call pk_roles.sp_create_rol(?)", r.getRolname());
	}

	@Override
	public int update(Rol r) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("call pk_roles.sp_update_rol(?,?)", r.getRol_id(), r.getRolname());
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("call pk_roles.sp_delete_rol(?)", id);
	}

	@Override
	public void convertitMap(Map<String, Object> map) {
		Gson rr = new Gson();
		/*
		 * for (Entry<String, Object> entry : map.entrySet()) {
		 * System.out.println("entry key : "+entry.getKey());
		 * System.out.println("Object value :"+entry.getValue());
		 * System.out.println("Object value :"+entry.getClass().toString()); }
		 */
		Object lista = rr.toJson(map.get("cursor_roles"));
		System.out.println(lista.toString());
	}

	@Override
	public int update(int id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("call pk_roles.sp_delete_logica_rol(?)", id);
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<GrantedAuthority> buscarRolUser(int iduser) {
		List<GrantedAuthority> autores = new ArrayList<GrantedAuthority>();
		String SQL = "select r.rol_id,r.rolname from usuario_rol ur join usuario u on (ur.persona_id=u.persona_id) join rol r on (r.rol_id=ur.rol_id) where u.persona_id=?";
		List<Rol> roles = jdbcTemplate.query(SQL, new Object[] { iduser }, new BeanPropertyRowMapper<Rol>(Rol.class));
		for (int i = 0; i < roles.size(); i++) {
			autores.add(new SimpleGrantedAuthority(roles.get(i).getRolname()));
		}
		return autores;
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<Rol> readHola(int id) {
		String SQL = "select r.rol_id,r.rolname from usuario_rol ur join usuario u on (ur.persona_id=u.persona_id) join rol r on (r.rol_id=ur.rol_id) where u.persona_id=1";
		return jdbcTemplate.query(SQL, new Object[] { id }, new BeanPropertyRowMapper<Rol>(Rol.class));
	}
}
