package org.myazure.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Factory {

	@Id
	@GeneratedValue
	@Column(name = "id", nullable = false, length = 11)
	private Long id;
	
	
	
	
	
	public Factory(){
		
	}
}
