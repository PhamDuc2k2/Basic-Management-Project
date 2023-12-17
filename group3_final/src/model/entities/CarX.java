package model.entities;

import java.io.Serializable;
import java.util.Objects;

public class CarX extends Product implements Serializable {
	public static final double CYLINDER_CAPACITY = 0;
	public static final String COLOR = "NO COLOR";
	
	private double cylinder;
	private String color;
	
	public CarX() {
		this(CarX.ID, CarX.NAME, CarX.PRICE, CarX.TOTAL, CarX.CYLINDER_CAPACITY, CarX.COLOR);
	}
	
	public CarX(String product_id, String product_name, double product_price, long total, double cylinder,
			String color) {
		super(product_id, product_name, product_price, total);
		this.cylinder = cylinder;
		this.color = color;
	}

	public double getCylinder() {
		return cylinder;
	}

	public String getColor() {
		return color;
	}

	public void setCylinder(double cylinder) {
		this.cylinder = cylinder;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		CarX other = (CarX) obj;
		return super.equals(obj) && Objects.equals(color, other.color)
				&& Double.doubleToLongBits(cylinder) == Double.doubleToLongBits(other.cylinder);
	}
	
	
	
}
