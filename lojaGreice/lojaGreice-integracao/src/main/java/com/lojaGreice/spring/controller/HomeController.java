package com.lojaGreice.spring.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lojaGreice.spring.dao.UserDAO;
import com.lojaGreice.spring.migration.MigrationService;
import com.lojaGreice.spring.model.User;

@Controller
public class HomeController {

	@Autowired
	private UserDAO userDao;
	
	@Autowired
	private MigrationService migration;
	
	@RequestMapping(value="/")
	public ModelAndView home() throws IOException{
		List<User> listUsers = userDao.list();
		ModelAndView model = new ModelAndView("home");
		model.addObject("userList", listUsers);
		return model;
	}
	
	@PostConstruct
	public void inicializa() {
		System.out.println("inicializando");
		
		migration.migrate();

	}
}
