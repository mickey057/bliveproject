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
import com.pay.test.dao.ProfileRepository;
import com.pay.test.dao.TeamRepository;
import com.pay.test.dao.EmployeeProfileRepository;
import com.pay.test.entity.Employee;
import com.pay.test.entity.Profile;
import com.pay.test.entity.Team;
import com.pay.test.entity.EmplProf;

@Controller
public class EmplProfController {
	
	@Autowired
	private EmployeeProfileRepository emplProfRepo;
	@Autowired
	private EmployeeRepository empRepo;
	@Autowired
	private TeamRepository teamRepo;
	@Autowired
	private ProfileRepository profRepo;

	@GetMapping("/listEmplProf")
	public String viewEmplProfPage(Model model) {
		List<EmplProf> listEmplProfs = emplProfRepo.findAll();
		model.addAttribute("listEmplProfs",listEmplProfs);
		List<Team> listTeams = teamRepo.findAll();
        model.addAttribute("listTeams", listTeams);
        List<Employee> listEmployees = empRepo.findAll();
        model.addAttribute("listEmployees", listEmployees);
        List<Profile> listProfiles = profRepo.findAll();
        model.addAttribute("listProfiles", listProfiles);
		return "listEmplProf";
	}
	
	@GetMapping("/emplProf/new")
    public String showNewEmplProfForm(Model model) {
        // create model attribute to bind form data
    	EmplProf emplProf= new EmplProf();
        model.addAttribute("emplProf", emplProf);
        List<Team> listTeams = teamRepo.findAll();
        model.addAttribute("listTeams", listTeams);
        List<Employee> listEmployees = empRepo.findAll();
        model.addAttribute("listEmployees", listEmployees);
        List<Profile> listProfiles = profRepo.findAll();
        model.addAttribute("listProfiles", listProfiles);
        return "NewEmplProf";
	}
	
	@PostMapping("/emplProf/save")
    public String saveEmplProf(@ModelAttribute("emplProf") EmplProf emplProf) {
        // save user to database
    	emplProfRepo.save(emplProf);
        return "redirect:/listEmplProf";
    }
	
	@GetMapping("/emplProf/update/{idemplProf}")
    public String showFormForUpdateEmplProf(@PathVariable(value = "idemplProf") long idemplProf, Model model) {

        // get EmplProf from the service
        EmplProf emplProf= emplProfRepo.findById(idemplProf).get();

        // set emplProf as a model attribute to pre-populate the form
        model.addAttribute("emplProf", emplProf);
        List<Team> listTeams = teamRepo.findAll();
        model.addAttribute("listTeams", listTeams);
        List<Employee> listEmployees = empRepo.findAll();
        model.addAttribute("listEmployees", listEmployees);
        List<Profile> listProfiles = profRepo.findAll();
        model.addAttribute("listProfiles", listProfiles);
        
        return "NewEmplProf";
	}
        @GetMapping("/emplProf/delete/{idemplProf}")
	    public String deleteEmplProf(@PathVariable(value = "idemplProf") Long idemplProf, Model model) {

	        // call delete EmplProf method 
	        emplProfRepo.deleteById(idemplProf);
	        return "redirect:/listEmplProf";
	    }
    }

