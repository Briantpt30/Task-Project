package com.Briantpt30.TaskProject.Controllers;

import com.Briantpt30.TaskProject.Models.*;
import com.Briantpt30.TaskProject.Models.data.*;
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

    @Autowired
    private TodosDao todosDao;

    @Autowired
    private CommentsDao commentsDao;

    @PostMapping("/createProject")
    public String createProject(Model model, @ModelAttribute Project newProject, Principal principal) {
        model.addAttribute("title", "Create New Project");
        model.addAttribute(new Project());
        User user = userDao.findByEmail(principal.getName());
        newProject.setUser(user);
        projectDao.save(newProject);

        return "redirect:userpage/" + user.getId();

    }

    @PostMapping("/createTask/{projectId}")
    public String createTask(Model model, @ModelAttribute Task task, @PathVariable int projectId) {
        Project project = projectDao.findFirstById(projectId);
        System.out.println(projectId);
        model.addAttribute(new Task());
        task.setProject(project);
        taskDao.save(task);

        return "redirect:/projectpage/" + project.getId();
    }

    @PostMapping("/createGroupProject/{groupId}")
    public String createGroupProject(Model model, @ModelAttribute Project newProject, @PathVariable int groupId) {
        Group group = groupDao.findFirstById(groupId);
        newProject.setGroup(group);
        projectDao.save(newProject);

        return "redirect:/grouppage/" + group.getId();


    }


    @PostMapping("/createGroup")
    public String createGroup(Model model, @ModelAttribute Group newGroup, Principal principal, @ModelAttribute Object usersList) {
        User user = userDao.findByEmail(principal.getName());
        newGroup.addUser(user);
        groupDao.save(newGroup);
        return "redirect:userpage/" + user.getId();
    }

    @PostMapping("/createTodo/{projectId}/{taskId}")
    public String createTodo(@ModelAttribute Todos todos, @PathVariable int projectId, @PathVariable int taskId) {
        Project project = projectDao.findFirstById(projectId);
        Task task = taskDao.findFirstById(taskId);
        todos.setTask(task);
        todosDao.save(todos);

        return "redirect:/projectpage/" + project.getId();

    }

    @PostMapping("/createComment/{projectId}/{taskId}")
    public String createComment(@ModelAttribute Comments comments, @PathVariable int projectId, @PathVariable int taskId, Principal principal) {
        Project project = projectDao.findFirstById(projectId);
        Task task = taskDao.findFirstById(taskId);
        User user = userDao.findByEmail(principal.getName());


        comments.setUser(user);
        comments.setTask(task);
        commentsDao.save(comments);

        return "redirect:/projectpage/" + project.getId();

    }

    @PostMapping("createComplete/{projectId}/{taskId}")
    public String createComplete(@ModelAttribute Task task, @PathVariable int projectId, @PathVariable int taskId) {
        Project project = projectDao.findFirstById(projectId);
        Task task1 = taskDao.findFirstById(taskId);
        task1.setComplete(1);

        return "redirect:/projectpage/" + project.getId();


    }
}
