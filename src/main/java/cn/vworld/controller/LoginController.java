package cn.vworld.controller;

import cn.vworld.bean.User;
import cn.vworld.bean.UserInfo;
import cn.vworld.service.UserService;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping("/signin")
    public String signIn(String username, String password, Model model) {
        return "/login/sign-in";
    }

    //点击登录页面后的操作
    @RequestMapping(value = "/login")
    public String login(Model model, String username, String password, HttpSession session) {
//        User user= userService.findUserByU_P(username, password);
        //通过username和password来查询数据库
        User user= userService.findUserByU_P(username, password);
        if (user != null) {
            model.addAttribute("user", user);
            session.setAttribute("user_login",user);
            return "redirect:/movie/showmovie";
        }
        return "/login/signin";
    }
    //转到注册页面
    @RequestMapping("/signup")
    public String signUp() {
        return "/login/sign-up";
    }

    //转到忘记密码页面
    @RequestMapping("/forgetPassword")
    public String forgetPassword() {
        return "/login/reset-password";
    }

    //注册操作
    @RequestMapping("/regist")
    public String saveUser(User user, UserInfo userInfo, Model model, HttpSession session) {
        userService.saveUser(user,userInfo);
        User userSendMail = userService.findUserByEmail(userInfo.getEmail());
        session.setAttribute("userSendMail", userSendMail);
        return "redirect:/sendValidateMail";
    }

    /**
     * Ajax异步查询数据库 判断用户名是否被占用
     * @param response
     * @param request
     * @throws IOException
     */
    @RequestMapping(value = "/AjaxCheckUsername",method = RequestMethod.POST)
    public void checkUsername(HttpServletResponse response, HttpServletRequest request) throws IOException {
       String username = request.getParameter("username");
        User result =  userService.checkUsername(username);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write(result!=null?"用户名已存在!":"恭喜您!用户名可以使用");
    }

    @RequestMapping("logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user_login");
        return "redirect:/index";
    }








}
