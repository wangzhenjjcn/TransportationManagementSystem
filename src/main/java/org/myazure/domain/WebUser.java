package org.myazure.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class WebUser {

	@Id
	@GeneratedValue
	@Column(name = "id", nullable = false, length = 11)
	private Long id;
	@Column(name = "name", nullable = false)
	private String name;
	@Column(name = "password", nullable = false)
	private String password;
	@Column(name = "salt", nullable = false)
	private String salt;
	@Column(name = "role", nullable = false)
	private String role;
	@Column(name = "access", nullable = false)
	private String access;

	public WebUser() {

	}
}
