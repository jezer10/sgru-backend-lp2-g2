package pe.edu.upeu.sysrubricas.daoImp;

import oracle.jdbc.OracleTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.support.oracle.SqlReturnStruct;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.sysrubricas.dao.InstrumentoDao;
import pe.edu.upeu.sysrubricas.entity.Instrumento;
import pe.edu.upeu.sysrubricas.sql.SqlInstrumento;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Map;


@Repository
public class InstrumentoDaoImp implements InstrumentoDao {
    private Connection conn;
    private CallableStatement callableStmt;

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;


    @Override
    public void createInstrumento(SqlInstrumento instrumento) {
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("D_CRUD_INSTRUMENTO")
                .withProcedureName("SPP_CREATE_INSTRUMENTO")
                .declareParameters(new SqlParameter("INS", OracleTypes.STRUCT,"INSTRUMENTO_TYPE"));
        Map in = Collections.singletonMap("INS",instrumento);
        simpleJdbcCall.execute(in);

    }

    @Override
    public void updateInstrumento(SqlInstrumento instrumento) {
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("D_CRUD_INSTRUMENTO")
                .withProcedureName("SPP_UPDATE_INSTRUMENTO")
                .declareParameters(new SqlParameter("INS",OracleTypes.STRUCT,"INSTRUMENTO_TYPE"));
        Map in = Collections.singletonMap("INS",instrumento);
        simpleJdbcCall.execute(in);
    }

    @Override
    public Instrumento getInstrumento(int id) throws SQLException {
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("D_CRUD_INSTRUMENTO")
                .withProcedureName("SPP_GET_INSTRUMENTO")
                .declareParameters(new SqlOutParameter("OUT_INSTRUMENTO",OracleTypes.STRUCT,"INSTRUMENTO_TYPE",
                        new SqlReturnStruct(Instrumento.class))
                );


        Map in = Collections.singletonMap("INS_ID",id);
        return simpleJdbcCall.executeObject(Instrumento.class,in);
    }

    @Override
    public List<Instrumento> getInstrumentos() {
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("D_CRUD_INSTRUMENTO")
                .withProcedureName("SPP_GET_ALL_INSTRUMENTOS")
                .returningResultSet("OUT_INS_CUR",
                        BeanPropertyRowMapper.newInstance(Instrumento.class));

        return simpleJdbcCall.executeObject(List.class,Collections.emptyMap());
    }
}
