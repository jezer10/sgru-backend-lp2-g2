package pe.edu.upeu.sysrubricas.dao;

import pe.edu.upeu.sysrubricas.entity.Instrumento;
import pe.edu.upeu.sysrubricas.sql.SqlInstrumento;

import java.sql.SQLException;
import java.util.List;

public interface InstrumentoDao {
    void createInstrumento(final SqlInstrumento instrumento);
    void updateInstrumento(SqlInstrumento instrumento);
    Instrumento getInstrumento(int id) throws SQLException;
    List<Instrumento> getInstrumentos();
}
