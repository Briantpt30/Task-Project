package com.Briantpt30.TaskProject.Controllers;

import com.Briantpt30.TaskProject.Models.User;
import com.Briantpt30.TaskProject.Models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("signup")
public class SignupController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model){
        model.addAttribute("title", "Signup");
        model.addAttribute(new User());

        return "signup";
    }
    @RequestMapping(value = "", method = RequestMethod.POST)
    public String indexPost(Model model, @ModelAttribute @Valid User newUser){

        model.addAttribute("title", "Signup to TuDu!");

        userDao.save(newUser);
        model.addAttribute("user", newUser);

        return "redirect: userPage";

    }

}
