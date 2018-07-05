package org.myazure.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "payment")
public class Payment extends BaseEntity implements Serializable {
	@Transient
	private static final long serialVersionUID = 1L;

	@Id
	@JsonProperty("payment_id")
	@JSONField(name = "payment_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "payment_id", nullable = false, length = 11, columnDefinition = "bigint(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '订单编号'", insertable = true)
	private Long payId;

	@JsonProperty("order_id")
	@JSONField(name = "order_id")
	@Column(name = "order_id", columnDefinition = "bigint(11) unsigned NOT NULL")
	private Long orderId;

	@JsonProperty("payout")
	@Column(name = "payout", columnDefinition = "bigint(11) unsigned NOT NULL")
	@JSONField(name = "payout")
	private int payout;

	@JsonProperty("pay_time")
	@Column(name = "pay_time", columnDefinition = "datetime DEFAULT NULL")
	@JSONField(name = "pay_time")
	private Date payTime;

	@JSONField(name = "creator_user")
	@JsonProperty("creator_user")
	@JoinColumn(name = "creator_user_id")
	@ManyToOne(targetEntity = WebUser.class, fetch = FetchType.LAZY)
	private WebUser creatorUser = new WebUser();

	@JsonProperty("remarks")
	@Column(name = "remarks", columnDefinition = "varchar(255) DEFAULT NULL")
	@JSONField(name = "remarks")
	private String remarks;

	@JsonProperty("remarkspy")
	@Column(name = "remarkspy", columnDefinition = "varchar(255) DEFAULT NULL")
	@JSONField(name = "remarkspy")
	private String remarkspy;

	public Payment() {

	}

	public Long getPayId() {
		return payId;
	}

	public void setPayId(Long payId) {
		this.payId = payId;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public int getPayout() {
		return payout;
	}

	public void setPayout(int payout) {
		this.payout = payout;
	}

	public Date getPayTime() {
		return payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	public WebUser getCreatorUser() {
		return creatorUser;
	}

	public void setCreatorUser(WebUser creatorUser) {
		this.creatorUser = creatorUser;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getRemarkspy() {
		return remarkspy;
	}

	public void setRemarkspy(String remarkspy) {
		this.remarkspy = remarkspy;
	}

}
