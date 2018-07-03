package org.myazure.domain;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "user")
public class WebUser extends BaseEntity { 
	public static int ROLE_ADMIN = 8;
	public static int WEB_USER = 0;
	public static int ACCOUNTANT = 6;
	public static int SYSTEM_ADMIN = 9;
	public static int DRIVER = 3;
	public static int CUSTOMER = 5;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty("id")
	@JSONField(name = "id")
	@Column(name = "user_id", nullable = false, length = 11)
	private Long id;
	
	@JsonProperty("user_name")
	@JSONField(serialize=false,name = "user_name")
	@Column(name = "user_name", nullable = false)
	private String username;

	@JsonProperty("password")
    @JSONField(serialize=false)
	@Column(name = "pass_word", nullable = false)
	private String password ;
 
    
    @JsonProperty("name")
    @JSONField(serialize=true,name = "name")
    @Column(name = "name", nullable = false)
    private String name;
    
    
	@JSONField(serialize=false)
	@Column(name = "salt", nullable = false)
	private String salt ;
	
	@JsonProperty("role")
    @JSONField(serialize=true,name = "role")
	@Column(name = "role", nullable = false)
	private String role;
	@JSONField(serialize=false)
	@Column(name = "token", nullable = true)
	private String token;
	@JSONField(serialize=false)
	@Column(name = "last_login_ip", nullable = true)
	private String lastLoginIp;
	@JSONField(serialize=false)
	@Column(name = "last_login_time", nullable = true)
	private String lastLoginTime;

	
	
	public WebUser() {
		username="null";
		role="User";
		password="";
		name = "用户名";
		salt = (System.currentTimeMillis() + "" + UUID.randomUUID())
				.hashCode() + "";
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getSalt() {
		return salt;
	}



	public void setSalt(String salt) {
		this.salt = salt;
	}



	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}



	public String getToken() {
		return token;
	}



	public void setToken(String token) {
		this.token = token;
	}



	public String getLastLoginIp() {
		return lastLoginIp;
	}



	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}



	public String getLastLoginTime() {
		return lastLoginTime;
	}



	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
}
