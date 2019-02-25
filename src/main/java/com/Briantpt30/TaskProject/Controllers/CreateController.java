package com.Briantpt30.TaskProject.Controllers;

import com.Briantpt30.TaskProject.Models.Project;
import com.Briantpt30.TaskProject.Models.data.GroupDao;
import com.Briantpt30.TaskProject.Models.data.ProjectDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CreateController {

    @Autowired
    private ProjectDao projectDao;

    @Autowired
    private GroupDao groupDao;

    @PostMapping("/createProject")
    public String createProject(Model model, @ModelAttribute Project newProject){
        model.addAttribute("title", "Create New Project");
        model.addAttribute(new Project());

        return "create/project";

    }
}
