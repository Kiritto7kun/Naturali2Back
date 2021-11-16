package com.mintic.Back.Repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.mintic.Back.Model.User;

/*
 * Aqui se realizan las opereciones crud   
 * los parametros son la entidad y el tipo de datos que se definio como @id en la entidad  
 * el id es long debe ir igual en el crud repository <Usuario, Long>
 */

public interface IUser extends CrudRepository<User, Long> {

		// JPQL: Se hace la consulta sobre la clase 
		@Query("select count(*) from User as p where p.usuario= :usuario and p.pasword= :pasword")
		Integer findByNombreUsuarioAndPassword(@Param("usuario") String usuario,
				@Param("pasword") String pasword);

		
		@Query("select p from User as p where p.usuario= :usuario and p.pasword=:pasword")
		User findByNameAndPassword(@Param("usuario") String usuario,
				@Param("pasword") String pasword);
		
		//admin123456 //admin

}
