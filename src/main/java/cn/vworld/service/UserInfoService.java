package cn.vworld.service;

import cn.vworld.bean.UserInfo;

public interface UserInfoService {
    /**
     * 根据id查找userInfo对象
     *
     * @param userInfoId
     * @return
     */
    UserInfo findUserInfoById(String userInfoId);

    /**
     * 更新个人信息
     * @param userInfo
     */
    void updateUserInfo(UserInfo userInfo);
}
