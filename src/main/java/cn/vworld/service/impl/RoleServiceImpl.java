package cn.vworld.service.impl;

import cn.vworld.bean.Role;
import cn.vworld.mapper.RoleMapper;
import cn.vworld.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
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


}
