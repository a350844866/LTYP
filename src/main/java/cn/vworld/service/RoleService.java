package cn.vworld.service;

import cn.vworld.bean.Role;

import java.util.List;

public interface RoleService {
    /**
     *
     * @return 返回所有角色对象
     */
    List<Role> findAll();

    /**
     * 添加角色
     * @param role 角色对象
     */
    void saveRole(Role role);

    /**
     * 根据角色ID删除角色
     * @param roleId    角色ID
     */
    void deleteRoleById(String roleId);


}
