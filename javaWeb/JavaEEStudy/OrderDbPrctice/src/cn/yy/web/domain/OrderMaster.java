package cn.yy.web.domain;

public class OrderMaster {
   private String orderNo;
   private String customerNo;
   private String employeeNo;
   private String orderDate;
   private double orderSum;
   private String invoiceNo;
   
   
   
public OrderMaster(String orderNo, String customerNo, String employeeNo,
		String orderDate, double orderSum, String invoiceNo) {
	super();
	this.orderNo = orderNo;
	this.customerNo = customerNo;
	this.employeeNo = employeeNo;
	this.orderDate = orderDate;
	this.orderSum = orderSum;
	this.invoiceNo = invoiceNo;
}


public OrderMaster() {
	super();
}


public String getOrderNo() {
	return orderNo;
}
public void setOrderNo(String orderNo) {
	this.orderNo = orderNo;
}
public String getCustomerNo() {
	return customerNo;
}
public void setCustomerNo(String customerNo) {
	this.customerNo = customerNo;
}
public String getEmployeeNo() {
	return employeeNo;
}
public void setEmployeeNo(String employeeNo) {
	this.employeeNo = employeeNo;
}
public String getOrderDate() {
	return orderDate;
}
public void setOrderDate(String orderDate) {
	this.orderDate = orderDate;
}
public double getOrderSum() {
	return orderSum;
}
public void setOrderSum(double orderSum) {
	this.orderSum = orderSum;
}
public String getInvoiceNo() {
	return invoiceNo;
}
public void setInvoiceNo(String invoiceNo) {
	this.invoiceNo = invoiceNo;
}
@Override
public String toString() {
	return "OrderMaster [orderNo=" + orderNo + ", customerNo=" + customerNo
			+ ", employeeNo=" + employeeNo + ", orderDate=" + orderDate
			+ ", orderSum=" + orderSum + ", invoiceNo=" + invoiceNo + "]";
}
   
   
   
   
}
