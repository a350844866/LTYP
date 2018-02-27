package cn.vworld.controller;


import cn.vworld.bean.*;


import cn.vworld.service.UserInfoService;

import cn.vworld.mapper.UserInfoMapper;

import cn.vworld.service.RoleService;

import cn.vworld.service.UserService;
import cn.vworld.utils.SendMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Transactional
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired

    private UserInfoService userInfoService;  

    @Autowired
    private RoleService roleService;

    //发送激活邮件
    @RequestMapping("/sendValidateMail")
    public String sendMail(Model model, HttpSession session) {
        User user = (User) session.getAttribute("userSendMail");
        String userId = user.getUserId();
        String to = user.getUserInfo().getEmail();
        session.removeAttribute("userSendMail");
        String validateUrl = "activateAccount?userId=" + userId;
        try {
            SendMail.sendMail(to, validateUrl);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("msg", "发送邮件出错，请联系管理员！");
            return "movie/message";
        }

        return "redirect:/login/signin";
    }


    //激活邮件页面
    @RequestMapping("/activateAccount")
    public String activateAccount(Model model, String userId){
        userService.updateState(userId);
        model.addAttribute("msg", "账号激活成功！");
        return "movie/message";
    }
    //管理员修改用户禁用状态
    @RequestMapping("/backend/updateBan")
    public String updateBan(String userId, @RequestParam("ban") String b){
        Integer ban = Integer.parseInt(b);
        userService.updateBan(userId, ban);
        return "redirect:/backend/userList";
    }

    //发送修改密码验证邮件
    @RequestMapping("/sendUpdatePasswordMail")
    public String sendUpdatePasswordMail(Model model, String userId, @RequestParam("email") String to, HttpSession session){
        try {
            userService.sendUpdatePasswordMail(to, userId, session);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("msg", "发送邮件出错，请联系管理员！");
            return "movie/message";
        }
        model.addAttribute("msg", "发送邮件成功！");
        return "movie/message";
    }


    //跳转到修改密码页面
    @RequestMapping("/toUpdatePassword")
    public String toUpdatePassword(String userId, String validate, Model model,  HttpSession session){
        try {
            if (userService.toUpdatePassword(validate, session)) {
                //验证码判断正确
                model.addAttribute("userId", userId);
                return "/login/reset-password";
            }
            model.addAttribute("msg", "跳转修改密码页面失败！请重新发送邮件");
            return "movie/message";
        } catch (Exception e) {
            model.addAttribute("msg", "跳转修改密码页面失败！请重新发送邮件");
            return "movie/message";
        }
    }


    //修改用户密码
    @RequestMapping("/updatePassword")
    public String updatePassword(String userId, String password, Model model, HttpSession session){
        userService.updatePassword(userId, password, session);
        model.addAttribute("msg", "修改密码成功，请重新登录！");
        return "movie/message";
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
            return "movie/message";
        }
        model.addAttribute("msg", "发送邮件成功！");
        return "movie/message";
    }

    //显示普通用户列表
    @RequestMapping("/backend/userList")
    public String showUserList(Model model, String showpage) {

        int page = 1;

        int lines = 8;

        if (showpage != null) {
            page = Integer.parseInt(showpage);
        }

        int allUsers = userService.findAllUserNum();

        int allpages = allUsers % lines == 0 ? (allUsers / lines) : ((allUsers / lines) + 1);

        List<User> userList = userService.findAllUser((page - 1) * lines, lines);

        model.addAttribute("userList", userList);
        model.addAttribute("allpages", allpages);

        return "/backend/userList";
    }

//    //按照username查找用户
//    @RequestMapping("/backend/findUserByUsername")
//    public String findUserByUsername(Model model, String username){
//        List<User> userList = userService.findUserByUsername(username);
//        model.addAttribute("userList", userList);
//        return "/backend/userList";
//    }

    //显示管理员列表
    @RequestMapping("/backend/adminList")
    public String showAdminList(Model model){
        List<User> adminList = userService.findAllAdmin();
        model.addAttribute("adminList", adminList);
        return "backend/adminList";
    }

    //删除管理员
    @RequestMapping("/backend/deleteAdmin")
    public String deleteAdmin(String userId){
        userService.deleteAdmin(userId);
        return "redirect:/backend/adminList";
    }

    //新增管理员
    @RequestMapping("/backend/saveAdmin")
    public String saveAdmin(User user, UserInfo userInfo, String roleId) {
        userService.saveAdmin(user, userInfo, roleId);
        return "redirect:/backend/adminList";
    }


