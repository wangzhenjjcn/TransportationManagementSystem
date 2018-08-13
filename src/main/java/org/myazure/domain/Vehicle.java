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

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "vehicle")
public class Vehicle extends BaseEntity implements Serializable {
	@Transient
	private static final long serialVersionUID = 1L;
	public static final List<String> NotNullList = new ArrayList<String>();
	@Id
	@JsonProperty("id")
	@JSONField(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "vehicle_id", nullable = false, length = 11, columnDefinition = "bigint(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '编号'", insertable = true)
	private Long id;

	@JsonProperty("car_license_plate")
	@Column(name = "car_license_plate", columnDefinition = "varchar(255) DEFAULT NULL")
	@JSONField(name = "car_license_plate")
	private String carLicensePlate;

	public String getCarLicensePlate() {
		return carLicensePlate;
	}

	public void setCarLicensePlate(String carLicensePlate) {
		this.carLicensePlate = carLicensePlate;
	}

	public Vehicle() {
		super();
		NotNullList.add("car_license_plate");
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
