package com.Briantpt30.TaskProject.Controllers;

import com.Briantpt30.TaskProject.Models.Comments;
import com.Briantpt30.TaskProject.Models.Project;
import com.Briantpt30.TaskProject.Models.Task;
import com.Briantpt30.TaskProject.Models.Todos;
import com.Briantpt30.TaskProject.Models.data.*;
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
    private UserDao userDao;

    @Autowired
    private ProjectDao projectDao;

    @Autowired
    private TaskDao taskDao;

    @Autowired
    private CommentsDao commentsDao;

    @Autowired
    private TodosDao todosDao;

    @RequestMapping(value = "/{projectId}", method = RequestMethod.GET)
    public String index(Model model, @PathVariable int projectId){
        Project project = projectDao.findFirstById(projectId);
        System.out.println(projectId);
        model.addAttribute(new Task());
        model.addAttribute(new Comments());
        model.addAttribute(new Todos());
        model.addAttribute("project", project);
        model.addAttribute("title", project.getName());
        model.addAttribute("tasks", project.getTasks());
        model.addAttribute("projectId", project.getId());

        return "projectPage";

    }

    /* Todo update Task model to have complete or not complete. Add the functionality to display complete or not complete
    on project page. Use different colors. If i have time try to assign a task to a user as well.
     */

}
