package CRUD_Spring_Boot.crudspringboot.controller;

import CRUD_Spring_Boot.crudspringboot.Service.RoleService;
import CRUD_Spring_Boot.crudspringboot.Service.UserService;
import CRUD_Spring_Boot.crudspringboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/user")
    public String getUser(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("roles", user.getRoles());
        return "user";
    }

}
