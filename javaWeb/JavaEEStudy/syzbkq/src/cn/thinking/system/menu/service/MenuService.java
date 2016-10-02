package cn.thinking.system.menu.service;

import java.util.List;

import cn.thinking.org.system.menu.Menu;

public interface MenuService {
    List<Menu> listAllMenu();

    List<Menu> listAllParentMenu();

    List<Menu> listSubMenuByParentId(Integer parentId);

    Menu getMenuById(Integer menuId);

    void saveMenu(Menu menu);

    void deleteMenuById(Integer menuId);

    List<Menu> listAllSubMenu();
}
