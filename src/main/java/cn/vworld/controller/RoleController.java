package cn.vworld.controller;

import cn.vworld.bean.Role;
import cn.vworld.service.RoleService;
import cn.vworld.service.RoleUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/role")
@Transactional
public class RoleController {
    @Autowired
    private RoleService roleService;

    @Autowired
    private RoleUserService roleUserService;

    @RequestMapping("/addRole")
    public String toRole(){
        return "/backend/addRole";
    }

    @RequestMapping("/list")
    public String findRole(Model model){
        List<Role> roleList=roleService.findAll();
        model.addAttribute("roleList",roleList);
        return "/backend/roleList";
    }

    @RequestMapping("/tosave")
    public String saveRole(Role role){
        roleService.saveRole(role);
        return "redirect:/role/list";
    }

    @RequestMapping("/delete")
    public String deleteRole(String roleId){
        roleUserService.deleteRoleUserById(roleId);  //角色用户关联表
        roleService.deleteRoleById(roleId);
        return "redirect:/role/list";
    }



}
