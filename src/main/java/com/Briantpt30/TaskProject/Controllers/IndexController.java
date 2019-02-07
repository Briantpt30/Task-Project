package com.Briantpt30.TaskProject.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class IndexController {

    @RequestMapping(value = "")
    public String index(Model model){
        model.addAttribute("title", "TuDu!");
        return "index";
    }
}
