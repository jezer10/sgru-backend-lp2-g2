package pe.edu.upeu.sysrubricas.dao;

import pe.edu.upeu.sysrubricas.entity.Pregunta;
import pe.edu.upeu.sysrubricas.sql.SqlPregunta;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

public interface PreguntaDao {

    List<Pregunta> getPreguntas() throws SQLException;
    List<Pregunta> getPreguntasxins(int id) throws SQLException;
    Pregunta getPregunta(BigDecimal id);
    BigDecimal createPregunta(SqlPregunta pregunta);
    void updatePregunta(SqlPregunta pregunta);
    void deletePregunta(int id);

}
