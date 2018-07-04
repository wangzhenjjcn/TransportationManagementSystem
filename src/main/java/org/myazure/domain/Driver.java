package org.myazure.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "driver")
public class Driver extends BaseEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "driver_id", nullable = false, length = 11)
	private Long id;
	@JsonProperty("name")
	@JSONField(name = "name")
	@Column(name = "name", columnDefinition = "varchar(255) DEFAULT NULL")
	private String name;
	@JsonProperty("namepy")
	@JSONField(name = "namepy")
	@Column(name = "namepy", columnDefinition = "varchar(255) DEFAULT NULL")
	private String namepy;
	@JsonProperty("phone")
	@JSONField(name = "phone")
	@Column(name = "phone", columnDefinition = "varchar(255) DEFAULT NULL")
	private String phone;
	
	public void setId(Long id) {
		this.id = id;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public Driver(){
		
	}


	public Long getId() {
		return id;
	}


	public String getName() {
		return name;
	}


	public String getNamepy() {
		return namepy;
	}


	public String getPhone() {
		return phone;
	}


	public void setNamepy(String namepy) {
		this.namepy = namepy;
	}


}
