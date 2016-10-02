package cn.thinking.system.role.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.thinking.org.system.role.Role;
import cn.thinking.system.role.dao.IRoleDao;
import cn.thinking.system.role.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private IRoleDao roleDao;

    public List<Role> listAllRoles() {
        return roleDao.listAllRoles();
    }

    public void deleteRoleById(int roleId) {
        roleDao.deleteRoleById(roleId);
    }

    public Role getRoleById(int roleId) {
        return roleDao.getRoleById(roleId);
    }

    public boolean insertRole(Role role) {
        if (roleDao.getCountByName(role) > 0)
            return false;
        else {
            roleDao.insertRole(role);
            return true;
        }
    }

    public boolean updateRoleBaseInfo(Role role) {
        if (roleDao.getCountByName(role) > 0)
            return false;
        else {
            roleDao.updateRoleBaseInfo(role);
            return true;
        }
    }

    public void updateRoleRights(Role role) {
        roleDao.updateRoleRights(role);
    }

    public IRoleDao getRoleMapper() {
        return roleDao;
    }

    public void setRoleMapper(IRoleDao roleMapper) {
        this.roleDao = roleMapper;
    }

}
