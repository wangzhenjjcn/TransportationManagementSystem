package org.myazure.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "customer_id", nullable = false, length = 11)
	private Long customerId;
	
	
	
	public Customer(){
		
	}



	public Long getCustomerId() {
		return customerId;
	}



	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}


}
