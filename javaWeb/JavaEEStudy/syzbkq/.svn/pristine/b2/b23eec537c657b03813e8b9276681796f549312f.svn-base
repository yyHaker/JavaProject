package cn.thinking.system.menu.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.thinking.common.basedao.BaseDao;
import cn.thinking.org.system.menu.Menu;
import cn.thinking.system.menu.dao.IMenuDao;

@Repository(value = "cn.thinking.system.menu.dao.MenuDaoImpl")
public class MenuDaoImpl extends BaseDao implements IMenuDao {

    @Override
    public List<Menu> listAllParentMenu() {
        return (List<Menu>) this.selectList("cn.thinking.org.system.menu.Menu.listAllParentMenu");
    }

    @Override
    public List<Menu> listSubMenuByParentId(Integer parentId) {
        return (List<Menu>) this.selectList("cn.thinking.org.system.menu.Menu.listSubMenuByParentId", parentId);
    }

    @Override
    public Menu getMenuById(Integer menuId) {
        return (Menu) this.selectOne("cn.thinking.org.system.menu.Menu.getMenuById", menuId);
    }

    @Override
    public void insertMenu(Menu menu) {
        this.insert("cn.thinking.org.system.menu.Menu.insertMenu", menu);
    }

    @Override
    public void updateMenu(Menu menu) {
        this.update("cn.thinking.org.system.menu.Menu.updateMenu", menu);
    }

    @Override
    public void deleteMenuById(Integer menuId) {
        this.delete("cn.thinking.org.system.menu.Menu.deleteMenuById", menuId);
    }

    @Override
    public List<Menu> listAllSubMenu() {
        return (List<Menu>) this.selectList("cn.thinking.org.system.menu.Menu.listAllSubMenu");
    }

}
