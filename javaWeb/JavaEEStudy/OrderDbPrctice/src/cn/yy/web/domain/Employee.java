package cn.yy.web.domain;

public class Employee {
   private String employeeNo;
   private String employeeName;
   private String gender;
   private String birthday;
   private String address;
   private String telephone;
   private String hireDate;
   private String department;
   private String headShip;
   private double salary;
   
   
public Employee(String employeeNo, String employeeName, String gender,
		String birthday, String address, String telephone, String hireDate,
		String department, String headShip, double salary) {
	super();
	this.employeeNo = employeeNo;
	this.employeeName = employeeName;
	this.gender = gender;
	this.birthday = birthday;
	this.address = address;
	this.telephone = telephone;
	this.hireDate = hireDate;
	this.department = department;
	this.headShip = headShip;
	this.salary = salary;
}


public Employee() {
	super();
}


public String getEmployeeNo() {
	return employeeNo;
}
public void setEmployeeNo(String employeeNo) {
	this.employeeNo = employeeNo;
}
public String getEmployeeName() {
	return employeeName;
}
public void setEmployeeName(String employeeName) {
	this.employeeName = employeeName;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getBirthday() {
	return birthday;
}
public void setBirthday(String birthday) {
	this.birthday = birthday;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getTelephone() {
	return telephone;
}
public void setTelephone(String telephone) {
	this.telephone = telephone;
}
public String getHireDate() {
	return hireDate;
}
public void setHireDate(String hireDate) {
	this.hireDate = hireDate;
}
public String getDepartment() {
	return department;
}
public void setDepartment(String department) {
	this.department = department;
}
public String getHeadShip() {
	return headShip;
}
public void setHeadShip(String headShip) {
	this.headShip = headShip;
}
public double getSalary() {
	return salary;
}
public void setSalary(double salary) {
	this.salary = salary;
}
@Override
public String toString() {
	return "Employee [employeeNo=" + employeeNo + ", employeeName="
			+ employeeName + ", gender=" + gender + ", birthday=" + birthday
			+ ", address=" + address + ", telephone=" + telephone
			+ ", hireDate=" + hireDate + ", department=" + department
			+ ", headShip=" + headShip + ", salary=" + salary + "]";
}
   
   
   
   
   
   
   
}
