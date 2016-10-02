package cn.thinking.system.unit.service.impl;

import java.util.List;
import java.util.UUID;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.thinking.org.system.unit.Unit;
import cn.thinking.system.unit.dao.IUnitDao;
import cn.thinking.system.unit.service.UnitService;

/**
 * 组织机构操作接口实现
 * 
 * @author user
 */
@Service
public class UnitServiceImpl implements UnitService {

	@Autowired
	private IUnitDao unitDao;


    /**
	 * 删除组织机构信息
	 * 
	 * @param orgId
	 */
    @Override
    public void deleteUnitById(String orgId) {
		unitDao.deleteUnitById(orgId);
    }

    /**
	 * 根据主键查询组织机构信息
	 * 
	 * @param orgId
	 * @return
	 */
    @Override
    public Unit getUnitById(String orgId) {
		return unitDao.getUnitById(orgId);
    }

    /**
	 * 查询所有组织机构根节点
	 */
    @Override
    public List<Unit> listAllParentUnit() {
		return unitDao.listAllParentUnit();
    }

    /**
	 * 查询所有的子组织机构信息
	 * 
	 * @return
	 */
    @Override
    public List<Unit> listAllSubUnit() {
		return unitDao.listAllSubUnit();
    }

    /**
	 * 查询所有的组织机构
	 */
    @Override
    public List<Unit> listAllUnit() {
		List<Unit> unitList = unitDao.listAllParentUnit();
        if (CollectionUtils.isNotEmpty(unitList)) {
            for (Unit unit : unitList) {
				List<Unit> subList = unitDao.listSubUnitByParentId(unit
						.getOrgId());
                if (CollectionUtils.isNotEmpty(subList)) {
                    unit.setHasUnit(true);
                    unit.setSubUnits(subList);
                }
            }
        }

        return unitList;
    }

    /**
	 * 根据父节点ID查询下级组织机构
	 */
    @Override
    public List<Unit> listSubUnitByParentId(String parentId) {
		return unitDao.listSubUnitByParentId(parentId);
    }

    /**
	 * 保存组织机构信息
	 */
    @Override
    public void saveUnit(Unit unit) {
        if ("1".equals(unit.getOrgLevel())) {
            unit.setParentId("UNITROOT");
        }

        if (StringUtils.isNotEmpty(unit.getOrgId())) {
			unitDao.updateUnit(unit);
        }
        else {
            unit.setOrgId(UUID.randomUUID().toString());
			unitDao.insertUnit(unit);
        }
    }

}
