package cn.vworld.service.impl;

import cn.vworld.bean.*;
import cn.vworld.mapper.RoleUserMapper;
import cn.vworld.mapper.UserInfoMapper;
import cn.vworld.mapper.UserMapper;
import cn.vworld.service.UserService;
import cn.vworld.tool.Md5HashPassword;
import cn.vworld.utils.SendMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private RoleUserMapper roleUserMapper;

    @Override
    public User findUserByU_P(String username, String password) {
        return userMapper.findUserByU_P(username,password);
    }

    @Override
    public User findUserByU_P_simple(String username, String password) {
        return userMapper.findUserByU_P_simple(username,password);
    }


    @Override
    public User checkUsername(String username) {
        return userMapper.checkUsername(username);
    }

    @Override
    public int findUserNumBykey(String key) {
        return userMapper.findUserNumByKey(key);
    }

    @Override
    public List<User> findUserListByKey(int showpage, int lines, String key) {
        return userMapper.findUserListByKey(showpage, lines, key);
    }

    @Override
    public User checkEmailExist(String email) {
        return userMapper.checkEmailExist(email);
    }

    @Override
    public int findRecentRegisterUser() {
        return userMapper.selectRecentRegisterUser();
    }

    @Override
    public int findAllUserNum() {
        return userMapper.findAllUserNum();
    }




    @Override
    public void saveUser(User user,UserInfo userInfo) {
        user.setUserId(UUID.randomUUID().toString());
        user.setCreateTime(new Date());
        user.setState(0);
        user.setBan(0);
        user.setPassword(Md5HashPassword.getMd5Hash(user.getPassword(), user.getUsername()));
        user.setUpdateTime(user.getCreateTime());
        userMapper.saveUser(user);
        roleUserMapper.saveNormalRole(user.getUserId());
        userInfo.setUserInfoId(user.getUserId());
        userInfo.setNickname(user.getUsername());
        userInfo.setCreateTime(new Date());
        userInfo.setUpdateTime(userInfo.getCreateTime());
        userInfoMapper.saveUserInfo(userInfo);

    }

    @Override
    public void updateState(String userId) {
        userMapper.updateState(userId);
    }

    @Override
    public void updateBan(String userId, Integer ban) {
        userMapper.updateBan(userId, ban);
    }


    @Override
    public boolean toUpdatePassword(String validate, HttpSession session) {
        return session.getAttribute("validate").equals(validate);
    }

    @Override
    public void updatePassword(String userId, String password, HttpSession session) {
        User user = userMapper.findUserByUserId(userId);
        password = Md5HashPassword.getMd5Hash(password, user.getUsername());
        userMapper.updatePassword(userId, password);
        session.removeAttribute("validate");
        session.removeAttribute("user_login");//修改密码完成后自动退出
    }

    @Override
    public void sendUpdatePasswordMail(String to, String userId, HttpSession session) throws Exception {
        String validate = UUID.randomUUID().toString();
        String validateUrl = "toUpdatePassword?userId=" + userId + "&validate=" + validate;
        session.setAttribute("validate", validate);
        SendMail.sendMail(to, validateUrl);
    }

    @Override
    public User findUserByEmail(String to) {
        return userMapper.findUserByEmail(to);
    }


    @Override
    public List<User> findAllUser(int showpage, int lines) {
        return userMapper.findAllUser(showpage, lines);
    }


    @Override
    public List<User> findUserByUsername(int showpage, int lines, String username) {
        return userMapper.findUserByUsername(showpage, lines, username);
    }

    @Override
    public List<User> findAllAdmin() {
        return userMapper.findAllAdmin();
    }

    @Override
    public void deleteAdmin(String userId) {
        userMapper.deleteAdminRole(userId);
        userMapper.deleteAdmin(userId);
    }

    @Override
    public void saveAdmin(User user, UserInfo userInfo, String roleId) {
        user.setUserId(UUID.randomUUID().toString());
        user.setCreateTime(new Date());
        user.setState(1);
        user.setBan(0);
        user.setPassword(Md5HashPassword.getMd5Hash(user.getPassword(), user.getPassword()));
        userMapper.saveUser(user);
        userInfo.setUserInfoId(user.getUserId());
        userInfo.setCreateTime(new Date());
        userInfo.setUpdateTime(userInfo.getCreateTime());
        userInfo.setNickname(user.getUsername());
        userInfoMapper.saveUserInfo(userInfo);
        userMapper.saveUserRole(user.getUserId(), roleId);
    }

    @Override
    public User findUserByUserId(String userId) {
        return userMapper.findUserByUserId(userId);
    }

    @Override
    public List<Type> findUserType(String userId) {
        return userMapper.findUserType(userId);
    }

    @Override
    public void updateUserInfo(UserInfo userInfo, String[] types) {
        userMapper.deleteUserTypes(userInfo.getUserInfoId());
        for (String typeId :
                types) {
            userMapper.saveUserType(userInfo.getUserInfoId(), typeId);
        }
        userInfo.setUpdateTime(new Date());
        userInfoMapper.updateUserInfo(userInfo);
    }


    @Override
    public List<MovieInfo> downLoadFilmList(HashMap<String, String> map) {
        List<MovieInfo> list=userMapper.downLoadFilmList(map);
        return list;
    }

    @Override
    public List<User> downLoadUserList(HashMap<String, String> map) {
        List<User> list=userMapper.downLoadUserList(map);
        return list;
    }
}
