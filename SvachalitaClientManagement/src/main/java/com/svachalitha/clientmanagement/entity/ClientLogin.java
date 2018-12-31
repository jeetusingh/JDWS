package com.svachalitha.clientmanagement.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.validation.constraints.Email;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(schema = "svachalitha_client_management")
public class ClientLogin {

	@Id
	@GeneratedValue(generator = "clientLoginIdGenerator", strategy = GenerationType.TABLE)
	@TableGenerator(name = "clientLoginIdGenerator", table = "svachalitha_primary_key_generator",
	pkColumnName = "svachalitha_generator_name", valueColumnName = "svachalitha_generator_value",
	pkColumnValue="clientloginid",schema = "svachalitha_client_management", 
	allocationSize = 1, initialValue = 1)
	private Long id;

	@NotEmpty(message = "please send user name")
	@Column(name="clientname",nullable=false,unique=true)
	private String name;

	@NotEmpty(message = "please send password")
	@Column(name="password",nullable=false)
	private String password;

	@Email(message = "please send email address")
	@Column(name="email",nullable=false)
	private String email;

	@NotEmpty(message = "please send mobile number")
	@Size(min = 10, max = 10, message = "please send mobile number with 10 characters")
	private String mobile;

	@NotNull(message = "please send organization name")
	@Size(max = 40, message = "please send organization name less than 40 characters")
	private String organizationName;

	@NotNull(message = "please send client address")
	@Size(max = 200, message = "please send client address less than 200 characters")
	private String clientAddress;

	@NotNull(message = "please send organization address")
	@Size(max = 200, message = "please send organization address less than 200 characters")
	private String organizationAddress;

	private Date registrationDate = new Date();

	@Future(message = "please send future expiry date")
	private Date expiryDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getClientAddress() {
		return clientAddress;
	}

	public void setClientAddress(String clientAddress) {
		this.clientAddress = clientAddress;
	}

	public String getOrganizationAddress() {
		return organizationAddress;
	}

	public void setOrganizationAddress(String organizationAddress) {
		this.organizationAddress = organizationAddress;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

}
