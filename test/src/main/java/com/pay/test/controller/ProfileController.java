package com.pay.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.pay.test.dao.ProfileRepository;
import com.pay.test.entity.Profile;

@Controller
public class ProfileController {
	
	@Autowired
	private ProfileRepository proRepo;

	@GetMapping("/listProfile")
	public String viewProfilePage(Model model) {
		List<Profile> listProfiles = proRepo.findAll();
		model.addAttribute("listProfiles",listProfiles);
		return "listProfile";
	}
	
	@GetMapping("/profile/new")
    public String showNewProfileForm(Model model) {
        // create model attribute to bind form data
    	Profile profile= new Profile();
        model.addAttribute("profile", profile);
        return "NewProfile";
	}
	
	@PostMapping("/profile/save")
    public String saveProfile(@ModelAttribute("profile") Profile profile) {
        // save user to database
    	proRepo.save(profile);
        return "redirect:/listProfile";
    }
	
	@GetMapping("/profile/update/{idprofile}")
    public String showFormForUpdateProfile(@PathVariable(value = "idprofile") long idprofile, Model model) {

        // get Profile from the service
        Profile profile= proRepo.findById(idprofile).get();

        // set profile as a model attribute to pre-populate the form
        model.addAttribute("profile", profile);
        
        return "NewProfile";
	}
        @GetMapping("/profile/delete/{idprofile}")
	    public String deleteProfile(@PathVariable(value = "idprofile") Long idprofile, Model model) {

	        // call delete Profile method 
	        proRepo.deleteById(idprofile);
	        return "redirect:/listProfile";
	    }
    }
