package org.myazure.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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

import org.myazure.utils.S;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity implements Serializable {
	@Transient
	private static final long serialVersionUID = 1L;
	@Id
	@JsonProperty("order_id")
	@JSONField(name = "order_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "order_id", nullable = false, length = 11, columnDefinition = "bigint(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '订单编号'", insertable = true)
	private Long orderId;
	@JsonProperty("orderCreatDate")
	@JSONField(name = "orderCreatDate")
	@Column(name = "order_creat_date", columnDefinition = "datetime DEFAULT NULL")
	private Date orderCreatDate;
	@JsonProperty("orderDate")
	@Column(name = "order_date", columnDefinition = "datetime DEFAULT NULL")
	@JSONField(name = "orderDate")
	private Date orderDate;
	@JSONField(name = "creat_user")
	@JsonProperty("creat_user")
	@JoinColumn(name = "creat_user_id")
	@ManyToOne(targetEntity = WebUser.class, fetch = FetchType.LAZY)
	private WebUser creatorUser = new WebUser();
	@JSONField(name = "customer_user")
	@JsonProperty("customer_user")
	@JoinColumn(name = "customer_user_id")
	@ManyToOne(targetEntity = WebUser.class, fetch = FetchType.LAZY)
	private WebUser customerUser = new WebUser();
	@JSONField(name = "transport_driver_user")
	@JsonProperty("transport_driver_user")
	@JoinColumn(name = "transport_driver_user_id")
	@ManyToOne(targetEntity = WebUser.class, fetch = FetchType.LAZY)
	private WebUser transportDriverUser = new WebUser();
	@JSONField(name = "delivery_driver_user")
	@JsonProperty("delivery_driver_user")
	@JoinColumn(name = "delivery_driver_user_id")
	@ManyToOne(targetEntity = WebUser.class, fetch = FetchType.LAZY)
	private WebUser deliveryDriverUser = new WebUser();
	@JSONField(name = "factory_user")
	@JsonProperty("factory_user")
	@JoinColumn(name = "factory_user_id")
	@ManyToOne(targetEntity = WebUser.class, fetch = FetchType.LAZY)
	private WebUser factoryUser = new WebUser();
	@JSONField(name = "transport_vehicle")
	@JsonProperty("transport_vehicle")
	@JoinColumn(name = "transport_vehicle_id")
	@ManyToOne(targetEntity = Vehicle.class, fetch = FetchType.LAZY)
	private Vehicle transportVehicle = new Vehicle();
	@JSONField(name = "delivery_vehicle")
	@JsonProperty("delivery_vehicle")
	@JoinColumn(name = "delivery_vehicle_id")
	@ManyToOne(targetEntity = Vehicle.class, fetch = FetchType.LAZY)
	private Vehicle deliveryVehicle = new Vehicle();
	@Transient
	@JSONField(name = "factory")
	@JsonProperty("factory")
	private Factory factory = new Factory();
	@JsonProperty("factory_id")
	@Column(name = "factory_id", columnDefinition = "bigint(11) DEFAULT NULL")
	@JSONField(name = "factory_id")
	private int factoryId;
	@Transient
	private String factoryName;
	@Transient
	private String factoryAddress;
	// `from` varchar(255) DEFAULT NULL,
	@JsonProperty("source")
	@Column(name = "source", columnDefinition = "varchar(255) DEFAULT NULL")
	@JSONField(name = "source")
	private String from;
	@JsonProperty("sourcepy")
	@JSONField(name = "sourcepy")
	@Column(name = "sourcepy", columnDefinition = "varchar(25) DEFAULT NULL")
	private String frompy;
	// `to` varchar(255) DEFAULT NULL,
	@JsonProperty("destination")
	@Column(name = "destination", columnDefinition = "varchar(255) DEFAULT NULL")
	@JSONField(name = "destination")
	private String destination;
	// `to` varchar(255) DEFAULT NULL,
	@JsonProperty("destinationpy")
	@Column(name = "destinationpy", columnDefinition = "varchar(25) DEFAULT NULL")
	@JSONField(name = "destinationpy")
	private String destinationpy;
	@Transient
	private String transferNumber;
	@Transient
	private String pickUpNumber;
	// `entry_number` varchar(255) DEFAULT NULL,
	@JsonProperty("entry_number")
	@Column(name = "entry_number", columnDefinition = "varchar(255) DEFAULT NULL")
	@JSONField(name = "entry_number")
	private String entryNumber;
	// `packages` int(11) DEFAULT NULL,
	@JsonProperty("packages")
	@Column(name = "packages", columnDefinition = "int(11) DEFAULT NULL")
	@JSONField(name = "packages")
	private int pakagesNumber;
	@JsonProperty("weight")
	@Column(name = "weight", columnDefinition = "int(11) DEFAULT NULL")
	@JSONField(name = "weight")
	private int weight;
	// `size` int(11) DEFAULT NULL,
	@JsonProperty("size")
	@Column(name = "size", columnDefinition = "int(11) DEFAULT NULL")
	@JSONField(name = "size")
	private int size;
	// `distence` int(11) DEFAULT NULL,
	@JsonProperty("distence")
	@Column(name = "distence", columnDefinition = "int(11) DEFAULT NULL")
	@JSONField(name = "distence")
	private int distence;
	@JsonProperty("carriage_fee")
	@Column(name = "carriage_fee", columnDefinition = "int(11) DEFAULT NULL")
	@JSONField(name = "carriage_fee")
	private int carriageFee;
	@JsonProperty("cushion_fee")
	@Column(name = "cushion_fee", columnDefinition = "int(11) DEFAULT NULL")
	@JSONField(name = "cushion_fee")
	private int cushionFee;
	@JsonProperty("remarks")
	@Column(name = "remarks", columnDefinition = "varchar(255) DEFAULT NULL")
	@JSONField(name = "remarks")
	private String remarks;
	@JsonProperty("transport_vehicle_registration_number")
	@Column(name = "transport_vehicle_registration_number", columnDefinition = "varchar(9) DEFAULT NULL")
	@JSONField(name = "transport_vehicle_registration_number")
	private String transportVehicleRegistrationNumber;
	@JsonProperty("delivery_vehicle_registration_number")
	@Column(name = "delivery_vehicle_registration_number", columnDefinition = "varchar(9) DEFAULT NULL")
	@JSONField(name = "delivery_vehicle_registration_number")
	private String deliveryVehicleRegistrationNumber;
	@JoinColumn(name = "customer_id")
	@JSONField(name = "customer_id")
	@ManyToOne(targetEntity = Customer.class, fetch = FetchType.LAZY)
	@JsonProperty("customer_id")
	private Customer customer;
	// `plan_id` bigint(11) DEFAULT NULL,
	@JsonProperty("planId")
	@JSONField(name = "planId")
	@JoinColumn(name = "plan_id", columnDefinition = "bigint(11) DEFAULT NULL")
	@ManyToOne(targetEntity = Plan.class, fetch = FetchType.LAZY)
	private Plan plan;
	// `customer_number` varchar(30) DEFAULT NULL,
	@JsonProperty("customer_number")
	@Column(name = "customer_number", columnDefinition = "varchar(30) DEFAULT NULL")
	@JSONField(name = "customer_number")
	private String customerNumber;
	@Transient
	private boolean isFreight;
	// `contact` varchar(255) DEFAULT NULL,
	@JsonProperty("contact")
	@Column(name = "contact", columnDefinition = "varchar(255) DEFAULT NULL")
	@JSONField(name = "contact")
	private String contactName;
	// `phone` varchar(255) DEFAULT NULL,
	@JsonProperty("phone")
	@Column(name = "phone", columnDefinition = "varchar(255) DEFAULT NULL")
	@JSONField(name = "phone")
	private String contactPhone;
	// `isCharterd` int(11) DEFAULT NULL,
	@JsonProperty("isCharterd")
	@Column(name = "isCharterd", columnDefinition = "int(11) DEFAULT NULL")
	@JSONField(name = "isCharterd")
	private boolean isCharterd;
	@JsonProperty("fee_time")
	@JSONField(name = "fee_time")
	@Column(name = "fee_time", columnDefinition = "int(2) DEFAULT NULL")
	private int feeTime;
	// 0创建
	// 1审核
	// 2运输
	// 3送达
	// 4上传
	// 5完成
	// 6结算
	// 7关闭
	@JsonProperty("order_state")
	@Column(name = "order_state", columnDefinition = "int(2) unsigned DEFAULT '0'")
	@JSONField(name = "order_state")
	private int orderState = 0;
	@Transient
	private String orderStateString;
	@Transient
	private Map<String, Integer> feeHistory = new HashMap<String, Integer>();

	public Order() {
		orderCreatDate = new Date(System.currentTimeMillis());
		orderDate = new Date(System.currentTimeMillis());
		contactName = "";
		orderState = 0;
		orderStateString = "新订单";
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
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

	public String getFrompy() {
		return frompy;
	}

	public void setFrompy(String frompy) {
		this.frompy = frompy;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDestinationpy() {
		return destinationpy;
	}

	public void setDestinationpy(String destinationpy) {
		this.destinationpy = destinationpy;
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

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
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

	public Map<String, Integer> getFeeHistory() {
		return feeHistory;
	}

	public void setFeeHistory(Map<String, Integer> feeHistory) {
		this.feeHistory = feeHistory;
	}

	public static Order getOrderExp() {
		Order order = new Order();
		order.setCarriageFee(S.getRandomNum(3));
		order.setCharterd(false);
		order.setContactName("TEST" + S.getRandomNumString(3) + "NAME");
		order.setContactPhone("139" + S.getRandomNumString(8));
		order.setCustomerNumber("CSN" + S.getRandomNumString(5));
		order.setDestination("苏州");
		order.setDistence(S.getRandomNum(5));
		order.setEntryNumber(S.getRandomString(8));
		order.setFactoryId(S.getRandomNum(7));
		order.setFactoryName("TEST" + S.getRandomNumString(3) + "FACTORY");
		order.setFactoryAddress("苏州观前街");
		order.setFeeTime(S.getRandomNum(1));
		order.setFreight(false);
		order.setFrom("上海");
		order.setOrderStateString("已完成");
		order.setOrderDate(new Date(System.currentTimeMillis()));
		order.setOrderCreatDate(new Date(System.currentTimeMillis()));
		order.setPakagesNumber(S.getRandomNum(2));
		order.setPickUpNumber(S.getRandomString(12));
		order.setRemarks(S.getRandomString(10));
		order.setSize(S.getRandomNum(2));
		order.setTransferNumber(S.getRandomString(8));
		order.setTransportVehicleRegistrationNumber("苏E" + S.getRandomString(4));
		order.setDeliveryVehicleRegistrationNumber("苏E" + S.getRandomString(4));
		order.setWeight(S.getRandomNum(2));
		Plan plan = new Plan();
		plan.setId(789689L);
		plan.setCreatedAt(new Date(System.currentTimeMillis()));
		plan.setLastModified(new Date(System.currentTimeMillis()));
		order.setPlan(plan);
		WebUser creatorUser = new WebUser();
		creatorUser.setUsername(S.getRandomString(4));
		creatorUser.setName(S.getRandomString(5));
		creatorUser.setLastLoginIp("8.8.8.8");
		creatorUser.setLastLoginTime(System.currentTimeMillis() + "");
		order.setCreatorUser(creatorUser);
		WebUser customerUser = new WebUser();
		customerUser.setUsername(S.getRandomString(4));
		customerUser.setName(S.getRandomString(5));
		customerUser.setLastLoginIp("8.8.8.8");
		customerUser.setLastLoginTime(System.currentTimeMillis() + "");
		order.setCustomerUser(customerUser);
		Vehicle deliveryVehicle = new Vehicle();
		deliveryVehicle.setLastModified(new Date(System.currentTimeMillis()));
		deliveryVehicle.setCreatedAt(new Date(System.currentTimeMillis()));
		order.setDeliveryVehicle(deliveryVehicle);
		Factory factory = new Factory();
		Map<String, Integer> feeHistory = new HashMap<String, Integer>();
		feeHistory.put("代付费",
				S.getRandomNum(2));
		feeHistory.put("过路费",
				S.getRandomNum(2));
		feeHistory.put("其他",
				S.getRandomNum(2));
		order.setFeeHistory(feeHistory);
		order.setFactory(factory);
		Vehicle transportVehicle = new Vehicle();
		transportVehicle.setId(1L);
		transportVehicle.setLastModified(new Date(System.currentTimeMillis()));
		transportVehicle.setCreatedAt(new Date(System.currentTimeMillis()));
		order.setTransportVehicle(transportVehicle);
		Customer customer = new Customer();
		customer.setCustomerId(1L);
		order.setCustomer(customer);
		return order;
	}

}
