package cn.vworld.mapper;

import cn.vworld.bean.UserInfo;

public interface UserInfoMapper {
    /**
     * 保存用户信息
     *
     * @param userInfo
     */
    void saveUserInfo(UserInfo userInfo);

    /**
     * 通过id查找用户
     * @param userInfoId
     * @return
     */
    UserInfo findUserInfoById(String userInfoId);

    /**
     * 更新用户信息
     * @param userInfo
     */
    void updateUserInfo(UserInfo userInfo);

    /**
     *
     * @param userInfo
     */
    void updateUserInfoByUser(UserInfo userInfo);
}
