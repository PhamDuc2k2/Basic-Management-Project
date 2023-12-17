package model.lists;

import java.util.ArrayList;

import model.entities.Mobile;

public class ListMobiles {
	
	private ArrayList<Mobile> list= new ArrayList<>();
	
	
	
	public ArrayList<Mobile> getList() {
		return list;
	}

	public void setList(ArrayList<Mobile> list) {
		this.list = list;
	}

	private String initName() {
		String[] names = {
			"Realme ", "Realme i",
			"Samsung Galaxy Z", "Samsung Galaxy S", "Samsung Galaxy A", "Samsung Galaxy Note ",
			"Oppo Reno ", "Oppo Find ", "Oppo Find X"
		};
		return names[(int)(Math.random() * names.length )] + (int)(Math.random() * (10-5 + 1) + 5);
	}
	
	private double initPrice() {
    	return (double)Math.round(((Math.random() * (30 - 10 + 1)) + 10 ) * 10) / 10 ;
    }
	
	private int initTotal() {
		return (int)(Math.random() * 500);
	}
	
	private double initBattery() {
		return (double)Math.round(((Math.random() * (5000 - 1000 + 1)) + 1000 )) ;
	}
	
	private int initMemory() {
		return (int)(Math.random()*512);
	}
	
	public void init(int n) {
		for(int i = 1; i <= n; i++) {
			String tmpName = initName();
			list.add(new Mobile(String.valueOf(i), tmpName, initPrice(), initTotal(), tmpName.substring(0, tmpName.indexOf(" ")), initBattery(), initMemory()));
		}
	}
	
	
}
