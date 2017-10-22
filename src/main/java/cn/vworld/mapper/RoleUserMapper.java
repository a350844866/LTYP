package cn.vworld.mapper;

public interface RoleUserMapper {
    /**
     * 注册的时候设置用户为普通用户
     *
     * @param userId userID
     */
    void saveNormalRole(String userId);
}
