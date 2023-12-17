package model.entities;

import java.io.Serializable; 

public class Mobile extends Product implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	// properties
	private String mobile_brand;
	private double mobile_battery;
	private int mobile_memory;

	
	// constructors
	public Mobile() {
		
	}
	
	public Mobile(String product_id, String product_name, double product_price, int product_total, String mobile_brand,
			double mobile_battery, int mobile_memory) {
		super(product_id, product_name, product_price, product_total);
		this.mobile_brand = mobile_brand;
		this.mobile_battery = mobile_battery;
		this.mobile_memory = mobile_memory;
	}
	
	// getters and setters
	
	
	public String getMobile_brand() {
		return mobile_brand;
	}
	public void setMobile_brand(String mobile_brand) {
		this.mobile_brand = mobile_brand;
	}
	public double getMobile_battery() {
		return mobile_battery;
	}
	public void setMobile_battery(double mobile_battery) {
		this.mobile_battery = mobile_battery;
	}
	public int getMobile_memory() {
		return mobile_memory;
	}
	public void setMobile_memory(int mobile_memory) {
		this.mobile_memory = mobile_memory;
	}

}
