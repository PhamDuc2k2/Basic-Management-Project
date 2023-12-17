package controller;

import java.util.List;

import model.entities.CarX;

public interface CarXManager {
	public boolean addCar(CarX c);
	public boolean editCar(CarX c);
	public boolean delCar(CarX c);
	public List<CarX> searchCar(String name);
	public List<CarX> searchCar(double price);
	public List<CarX> searchCar(int total);
	public List<CarX> searchCarByCylinder(double cylinder);
	public List<CarX> searchCarByColor(String color);
	public List<CarX> sortedCar(double price, boolean isINC);
	public List<CarX> sortedCarByCylinder(double cylinder, boolean isINC);
}
