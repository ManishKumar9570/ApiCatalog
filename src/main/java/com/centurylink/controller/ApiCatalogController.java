package com.centurylink.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.centurylink.entities.ApiDetails;
import com.centurylink.service.ApiCatalogService;



@RestController
public class ApiCatalogController {
	
	@Autowired
	private ApiCatalogService apiCatalogService;
		
	//add api catalog
	@PostMapping("/apicatalog")
	public ResponseEntity<ApiDetails> addApiCatalog(@RequestBody ApiDetails apiDetails){
		try {
			ApiDetails addApiDetails=apiCatalogService.addApiCatalog(apiDetails);
			return ResponseEntity.status(HttpStatus.CREATED).body(addApiDetails);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	
	
	
	
	// update api catalog
	
	@PutMapping("/apicatalog/{apiId}")
	public ResponseEntity<ApiDetails> updateApiCatalog(@RequestBody ApiDetails apiDetails,@PathVariable("apiId") int apiId){
		try {
			ApiDetails updateApiByApiId=apiCatalogService.updateApiByApiId(apiDetails,apiId);
			return ResponseEntity.ok().body(updateApiByApiId);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.notFound().build();
		}
	}
	
	
	
	// delete API by apiId;
	
	@DeleteMapping("/apicatalog/{apiId}")
	public ResponseEntity<Void> deleteAPi(@PathVariable("apiId") int apiId){
		try {
			apiCatalogService.deleteApiById(apiId);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
