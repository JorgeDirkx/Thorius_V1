package com.jorgedirkx.controller;

import com.jorgedirkx.model.Project;
import com.jorgedirkx.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AppController {

    @Autowired
    private ProjectService service;


    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<Project> listProjects = service.listAll();
        model.addAttribute("listProjects", listProjects);

        return "index";
    }

    @RequestMapping("/new")
    public String showNewProjectPage(Model model) {
        Project project = new Project();
        model.addAttribute("project", project);

        return "new_project";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("project") Project project) {
        service.save(project);

        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit project");
        Project project = service.get(id);
        mav.addObject("project", project);

        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteProject(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/";
    }
}