package com.Briantpt30.TaskProject.Controllers;

import com.Briantpt30.TaskProject.Models.User;
import com.Briantpt30.TaskProject.Service.SecurityService;
import com.Briantpt30.TaskProject.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
// @RequestMapping("signup")
public class SignupController {

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

   // @RequestMapping(value = "", method = RequestMethod.GET)
    @GetMapping("/signup")
    public String index(Model model){
        model.addAttribute("title", "Signup to TuDu!");
        model.addAttribute(new User());
        System.out.println("Spiderman");

        return "signup";
    }
    //@RequestMapping(value = "", method = RequestMethod.POST)
    @PostMapping("/signup")
    public String indexPost(Model model, @ModelAttribute @Valid User newUser, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            System.out.println("sdadaddadsd");
            return "signup";
        }
        System.out.println("Bullshit");
        System.out.println(newUser.getEmail());
        userService.save(newUser);
        securityService.autologin(newUser.getEmail(), newUser.getPassword());
        return "redirect:userpage/" + newUser.getId();

        }

}








