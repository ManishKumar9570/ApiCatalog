package com.centurylink.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "api_details")
public class ApiDetails {
	

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int apiId;

    private String apiUrl;

    private String apiDesc;
    
    private String businessObject;

	public ApiDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ApiDetails(int apiId, String apiUrl, String apiDesc, String businessObject) {
		super();
		this.apiId = apiId;
		this.apiUrl = apiUrl;
		this.apiDesc = apiDesc;
		this.businessObject = businessObject;
	}

	public int getApiId() {
		return apiId;
	}

	public void setApiId(int apiId) {
		this.apiId = apiId;
	}

	public String getApiUrl() {
		return apiUrl;
	}

	public void setApiUrl(String apiUrl) {
		this.apiUrl = apiUrl;
	}

	public String getApiDesc() {
		return apiDesc;
	}

	public void setApiDesc(String apiDesc) {
		this.apiDesc = apiDesc;
	}

	public String getBusinessObject() {
		return businessObject;
	}

	public void setBusinessObject(String businessObject) {
		this.businessObject = businessObject;
	}

	@Override
	public String toString() {
		return "ApiDetails [apiId=" + apiId + ", apiUrl=" + apiUrl + ", apiDesc=" + apiDesc + ", businessObject="
				+ businessObject + "]";
	}
   
	
    

    

}
