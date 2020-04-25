package com.johndoe.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * 
 * @author John Doe
 *
 */

@RestController(value = "/api")
public class MockController {
	@GetMapping(value = "/success")
	public ResponseEntity<?> getSuccess(UriComponentsBuilder ucBuilder){
		HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api").buildAndExpand("/success").toUri());
        return new ResponseEntity<String>(headers, HttpStatus.OK);
	}
}//end of the class
