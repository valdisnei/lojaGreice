package com.lojaGreice.spring.controller;

import static com.google.common.base.Preconditions.checkNotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lojaGreice.spring.dao.UserDAO;
import com.lojaGreice.spring.model.User;

@RestController
public class LojaGreiceController {	
	
	
	@Autowired
	UserDAO userDAO;
	
	
//	@Autowired
//	UsuarioRepository usuarioRepository;
//	
//	
//	@RequestMapping(value="/customer" , method = RequestMethod.POST)
//	public Customer customer(@RequestParam(value="nome",defaultValue="Valdis") String nome, @RequestParam(value="lastName",defaultValue="Fajardo Grilo") String lastName) {
//		
//		return new Customer(nome,lastName);
//		
//	}
//	
//	
//	
//	@RequestMapping(value="/usuario" , method = RequestMethod.POST)
//	public Usuario usuario(@RequestParam(value="usuario",defaultValue="Valdis") String usuario, @RequestParam(value="senha",defaultValue="123123") String senha) {	
//		
//		return new Usuario(usuario,senha);
//		
//	}
//	
//	
//	
//	@RequestMapping(value="/login" , method = RequestMethod.PATCH)
//	public Usuario login(@RequestBody Login userLogin) {	
//		
//		Usuario usuario = usuarioRepository.findByLogin(userLogin);
//		
//		checkNotNull(usuario,
//				"Usuario não encontrado");		
//		
//		return usuario;
//		
//	}
//	
//	
	@RequestMapping(value="/addUsuario" , method = RequestMethod.POST,headers="Accept=application/json")
	public User usuario(@RequestBody User usuario) {
		
		validar(usuario);		
		
		userDAO.save(usuario);
		
		return usuario;		
	}
	
	
	@RequestMapping(value="/nomeServico" , method = RequestMethod.GET)
	public String nomeServico() {
		return "valdisnei";
	}
//
//
//
	private void validar(User usuario) {
		checkNotNull(usuario,
				"Eh preciso informar o usuario");
		
		checkNotNull(usuario.getUsername(),
				"Eh preciso informar o login");
		
		checkNotNull(usuario.getEmail(),
				"Eh preciso informar o Email");
		
		checkNotNull(usuario.getPassword(),
				"Eh preciso informar a senha");		
	}
	
	

}
