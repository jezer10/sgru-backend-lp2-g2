package pe.edu.upeu.sysrubricas.dao;

import pe.edu.upeu.sysrubricas.entity.Ciclo;

import java.util.List;

public interface CicloDao {
    List<Ciclo> getCiclos(int id);
}
