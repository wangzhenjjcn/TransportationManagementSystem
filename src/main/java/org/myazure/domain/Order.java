package org.myazure.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
@Table(name = "order")
public class Order extends BaseEntity implements Serializable {
	// `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '订单编号',
	// `customer_id` bigint(11) NOT NULL,
	// `factory_id` bigint(11) NOT NULL,
	// `plan_id` bigint(11) DEFAULT NULL,
	// `delivery_id` bigint(11) DEFAULT NULL,
	// `pick_id` bigint(20) DEFAULT NULL,
	// `user_id` bigint(20) DEFAULT NULL,
	// `weight` int(11) DEFAULT NULL,
	// `size` int(11) DEFAULT NULL,
	// `distence` int(11) DEFAULT NULL,
	// `entry_number` varchar(255) DEFAULT NULL,
	// `customer_number` bigint(20) DEFAULT NULL,
	// `from` varchar(255) DEFAULT NULL,
	// `to` varchar(255) DEFAULT NULL,
	// `packages` int(11) DEFAULT NULL,
	// `freight` int(11) DEFAULT NULL,
	// `cushion_fee` int(11) DEFAULT NULL,
	// `contact` varchar(255) DEFAULT NULL,
	// `phone` varchar(255) DEFAULT NULL,
	// `isCharterd` int(11) DEFAULT NULL,
	// `shipping_type` int(11) DEFAULT NULL,
	// `fee_time` datetime DEFAULT NULL,

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// @Column(name=" ",columnDefinition="int(3) COMMENT '床位终端电量'")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "order_id", nullable = false, length = 11, columnDefinition = "bigint(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '订单编号'", insertable = true)
	private Long orderId;

	@JsonProperty("orderCreatDate")
	@Column(name = "order_creat_date",columnDefinition = "datetime DEFAULT NULL")
	@JSONField(name = "orderCreatDate")
	private Date orderCreatDate;

	@JsonProperty("orderDate")
	@Column(name = "order_date",columnDefinition = "datetime DEFAULT NULL")
	@JSONField(name = "orderDate")
	private Date orderDate;

	@Transient
	private WebUser creatorUser = new WebUser();
	@Transient
	private WebUser customerUser = new WebUser();
	@Transient
	private WebUser transportDriverUser = new WebUser();
	@Transient
	private WebUser deliveryDriverUser = new WebUser();
	@Transient
	private WebUser factoryUser = new WebUser();
	@Transient
	private Vehicle transportVehicle = new Vehicle();
	@Transient
	private Vehicle deliveryVehicle = new Vehicle();
	@Transient
	private Factory factory = new Factory();
	@JsonProperty("factoryId")
	@Column(name = "factory_id",columnDefinition = "bigint(11) DEFAULT NULL")
	@JSONField(name = "factoryId")
	private int factoryId;
	@Transient
	private String factoryName;
	@Transient
	private String factoryAddress;
	@Transient
	private String from;
	@Transient
	private String transferNumber;
	@Transient
	private String pickUpNumber;
	@Transient
	private String entryNumber;
	@Transient
	private int pakagesNumber;
	@Transient
	private int weight;
	@Transient
	private int size;
	@Transient
	private String destination;
	@Transient
	private int distence;
	@Transient
	private int carriageFee;
	@Transient
	private int cushionFee;
	@Transient
	private String remarks;
	@Transient
	private String transportVehicleRegistrationNumber;
	@Transient
	private String deliveryVehicleRegistrationNumber;
	@Transient
	// @OneToOne(targetEntity = Customer.class, fetch = FetchType.EAGER)
	// @JoinColumn(name = "customer_id")
	@JsonProperty("customer_id")
	@JSONField(name = "customer_id")
	private Customer customer;
	
	@Transient
	@JsonProperty("planId")
	@Column(name = "plan_id",columnDefinition = "bigint(11) DEFAULT NULL")
	@JSONField(name = "planId")
	private Plan plan;
	
	
	
	@Transient
	private String customerNumber;
	@Transient
	private boolean isFreight;
	@Transient
	private String contactName;
	@Transient
	private String contactPhone;
	@Transient
	private boolean isCharterd;
	@Transient
	private int feeTime;
	@Transient
	private int orderState;
	@Transient
	private String orderStateString;
	@Transient
	private Map<Date, String> feeHistory = new HashMap<Date, String>();

	public Order() {
	}


