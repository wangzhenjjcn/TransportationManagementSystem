package org.myazure.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "remarks")
public class Remarks {
	@Id
	@JsonProperty("id")
	@JSONField(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "remarks_id", nullable = false, length = 11, columnDefinition = "bigint(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '订单编号'", insertable = true)
	private Long remarksId;
	
	@JsonProperty("order_id")
	@JSONField(name = "order_id")
	@Column(name = "order_id",  length = 11, columnDefinition = "bigint(11) DEFAULT NULL COMMENT '订单编号'", insertable = true)
	private Long orderId;
	
	@JsonProperty("remarks_key")
	@Column(name = "remarks_key", columnDefinition = "varchar(25) DEFAULT NULL")
	@JSONField(name = "remarks_key")
	private String remarksKey;
	
	@JsonProperty("remarks_value")
	@Column(name = "remarks_value", columnDefinition = "varchar(255) DEFAULT NULL")
	@JSONField(name = "remarks_value")
	private String remarksValue;
	 
	public Remarks() {

	}

	public Long getRemarksId() {
		return remarksId;
	}

	public void setRemarksId(Long remarksId) {
		this.remarksId = remarksId;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getRemarksKey() {
		return remarksKey;
	}

	public void setRemarksKey(String remarksKey) {
		this.remarksKey = remarksKey;
	}

	public String getRemarksValue() {
		return remarksValue;
	}

	public void setRemarksValue(String remarksValue) {
		this.remarksValue = remarksValue;
	}

}
