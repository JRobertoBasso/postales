package com.core.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.core.entity.Postal;

public class MPostal {

	private int zip_code;
	private String locality;
	private String federal_entity;
	private List<MSettlement> settlements;
	private String minicipality;
	
	
	public int getZip_code() {
		return zip_code;
	}
	public void setZip_code(int zip_code) {
		this.zip_code = zip_code;
	}
	public String getLocality() {
		return locality;
	}
	public void setLocality(String locality) {
		this.locality = locality;
	}
	public String getFederal_entity() {
		return federal_entity;
	}
	public void setFederal_entity(String federal_entity) {
		this.federal_entity = federal_entity;
	}
	public List<MSettlement> getSettlements() {
		return settlements;
	}
	public void setSettlements(List<MSettlement> settlements) {
		this.settlements = settlements;
	}
	public String getMinicipality() {
		return minicipality;
	}
	public void setMinicipality(String minicipality) {
		this.minicipality = minicipality;
	}
	
	public MPostal() {
		this.setSettlements(new ArrayList<MSettlement>());
	}
	
	public MPostal(Postal postal) {
		
		this.zip_code = postal.getZipCode();
		this.locality = postal.getMunicipio();
		this.federal_entity = postal.getEstado();
		this.minicipality = postal.getMunicipio();
		
	}

	public MPostal(int zip_code, String locality, String federal_entity, List<MSettlement> settlements, String minicipality) {
		this.zip_code = zip_code;
		this.locality = locality;
		this.federal_entity = federal_entity;
		this.settlements = settlements;
		this.minicipality = minicipality;
	}
	
	
	
	
}



