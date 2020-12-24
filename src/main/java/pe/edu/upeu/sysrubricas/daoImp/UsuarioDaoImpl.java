package pe.edu.upeu.sysrubricas.daoImp;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;

import pe.edu.upeu.sysrubricas.entity.Usuario;

@Repository
public class UsuarioDaoImpl implements pe.edu.upeu.sysrubricas.dao.UsuarioDao {
	Gson g = new Gson();
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@SuppressWarnings("deprecation")
	@Override
	public Usuario validarUsuario(String nomuser) {
		String SQL = "select * from usuario where username=?";
		Usuario usuario = jdbcTemplate.queryForObject(SQL, new Object[] { nomuser },new BeanPropertyRowMapper<Usuario>(Usuario.class));
		return usuario;
	}

	@Override
	public Map<String, Object> datosUsuario(String username) {
		String SQL = "SELECT u.idusuario, r.idrol, p.nombres, u.username, r.nombre FROM personas p "
				+ "INNER JOIN usuarios u ON u.idpersona = p.idpersona "
				+ "INNER JOIN usuarios_roles ur ON u.idusuario = ur.idusuario "
				+ "INNER JOIN roles r ON r.idrol=ur.idrol " + "where u.username = ?";
		Map<String, Object> map = jdbcTemplate.queryForMap(SQL, username);
		return map;
	}

	@Override
	public int create(Usuario u) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Usuario u) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@SuppressWarnings("deprecation")
	@Override
	public Usuario read(int id) {
		// TODO Auto-generated method stub
		String SQL = "select *from usuario where persona_id=?";
		return jdbcTemplate.queryForObject(SQL, new Object[] { id }, new BeanPropertyRowMapper<Usuario>(Usuario.class));
	}

	@SuppressWarnings("deprecation")
	@Override
	public Usuario read(String nomuser) {
		// TODO Auto-generated method stub
		String SQL = "SELECT *FROM usuario WHERE username=?";
		return jdbcTemplate.queryForObject(SQL, new Object[] { nomuser },new BeanPropertyRowMapper<Usuario>(Usuario.class));
	}

}
