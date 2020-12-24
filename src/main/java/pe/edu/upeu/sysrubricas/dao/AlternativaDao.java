package pe.edu.upeu.sysrubricas.dao;

import pe.edu.upeu.sysrubricas.entity.Alternativa;
import pe.edu.upeu.sysrubricas.sql.SqlAlternativa;

import java.sql.SQLException;
import java.util.List;

public interface AlternativaDao {

    void createAlternativa(SqlAlternativa alternativa);
    void updateAlternativa(SqlAlternativa alternativa);
    List<Alternativa> getAlternativas(int id) throws SQLException;
    void deleteAlternativa(int id);
}
