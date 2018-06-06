package org.myazure.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "order")
public class Order {
	
	
	
	
	@Id
	@GeneratedValue
	@Column(name = "id", nullable = false, length = 11)
	private Long id;

 
	@OneToOne(targetEntity = Factory.class, fetch = FetchType.EAGER)
	@Column(name = "factory_id")
    @JoinColumn(name = "id")
	Factory factory;
	
	
	
	public Order(){
		
	}
}
