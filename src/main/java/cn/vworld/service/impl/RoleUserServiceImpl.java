package cn.vworld.service.impl;

import cn.vworld.mapper.RoleUserMapper;
import cn.vworld.service.RoleUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author jiaxu
 * @version $Id: RoleUserServiceImpl.java, v 0.1 2018/3/1 18:10 jiaxu Exp $$
 */
@Service
public class RoleUserServiceImpl implements RoleUserService {

    @Autowired
    private RoleUserMapper roleUserMapper;

    /**
     * 注册的时候设置用户为普通用户
     *
     * @param userId userID
     */
    @Override
    public void saveNormalRole(String userId) {
        roleUserMapper.saveNormalRole(userId);
    }

    /**
     * 根据roleId删除role
     *
     * @param roleId
     */
    @Override
    public void deleteRoleUserById(String roleId) {
        roleUserMapper.deleteRoleUserById(roleId);
    }
}
