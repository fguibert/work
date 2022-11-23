package com.darva.api.mvs.controller;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.darva.api.mvs.dto.CustomerDto;
import com.darva.api.mvs.dto.RestJsonResponse;


/**
* Controller "ApiController" Spring REST 
* Service MOCK MVS pour le POC CRM DARVA SalesForce
*
* @author  Fabien GUIBERT
* @version 1.0
* @since   2022-11-24
**/

@RestController
public class ApiController {

	

		
	@PostMapping(value = "/customer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public ResponseEntity<?> postCustomer(@RequestHeader String apiKey, @RequestBody CustomerDto client) {

		// Controle API Key
		if (apiKey==null || !apiKey.equals("b64d5eb3-64d0-4758-91a7-a3a447bb265e"))
			return new ResponseEntity<>(new RestJsonResponse(false, "ERREUR - Opération impossible : ApiKey invalide dans le header de la requête", "E01"), HttpStatus.FORBIDDEN);

		// Controle données obligatoire
		if (client==null) 
			return new ResponseEntity<>(new RestJsonResponse(false, "ERREUR - Opération impossible : Objet client absent du corps de la requête", "E02"), HttpStatus.BAD_REQUEST);
		if (client.getRaisonSociale()==null || client.getRaisonSociale().equals("")) 
			return new ResponseEntity<>(new RestJsonResponse(false, "ERREUR - Opération impossible : Raison sociale absente ou invalide", "E03"), HttpStatus.BAD_REQUEST);
		if (client.getSiren()==null || client.getSiren().equals("")) 
			return new ResponseEntity<>(new RestJsonResponse(false, "ERREUR - Opération impossible : SIREN absent ou invalide", "E04"), HttpStatus.BAD_REQUEST);
				
		
		// Génération du code client aléatoire entre 10000 et 99999
		return new ResponseEntity<>(new RestJsonResponse(true,"OK - Client créé",ThreadLocalRandom.current().nextInt(10000, 99999 + 1)), HttpStatus.OK);

	}



	
	

}
