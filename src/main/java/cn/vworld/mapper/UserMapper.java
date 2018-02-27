package cn.vworld.mapper;

import cn.vworld.bean.*;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.web.filter.mgt.DefaultFilter;

import java.util.HashMap;
import java.util.List;

public interface UserMapper {
    /**
     * 根据登录名和密码查找用户
     *
     * @param username
     * @param password
     * @return
     */
    User findUserByU_P(@Param("username") String username,@Param("password") String password);

    /**
     * 根据用户名和密码查找简单的用户对象
     * @param username
     * @param password
     * @return
     */
    User findUserByU_P_simple(@Param("username") String username, @Param("password") String password);

    /**
     * 激活用户
     * @param userId
     */
    void updateState(String userId);

    /**
     * 更改用户禁用
     * @param userId
     * @param ban
     */
    void updateBan(@Param("userId") String userId, @Param("ban") Integer ban);

    /**
     * 保存用户
     * @param user
     */
    void saveUser(User user);

    //修改用户密码
    void updatePassword(@Param("userId") String userId, @Param("password") String password);
    //根据用户邮箱查找用户
    User findUserByEmail(String email);
    //显示全用户列表
    List<User> findAllUser(@Param("showpage") int showpage, @Param("lines") int lines);
    //根据用户名查找用户，显示在用户列表
    List<User> findUserByUsername(@Param("showpage") int showpage, @Param("lines") int lines, @Param("username") String username);
    //显示管理员列表
    List<User> findAllAdmin();
    //删除管理员账号
    void deleteAdmin(String userId);
    //删除role_user关联表里面的数据
    void deleteAdminRole(String userId);
    //查询用户详情
    User findUserByUserId(String userId);
    //查询用户喜欢的电影类型
    List<Type> findUserType(String userId);
    //添加用户-电影类型关联表数据
    void saveUserType(@Param("userId") String userId, @Param("userId") String typeId);
    //删除用户-电影类型关联表数据
    void deleteUserTypes(String userId);

    /**
     * 判断用户名字是否存在
     * @param username
     * @return
     */
    User checkUsername(String username);

    //添加管理员时候的职位设定
    void saveUserRole(@Param("userId") String userId, @Param("roleId") String roleId);

    /**
     * 通过用户名模糊查找用户
     * @param key
     * @return
     */
    int findUserNumByKey(String key);


    List<User> findUserListByKey(@Param("showpage") int showpage, @Param("lines") int lines, @Param("key") String key);

    int findAllUserNum();

    

    List<MovieInfo> downLoadFilmList(HashMap<String, String> map);


    List<User> downLoadUserList(HashMap<String, String> map);


    User checkEmailExist(String email);

    /**
     * 查找最近一周
     *
     * @return
     */
    int selectRecentRegisterUser();
}
