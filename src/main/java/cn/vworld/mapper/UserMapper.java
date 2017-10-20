package cn.vworld.mapper;

import cn.vworld.bean.Type;
import cn.vworld.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface UserMapper {

    User findUserByU_P(@Param("username") String username,@Param("password") String password);

    User findUserByU_P_simple(@Param("username") String username,@Param("password") String password);


    void updateState(String userId);

    void updateBan(@Param("userId") String userId, @Param("ban") Integer ban);

    void saveUser(User user);

    //修改用户密码
    void updatePassword(@Param("userId") String userId, @Param("password") String password);
    //根据用户邮箱查找用户
    User findUserByEmail(String email);
    //显示全用户列表
    List<User> findAllUser();
    //根据用户名查找用户，显示在用户列表
    List<User> findUserByUsername(String username);
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
  
    User checkUsername(String username);

}
