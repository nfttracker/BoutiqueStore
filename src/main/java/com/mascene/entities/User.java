package com.mascene.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.mascene.api.response.Response;

/**
 * @author Raman.Ahuja
 * 
 *         User Entity
 *
 */
@Entity(name = "user")
public class User extends Response {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	@Column(nullable = false, unique = true)
	private String userName;
	@Column(nullable = false, unique = true)
	private String password;
	@Column(nullable = false, unique = true)
	private String userEmailId;
	@Column(nullable = false, unique = true)
	private int userEmpId;
	@Column(nullable = false)
	private String empName;
	@Column(nullable = false)
	private Date empDob;
	@Column(nullable = false)
	private String employeeRole;

	@Column(nullable = false)
	private Date dateAdded;

	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserEmailId() {
		return userEmailId;
	}

	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}

	public int getUserEmpId() {
		return userEmpId;
	}

	public void setUserEmpId(int userEmpId) {
		this.userEmpId = userEmpId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Date getEmpDob() {
		return empDob;
	}

	public void setEmpDob(Date empDob) {
		this.empDob = empDob;
	}

	public String getEmployeeRole() {
		return employeeRole;
	}

	public void setEmployeeRole(String employeeRole) {
		this.employeeRole = employeeRole;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", userEmailId="
				+ userEmailId + ", userEmpId=" + userEmpId + ", empName=" + empName + ", empDob=" + empDob
				+ ", employeeRole=" + employeeRole + "]";
	}

}
