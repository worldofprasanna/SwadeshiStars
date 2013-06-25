package org.swadeshi.controllers;

import java.beans.PropertyEditorSupport;
import java.security.Principal;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.swadeshi.entities.Account;
import org.swadeshi.entities.Appreciation;
import org.swadeshi.entities.User;
import org.swadeshi.entities.UserConnection;
import org.swadeshi.exceptions.CustomException;
import org.swadeshi.services.AccountService;
import org.swadeshi.services.AppreciationService;
import org.swadeshi.services.UserService;


@Controller
public class AdminController {

	@Autowired
	private AppreciationService appreciationService;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@RequestMapping("/admin")
	public ModelAndView home(){
		ModelAndView modelAndView = new ModelAndView("admin");
		try {
			List<Appreciation>appreciations = appreciationService.fetchAllAppreciations();
			List<Account> accounts = accountService.fetchAllAccounts();
			List<User> users = userService.fetchAllUsers();
			
			modelAndView.addObject("appreciations", appreciations);
			modelAndView.addObject("account", accounts);
			modelAndView.addObject("users", users);
			
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
			appreciationService.saveAppreciation(appreciation);
			List<Appreciation>appreciations = appreciationService.fetchAllAppreciations();
			modelAndView.addObject("appreciations", appreciations);
			modelAndView.addObject("message", "Appreciation added successfully !");
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return modelAndView;
	}
	
	@RequestMapping("/createaccount")
	public ModelAndView saveAccount(@RequestParam List<String> userName, @RequestParam List<Double> amount){
		ModelAndView modelAndView = new ModelAndView("admin");
		try {
			//accountService.saveAccount(account);
			List<Account>accounts = accountService.contributedAccounts(userName, amount);
			List<User> users = userService.fetchAllUsers();
			List<Appreciation>appreciations = appreciationService.fetchAllAppreciations();
			modelAndView.addObject("appreciations", appreciations);
			modelAndView.addObject("accounts", accounts);
			modelAndView.addObject("users", users);
			
			modelAndView.addObject("message", "Accounts added successfully !");
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
	
	@RequestMapping ("/sendmail")
	public ModelAndView sendMail(@RequestParam String bodyContent, @RequestParam String subject){
		
		ModelAndView modelAndView = new ModelAndView("admin");
		
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setSubject(subject);
		mailMessage.setFrom("ssenthilkumar.cs@gmail.com");
		List<User> users = userService.fetchAllUsers();
		String toMailId = "";
		for(User user:users) {
			toMailId +=user.getEmailId();
			toMailId += ",";
		}
		//Add group Mail id
		toMailId += "prasanna.v@imaginea.com";
		
		mailMessage.setTo(toMailId);
		
		mailMessage.setText(bodyContent);
		mailSender.send(mailMessage);
		
		modelAndView.addObject("message", "Mail Sent successfully !");
		
		return modelAndView;
	}
	
	@RequestMapping("/signin")
	public ModelAndView home(Principal currentUser, Model model, HttpServletRequest request) {		
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.getModel().put("error", "Please Login to view the Page.");
		return modelAndView;
	}
}
