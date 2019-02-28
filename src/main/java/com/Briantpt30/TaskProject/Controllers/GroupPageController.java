package com.Briantpt30.TaskProject.Controllers;

import com.Briantpt30.TaskProject.Models.*;
import com.Briantpt30.TaskProject.Models.data.GroupDao;
import com.Briantpt30.TaskProject.Models.data.ProjectDao;
import com.Briantpt30.TaskProject.Models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("grouppage")
public class GroupPageController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private ProjectDao projectDao;

    @Autowired
    private GroupDao groupDao;


    @RequestMapping(value = "/{groupId}", method = RequestMethod.GET)
    public String index(Model model, @PathVariable int groupId){

        Group group = groupDao.findFirstById(groupId);
        model.addAttribute(new Project());
        model.addAttribute("group", group);
        model.addAttribute("title", group.getName());
        model.addAttribute("projects", group.getProjects());
        model.addAttribute("users", group.getUsers());



        return "grouppage";

    }
}
