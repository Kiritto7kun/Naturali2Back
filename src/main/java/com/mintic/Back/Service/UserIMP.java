package com.mintic.Back.Service;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.mintic.Back.Model.LoginDTO;
import com.mintic.Back.Model.User;
import com.mintic.Back.Repository.IUser;

/*
 * Implementamos la interface con sus metodos
 * @Service  indica la logina empresarial toda la logica de negocio */
@Service 
public class UserIMP  implements IUserService{
	
	/*
	 * @Autowired inyeccion de dependencia  en este caso para acceder a los metodos del repositorio IUsuario
	 *  (accedemos al login)
	 * */
	
	@Autowired
	IUser iUsuario;
	/*
	 * Motodo para validar si existe el usuario
	 */
	@Override
	public int login(LoginDTO userDTO) {
		int u = iUsuario.findByNombreUsuarioAndPassword(userDTO.getUsu(),userDTO.getPasw());
		return u;
	}
	@Override
	public ResponseEntity<?> ingresar(LoginDTO userDTO) {
		Map<String, Object> response = new HashMap<>();
		User usuario = null;	
		try {
			usuario = iUsuario.findByNameAndPassword(userDTO.getUsu(), userDTO.getPasw());
			 if (usuario ==null) {
				 response.put("usuarios", null);
				 response.put("Mensaje", "Alerta:Usuario o Password incorrectos");
				 response.put("statusCode", HttpStatus.NOT_FOUND.value());
				 return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		 	
			 }else {
				 response.put("usuarios", usuario);
				 response.put("Mensaje", "Datos correctos");
				 response.put("statusCode", HttpStatus.OK.value());
				 return new ResponseEntity<>(response, HttpStatus.OK);
			 }
		} catch (Exception e) {
			 response.put("usuarios", null);
			 response.put("Mensaje", "Ha ocurrido un error");
			 response.put("statusCode", HttpStatus.INTERNAL_SERVER_ERROR.value());
			 return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
