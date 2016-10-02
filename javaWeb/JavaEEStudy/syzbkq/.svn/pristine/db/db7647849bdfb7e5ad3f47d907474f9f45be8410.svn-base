package cn.thinking.common.util;

import cn.thinking.system.menu.service.MenuService;
import cn.thinking.system.role.service.RoleService;
import cn.thinking.system.sequence.service.SequenceService;
import cn.thinking.system.user.service.IUserService;

/**
 * 
 * Description: 获取Spring容器中的service bean
 * @update [修改人] [修改时间]
 * @version 1.0
 *
 */
public final class ServiceHelper {

    public static Object getService(String serviceName) {
        //WebApplicationContextUtils.
        return Const.WEB_APP_CONTEXT.getBean(serviceName);
    }

    public static IUserService getUserService() {
        return (IUserService) getService("userService");
    }

    public static RoleService getRoleService() {
        return (RoleService) getService("roleService");
    }

    public static MenuService getMenuService() {
        return (MenuService) getService("menuService");
    }

    public static SequenceService getSequenceService() {
        return (SequenceService) getService("sequenceService");
    }
}
