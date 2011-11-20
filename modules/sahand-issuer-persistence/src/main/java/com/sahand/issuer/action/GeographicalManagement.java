package com.sahand.issuer.action;

import com.sahand.acquirer.data.CityDto;
import com.sahand.acquirer.model.Geographical;

public interface GeographicalManagement {


	public Geographical find(String geoId) throws Exception;

	public CityDto convertFrom(Geographical instituteCity);

}
