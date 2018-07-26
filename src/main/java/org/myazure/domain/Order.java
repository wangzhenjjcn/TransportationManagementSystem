package org.myazure.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.myazure.utils.S;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity implements Serializable {
	@Transient
	private static final long serialVersionUID = 1L;
	@Id
	@JsonProperty("id")
	@JSONField(name = "id")
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
	@JSONField(name = "creator_user", serialize = false)
	@JsonProperty("creator_user")
	@JoinColumn(name = "creator_user_id")
	@ManyToOne(targetEntity = WebUser.class, fetch = FetchType.LAZY)
	private WebUser creatorUser = new WebUser();
	@JSONField(name = "customer_user", serialize = false)
	@JsonProperty("customer_user")
	@JoinColumn(name = "customer_user_id")
	@ManyToOne(targetEntity = WebUser.class, fetch = FetchType.LAZY)
	private WebUser customerUser = new WebUser();
	@JSONField(name = "transport_driver_user", serialize = false)
	@JsonProperty("transport_driver_user")
	@JoinColumn(name = "transport_driver_user_id")
	@ManyToOne(targetEntity = WebUser.class, fetch = FetchType.LAZY)
	private WebUser transportDriverUser = new WebUser();
	@JSONField(name = "delivery_driver_user", serialize = false)
	@JsonProperty("delivery_driver_user")
	@JoinColumn(name = "delivery_driver_user_id")
	@ManyToOne(targetEntity = WebUser.class, fetch = FetchType.LAZY)
	private WebUser deliveryDriverUser = new WebUser();
	@JSONField(name = "factory_user", serialize = false)
	@JsonProperty("factory_user")
	@JoinColumn(name = "factory_user_id")
	@ManyToOne(targetEntity = WebUser.class, fetch = FetchType.LAZY)
	private WebUser factoryUser = new WebUser();
	@JSONField(name = "transport_vehicle", serialize = false)
	@JsonProperty("transport_vehicle")
	@JoinColumn(name = "transport_vehicle_id")
	@ManyToOne(targetEntity = Vehicle.class, fetch = FetchType.LAZY)
	private Vehicle transportVehicle = new Vehicle();
	@JSONField(name = "delivery_vehicle", serialize = false)
	@JsonProperty("delivery_vehicle")
	@JoinColumn(name = "delivery_vehicle_id")
	@ManyToOne(targetEntity = Vehicle.class, fetch = FetchType.LAZY)
	private Vehicle deliveryVehicle = new Vehicle();
	@JSONField(name = "transport_vehicle_driver", serialize = false)
	@JsonProperty("transport_vehicle_driver")
	@JoinColumn(name = "transport_vehicle_driver_id")
	@ManyToOne(targetEntity = Driver.class, fetch = FetchType.LAZY)
	private Driver transportVehicleDriver = new Driver();
	@JSONField(name = "delivery_vehicle", serialize = false)
	@JsonProperty("delivery_vehicle")
	@JoinColumn(name = "delivery_vehicle_driver_id")
	@ManyToOne(targetEntity = Driver.class, fetch = FetchType.LAZY)
	private Driver deliveryVehicleDriver = new Driver();
	@JSONField(name = "factory")
	@JsonProperty("factory")
	@JoinColumn(name = "factory_id")
	@ManyToOne(targetEntity = Factory.class, fetch = FetchType.LAZY)
	private Factory factory = new Factory();
	@JSONField(name = "factory_name")
	@JsonProperty("factory_name")
	@Column(name = "factory_name", columnDefinition = "varchar(255) DEFAULT NULL")
	private String factoryName;
	@Transient
	@JSONField(name = "factory_address")
	@JsonProperty("factory_address")
	private String factoryAddress;
	@Transient
	@JSONField(name = "factory_addresspy")
	@JsonProperty("factory_addresspy")
	private String factoryAddresspy;
	@JsonProperty("source")
	@Column(name = "source", columnDefinition = "varchar(255) DEFAULT NULL")
	@JSONField(name = "source")
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
	@JsonProperty("transfer_number")
	@Column(name = "transfer_number", columnDefinition = "varchar(255) DEFAULT NULL")
	@JSONField(name = "transfer_number")
	private String transferNumber;
	@JsonProperty("pickup_number")
	@Column(name = "pickup_number", columnDefinition = "varchar(255) DEFAULT NULL")
	@JSONField(name = "pickup_number")
	private String pickupNumber;
	@JsonProperty("entry_number")
	@Column(name = "entry_number", columnDefinition = "varchar(255) DEFAULT NULL")
	@JSONField(name = "entry_number")
	private String entryNumber;
	@JsonProperty("weight")
	@Column(name = "weight", columnDefinition = "int(11) DEFAULT NULL")
	@JSONField(name = "weight")
	private int weight;
	@JsonProperty("size")
	@Column(name = "size", columnDefinition = "int(11) DEFAULT NULL")
	@JSONField(name = "size")
	private int size;
	@JsonProperty("packages")
	@Column(name = "packages", columnDefinition = "int(11) DEFAULT NULL")
	@JSONField(name = "packages")
	private int pakages;
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
	@JsonProperty("remarkspy")
	@Column(name = "remarkspy", columnDefinition = "varchar(255) DEFAULT NULL")
	@JSONField(name = "remarkspy")
	private String remarkspy;
	@JsonProperty("transport_vehicle_registration_number")
	@Column(name = "transport_vehicle_registration_number", columnDefinition = "varchar(9) DEFAULT NULL")
	@JSONField(name = "transport_vehicle_registration_number")
	private String transportVehicleRegistrationNumber;
	@JsonProperty("delivery_vehicle_registration_number")
	@Column(name = "delivery_vehicle_registration_number", columnDefinition = "varchar(9) DEFAULT NULL")
	@JSONField(name = "delivery_vehicle_registration_number")
	private String deliveryVehicleRegistrationNumber;
	@JSONField(name = "customer")
	@JsonProperty("customer")
	@JoinColumn(name = "customer_id")
	@ManyToOne(targetEntity = Customer.class, fetch = FetchType.LAZY)
	private Customer customer;
	@JSONField(name = "customer_name")
	@JsonProperty("customer_name")
	@Column(name = "customer_name", columnDefinition = "varchar(255) DEFAULT NULL")
	private String customerName;
	@JsonProperty("plan")
	@JSONField(name = "plan")
	@JoinColumn(name = "plan_id", columnDefinition = "bigint(11) DEFAULT NULL")
	@ManyToOne(targetEntity = Plan.class, fetch = FetchType.LAZY)
	private Plan plan;
	@JsonProperty("customer_number")
	@Column(name = "customer_number", columnDefinition = "varchar(30) DEFAULT NULL")
	@JSONField(name = "customer_number")
	private String customerNumber;
	@JsonProperty("freight_tpye")
	@JSONField(name = "freight_tpye")
	@Column(name = "freight_tpye", columnDefinition = " int(1) DEFAULT '0'")
	private int freightType;
	@Transient
	@JsonProperty("freight_tpye_String")
	@JSONField(name = "freight_tpye_String")
	private String freightTypeString;
	@Transient
	@JsonProperty("freight_tpye_string_py")
	@JSONField(name = "freight_tpye_string_py")
	private String freightTypeStringPy;
	@JsonProperty("contact")
	@Column(name = "contact", columnDefinition = "varchar(255) DEFAULT NULL")
	@JSONField(name = "contact")
	private String contactName;
	@JsonProperty("contactpy")
	@Column(name = "contactpy", columnDefinition = "varchar(255) DEFAULT NULL")
	@JSONField(name = "contactpy")
	private String contactNamepy;
	@JsonProperty("phone")
	@Column(name = "phone", columnDefinition = "varchar(255) DEFAULT NULL")
	@JSONField(name = "phone")
	private String contactPhone;
	@JsonProperty("isChartered")
	@Column(name = "isChartered", columnDefinition = "bit(1) DEFAULT NULL")
	@JSONField(name = "isChartered")
	private boolean isChartered = false;
	@JsonProperty("fee_time")
	@JSONField(name = "fee_time")
	@Column(name = "fee_time", columnDefinition = "int(2) DEFAULT NULL")
	private int feeTime = 1;
	@JsonProperty("order_state")
	@JSONField(name = "order_state")
	@Column(name = "order_state", columnDefinition = "int(2) unsigned DEFAULT '0'")
	private int orderState = 0;
	// 0草稿 // 1审核 // 2运输 // 3送达 // 4上传 // 5完成 // 6结算 // 7关闭
	@Transient
	@JsonProperty("order_state_string")
	@JSONField(name = "order_state_string")
	private String orderStateString;
	@Transient
	@JsonProperty("order_state_string_py")
	@JSONField(name = "order_state_string_py")
	private String orderStateStringPY;
	@JSONField(name = "payments")
	@JsonProperty("payments")
	@OneToMany(cascade = CascadeType.ALL, targetEntity = Payment.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "order_id")
	private List<Payment> feeHistory = new ArrayList<Payment>();
	@JSONField(name = "account_payable")
	@JsonProperty("account_payable")
	@OneToMany(cascade = CascadeType.ALL, targetEntity = Payment.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "order_id")
	private List<Payment> accountPayable = new ArrayList<Payment>();

	public Order() {
		orderCreatDate = new Date(System.currentTimeMillis());
		orderDate = new Date(System.currentTimeMillis());
		contactName = "";
		orderState = 0;
		orderStateString = "新订单";
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public void setCreatorUser(WebUser creatorUser) {
		this.creatorUser = creatorUser;
	}

	public void setCustomerUser(WebUser customerUser) {
		this.customerUser = customerUser;
	}

	public void setTransportDriverUser(WebUser transportDriverUser) {
		this.transportDriverUser = transportDriverUser;
	}

	public void setDeliveryDriverUser(WebUser deliveryDriverUser) {
		this.deliveryDriverUser = deliveryDriverUser;
	}

	public void setFactoryUser(WebUser factoryUser) {
		this.factoryUser = factoryUser;
	}

	public void setTransportVehicle(Vehicle transportVehicle) {
		this.transportVehicle = transportVehicle;
		this.transportVehicleRegistrationNumber = transportVehicle
				.getCarLicensePlate();
	}

	public void setDeliveryVehicle(Vehicle deliveryVehicle) {
		this.deliveryVehicle = deliveryVehicle;
		this.deliveryVehicleRegistrationNumber = deliveryVehicle
				.getCarLicensePlate();
	}

	public void setFactory(Factory factory) {
		this.factory = factory;
		if (factory==null) {
			return;
		}
		this.factoryName = factory.getName();
		this.factoryAddress = factory.getAddress();
	}

	public void setSource(String source) {
		this.source = source;
		this.sourcepy = S.getPinYinFirstChar(source);
	}

	public void setDestination(String destination) {
		this.destination = destination;
		this.destinationpy = S.getPinYinFirstChar(destination);
	}

	public void setTransferNumber(String transferNumber) {
		this.transferNumber = transferNumber;
	}

	public void setEntryNumber(String entryNumber) {
		this.entryNumber = entryNumber;
	}

	public void setPakages(int pakages) {
		this.pakages = pakages;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void setDistence(int distence) {
		this.distence = distence;
	}

	public void setCarriageFee(int carriageFee) {
		this.carriageFee = carriageFee;
	}

	public void setCushionFee(int cushionFee) {
		this.cushionFee = cushionFee;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
		this.remarkspy = S.getPinYinFirstChar(remarks);
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	public void setFreightType(int freightType) {
		this.freightType = freightType;
		switch (freightType) {
		case 1:
			this.freightTypeString = "陆运";
			break;
		case 2:
			this.freightTypeString = "空运";
			break;
		case 3:
			this.freightTypeString = "海运";
			break;
		case 4:
			this.freightTypeString = "其他";
			break;
		default:
			break;
		}
		this.freightTypeStringPy=S.getPinYinFirstChar(freightTypeString);
	}

	public void setChartered(boolean isChartered) {
		this.isChartered = isChartered;
	}

	public void setFeeTime(int feeTime) {
		this.feeTime = feeTime;
	}

	public void setOrderState(int orderState) {
		this.orderState = orderState;
		switch (orderState) {
		// 0草稿 // 1审核 // 2运输 // 3送达 // 4上传 // 5完成 // 6结算 // 7关闭
		case 0:
			this.orderStateString = "草稿";
			break;
		case 1:
			this.orderStateString = "已审核";
			break;
		case 2:
			this.orderStateString = "运输中";
			break;
		case 3:
			this.orderStateString = "待上传";
			break;
		case 4:
			this.orderStateString = "已送达";
			break;
		case 5:
			this.orderStateString = "已交付";
			break;
		case 6:
			this.orderStateString = "已结算";
			break;
		case 7:
			this.orderStateString = "已关闭";
			break;
		default:
			break;
		}
		this.orderStateStringPY = S.getPinYinFirstChar(orderStateString);
	}

	public void setFeeHistory(List<Payment> feeHistory) {
		this.feeHistory = feeHistory;
	}

	public void setAccountPayable(List<Payment> accountPayable) {
		this.accountPayable = accountPayable;
	}

	public Long getOrderId() {
		return orderId;
	}

	public Date getOrderCreatDate() {
		return orderCreatDate;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public WebUser getCreatorUser() {
		return creatorUser;
	}

	public WebUser getCustomerUser() {
		return customerUser;
	}

	public WebUser getTransportDriverUser() {
		return transportDriverUser;
	}

	public WebUser getDeliveryDriverUser() {
		return deliveryDriverUser;
	}

	public WebUser getFactoryUser() {
		return factoryUser;
	}

	public Vehicle getTransportVehicle() {
		return transportVehicle;
	}

	public Vehicle getDeliveryVehicle() {
		return deliveryVehicle;
	}

	public Factory getFactory() {
		return factory;
	}

	public String getFactoryName() {
		return factoryName;
	}

	public String getFactoryAddress() {
		return factoryAddress;
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

	public String getTransferNumber() {
		return transferNumber;
	}

	public String getEntryNumber() {
		return entryNumber;
	}

	public int getPakages() {
		return pakages;
	}

	public int getWeight() {
		return weight;
	}

	public int getSize() {
		return size;
	}

	public int getDistence() {
		return distence;
	}

	public int getCarriageFee() {
		return carriageFee;
	}

	public int getCushionFee() {
		return cushionFee;
	}

	public String getRemarks() {
		return remarks;
	}

	public String getRemarkspy() {
		return remarkspy;
	}

	public String getTransportVehicleRegistrationNumber() {
		return transportVehicleRegistrationNumber;
	}

	public String getDeliveryVehicleRegistrationNumber() {
		return deliveryVehicleRegistrationNumber;
	}

	public Customer getCustomer() {
		return customer;
	}

	public Plan getPlan() {
		return plan;
	}

	public String getCustomerNumber() {
		return customerNumber;
	}

	public int getFreightType() {
		return freightType;
	}

	public String getFreightTypeString() {
		return freightTypeString;
	}

	public String getFreightTypeStringPy() {
		return freightTypeStringPy;
	}

	public String getContactName() {
		return contactName;
	}

	public String getContactNamepy() {
		return contactNamepy;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public boolean isChartered() {
		return isChartered;
	}

	public int getFeeTime() {
		return feeTime;
	}

	public int getOrderState() {
		return orderState;
	}

	public String getOrderStateString() {
		return orderStateString;
	}

	public String getOrderStateStringPY() {
		return orderStateStringPY;
	}

	public List<Payment> getFeeHistory() {
		return feeHistory;
	}

	public void setOrderCreatDate(Date orderCreatDate) {
		this.orderCreatDate = orderCreatDate;
	}

	public void setFactoryName(String factoryName) {
		this.factoryName = factoryName;
		
	}

	public void setFactoryAddress(String factoryAddress) {
		this.factoryAddress = factoryAddress;
		this.factoryAddresspy=S.getPinYinFirstChar(factoryAddress);
	}

	public void setSourcepy(String sourcepy) {
		this.sourcepy = sourcepy;
	}

	public void setDestinationpy(String destinationpy) {
		this.destinationpy = destinationpy;
	}

	public void setRemarkspy(String remarkspy) {
		this.remarkspy = remarkspy;
	}

	public void setTransportVehicleRegistrationNumber(
			String transportVehicleRegistrationNumber) {
		this.transportVehicleRegistrationNumber = transportVehicleRegistrationNumber;
	}

	public void setDeliveryVehicleRegistrationNumber(
			String deliveryVehicleRegistrationNumber) {
		this.deliveryVehicleRegistrationNumber = deliveryVehicleRegistrationNumber;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
		this.contactNamepy = S.getPinYinFirstChar(contactName);
	}

	public void setContactNamepy(String contactNamepy) {
		this.contactNamepy = contactNamepy;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public void setOrderStateString(String orderStateString) {
		this.orderStateString = orderStateString;
	}

	public void setOrderStateStringPY(String orderStateStringPY) {
		this.orderStateStringPY = orderStateStringPY;
	}

	public List<Payment> getAccountPayable() {
		return accountPayable;
	}

	public void setFreightTypeString(String freightTypeString) {
		this.freightTypeString = freightTypeString;
	}

	public void setFreightTypeStringPy(String freightTypeStringPy) {
		this.freightTypeStringPy = freightTypeStringPy;
	}

	public Driver getTransportVehicleDriver() {
		return transportVehicleDriver;
	}

	public void setTransportVehicleDriver(Driver transportVehicleDriver) {
		this.transportVehicleDriver = transportVehicleDriver;
	}

	public Driver getDeliveryVehicleDriver() {
		return deliveryVehicleDriver;
	}

	public void setDeliveryVehicleDriver(Driver deliveryVehicleDriver) {
		this.deliveryVehicleDriver = deliveryVehicleDriver;
	}

	public String getPickupNumber() {
		return pickupNumber;
	}

	public void setPickupNumber(String pickupNumber) {
		this.pickupNumber = pickupNumber;
	}

	public String getFactoryAddresspy() {
		return factoryAddresspy;
	}

	public void setFactoryAddresspy(String factoryAddresspy) {
		this.factoryAddresspy = factoryAddresspy;
	}

}
