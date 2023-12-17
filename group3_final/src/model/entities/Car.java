package model.entities;

import java.io.Serializable;

public class Car extends Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final double CYLINDER_CAPACITY = 0;
	public static final int SEAT = 0;
	
	private double cylinderCapacity;
	private int seat;
	
	
	
	public Car() {
		this(Car.ID, Car.NAME, Car.PRICE, Car.TOTAL, Car.CYLINDER_CAPACITY, Car.SEAT);
	}

	public Car(String product_id, String product_name, double product_price, long total, double cylinderCapacity,
			int seat) {
		super(product_id, product_name, product_price, total);
		this.cylinderCapacity = cylinderCapacity;
		this.seat = seat;
	}

	public double getCylinderCapacity() {
		return cylinderCapacity;
	}

	public int getSeat() {
		return seat;
	}

	public void setCylinderCapacity(double cylinderCapacity) {
		this.cylinderCapacity = cylinderCapacity;
	}

	public void setSeat(int seat) {
		this.seat = seat;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		return super.equals(obj) && Double.doubleToLongBits(cylinderCapacity) == Double.doubleToLongBits(other.cylinderCapacity)
				&& seat == other.seat;
	}
}
