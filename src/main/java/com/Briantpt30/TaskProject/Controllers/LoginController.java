package com.Briantpt30.TaskProject.Controllers;

import com.Briantpt30.TaskProject.Models.User;
import com.Briantpt30.TaskProject.Models.data.UserDao;
import com.Briantpt30.TaskProject.Service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
//@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private SecurityService securityService;

    //@RequestMapping(value = "", method = RequestMethod.GET)
    @GetMapping("/login")
    public String index(Model model){
        model.addAttribute("title", "Login");
        model.addAttribute(new User());

        return "login";
    }

    //@RequestMapping(value = "", method = RequestMethod.POST)
    @PostMapping("/login")
    public String indexPost(Model model, @ModelAttribute User logUser, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            System.out.println("sdadaddadsd");
           return "signup";
        }
       model.addAttribute("user", logUser);
        System.out.println(logUser.getEmail());
        System.out.println(logUser.getPassword());
        System.out.println(logUser.getId());
        securityService.autologin(logUser.getEmail(), logUser.getPassword());

        return "redirect:userpage/" + logUser.getId();
    }


}
