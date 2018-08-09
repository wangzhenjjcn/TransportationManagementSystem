package org.myazure.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.myazure.utils.S;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "driver")
public class Driver extends BaseEntity implements Serializable {
	@Transient
	private static final long serialVersionUID = 1L;
	public static final List<String> NotNullList = new ArrayList<String>();
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty("id")
	@JSONField(name = "id")
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

	
	public Driver() {
		super();
		NotNullList.add("name");
	}
	
	
	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
		this.namepy=S.getPinYinFirstChar(name);
	}

	public void setPhone(String phone) {
		this.phone = phone;
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
