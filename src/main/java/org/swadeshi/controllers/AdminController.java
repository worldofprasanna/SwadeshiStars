package org.swadeshi.controllers;

import java.beans.PropertyEditorSupport;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.swadeshi.entities.Appreciation;
import org.swadeshi.exceptions.CustomException;
import org.swadeshi.services.AppreciationService;

@Controller
public class AdminController {

	@Autowired
	private AppreciationService appreciationService;
	
	@RequestMapping("/admin")
	public ModelAndView home(){
		ModelAndView modelAndView = new ModelAndView("admin");
		try {
			List<Appreciation>appreciations = appreciationService.fetchAllAppreciations();
			modelAndView.addObject("appreciations", appreciations);
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return modelAndView;
	}
	
	@RequestMapping("/createappreciation")
	public ModelAndView saveAppreciation(@ModelAttribute Appreciation appreciation){
		ModelAndView modelAndView = new ModelAndView("admin");
		try {
			appreciationService.saveAppreciationService(appreciation);
			List<Appreciation>appreciations = appreciationService.fetchAllAppreciations();
			modelAndView.addObject("appreciations", appreciations);
			modelAndView.addObject("message", "Appreciation added successfully !");
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return modelAndView;
	}
	
	// Conversion for String to Date
	
	@InitBinder
	public void dateBinder(WebDataBinder binder){
		
		binder.registerCustomEditor(Date.class, new PropertyEditorSupport(){
			public void setAsText(String value) {
		        try {
		            setValue(new SimpleDateFormat("dd/MM/yyyy").parse(value));
		        } catch(ParseException e) {
		            setValue(null);
		        }
		    }

		    public String getAsText() {
		        return new SimpleDateFormat("dd/MM/yyyy").format((Date) getValue());
		    } 
		});
	}
	
}
