package cn.thinking.system.role.dao.impl;

import java.util.List;
import org.springframework.stereotype.Repository;
import cn.thinking.common.basedao.BaseDao;
import cn.thinking.org.system.role.Role;
import cn.thinking.system.role.dao.IRoleDao;

@Repository(value = "cn.thinking.system.role.dao.impl.RoleDaoImpl")
public class RoleDaoImpl extends BaseDao implements IRoleDao {

    @Override
    public List<Role> listAllRoles() {
        return (List<Role>) this.selectList("cn.thinking.org.system.role.Role.listAllRoles");
    }

    @Override
    public Role getRoleById(int roleId) {
        return (Role) this.selectOne("cn.thinking.org.system.role.Role.getRoleById", roleId);
    }

    @Override
    public void insertRole(Role role) {
        this.insert("cn.thinking.org.system.role.Role.insertRole", role);
    }

    @Override
    public void updateRoleBaseInfo(Role role) {
        this.update("cn.thinking.org.system.role.Role.updateRoleBaseInfo", role);
    }

    @Override
    public void deleteRoleById(int roleId) {
        this.delete("cn.thinking.org.system.role.Role.deleteRoleById", roleId);
    }

    @Override
    public int getCountByName(Role role) {
        return (Integer) this.selectOne("cn.thinking.org.system.role.Role.getCountByName", role);
    }

    @Override
    public void updateRoleRights(Role role) {
        this.update("cn.thinking.org.system.role.Role.updateRoleRights", role);
    }

}
