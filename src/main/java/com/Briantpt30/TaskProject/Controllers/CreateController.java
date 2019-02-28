package com.Briantpt30.TaskProject.Controllers;

import com.Briantpt30.TaskProject.Models.Group;
import com.Briantpt30.TaskProject.Models.Project;
import com.Briantpt30.TaskProject.Models.Task;
import com.Briantpt30.TaskProject.Models.User;
import com.Briantpt30.TaskProject.Models.data.GroupDao;
import com.Briantpt30.TaskProject.Models.data.ProjectDao;
import com.Briantpt30.TaskProject.Models.data.TaskDao;
import com.Briantpt30.TaskProject.Models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class CreateController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private ProjectDao projectDao;

    @Autowired
    private GroupDao groupDao;

    @Autowired
    private TaskDao taskDao;

    @PostMapping("/createProject")
    public String createProject(Model model, @ModelAttribute Project newProject, Principal principal){
        model.addAttribute("title", "Create New Project");
        model.addAttribute(new Project());
        User user = userDao.findByEmail(principal.getName());
        newProject.setUser(user);
        projectDao.save(newProject);

        return "redirect:userpage/" + user.getId();

    }

    @PostMapping("/createTask/{projectId}")
    public String createTask(Model model, @ModelAttribute Task task, @PathVariable int projectId){
        Project project = projectDao.findFirstById(projectId);
        System.out.println(projectId);
        model.addAttribute(new Task());
        task.setProject(project);
        taskDao.save(task);

        return "redirect:/projectpage/" + project.getId();
    }

    @PostMapping("/createGroupProject/{groupId}")
    public String createGroupProject(Model model, @ModelAttribute Project newProject, @PathVariable int groupId){
        Group group = groupDao.findFirstById(groupId);
        newProject.setGroup(group);
        projectDao.save(newProject);

        return "redirect:grouppage/" + group.getId();


    }

    // Todo cannot grab Object, i have no idea how to convert object to list!!!
    @PostMapping("/createGroup")
    public String createGroup(Model model, @ModelAttribute Group newGroup, Principal principal, @ModelAttribute Object usersList) {
        System.out.println(usersList.getClass());
        System.out.println(usersList.toString().length());

        User user = userDao.findByEmail(principal.getName());

        groupDao.save(newGroup);
        return "redirect:userpage/" + user.getId();
    }

    // Todo create an add user function for group(use modal for form)

}
