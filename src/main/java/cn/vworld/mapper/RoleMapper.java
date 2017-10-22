package cn.vworld.mapper;

import cn.vworld.bean.Role;

import java.util.List;

public interface RoleMapper {

    List<Role> findAll();

    void saveRole(Role role);

    void deleteRoleById_m(String roleId);

    void deleteRoleById(String roleId);


}
