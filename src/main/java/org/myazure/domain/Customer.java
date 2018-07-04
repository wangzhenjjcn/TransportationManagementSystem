package org.myazure.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.myazure.utils.S;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "customer")
public class Customer extends BaseEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "customer_id", nullable = false, length = 11)
	private Long customerId;
	@JsonProperty("name")
	@JSONField(name = "name")
	@Column(name = "name", columnDefinition = "varchar(255) DEFAULT NULL")
	private String name;
	@JsonProperty("namepy")
	@JSONField(name = "namepy")
	@Column(name = "namepy", columnDefinition = "varchar(255) DEFAULT NULL")
	private String namepy;
	@JsonProperty("address")
	@JSONField(name = "address")
	@Column(name = "address", columnDefinition = "varchar(255) DEFAULT NULL")
	private String address;
	@JsonProperty("addresspy")
	@JSONField(name = "addresspy")
	@Column(name = "addresspy", columnDefinition = "varchar(255) DEFAULT NULL")
	private String addresspy;
	@JsonProperty("contact")
	@JSONField(name = "contact")
	@Column(name = "contact", columnDefinition = "varchar(255) DEFAULT NULL")
	private String contact;
	@JsonProperty("phone")
	@JSONField(name = "phone")
	@Column(name = "phone", columnDefinition = "varchar(255) DEFAULT NULL")
	private String phone;
	
	
	public Customer(){
		
	}
	
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}


	public void setName(String name) {
		this.name = name;
		this.namepy=S.getPinYinFirstChar(name);
	}



	public void setAddress(String address) {
		this.address = address;
		this.addresspy=S.getPinYinFirstChar(address);
	}



	public void setContact(String contact) {
		this.contact = contact;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}





	public Long getCustomerId() {
		return customerId;
	}



	public String getName() {
		return name;
	}



	public String getNamepy() {
		return namepy;
	}



	public String getAddress() {
		return address;
	}



	public String getAddresspy() {
		return addresspy;
	}



	public String getContact() {
		return contact;
	}



	public String getPhone() {
		return phone;
	}

	public void setNamepy(String namepy) {
		this.namepy = namepy;
	}

	public void setAddresspy(String addresspy) {
		this.addresspy = addresspy;
	}


}
