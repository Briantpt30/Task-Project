package com.Briantpt30.TaskProject.Controllers;


import com.Briantpt30.TaskProject.Models.User;
import com.Briantpt30.TaskProject.Models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
@RequestMapping("handleLogin")
public class HandleLoginController {

    @Autowired
    UserDao userDao;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String handleLogin(Principal principal) {

        String loggedIn = principal.getName();
        System.out.println("This should be email below");
        System.out.println(loggedIn);
        User user = userDao.findByEmail(loggedIn);
        System.out.println("This should be user object below");
        System.out.println(user);

        return "redirect:userpage/" + user.getId();

    }
}
