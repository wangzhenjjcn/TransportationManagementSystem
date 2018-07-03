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
@Table(name = "factory")
public class Factory  extends BaseEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@JsonProperty("factory_id")
	@JSONField(name = "factory_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "factory_id", nullable = false, length = 11, columnDefinition = "bigint(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '编号'", insertable = true)
	private Long id;
	
	
	@JsonProperty("name")
	@JSONField(name = "name")
	@Column(name = "name", columnDefinition = "varchar(255) DEFAULT NULL")
	private String name;
	
	@JsonProperty("namepy")
	@JSONField(name = "namepy")
	@Column(name = "namepy", columnDefinition = "varchar(255) DEFAULT NULL")
	private String namepy;
	
	public Factory(){
		
	}





	public Long getId() {
		return id;
	}





	public void setId(Long id) {
		this.id = id;
	}
}
