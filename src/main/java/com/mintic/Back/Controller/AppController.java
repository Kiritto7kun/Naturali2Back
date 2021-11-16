package com.mintic.Back.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.mintic.Back.Model.LoginDTO;
import com.mintic.Back.Repository.ITypeDocument;
import com.mintic.Back.Repository.IUser;
import com.mintic.Back.Service.IUserService;

@RestController
public class AppController {
	
	@Autowired
	IUserService Iusuario;
	
	@Autowired
	ITypeDocument ITdocument;
	
	@CrossOrigin(origins = {"http://localhost:8006"})
	@PostMapping("/loginclient")
	public int login(@RequestBody LoginDTO user) {
		int responseLogin = Iusuario.login(user);
		return responseLogin;
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> loginclient(@RequestBody LoginDTO user){
		return Iusuario.ingresar(user);
	}
}
