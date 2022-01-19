package com.pay.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.pay.test.dao.EmployeeRepository;
import com.pay.test.dao.ProjectRepository;
import com.pay.test.dao.TeamRepository;
import com.pay.test.entity.Employee;
import com.pay.test.entity.Project;
import com.pay.test.entity.Team;

@Controller
public class TeamController {
	
	@Autowired
	private TeamRepository teamRepo;
	@Autowired
	private EmployeeRepository empRepo;
	@Autowired
	private ProjectRepository projRepo;

	@GetMapping("/listTeam")
	public String viewTeamPage(Model model) {
		List<Team> listTeams = teamRepo.findAll();
		model.addAttribute("listTeams",listTeams);
		List<Project> listProjects = projRepo.findAll();
        model.addAttribute("listProjects", listProjects);
		return "listTeam";
	}
	
	@GetMapping("/team/new")
    public String showNewTeamForm(Model model) {
        // create model attribute to bind form data
    	Team team= new Team();
        model.addAttribute("team", team);
        List<Project> listProjects = projRepo.findAll();
        model.addAttribute("listProjects", listProjects);
        return "NewTeam";
	}
	
	@PostMapping("/team/save")
    public String saveTeam(@ModelAttribute("team") Team team) {
        // save user to database
    	teamRepo.save(team);
        return "redirect:/listTeam";
    }
	
	@GetMapping("/team/update/{idteam}")
    public String showFormForUpdateTeam(@PathVariable(value = "idteam") long idteam, Model model) {

        // get Team from the service
        Team team= teamRepo.findById(idteam).get();

        // set team as a model attribute to pre-populate the form
        model.addAttribute("team", team);
        List<Project> listProjects = projRepo.findAll();
        model.addAttribute("listProjects", listProjects);
        
        return "NewTeam";
	}
        @GetMapping("/team/delete/{idteam}")
	    public String deleteTeam(@PathVariable(value = "idteam") Long idteam, Model model) {

	        // call delete Team method 
	        teamRepo.deleteById(idteam);
	        return "redirect:/listTeam";
	    }
    }

