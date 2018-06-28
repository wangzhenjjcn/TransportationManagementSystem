package org.myazure.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "factory")
public class Factory {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "factory_id", nullable = false, length = 11)
	private Long id;
	
	
	
	
	
	public Factory(){
		
	}





	public Long getId() {
		return id;
	}





	public void setId(Long id) {
		this.id = id;
	}
}