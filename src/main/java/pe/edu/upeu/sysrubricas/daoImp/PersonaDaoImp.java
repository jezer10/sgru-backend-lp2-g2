package pe.edu.upeu.sysrubricas.daoImp;

import oracle.jdbc.internal.OracleTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.sysrubricas.dao.PersonaDao;
import pe.edu.upeu.sysrubricas.entity.Persona;

import java.sql.Types;
import java.util.Map;

@Repository
public class PersonaDaoImp implements PersonaDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall simpleJdbcCall;

	@Override
	public void create(Persona p) {

	}

	@Override
	public void update(Persona p) {

	}

	@Override
	public int delete(int id) {
		int p;
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName("D_CRUD_PERSONA")
				.withProcedureName("SPP_DEL_PERSONA")
				.declareParameters(new SqlParameter("ID_PER", Types.INTEGER),new SqlOutParameter("P_OK",Types.INTEGER));
		Map<String,Object> out =simpleJdbcCall.execute(id);
		p=(int)out.get("P_OK");
		return p;
	}

	@SuppressWarnings("deprecation")
	@Override
	public Persona read(int id) {
			String SQL = "select * from persona where persona_id=?";
			return jdbcTemplate.queryForObject(SQL, new Object[] {id}, new BeanPropertyRowMapper<Persona>(Persona.class));
		
	}

	@Override
	public Map<String, Object> readAll() {
		simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName("D_CRUD_PERSONA")
				.withProcedureName("SPP_READALL_PERSONA")
				.declareParameters(new SqlOutParameter("dato", OracleTypes.CURSOR, new ColumnMapRowMapper()));
		return simpleJdbcCall.execute();
	}

}
