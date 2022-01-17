package com.pay.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.pay.test.dao.ProjectRepository;
import com.pay.test.entity.Project;

@Controller
public class ProjectController {
	
	@Autowired
	private ProjectRepository projRep;

	@GetMapping("/listProject")
	public String viewProjectPage(Model model) {
		List<Project> listProjects = projRep.findAll();
		model.addAttribute("listProjects",listProjects);
		return "listProject";
	}
	
	@GetMapping("/project/new")
    public String showNewProjectForm(Model model) {
        // create model attribute to bind form data
    	Project project= new Project();
        model.addAttribute("project", project);
        return "NewProject";
	}
	
	@PostMapping("/project/save")
    public String saveProject(@ModelAttribute("project") Project project) {
        // save user to database
    	projRep.save(project);
        return "redirect:/listProject";
    }
	
	@GetMapping("/project/update/{idproject}")
    public String showFormForUpdateProject(@PathVariable(value = "idproject") long idproject, Model model) {

        // get Project from the service
        Project project= projRep.findById(idproject).get();

        // set project as a model attribute to pre-populate the form
        model.addAttribute("project", project);
        
        return "NewProject";
	}
        @GetMapping("/project/delete/{idproject}")
	    public String deleteProject(@PathVariable(value = "idproject") Long idproject, Model model) {

	        // call delete Project method 
	        projRep.deleteById(idproject);
	        return "redirect:/listProject";
	    }
    }
