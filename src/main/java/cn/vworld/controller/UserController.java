package cn.vworld.controller;

import cn.vworld.bean.Type;
import cn.vworld.bean.User;
import cn.vworld.bean.UserInfo;
import cn.vworld.mapper.UserInfoMapper;
import cn.vworld.service.UserService;
import cn.vworld.utils.SendMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    //发送激活邮件
    @RequestMapping("/sendValidateMail")
    public String sendMail(Model model, String userId, @RequestParam("email") String to){
        String validateUrl = "链接地址?userId="+userId;
        try {
            SendMail.sendMail(to, validateUrl);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("msg", "发送邮件出错，请联系管理员！");
            return "显示信息的网址";
        }
        return "输入注册成功的页面";
    }
    //激活邮件页面
    @RequestMapping("/activateAccount")
    public String activateAccount(Model model, String userId){
        userService.updateState(userId);
        model.addAttribute("msg", "账号激活成功！");
        return "显示信息的页面";
    }
    //管理员修改用户禁用状态
    @RequestMapping("/updateBan")
    public String updateBan(String userId, @RequestParam("ban") String b){
        Integer ban = Integer.parseInt(b);
        userService.updateBan(userId, ban);
        return "用户列表页面";
    }








































































































    //发送修改密码验证邮件
    @RequestMapping("/sendUpdatePasswordMail")
    public String sendUpdatePasswordMail(Model model, String userId, @RequestParam("email") String to, HttpSession session){
        try {
            userService.sendUpdatePasswordMail(to, userId, session);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("msg", "发送邮件出错，请联系管理员！");
            return "显示信息的网址";
        }
        model.addAttribute("msg", "发送邮件成功！");
        return "显示信息的网址";
    }

    //跳转到修改密码页面
    @RequestMapping("/toUpdatePassword")
    public String toUpdatePassword(String userId, String validate, Model model,  HttpSession session){
        if(userService.toUpdatePassword(validate, session)){
            //验证码判断正确
            return "修改密码的页面";
        }
        model.addAttribute("msg", "跳转修改密码页面失败！");
        return "显示信息的网址";
    }

    //修改用户密码
    @RequestMapping("/updatePassword")
    public String updatePassword(String userId, String password, Model model, HttpSession session){
        userService.updatePassword(userId, password, session);
        model.addAttribute("msg", "修改密码成功，请重新登录！");
        return "显示修改密码成功/或者跳转到登录页面";
    }

    //用户“忘记密码”界面的发送邮件
    @RequestMapping("/sendForgetMail")
    public String sendForgetMail(Model model, @RequestParam("email") String to, HttpSession session){
        User user = userService.findUserByEmail(to);
        try {
            userService.sendUpdatePasswordMail(to, user.getUserId(), session);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("msg", "发送邮件出错，请联系管理员！");
            return "显示信息的网址";
        }
        model.addAttribute("msg", "发送邮件成功！");
        return "显示信息的网址";
    }

    //显示普通用户列表
    @RequestMapping("/userList")
    public String showUserList(Model model){
        List<User> userList = userService.findAllUser();
        model.addAttribute("userList", userList);
        return "用户列表显示页面";
    }


    //按照username查找用户
    @RequestMapping("/findUserByUsername")
    public String findUserByUsername(Model model, String username){
        List<User> userList = userService.findUserByUsername(username);
        model.addAttribute("userList", userList);
        return "用户列表显示页面";
    }

    //显示管理员列表
    @RequestMapping("/adminList")
    public String showAdminList(Model model){
        List<User> adminList = userService.findAllAdmin();
        model.addAttribute("adminList", adminList);
        return "管理员列表显示页面";
    }

    //删除管理员
    @RequestMapping("/deleteAdmin")
    public String deleteAdmin(String userId){
        userService.deleteAdmin(userId);
        return "/adminList";
    }

    //新增管理员
    @RequestMapping("/saveAdmin")
    public String saveAdmin(User user, UserInfo userInfo){
        userService.saveAdmin(user, userInfo);
        return "/adminList";
    }

    //用户信息查看
    @RequestMapping("/findUserInfo")
    public String findUserInfo(Model model, String userId){
        User user = userService.findUserByUserId(userId);
        List<Type> typeList = userService.findUserType(userId);
        model.addAttribute("user", user);
        model.addAttribute("typeList", typeList);
        return "用户详情界面";
    }


    //用户信息修改
    @RequestMapping("/updateUserInfo")
    public String updateUserInfo(UserInfo userInfo, String[] types){
        userService.updateUserInfo(userInfo, types);
        return "/findUserInfo";
    }

}
