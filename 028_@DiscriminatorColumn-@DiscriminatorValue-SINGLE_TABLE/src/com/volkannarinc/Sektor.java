package com.volkannarinc;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "SEKTOR")
public class Sektor extends Meslek {

	private String calismaAlani;
	
	public String getCalismaAlani() {
		return calismaAlani;
	}



	public void setCalismaAlani(String calismaAlani) {
		this.calismaAlani = calismaAlani;
	}
	
}
