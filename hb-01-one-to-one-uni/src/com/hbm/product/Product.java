package com.hbm.product;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Product {

	public Product(int pid, String productName, int price) {
		this.pid = pid;
		this.productName = productName;
		this.price = price;
	}

	public Product() {}
	
	@Id
	private int pid;
	
	private String productName;
	
	private int price;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", productName=" + productName + ", price=" + price + "]";
	}
}
