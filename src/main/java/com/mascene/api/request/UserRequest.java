package com.mascene.api.request;

import java.util.Date;

/**
 * @author Raman.Ahuja
 *
 *         Class to make a request to the api for User CRUD operations
 *
 */
public class UserRequest {

	private String userName;

	private String password;

	private String userEmailId;

	private int userEmpId;

	private String empName;

	private Date empDob;

	private String employeeRole;

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
		return "UserRequest [userName=" + userName + ", password=" + password + ", userEmailId=" + userEmailId
				+ ", userEmpId=" + userEmpId + ", empName=" + empName + ", empDob=" + empDob + ", employeeRole="
				+ employeeRole + "]";
	}

}
