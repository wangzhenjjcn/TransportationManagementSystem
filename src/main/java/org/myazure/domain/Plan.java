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
@Table(name = "plan")
public class Plan extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "plan_id", nullable = false, length = 11)
	private Long id;

	@JsonProperty("price")
	@JSONField(name = "price")
	@Column(name = "price", columnDefinition = "int(11) unsigned DEFAULT NULL")
	private int price;
	@JsonProperty("chartered_price")
	@JSONField(name = "chartered_price")
	@Column(name = "chartered_price", columnDefinition = "int(11) unsigned DEFAULT NULL")
	private int charteredPrice;
	@JsonProperty("weight")
	@JSONField(name = "weight")
	@Column(name = "weight", columnDefinition = "int(11) unsigned DEFAULT NULL")
	private int weight;
	@JsonProperty("size")
	@JSONField(name = "size")
	@Column(name = "size", columnDefinition = "int(11) unsigned DEFAULT NULL")
	private int size;
	@JsonProperty("distance")
	@JSONField(name = "distance")
	@Column(name = "distance", columnDefinition = "int(11) unsigned DEFAULT NULL")
	private int distance;
	@JsonProperty("company_name")
	@JSONField(name = "company_name")
	@Column(name = "company_name", columnDefinition = "varchar(255) DEFAULT NULL")
	private String companyName;
	@JsonProperty("source")
	@JSONField(name = "source")
	@Column(name = "source", columnDefinition = "varchar(255) DEFAULT NULL")
	private String source;
	@JsonProperty("sourcepy")
	@JSONField(name = "sourcepy")
	@Column(name = "sourcepy", columnDefinition = "varchar(25) DEFAULT NULL")
	private String sourcepy;
	@JsonProperty("destination")
	@Column(name = "destination", columnDefinition = "varchar(255) DEFAULT NULL")
	@JSONField(name = "destination")
	private String destination;
	@JsonProperty("destinationpy")
	@Column(name = "destinationpy", columnDefinition = "varchar(25) DEFAULT NULL")
	@JSONField(name = "destinationpy")
	private String destinationpy;

	public void setId(Long id) {
		this.id = id;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setCharteredPrice(int charteredPrice) {
		this.charteredPrice = charteredPrice;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Plan() {

	}

	public Long getId() {
		return id;
	}

	public int getPrice() {
		return price;
	}

	public int getCharteredPrice() {
		return charteredPrice;
	}

	public int getWeight() {
		return weight;
	}

	public int getSize() {
		return size;
	}

	public int getDistance() {
		return distance;
	}

	public String getCompanyName() {
		return companyName;
	}

	public String getSource() {
		return source;
	}

	public String getSourcepy() {
		return sourcepy;
	}

	public String getDestination() {
		return destination;
	}

	public String getDestinationpy() {
		return destinationpy;
	}

	public void setSourcepy(String sourcepy) {
		this.sourcepy = sourcepy;
	}

	public void setDestinationpy(String destinationpy) {
		this.destinationpy = destinationpy;
	}

}
