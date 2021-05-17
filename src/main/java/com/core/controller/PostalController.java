package com.core.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.core.entity.Postal;
import com.core.model.MPostal;
import com.core.service.PostalService;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * 
 * @author Basso
 * Clase controlador que gestiona las peticiones del cliente.
 */
@RestController
@RequestMapping("/zip-codes/")
@CrossOrigin(origins = "*")
public class PostalController {

	@Autowired
	PostalService postalService;
	
	/**
	 * 
	 * @param code (int) codigo postal que se esta consultando
	 * @return Si el resultado es correcto retorna JSON tipo MPostal con los datos si no retorna JSON Vacio
	 * @return
	 */
	@GetMapping("/{code}")
	public MPostal getByZipCode(@PathVariable("code") int code ){
		MPostal mPostal = postalService.findByZipCode(code);
		if(mPostal == null)
			throw new NullPointerException();
		else
			return mPostal;
	}
	
	@ExceptionHandler(Exception.class)
	 public ResponseEntity handle(Exception ex, 
	                HttpServletRequest request, HttpServletResponse response) {
			HttpHeaders headers = new HttpHeaders();
	        headers.add("Content-Type", "application/json");
		
	        if (ex instanceof NullPointerException) {
	            return new ResponseEntity<>(new EmptyJsonResponse(),HttpStatus.OK);
	            
	        }
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    }
	
	@JsonSerialize
	public class EmptyJsonResponse { }
}
