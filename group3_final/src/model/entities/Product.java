package model.entities;

import java.io.Serializable;
import java.util.Objects;
import java.util.Scanner;

public class Product implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static Scanner sc = new Scanner(System.in);
	
	public static final String ID = "NO ID";
	public static final String NAME = "NO NAME";
	public static final double PRICE = 0;
	public static final long TOTAL = 0;
	
	protected String product_id;
	protected String product_name;
	protected double product_price;
	protected long product_total;
	
	
	
	public Product() {
		this(Product.ID, Product.NAME, Product.PRICE, Product.TOTAL);
	}



	public Product(String product_id, String product_name, double product_price, long total) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_price = product_price;
		this.product_total = total;
	}




	public String getProduct_id() {
		return product_id;
	}



	public String getProduct_name() {
		return product_name;
	}



	public double getProduct_price() {
		return product_price;
	}



	public long getProduct_total() {
		return product_total;
	}



	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}



	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}



	public void setProduct_price(double product_price) {
		this.product_price = product_price;
	}



	public void setProduct_total(long product_total) {
		this.product_total = product_total;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(product_name, other.product_name)
				&& Double.doubleToLongBits(product_price) == Double.doubleToLongBits(other.product_price)
				&& product_total == other.product_total;
	}
}
