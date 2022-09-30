package CRUD_Spring_Boot.crudspringboot.controllers;

import CRUD_Spring_Boot.crudspringboot.service.RoleService;
import CRUD_Spring_Boot.crudspringboot.service.UserService;
import CRUD_Spring_Boot.crudspringboot.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdminController {

    private UserService userService;
    private RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping(value = "/admin/users")
    public String getAllUsers(@AuthenticationPrincipal User user, Model model){
        model.addAttribute("user", user);
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("roles", user.getRoles());
        return "allusers";
    }

    @PostMapping("/admin/users")
    public String create(@ModelAttribute("user") User user, @RequestParam(value = "checkBoxRoles") String[] checkBoxRoles) {
        userService.save(user, checkBoxRoles);
        return "redirect:/admin/users";
    }

    @GetMapping("/admin/edit/{userId}")
    public String edit(Model model, @PathVariable("userId") int userId) {
        model.addAttribute("user", userService.getUser(userId));
        model.addAttribute("roles", roleService.getAllRoles());
        return "allusers";
    }

    @PatchMapping("/admin/edit/{id}")
    public String update(@ModelAttribute("user") User user, @RequestParam(value = "checkBoxRoles") String[] checkBoxRoles) {
        userService.update(user, checkBoxRoles);
        return "redirect:/admin/users";
    }

    @DeleteMapping("/admin/remove/{userId}")
    public String delete(@PathVariable("userId") int userId) {
        userService.delete(userId);
        return "redirect:/admin/users";
    }
}
