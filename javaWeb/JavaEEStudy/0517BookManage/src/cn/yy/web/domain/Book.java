package cn.yy.web.domain;

public class Book {
 private String bid;
 private String bname;
 private float  price;
 private int category;
 
 public String getBid() {
	return bid;
}
public void setBid(String bid) {
	this.bid = bid;
}
public String getBname() {
	return bname;
}
public void setBname(String bname) {
	this.bname = bname;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}
@Override
public String toString() {
	return "Book [bid=" + bid + ", bname=" + bname + ", price=" + price
			+ ", category=" + category + "]";
}
public int getCategory() {
	return category;
}
public void setCategory(int category) {
	this.category = category;
}

 
}
