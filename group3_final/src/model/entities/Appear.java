package model.entities;

import java.io.Serializable;

public class Appear implements Serializable{
	private static final long serialVersionUID = 1L;
	private String name; 
	private int total; 
	
	public Appear() {
		this(null, 0);
	}
	
	public Appear(String name, int total) {
		this.name = name; 
		this.total = total; 
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
}
