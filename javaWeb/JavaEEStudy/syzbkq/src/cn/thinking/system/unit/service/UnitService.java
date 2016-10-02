package cn.thinking.system.unit.service;

import java.util.List;
import cn.thinking.org.system.unit.Unit;

/**
 * 组织机构操作接口 
 * @author user
 */
public interface UnitService {
    /**
     * 查询所有的组织机构
     */
    List<Unit> listAllUnit();

    /**
     * 查询所有组织机构根节点 
     */
    List<Unit> listAllParentUnit();

    /**
     * 根据父节点ID查询其子节点
     * @param parentId
     * @return
     */
    List<Unit> listSubUnitByParentId(String parentId);

    /**
     * 根据主键查询组织机构信息
     * @param orgId
     * @return
     */
    Unit getUnitById(String orgId);

    /**
     * 保存组织机构信息
     * @param unit
     */
    void saveUnit(Unit unit);

    /**
     * 删除组织机构信息
     * @param orgId
     */
    void deleteUnitById(String orgId);

    /**
     * 查询所有的子组织机构信息
     * @return
     */
    List<Unit> listAllSubUnit();
}
