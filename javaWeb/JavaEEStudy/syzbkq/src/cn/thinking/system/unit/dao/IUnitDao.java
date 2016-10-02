package cn.thinking.system.unit.dao;

import java.util.List;

import cn.thinking.org.system.unit.Unit;

public interface IUnitDao {
    List<Unit> listAllParentUnit();

    List<Unit> listSubUnitByParentId(String parentId);

    Unit getUnitById(String orgId);

    void insertUnit(Unit unit);

    void updateUnit(Unit unit);

    void deleteUnitById(String orgId);

    List<Unit> listAllSubUnit();

}
