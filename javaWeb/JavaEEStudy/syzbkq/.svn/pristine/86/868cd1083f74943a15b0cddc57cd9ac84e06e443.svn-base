package cn.thinking.system.menu.dao;

import java.util.List;

import cn.thinking.org.system.menu.Menu;

public interface IMenuDao {
    List<Menu> listAllParentMenu();

    List<Menu> listSubMenuByParentId(Integer parentId);

    Menu getMenuById(Integer menuId);

    void insertMenu(Menu menu);

    void updateMenu(Menu menu);

    void deleteMenuById(Integer menuId);

    List<Menu> listAllSubMenu();
}
