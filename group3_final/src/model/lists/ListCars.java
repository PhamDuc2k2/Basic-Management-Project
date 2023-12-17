package model.lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.entities.Car;

public class ListCars {
	private List<Car> list = new ArrayList<Car>();
	
	public List<Car> getList() {
		return list;
	}

	public void setList(List<Car> list) {
		this.list = list;
	}
	
	private String createName() {
		String[] names = {
				"Honda", "Toyota", "Lexus", "Suzuki", "Bentley", "Randrover",
				"Roll-Royce", "Huyndai", "Kia", "Ford", "Chryler", "BMW",
				"Mercedes-benz"
		};
		return names[(int)(Math.random() *names.length )];
	}
	
	
	private double createPrice() {
		return (double)Math.round(((Math.random() * (100 - 2 + 1)) + 2 ) * 10) / 10 ;
	}
	
	private int createTotal() {
		return (int)(Math.random() * 5000);
	}
	
	private double createCylinder() {
		return (double)Math.round(((Math.random() * (8 - 2 + 1)) + 2) * 10) / 10 ;
	}
	
	private int createSeat() {
		return (int)((Math.random() * (4-1))+1);
	}

	public void init(int n) {
		for(int i = 1; i <= n; i++) {
			list.add(new Car(String.valueOf(i),createName(),createPrice() , createTotal(), createCylinder(), createSeat()));
		}
	}

}


