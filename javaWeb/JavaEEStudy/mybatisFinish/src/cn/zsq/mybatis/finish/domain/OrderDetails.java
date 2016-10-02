package cn.zsq.mybatis.finish.domain;

public class OrderDetails {
	private int id;
	private int ordersId;
	private int itemsId;
	private int itemsSum;
	
	private Orders orders;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrdersId() {
		return ordersId;
	}
	public void setOrdersId(int ordersId) {
		this.ordersId = ordersId;
	}
	public int getItemsId() {
		return itemsId;
	}
	public void setItemsId(int itemsId) {
		this.itemsId = itemsId;
	}
	public int getItemsSum() {
		return itemsSum;
	}
	public void setItemsSum(int itemsSum) {
		this.itemsSum = itemsSum;
	}
	public OrderDetails(int id, int ordersId, int itemsId, int itemsSum) {
		super();
		this.id = id;
		this.ordersId = ordersId;
		this.itemsId = itemsId;
		this.itemsSum = itemsSum;
	}
	public OrderDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "OrderDetails [id=" + id + ", ordersId=" + ordersId
				+ ", itemsId=" + itemsId + ", itemsSum=" + itemsSum + "]";
	}
	public Orders getOrders() {
		return orders;
	}
	public void setOrders(Orders orders) {
		this.orders = orders;
	}
}
