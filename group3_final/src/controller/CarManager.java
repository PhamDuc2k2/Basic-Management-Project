package controller;

import java.util.List;

import model.entities.Car;

public interface CarManager {
	public boolean addCar(Car c);
	public boolean editCar(Car c);
	public boolean delCar(Car c);
	public List<Car> searchCar(String name);
	public List<Car> searchCar(double price);
	public List<Car> searchCar(int total);
	public List<Car> searchCarByCylinder(double cylinder);
	public List<Car> searchCarBySeat(int seat);
	public List<Car> sortedCar(double price, boolean isINC);
	public List<Car> sortedCarByCylinder(double cylinder, boolean isINC);
}
