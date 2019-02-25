package com.Briantpt30.TaskProject.Controllers;

import com.Briantpt30.TaskProject.Models.Project;
import com.Briantpt30.TaskProject.Models.User;
import com.Briantpt30.TaskProject.Models.data.GroupDao;
import com.Briantpt30.TaskProject.Models.data.ProjectDao;
import com.Briantpt30.TaskProject.Models.data.UserDao;
import com.Briantpt30.TaskProject.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/userpage")
public class UserPageController {

    @Autowired
    UserService userService;

    @Autowired
    private ProjectDao projectDao;

    @Autowired
    private GroupDao groupDao;

    //@PreAuthorize("hasAnyRole('USER')")
    //@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    @GetMapping("/{userId}")
    public String index(Model model, @PathVariable int userId) {
        model.addAttribute("title", "MyProjects" );
        User user = userService.findById(userId);
        model.addAttribute(new Project());
        model.addAttribute("user", user);
        model.addAttribute("userId", user.getId());
        model.addAttribute("projects", user.getProjects());
        model.addAttribute("groups", user.getGroups());

        return "userPage";

    }

//    @GetMapping("/{userId}/project")
//    public String createProject(Model model){
//        model.addAttribute("title", "Create New Project");
//        model.addAttribute(new Project());
//
//        return "create/project";
//
//    }
}