	public Long getOrderId() {
		return orderId;
	}


	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}


	public Plan getPlan() {
		return plan;
	}


	public void setPlan(Plan plan) {
		this.plan = plan;
	}


	public Date getOrderCreatDate() {
		return orderCreatDate;
	}

	public void setOrderCreatDate(Date orderCreatDate) {
		this.orderCreatDate = orderCreatDate;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public WebUser getCreatorUser() {
		return creatorUser;
	}

	public void setCreatorUser(WebUser creatorUser) {
		this.creatorUser = creatorUser;
	}

	public WebUser getCustomerUser() {
		return customerUser;
	}

	public void setCustomerUser(WebUser customerUser) {
		this.customerUser = customerUser;
	}

	public WebUser getTransportDriverUser() {
		return transportDriverUser;
	}

	public void setTransportDriverUser(WebUser transportDriverUser) {
		this.transportDriverUser = transportDriverUser;
	}

	public WebUser getDeliveryDriverUser() {
		return deliveryDriverUser;
	}

	public void setDeliveryDriverUser(WebUser deliveryDriverUser) {
		this.deliveryDriverUser = deliveryDriverUser;
	}

	public WebUser getFactoryUser() {
		return factoryUser;
	}

	public void setFactoryUser(WebUser factoryUser) {
		this.factoryUser = factoryUser;
	}

	public Vehicle getTransportVehicle() {
		return transportVehicle;
	}

	public void setTransportVehicle(Vehicle transportVehicle) {
		this.transportVehicle = transportVehicle;
	}

	public Vehicle getDeliveryVehicle() {
		return deliveryVehicle;
	}

	public void setDeliveryVehicle(Vehicle deliveryVehicle) {
		this.deliveryVehicle = deliveryVehicle;
	}

	public Factory getFactory() {
		return factory;
	}

	public void setFactory(Factory factory) {
		this.factory = factory;
	}

	public int getFactoryId() {
		return factoryId;
	}

	public void setFactoryId(int factoryId) {
		this.factoryId = factoryId;
	}

	public String getFactoryName() {
		return factoryName;
	}

	public void setFactoryName(String factoryName) {
		this.factoryName = factoryName;
	}

	public String getFactoryAddress() {
		return factoryAddress;
	}

	public void setFactoryAddress(String factoryAddress) {
		this.factoryAddress = factoryAddress;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTransferNumber() {
		return transferNumber;
	}

	public void setTransferNumber(String transferNumber) {
		this.transferNumber = transferNumber;
	}

	public String getPickUpNumber() {
		return pickUpNumber;
	}

	public void setPickUpNumber(String pickUpNumber) {
		this.pickUpNumber = pickUpNumber;
	}

	public String getEntryNumber() {
		return entryNumber;
	}

	public void setEntryNumber(String entryNumber) {
		this.entryNumber = entryNumber;
	}

	public int getPakagesNumber() {
		return pakagesNumber;
	}

	public void setPakagesNumber(int pakagesNumber) {
		this.pakagesNumber = pakagesNumber;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getDistence() {
		return distence;
	}

	public void setDistence(int distence) {
		this.distence = distence;
	}

	public int getCarriageFee() {
		return carriageFee;
	}

	public void setCarriageFee(int carriageFee) {
		this.carriageFee = carriageFee;
	}

	public int getCushionFee() {
		return cushionFee;
	}

	public void setCushionFee(int cushionFee) {
		this.cushionFee = cushionFee;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getTransportVehicleRegistrationNumber() {
		return transportVehicleRegistrationNumber;
	}

	public void setTransportVehicleRegistrationNumber(
			String transportVehicleRegistrationNumber) {
		this.transportVehicleRegistrationNumber = transportVehicleRegistrationNumber;
	}

	public String getDeliveryVehicleRegistrationNumber() {
		return deliveryVehicleRegistrationNumber;
	}

	public void setDeliveryVehicleRegistrationNumber(
			String deliveryVehicleRegistrationNumber) {
		this.deliveryVehicleRegistrationNumber = deliveryVehicleRegistrationNumber;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Plan getRate() {
		return plan;
	}

	public void setRate(Plan plan) {
		this.plan = plan;
	}

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	public boolean isFreight() {
		return isFreight;
	}

	public void setFreight(boolean isFreight) {
		this.isFreight = isFreight;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public boolean isCharterd() {
		return isCharterd;
	}

	public void setCharterd(boolean isCharterd) {
		this.isCharterd = isCharterd;
	}

	public int getFeeTime() {
		return feeTime;
	}

	public void setFeeTime(int feeTime) {
		this.feeTime = feeTime;
	}

	public int getOrderState() {
		return orderState;
	}

	public void setOrderState(int orderState) {
		this.orderState = orderState;
	}

	public String getOrderStateString() {
		return orderStateString;
	}

	public void setOrderStateString(String orderStateString) {
		this.orderStateString = orderStateString;
	}

	public Map<Date, String> getFeeHistory() {
		return feeHistory;
	}

	public void setFeeHistory(Map<Date, String> feeHistory) {
		this.feeHistory = feeHistory;
	}
}
