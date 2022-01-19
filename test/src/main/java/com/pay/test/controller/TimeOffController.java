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
import com.pay.test.dao.TeamRepository;
import com.pay.test.dao.TimeOffRepository;
import com.pay.test.entity.Employee;
import com.pay.test.entity.Team;
import com.pay.test.entity.TimeOff;

@Controller
public class TimeOffController {
	
	@Autowired
	private TimeOffRepository timeRepo;
	@Autowired
	private EmployeeRepository empRepo;
	@Autowired
	private TeamRepository timeOffRepo;

	@GetMapping("/listTimeOff")
	public String viewTimeOffPage(Model model) {
		List<TimeOff> listTimeOffs = timeRepo.findAll();
		model.addAttribute("listTimeOffs",listTimeOffs);
		List<Team> listTeams = timeOffRepo.findAll();
        model.addAttribute("listTeams", listTeams);
        List<Employee> listEmployees = empRepo.findAll();
        model.addAttribute("listEmployees", listEmployees);
		return "listTimeOff";
	}
	
	@GetMapping("/timeOff/new")
    public String showNewTimeOffForm(Model model) {
        // create model attribute to bind form data
    	TimeOff timeOff= new TimeOff();
        model.addAttribute("timeOff", timeOff);
        List<Team> listTeams = timeOffRepo.findAll();
        model.addAttribute("listTeams", listTeams);
        List<Employee> listEmployees = empRepo.findAll();
        model.addAttribute("listEmployees", listEmployees);
        return "NewTimeOff";
	}
	
	@PostMapping("/timeOff/save")
    public String saveTimeOff(@ModelAttribute("timeOff") TimeOff timeOff) {
        // save user to database
    	timeRepo.save(timeOff);
        return "redirect:/listTimeOff";
    }
	
	@GetMapping("/timeOff/update/{idtimeOff}")
    public String showFormForUpdateTimeOff(@PathVariable(value = "idtimeOff") long idtimeOff, Model model) {

        // get TimeOff from the service
        TimeOff timeOff= timeRepo.findById(idtimeOff).get();

        // set timeOff as a model attribute to pre-populate the form
        model.addAttribute("timeOff", timeOff);
        List<Team> listTeams = timeOffRepo.findAll();
        model.addAttribute("listTeams", listTeams);
        List<Employee> listEmployees = empRepo.findAll();
        model.addAttribute("listEmployees", listEmployees);
        
        return "NewTimeOff";
	}
        @GetMapping("/timeOff/delete/{idtimeOff}")
	    public String deleteTimeOff(@PathVariable(value = "idtimeOff") Long idtimeOff, Model model) {

	        // call delete TimeOff method 
	        timeRepo.deleteById(idtimeOff);
	        return "redirect:/listTimeOff";
	    }
    }

