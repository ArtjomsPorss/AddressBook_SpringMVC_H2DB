package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.AddressBookEntry;

@Controller	
public class ApplicationController extends BaseController{
	
	@RequestMapping( value="/home", method=RequestMethod.GET )
	public String home(Model model){
		
		return "home";
	}
	
	
	@RequestMapping( value="/getEntryPage", method=RequestMethod.GET )
	public String getEntryPage(Model model){

		AddressBookEntry addressBookEntry = new AddressBookEntry();
		
		model.addAttribute("addressBookEntry", addressBookEntry);
		
		return "searchForEntryPage";
	}

	
	@RequestMapping( value="/getEntryPage", method=RequestMethod.POST )
	public String getEntry(@ModelAttribute AddressBookEntry addressBookEntry, RedirectAttributes redirect){
		
		List<AddressBookEntry> entries = applicationService.searchForEntry(addressBookEntry);
		
		redirect.addFlashAttribute("entryList", entries);
		redirect.addFlashAttribute("searchForSpecificEntry", "Y");
		
		return "redirect:/allEntriesPage.html";
	}
	
	
	@RequestMapping( value="/allEntriesPage", method=RequestMethod.GET )
	public String getAllEntriesPage(Model model,	
			@ModelAttribute("entryList") ArrayList<AddressBookEntry> entries,
			@ModelAttribute("searchForSpecificEntry") String searchForSpecificEntry){
		
		if(searchForSpecificEntry.equals("Y")){
			model.addAttribute("entryList", entries);
		} else {
			model.addAttribute("entryList", applicationService.getAllEntries());
		}
		model.addAttribute("addressBookEntry", new AddressBookEntry());
		
		return "allEntriesPage";
	}
	
	
	@RequestMapping( value="/addEntryPage", method=RequestMethod.GET )
	public String addEntryPage(Model model){
		
		model.addAttribute("addressBookEntry", new AddressBookEntry());
		
		return "addEntryPage";
	}
	
	
	@RequestMapping( value="/addEntry", method=RequestMethod.POST )
	public String addEntry(@ModelAttribute("addressBookEntry") AddressBookEntry entry){
		
		applicationService.addEntry(entry);
		
		return "redirect:/allEntriesPage.html";
	}
	
	
	@RequestMapping( value="/deleteEntry", method=RequestMethod.POST )
	public String deleteEntry(@ModelAttribute("addressBookEntry") AddressBookEntry entry){
		
		applicationService.deleteEntry(entry.getId());
		
		return "redirect:/allEntriesPage.html";
	}
	
	
	@RequestMapping( value="/editEntryPage", method=RequestMethod.GET )
	public String editEntry(Model model, @RequestParam int id){
		
		model.addAttribute("addressBookEntry", applicationService.getEntryById(id));
		
		return "editEntryPage";
	}
	
	
	@RequestMapping( value="/updateEntry", method=RequestMethod.POST )
	public String updateEntry(@ModelAttribute("addressBookEntry") AddressBookEntry entry){
		
		applicationService.updateEntry(entry);
		
		return "redirect:/allEntriesPage.html";
	}
	
	
}

