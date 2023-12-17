package model.lists;

import java.util.ArrayList;
import java.util.List;

import model.entities.CarX;

public class ListCarXs {
private List<CarX> list = new ArrayList<CarX>();
	
	public List<CarX> getList() {
		return list;
	}

	public void setList(List<CarX> list) {
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
	
	private String createColor() {
		String[] colors = {
				"Red", "Blue", "Orange", "Green","Yellow", "White", "Pink", "Purple", "Brown", "Gray"
		};
		return colors[(int)(Math.random() * colors.length)];
	}

	public void init(int n) {
		for(int i = 1; i <= n; i++) {
			list.add(new CarX(String.valueOf(i),createName(),createPrice() , createTotal(), createCylinder(), createColor()));
		}
	}

}
