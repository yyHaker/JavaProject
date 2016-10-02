package cn.thinking.system.role.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import cn.thinking.system.menu.service.MenuService;
import cn.thinking.system.role.service.RoleService;

@Controller
@RequestMapping(value = RoleController.modulePath)
public class RoleController {

    // 模块页面根路径
    public static final String modulePath = "module/system/role";
    @Autowired
    private RoleService roleService;

    @Autowired
    private MenuService menuService;

}
