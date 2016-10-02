package cn.yy.web.domain;

public class OrderDetail {
    private String orderNo;
    private String productNo;
    private int quantity;
    private double price;
    
    
    
	public OrderDetail(String orderNo, String productNo, int quantity,
			double price) {
		super();
		this.orderNo = orderNo;
		this.productNo = productNo;
		this.quantity = quantity;
		this.price = price;
	}
	
	
	public OrderDetail() {
		super();
	}


	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getProductNo() {
		return productNo;
	}
	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "OrderDetail [orderNo=" + orderNo + ", productNo=" + productNo
				+ ", quantity=" + quantity + ", price=" + price + "]";
	}
    
    
}
