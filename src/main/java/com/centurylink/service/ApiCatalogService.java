package com.centurylink.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.centurylink.entities.ApiDetails;
import com.centurylink.exception.CustomException;
import com.centurylink.repository.ApiCatalogRepository;


@Service
@Transactional
public class ApiCatalogService {
	
	@Autowired
	private ApiCatalogRepository apiCatalogRepository;

	public void deleteApiById(int id) {
		// TODO Auto-generated method stub
		apiCatalogRepository.deleteById(id);
		
	}

	public ApiDetails updateApiByApiId(ApiDetails apiDetails, int apiId) throws CustomException{
	
		Optional<ApiDetails> apidetail=apiCatalogRepository.findById(apiId);
		System.out.println("ApiCatalog by api id "+apidetail);
		ApiDetails updated=null;
		
		if(apidetail.isPresent()) {
			ApiDetails apiDetails2 = apidetail.get();
			System.out.println("api details2 "+apiDetails2);
			apiDetails2.setApiUrl(apiDetails.getApiUrl());
			apiDetails2.setApiDesc(apiDetails.getApiDesc());
		
			apiDetails2.setBusinessObject(apiDetails.getBusinessObject());
		System.out.println("apicatalog after update "+apiDetails);
		updated = apiCatalogRepository.save(apiDetails2);
		
		//return updated;
		}
		
		try {
			if(updated==null) {
				throw new CustomException("Api does not exists with id "+apiId);
			 
			}
		} catch (CustomException e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return updated;
	}
	

	public ApiDetails addApiCatalog(ApiDetails apiDetails) {
		// TODO Auto-generated method stub
		ApiDetails apiCatalog = apiCatalogRepository.save(apiDetails);
		return apiCatalog;
	}

}
