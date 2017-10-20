package cn.vworld.service;

import cn.vworld.bean.Type;
import cn.vworld.bean.User;
import cn.vworld.bean.UserInfo;
import cn.vworld.mapper.UserInfoMapper;
import cn.vworld.mapper.UserMapper;
import cn.vworld.utils.SendMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

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
    public void saveUser(User user,UserInfo userInfo) {
        user.setUserId(UUID.randomUUID().toString());
        user.setCreateTime(new Date());
        user.setState(0);
        user.setBan(0);
        userMapper.saveUser(user);
        userInfo.setUserInfoId(user.getUserId());
        userInfo.setCreateTime(new Date());
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
        userMapper.updatePassword(userId, password);
        session.invalidate();//修改密码完成后自动退出
    }

    @Override
    public void sendUpdatePasswordMail(String to, String userId, HttpSession session) throws Exception {
        String validate = UUID.randomUUID().toString();
        String validateUrl = "链接地址?userId="+userId+"&validate="+validate;
        session.setAttribute("validate", validate);
        SendMail.sendMail(to, validateUrl);
    }

    @Override
    public User findUserByEmail(String to) {
        return userMapper.findUserByEmail(to);
    }

    @Override
    public List<User> findAllUser() {
        return userMapper.findAllUser();
    }

    @Override
    public List<User> findUserByUsername(String username) {
        return userMapper.findUserByUsername(username);
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
    public void saveAdmin(User user, UserInfo userInfo) {
        user.setUserId(UUID.randomUUID().toString());
        user.setCreateTime(new Date());
        user.setState(1);
        user.setBan(0);
        userMapper.saveUser(user);
        userInfo.setUserInfoId(user.getUserId());
        userInfo.setCreateTime(new Date());
        userInfoMapper.saveUserInfo(userInfo);
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
}
