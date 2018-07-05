package org.myazure.domain;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.myazure.utils.S;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
	public static int SUPER = -1;

	public static String getRoleString(int role) {
		switch (role) {
		case 0:
			return "网站用户";
		case 3:
			return "司机";
		case 5:
			return "客户";
		case 6:

			return "会计";
		case 8:

			return "角色管理员";
		case 9:
			return "系统管理员";
		case -1:
			return "超级管理员";
		default:
			break;
		}
		return "未定义";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty("user_id")
	@JSONField(name = "user_id")
	@Column(name = "user_id", nullable = false, length = 11)
	private Long id;

	@JsonProperty("user_name")
	@JSONField(serialize = false, name = "user_name")
	@Column(name = "user_name", nullable = false)
	private String username;

	@JsonProperty("password")
	@JSONField(serialize = false)
	@Column(name = "pass_word", nullable = false)
	private String password;

	@JsonProperty("name")
	@JSONField(serialize = true, name = "name")
	@Column(name = "name", nullable = false)
	private String name;

	@JSONField(serialize = false)
	@Column(name = "salt", nullable = false)
	private String salt;

	@JsonProperty("role")
	@JSONField(serialize = true, name = "role")
	@Column(name = "role", nullable = false)
	private int role;

	@JsonProperty("role_id")
	@JSONField(name = "role_id")
	@Column(name = "role_id", nullable = false, length = 11)
	private Long roleId;
	@JsonProperty("role_string")
	@JSONField(name = "role_string")
	@Column(name = "role_string", columnDefinition = "varchar(255) DEFAULT NULL")
	private String roleString;
	@JsonProperty("role_string_py")
	@JSONField(name = "role_string_py")
	@Column(name = "role_string_py", columnDefinition = "varchar(255) DEFAULT NULL")
	private String roleStringPy;
	@JSONField(serialize = false)
	@JsonIgnore
	@Column(name = "token", nullable = true)
	private String token;
	@JSONField(serialize = false)
	@Column(name = "last_login_ip", nullable = true)
	private String lastLoginIp;
	@JSONField(serialize = false)
	@Column(name = "last_login_time", nullable = true)
	private String lastLoginTime;

	public WebUser() {
		username = "null";
		role = WebUser.WEB_USER;
		roleId = 1L;
		password = "";
		name = "用户名";
		salt = (System.currentTimeMillis() + "" + UUID.randomUUID()).hashCode()
				+ "";
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

	public static int getROLE_ADMIN() {
		return ROLE_ADMIN;
	}

	public static int getWEB_USER() {
		return WEB_USER;
	}

	public static int getACCOUNTANT() {
		return ACCOUNTANT;
	}

	public static int getSYSTEM_ADMIN() {
		return SYSTEM_ADMIN;
	}

	public static int getDRIVER() {
		return DRIVER;
	}

	public static int getCUSTOMER() {
		return CUSTOMER;
	}

	public int getRole() {
		return role;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRole(int role) {
		this.role = role;
		this.roleString = getRoleString(role);
		this.roleStringPy = S.getPinYinFirstChar(roleString);
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleString() {
		return roleString;
	}

	public void setRoleString(String roleString) {
		this.roleString = roleString;
	}

	public String getRoleStringPy() {
		return roleStringPy;
	}

	public void setRoleStringPy(String roleStringPy) {
		this.roleStringPy = roleStringPy;
	}
}
