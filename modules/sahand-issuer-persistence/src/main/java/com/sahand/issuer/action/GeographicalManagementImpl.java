package com.sahand.issuer.action;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.sahand.acquirer.action.AcquirerRepository;
import com.sahand.acquirer.action.GeographicalManagement;
import com.sahand.acquirer.data.CityDto;
import com.sahand.acquirer.model.Geographical;


@Stateless
public class GeographicalManagementImpl implements GeographicalManagement {

	
	@Inject
	@AcquirerRepository
	EntityManager entityManager;
	
	public Geographical find(String geoId) throws Exception {
		Geographical geographical = null;
		try {

			geographical = /*pm.getEntityManager()*/entityManager.find(Geographical.class, geoId);


		} catch (Exception e) {
			e.printStackTrace();

		}
		return geographical;
	}

	public CityDto convertFrom(Geographical city) {
		CityDto cityDto = new CityDto();
		if(city != null){
			if(city.getCode() != null)
				cityDto.setCode(String.valueOf(city.getCode()));
			cityDto.setName(city.getName());
			if(city.getType() != null)
				cityDto.setType(String.valueOf(city.getType()));
		}
//		cityDto.setParent(parent);
		
		return cityDto;
	}

}
