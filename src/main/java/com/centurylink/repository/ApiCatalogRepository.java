package com.centurylink.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.centurylink.entities.ApiDetails;

@Repository
public interface ApiCatalogRepository extends JpaRepository<ApiDetails, Integer>{
	
//	@Query("select a from api_details a where a.api_id=:apiId")
//	public ApiDetails findApiById(@Param("apiId")int apiId);

}
