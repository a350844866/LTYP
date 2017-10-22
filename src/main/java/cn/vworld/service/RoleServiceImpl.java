package cn.vworld.service;

import cn.vworld.bean.Role;
import cn.vworld.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> findAll() {
        List<Role> roleList = roleMapper.findAll();
        return roleList;
    }

    @Override
    public void saveRole(Role role){

        roleMapper.saveRole(role);
    }

    @Override
    public void deleteRoleById(String roleId) {
        roleMapper.deleteRoleById(roleId);
    }

    @Override
    public void deleteRoleById_m(String roleId) {
        roleMapper.deleteRoleById_m(roleId);
    }


}
