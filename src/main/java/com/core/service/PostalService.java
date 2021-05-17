package com.core.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.core.entity.Postal;
import com.core.model.MPostal;
import com.core.model.MSettlement;
import com.core.repository.PostalReposotory;

/** 
 * Servicio donde se obtiene datos de la BD y se procesan para retornar al controlador PostalController.
 * @author Jose Roberto Basso Narvaez
 * @version 16.05.2021
 * */

@Service("postalService")
public class PostalService {

	@Autowired
	PostalReposotory postalRepository;
	
	public List<Postal> findAll(){
		return postalRepository.findAll();
	}
	
	public MPostal findByZipCode(int code){
		List<Postal> _postales =  postalRepository.findByZipCode(code);
		MPostal _mPostal = new MPostal();
		Map<Object, List<Postal>> _resultadoAgrupado =_postales.stream().collect(Collectors.groupingBy((postal) -> Arrays.asList(postal.getEstado(),postal.getZipCode(),postal.getMunicipio(),postal.getCiudad()) ));
		for(Entry<Object, List<Postal>> entry : _resultadoAgrupado.entrySet()) {	
			for(Postal _postal : entry.getValue() ) {				
				_mPostal.setFederal_entity(_postal.getEstado());
				_mPostal.setLocality(_postal.getCiudad());
				_mPostal.setMinicipality(_postal.getMunicipio());
				_mPostal.setZip_code(_postal.getZipCode());
				_mPostal.getSettlements().add(new MSettlement(_postal.getAsentamiento(),_postal.getZona(),_postal.getTipoAsentamiento()));
				
			}
		}
		if(_postales.size() == 0)
			_mPostal = null;
		return _mPostal;
	}
}
