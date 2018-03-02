package cn.vworld.service;

/**
 * @author jiaxu
 * @version $Id: RoleUserService.java, v 0.1 2018/3/1 18:09 jiaxu Exp $$
 */
public interface RoleUserService {

    /**
     * 注册的时候设置用户为普通用户
     *
     * @param userId userID
     */
    void saveNormalRole(String userId);

    /**
     * 根据roleId删除role
     *
     * @param roleId
     */
    void deleteRoleUserById(String roleId);
}
