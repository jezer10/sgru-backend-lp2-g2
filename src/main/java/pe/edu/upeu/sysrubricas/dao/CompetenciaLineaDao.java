package pe.edu.upeu.sysrubricas.dao;

import pe.edu.upeu.sysrubricas.entity.CompetenciaLinea;

import java.util.List;

public interface CompetenciaLineaDao {
    List<CompetenciaLinea> getCompetenciasLinea(int id);
}
