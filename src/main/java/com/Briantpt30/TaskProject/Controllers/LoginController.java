package com.Briantpt30.TaskProject.Controllers;

import com.Briantpt30.TaskProject.Models.User;
import com.Briantpt30.TaskProject.Models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("login")
public class LoginController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model){
        model.addAttribute("title", "Login");
        model.addAttribute(new User());

        return "login";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String indexPost(Model model, @ModelAttribute User logUser) {
        model.addAttribute("user", logUser);
        System.out.println(logUser.getEmail());
        System.out.println(logUser.getPassword());
        System.out.println(logUser.getId());


        if (userDao.existsByEmail(logUser.getEmail())){
            if (userDao.existsByPassword(logUser.getPassword())){
                System.out.println("User logged in");
                User loggedIn = userDao.findByEmail(logUser.getEmail());
                System.out.println(loggedIn.getId());
                return "redirect:userpage/" + loggedIn.getId();
            }
        }


        return "redirect:login";
    }
}
