package cn.vworld.service;

import cn.vworld.bean.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;


public interface UserService {
    //通过用户名和密码找到用户的详细信息
    User findUserByU_P(String username, String password);

    /**
     * 通过账号密码查询简单用户对象
     *
     * @param username
     * @param password
     * @return
     */
    User findUserByU_P_simple(String username, String password);

    /**
     * 修改账户邮箱激活状态
     * @param userId 用户名
     */
    void updateState(String userId);

    /**
     * 修改用户账号禁用状态（是否被禁用）
     * @param userId 用户名
     * @param ban 禁用字段
     */
    void updateBan(String userId, Integer ban);

    /**
     * 注册用户
     * @param user  读到的user对象信息
     * @param userInfo 读到的userInfo对象信息
     */
    void saveUser(User user, UserInfo userInfo);


    /**
     * 修改密码的验证码验证
     * @param validate
     * @return
     */
    boolean toUpdatePassword(String validate,  HttpSession session);

    /**
     * 用户修改密码
     * @param userId
     * @param password
     * @param session
     */
    void updatePassword(String userId, String password, HttpSession session);

    /**
     * 发送修改密码的验证邮件
     * @param to
     * @param userId
     * @param session
     */
    void sendUpdatePasswordMail(String to, String userId, HttpSession session) throws Exception;

    /**
     * 根据邮箱查User对象
     * @param to
     * @return User
     */
    User findUserByEmail(String to);

    /**
     * 显示用户列表
     * @return
     */
    List<User> findAllUser(int showpage, int lines);

    /**
     * 按照用户名查询
     *
     * @param
     * @param lines
     *@param username  @return List<User>
     */
    List<User> findUserByUsername(int showpage, int lines, String username);

    /**
     * 显示管理员列表
     * @return List<User>
     */
    List<User> findAllAdmin();

    /**
     * 删除管理员
     * @param userId
     */
    void deleteAdmin(String userId);

    /**
     * 增加管理员
     * @param user
     * @param userInfo
     * @param role
     */
    void saveAdmin(User user, UserInfo userInfo, String role);

    /**
     * 查看用户详情
     * @param userId
     */
    User findUserByUserId(String userId);

    /**
     * 查询用户喜爱的电影类型
     * @param userId
     * @return List<Type>
     */
    List<Type> findUserType(String userId);

    /**
     * 更新用户详细信息
     * @param userInfo
     * @param types
     */
    void updateUserInfo(UserInfo userInfo, String[] types);

    /**
     * 通过username来查询有没有这个用户
     * @param username 用户名
     * @return user对象
     */
    User checkUsername(String username);

    /**
     * 根据关键字查询用户
     * @param key
     * @return
     */
    int findUserNumBykey(String key);

    /**
     * 根据关键字查询用户列表
     * @param showpage
     * @param lines
     * @param key
     * @return
     */
    List<User> findUserListByKey(int showpage, int lines, String key);

    /**
     * 查询用户数量
     * @return
     */
    int findAllUserNum();



    /**
     * 通过表类型下载电影信息表数据
     * @param map 传递表类型
     * @return
     */
    List<MovieInfo> downLoadFilmList(HashMap<String, String> map);

    /**
     * 通过表类型下载用户表数据
     * @param map 传递表类型
     * @return
     */
    List<User> downLoadUserList(HashMap<String, String> map);

    /**
     * 查询数据库看看email是否存在
     *
     * @param email 传入的email
     * @return 查到的User对象
     */
    User checkEmailExist(String email);

    /**
     * 查询最近一周新注册的用户数量
     *
     * @return
     */
    int findRecentRegisterUser();
}
