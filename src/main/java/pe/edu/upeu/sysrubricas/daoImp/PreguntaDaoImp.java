package pe.edu.upeu.sysrubricas.daoImp;

import oracle.jdbc.OracleTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.support.oracle.SqlReturnStruct;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.sysrubricas.dao.PreguntaDao;
import pe.edu.upeu.sysrubricas.entity.Pregunta;
import pe.edu.upeu.sysrubricas.sql.SqlPregunta;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;


@Repository
public class PreguntaDaoImp implements PreguntaDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;


    @Override
    public List<Pregunta> getPreguntas() throws SQLException {
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("D_CRUD_PREGUNTAS")
                .withProcedureName("SPP_GET_PREGUNTAS")
                .declareParameters(
                        new SqlOutParameter("OUT_PREGUNTAS", Types.ARRAY,"D_CRUD_PREGUNTAS.PREGUNTAS_TYPE"
                        ));

        Map<?,?> out = simpleJdbcCall.execute();
        List<Pregunta> preguntas = new ArrayList<>();

        Array oracleObjectArray = (Array) out.get("OUT_PREGUNTAS");
        return getPreguntas(preguntas, oracleObjectArray);
    }

    @Override
    public List<Pregunta> getPreguntasxins(int id) throws SQLException {
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("D_CRUD_PREGUNTAS")
                .withProcedureName("SPP_GET_PREGUNTAXINSTRUMENTO")
                .declareParameters(
                        new SqlOutParameter("OUT_PREGUNTAS_INS",Types.ARRAY,"D_CRUD_PREGUNTAS.PREGUNTAS_TYPE"));
        Map in = Collections.singletonMap("INS_ID",id);
        Map<?,?> out = simpleJdbcCall.execute(in);
        List<Pregunta> preguntas = new ArrayList<>();

        Array oracleObjectArray = (Array) out.get("OUT_PREGUNTAS_INS");
        return getPreguntas(preguntas, oracleObjectArray);
    }

    private List<Pregunta> getPreguntas(List<Pregunta> preguntas, Array oracleObjectArray) throws SQLException {
        Object[] objArray = (Object[]) oracleObjectArray.getArray();
        for (int i = 0;i<objArray.length;i++){
            Struct st = (Struct) objArray[i];

            Object[] obj = st.getAttributes();
            Pregunta pregunta = new Pregunta();
            pregunta.setPregunta_id((BigDecimal) obj[0]);
            pregunta.setInstrumento_id((BigDecimal) obj[1]);
            pregunta.setNombre((String) obj[4]);
            pregunta.setPeso((BigDecimal) obj[2]);
            pregunta.setEstado((String) obj[3]);


            preguntas.add(pregunta);
        }


        return preguntas;
    }

    @Override
    public Pregunta getPregunta(BigDecimal id) {
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("D_CRUD_PREGUNTAS")
                .withFunctionName("FUN_GET_PREGUNTA")
                .declareParameters(
                        new SqlOutParameter("V_PREGUNTA",OracleTypes.STRUCT,"D_CRUD_PREGUNTAS.PREGUNTA_TYPE",
                                new SqlReturnStruct(Pregunta.class)));
        Map in = Collections.singletonMap("IN_PREGUNTA_ID",id);
        return simpleJdbcCall.executeFunction(Pregunta.class,in);
    }

    @Override
    public BigDecimal createPregunta(SqlPregunta pregunta) {
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("D_CRUD_PREGUNTAS")
                .withProcedureName("SPP_CREATE_PREGUNTA")
                .declareParameters(
                        new SqlParameter("IN_PREGUNTA",OracleTypes.STRUCT,"D_CRUD_PREGUNTAS.PREGUNTAS_TYPE"),
                        new SqlOutParameter("OUT_PREGUNTA_ID",OracleTypes.NUMBER));

        Map in = Collections.singletonMap("IN_PREGUNTA",pregunta);
        Map<?,?> out = simpleJdbcCall.execute(in);
        BigDecimal id = (BigDecimal) out.get("OUT_PREGUNTA_ID");
        return id;
    }

    @Override
    public void updatePregunta(SqlPregunta pregunta) {
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("D_CRUD_PREGUNTAS")
                .withProcedureName("SPP_UPDATE_PREGUNTA")
                .declareParameters(
                        new SqlParameter("P_PREGUNTA",OracleTypes.STRUCT,"D_CRUD_PREGUNTAS.PREGUNTAS_TYPE"));
        Map in = Collections.singletonMap("IN_PREGUNTA",pregunta);
        simpleJdbcCall.execute(in);
    }

    @Override
    public void deletePregunta(int id) {
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("D_CRUD_PREGUNTAS")
                .withProcedureName("SPP_DELETE_PREGUNTA")
                .declareParameters(
                        new SqlParameter("IN_PREGUNTA_ID",OracleTypes.NUMBER)
                );
        Map in = Collections.singletonMap("IN_PREGUNTA_ID",id);
        simpleJdbcCall.execute(in);
    }

    public String convert(Clob clob) throws SQLException {

        return Math.toIntExact(clob.length()) == 0 //
                ? "" //
                : clob.getSubString(1,Math.toIntExact(clob.length())) ;
    }
}
