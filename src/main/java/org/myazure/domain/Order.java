package org.myazure.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	@JSONField(name = "creator_user")
	@JsonProperty("creator_user")
	@JoinColumn(name = "creator_user_id")
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
	@JSONField(name = "factory")
	@JsonProperty("factory")
	@JoinColumn(name = "factory_id")
	@ManyToOne(targetEntity = Factory.class, fetch = FetchType.LAZY)
	private Factory factory = new Factory();
	@Transient
	@JSONField(name = "factory_name")
	@JsonProperty("factory_name")
	private String factoryName;
	@Transient
	@JSONField(name = "factory_address")
	@JsonProperty("factory_address")
	private String factoryAddress;
	@JsonProperty("source")
	@Column(name = "source", columnDefinition = "varchar(255) DEFAULT NULL")
	@JSONField(name = "source")
	private String from;
	@JsonProperty("sourcepy")
	@JSONField(name = "sourcepy")
	@Column(name = "sourcepy", columnDefinition = "varchar(25) DEFAULT NULL")
	private String frompy;
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
	private String pickUpNumber;
	@JsonProperty("entry_number")
	@Column(name = "entry_number", columnDefinition = "varchar(255) DEFAULT NULL")
	@JSONField(name = "entry_number")
	private String entryNumber;
	@JsonProperty("packages")
	@Column(name = "packages", columnDefinition = "int(11) DEFAULT NULL")
	@JSONField(name = "packages")
	private int pakagesNumber;
	@JsonProperty("weight")
	@Column(name = "weight", columnDefinition = "int(11) DEFAULT NULL")
	@JSONField(name = "weight")
	private int weight;
	@JsonProperty("size")
	@Column(name = "size", columnDefinition = "int(11) DEFAULT NULL")
	@JSONField(name = "size")
	private int size;
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
	@JsonProperty("planId")
	@JSONField(name = "planId")
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
	// @ManyToOne(targetEntity = Payment.class, fetch = FetchType.LAZY)
	private List<Payment> feeHistory = new ArrayList<Payment>();

	public Order() {
		orderCreatDate = new Date(System.currentTimeMillis());
		orderDate = new Date(System.currentTimeMillis());
		contactName = "";
		orderState = 0;
		orderStateString = "新订单";
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
		feeHistory.put("代付费", S.getRandomNum(2));
		feeHistory.put("过路费", S.getRandomNum(2));
		feeHistory.put("其他", S.getRandomNum(2));
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
