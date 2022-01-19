package com.pay.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.pay.test.dao.HolidayRepository;
import com.pay.test.entity.Holiday;

@Controller
public class HolidayController {
	
	@Autowired
	private HolidayRepository holRepo;

	@GetMapping("/listHoliday")
	public String viewHolidayPage(Model model) {
		List<Holiday> listHolidays = holRepo.findAll();
		model.addAttribute("listHolidays",listHolidays);
		return "listHoliday";
	}
	
	@GetMapping("/holiday/new")
    public String showNewHolidayForm(Model model) {
        // create model attribute to bind form data
    	Holiday holiday= new Holiday();
        model.addAttribute("holiday", holiday);
        return "NewHoliday";
	}
	
	@PostMapping("/holiday/save")
    public String saveHoliday(@ModelAttribute("holiday") Holiday holiday) {
        // save user to database
    	holRepo.save(holiday);
        return "redirect:/listHoliday";
    }
	
	@GetMapping("/holiday/update/{idholiday}")
    public String showFormForUpdateHoliday(@PathVariable(value = "idholiday") long idholiday, Model model) {

        // get Holiday from the service
        Holiday holiday= holRepo.findById(idholiday).get();

        // set holiday as a model attribute to pre-populate the form
        model.addAttribute("holiday", holiday);
        
        return "NewHoliday";
	}
        @GetMapping("/holiday/delete/{idholiday}")
	    public String deleteHoliday(@PathVariable(value = "idholiday") Long idholiday, Model model) {

	        // call delete Holiday method 
	        holRepo.deleteById(idholiday);
	        return "redirect:/listHoliday";
	    }
    }
