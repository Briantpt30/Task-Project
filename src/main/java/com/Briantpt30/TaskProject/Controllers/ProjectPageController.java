package com.Briantpt30.TaskProject.Controllers;

import com.Briantpt30.TaskProject.Models.Project;
import com.Briantpt30.TaskProject.Models.data.ProjectDao;
import com.Briantpt30.TaskProject.Models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("projectpage")
public class ProjectPageController {

    @Autowired
    UserDao userDao;

    @Autowired
    ProjectDao projectDao;

    @RequestMapping(value = "/{projectId}", method = RequestMethod.GET)
    public String index(Model model, @PathVariable int projectId){
        Project project = projectDao.findFirstById(projectId);
        System.out.println(projectId);
        model.addAttribute("project", project);
        model.addAttribute("title", project.getName());
        model.addAttribute("tasks", project.getTasks());

        return "projectPage";

    }

}
