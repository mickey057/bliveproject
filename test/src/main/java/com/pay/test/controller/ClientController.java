package com.pay.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.pay.test.dao.ClientRepository;
import com.pay.test.entity.Client;

@Controller
public class ClientController {
	
	@Autowired
	private ClientRepository clientRepo;

	@GetMapping("/listClient")
	public String viewClientPage(Model model) {
		List<Client> listClients = clientRepo.findAll();
		model.addAttribute("listClients",listClients);
		return "listClient";
	}
	
	@GetMapping("/client/new")
    public String showNewClientForm(Model model) {
        // create model attribute to bind form data
    	Client client= new Client();
        model.addAttribute("client", client);
        return "NewClient";
	}
	
	@PostMapping("/client/save")
    public String saveClient(@ModelAttribute("client") Client client) {
        // save user to database
    	clientRepo.save(client);
        return "redirect:/listClient";
    }
	
	@GetMapping("/client/update/{idclient}")
    public String showFormForUpdateClient(@PathVariable(value = "idclient") long idclient, Model model) {

        // get Client from the service
        Client client= clientRepo.findById(idclient).get();

        // set client as a model attribute to pre-populate the form
        model.addAttribute("client", client);
        
        return "NewClient";
	}
        @GetMapping("/client/delete/{idclient}")
	    public String deleteClient(@PathVariable(value = "idclient") Long idclient, Model model) {

	        // call delete Client method 
	        clientRepo.deleteById(idclient);
	        return "redirect:/listClient";
	    }
    }
