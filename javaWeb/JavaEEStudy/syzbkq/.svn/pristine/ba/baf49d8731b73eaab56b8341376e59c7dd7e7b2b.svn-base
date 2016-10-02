package cn.thinking.system.menu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.thinking.org.system.menu.Menu;
import cn.thinking.system.menu.dao.IMenuDao;
import cn.thinking.system.menu.service.MenuService;

@Service("menuService")
public class MenuServiceImpl implements MenuService {

    @Autowired
    private IMenuDao menuDao;

    public void deleteMenuById(Integer menuId) {
        menuDao.deleteMenuById(menuId);
    }

    public Menu getMenuById(Integer menuId) {
        return menuDao.getMenuById(menuId);
    }

    public List<Menu> listAllParentMenu() {
        return menuDao.listAllParentMenu();
    }

    public void saveMenu(Menu menu) {
        if (menu.getMenuId() != null && menu.getMenuId().intValue() > 0) {
            menuDao.updateMenu(menu);
        }
        else {
            menuDao.insertMenu(menu);
        }
    }

    public List<Menu> listSubMenuByParentId(Integer parentId) {
        return menuDao.listSubMenuByParentId(parentId);
    }

    public List<Menu> listAllMenu() {
        List<Menu> rl = this.listAllParentMenu();
        for (Menu menu : rl) {
            List<Menu> subList = this.listSubMenuByParentId(menu.getMenuId());
            menu.setSubMenu(subList);
        }
        return rl;
    }

    public List<Menu> listAllSubMenu() {
        return menuDao.listAllSubMenu();
    }

    public IMenuDao getMenuMapper() {
        return menuDao;
    }

    public void setMenuMapper(IMenuDao menuMapper) {
        this.menuDao = menuMapper;
    }

}