//    //用户信息查看
//    @RequestMapping("/findUserInfo")
//    public String findUserInfo(Model model, String userId){
//        User user = userService.findUserByUserId(userId);
//        List<Type> typeList = userService.findUserType(userId);
//        model.addAttribute("user", user);
//        model.addAttribute("typeList", typeList);
//        return "用户详情界面";
//    }


    //用户信息修改
    @RequestMapping("/updateUserInfo")
    public String updateUserInfo(UserInfo userInfo, String[] types){
        userService.updateUserInfo(userInfo, types);
        return "/findUserInfo";
    }

    //跳转到管理员新增页面
    @RequestMapping("/backend/toAddAdmin")
    public String toAddAdmin(Model model) {
        List<Role> roleList = roleService.findAll();
        model.addAttribute("roleList", roleList);
        return "/backend/addAdmin";
    }

    //总管理员修改管理员禁用状态
    @RequestMapping("/backend/updateAdminBan")
    public String updateAdminBan(String userId, @RequestParam("ban") String b) {
        Integer ban = Integer.parseInt(b);
        userService.updateBan(userId, ban);
        return "redirect:/backend/adminList";
    }

    @RequestMapping("/userPerInfo")
    public String userPerInfo(String userId,Model model){
        System.out.println(userId);


        UserInfo userInfo = userInfoService.findUserInfoById(userId);
        System.out.println(userInfo.toString());
        model.addAttribute("userInfo",userInfo);
        return "/backend/userPersonalInfo";
    }
    @RequestMapping("/updateUserInfoByUser")
    public String updateUserInfo(UserInfo userInfo){

        userInfoService.updateUserInfo(userInfo);

        return "/backend/userPersonalInfo";
    }


    @RequestMapping("/toSendForgetMail")
    public String toSendForgetMail() {
        return "/login/sendMail";
    }


    //下载电影表数据
    @RequestMapping("/backend/downLoadFilmList")
    public void downloadFileList( HttpServletResponse response, String tableType) throws IOException {

        HashMap<String,String> map=new HashMap<String,String>();
        map.put("tableType",tableType);
        List<MovieInfo> list = userService.downLoadFilmList(map);
        // 3.定义保存销售榜单数据对象
        StringBuffer buffer = new StringBuffer("电影名称,上映时间,所属国家,评分\n");
        // 4.遍历list集合,拼接数据

        for (MovieInfo info : list) {
            buffer.append(info.getMovieName()).append(",").append(info.getShowTime()).append(",")
                    .append(info.getCountry()).append(",").append(info.getAvgscore()).append("\n");
        }
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String fname = tableType + sdf.format(date) + ".csv";
        // 告知浏览器以附件下载的方式打开
        response.setHeader("Content-Disposition", "attachment;filename=" + fname);
        response.setContentType("text/html;charset=gbk");
        response.getWriter().write(buffer.toString());
    }

    //下载用户表数据
    @RequestMapping("/backend/downLoadUserList")
    public void downLoadUserList( HttpServletResponse response,String tableType) throws IOException {
        HashMap<String,String> map=new HashMap<String,String>();
        map.put("tableType",tableType);

        List<User> list = userService.downLoadUserList(map);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        SimpleDateFormat  a=new SimpleDateFormat("yyyy年MM月dd日");
        // 3.定义保存销售榜单数据对象
        StringBuffer buffer = new StringBuffer("用户ID,用户名字,用户状态,创建时间,更新时间\n");
        // 4.遍历list集合,拼接数据
        for (User info : list) {
            if (info.getUsername() == null) {
                info.setUsername("Null");
            }
            if (info.getState() == null) {
                info.setState(0);
            }
            buffer.append(info.getUserId()).append(",").append(info.getUsername()).append(",")
                    .append(info.getState()).append(",").append(a.format(info.getCreateTime())).append(",").append(a.format(info.getUpdateTime())).append("\n");
        }

        Date date = new Date();
        String fname = tableType + sdf.format(date) + ".csv";
        // 告知浏览器以附件下载的方式打开
        response.setHeader("Content-Disposition", "attachment;filename=" + fname);
        response.setContentType("text/html;charset=gbk");
        response.getWriter().write(buffer.toString());
    }

}



