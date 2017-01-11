package com.shop.cart;

public class Product {
private String productname;
private int price,quantity,total;
public int getTotal() {
	return total;
}
public void setTotal(int total) {
	this.total = total;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public String getProductname() {
	return productname;
}
public void setProductname(String productname) {
	this.productname = productname;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
} 
}
