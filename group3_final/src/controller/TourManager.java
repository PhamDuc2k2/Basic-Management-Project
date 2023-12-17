package controller;

import java.util.List;

import model.entities.Tour;

/**
 *
 * @author admin
 */
public interface TourManager {
    public boolean addTour(Tour t);
    public boolean editTour(Tour t);
    public boolean delTour(Tour t);
    public List<Tour> searchTourByName(String name);
    public List<Tour> searchTourByPrice(double price);
    public List<Tour> searchTourByTime(int time);
    public List<Tour> sortedTour(double price);
}
