package pe.edu.upeu.sysrubricas.dao;

import pe.edu.upeu.sysrubricas.entity.LineaPlan;

import java.util.List;

public interface LineaPlanDao {
    List<LineaPlan> getLineasPlan(int id);
}
