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
import com.pay.test.entity.Employee;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository empRep;

	@GetMapping("/listEmployee")
	public String viewEmployeePage(Model model) {
		List<Employee> listEmployees = empRep.findAll();
		model.addAttribute("listEmployees",listEmployees);
		return "listEmployee";
	}
	
	@GetMapping("/employee/new")
    public String showNewEmployeeForm(Model model) {
        // create model attribute to bind form data
    	Employee employee= new Employee();
        model.addAttribute("employee", employee);
        return "NewEmployee";
	}
	
	@PostMapping("/employee/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        // save user to database
    	empRep.save(employee);
        return "redirect:/listEmployee";
    }
	
	@GetMapping("/employee/update/{idemployee}")
    public String showFormForUpdateEmployee(@PathVariable(value = "idemployee") long idemployee, Model model) {

        // get Employee from the service
        Employee employee= empRep.findById(idemployee).get();

        // set employee as a model attribute to pre-populate the form
        model.addAttribute("employee", employee);
        
        return "NewEmployee";
	}
        @GetMapping("/employee/delete/{idemployee}")
	    public String deleteEmployee(@PathVariable(value = "idemployee") Long idemployee, Model model) {

	        // call delete Employee method 
	        empRep.deleteById(idemployee);
	        return "redirect:/listEmployee";
	    }
    }

