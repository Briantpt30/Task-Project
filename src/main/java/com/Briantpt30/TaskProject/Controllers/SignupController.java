package com.Briantpt30.TaskProject.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("signup")
public class SignupController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model){

        return "signup";
    }
}
