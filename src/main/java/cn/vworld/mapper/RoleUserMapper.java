package cn.vworld.mapper;

public interface RoleUserMapper {
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
