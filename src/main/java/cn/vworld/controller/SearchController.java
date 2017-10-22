package cn.vworld.controller;

import cn.vworld.bean.User;
import cn.vworld.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class SearchController {

    @Autowired
    private UserService userService;

    @RequestMapping("/backend/search")
    public String search(Model model, String search, String key) {
        if (search.equals("movie")) {
            return "redirect:/backend/空着?xxxx=" + key;
        } else {
            List<User> userList = userService.findUserByUsername(key);
            model.addAttribute("userList", userList);
            return "/backend/userList";
        }
    }
}
