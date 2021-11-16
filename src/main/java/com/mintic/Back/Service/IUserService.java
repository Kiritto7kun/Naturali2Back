package com.mintic.Back.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.mintic.Back.Model.LoginDTO;

@Service
public interface IUserService {
	
	int login(LoginDTO userDTO);
	ResponseEntity<?> ingresar(LoginDTO userDTO);
	
}
