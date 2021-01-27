package com.mascene.entities;

/**
 * @author Raman.Ahuja
 * 
 *         Enum for Employee Role
 *
 */
public enum EmployeeRole {

	ADMIN("Admin"), SALES_ASSOCIATE("SalesAssociate");

	public String getEmployeeRole() {
		return this.employeeRole;
	}

	private String employeeRole;

	EmployeeRole(String employeeRole) {
		this.employeeRole = employeeRole;
	}

}
