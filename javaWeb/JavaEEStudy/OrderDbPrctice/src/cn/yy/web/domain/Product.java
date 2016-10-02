package cn.yy.web.domain;

public class Product {
    private String productNo;
    private String productName;
    private String productClass;
    private double productPrice;
    private int inStock;
    
    
    
	public Product(String productNo, String productName, String productClass,
			double productPrice, int inStock) {
		super();
		this.productNo = productNo;
		this.productName = productName;
		this.productClass = productClass;
		this.productPrice = productPrice;
		this.inStock = inStock;
	}
	
	public Product() {
		super();
	}

	public String getProductNo() {
		return productNo;
	}
	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductClass() {
		return productClass;
	}
	public void setProductClass(String productClass) {
		this.productClass = productClass;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public int getInStock() {
		return inStock;
	}
	public void setInStock(int inStock) {
		this.inStock = inStock;
	}
	
	@Override
	public String toString() {
		return "Product [productNo=" + productNo + ", productName="
				+ productName + ", productClass=" + productClass
				+ ", productPrice=" + productPrice + ", inStock=" + inStock
				+ "]";
	}
    
    
    
    
    
}
