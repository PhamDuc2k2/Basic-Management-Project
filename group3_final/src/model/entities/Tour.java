package model.entities;

import java.io.Serializable;


public class Tour extends Product implements Serializable {
    private static final long serialVersionUID = 1L;
	private String tour_place;
    private int tour_time;

    public Tour() {
    }

    public Tour(String tour_place, int tour_time) {
        this.tour_place = tour_place;
        this.tour_time = tour_time;
    }

    public Tour(String product_id, String product_name, double product_price, long product_time, String tour_place, int tour_time) {
        super(product_id, product_name, product_price, product_time);
        this.tour_place = tour_place;
        this.tour_time = tour_time;
    }

    public String getTour_place() {
        return tour_place;
    }

    public void setTour_place(String tour_place) {
        this.tour_place = tour_place;
    }

    public int getTour_time() {
        return tour_time;
    }

    public void setTour_time(int tour_time) {
        this.tour_time = tour_time;
    }
    
    public boolean isEqual(Tour t) {
      if (!t.getProduct_id().equals(super.getProduct_id())) return false;
      if (!t.getProduct_name().equals(super.getProduct_name())) return false;
      if (t.getProduct_price()!=super.getProduct_price()) return false;
      if (t.getProduct_total()!=super.getProduct_total()) return false;
      if (!t.getTour_place().equals(tour_place)) return false;
      if (t.getTour_time()!=tour_time) return false;
      return true;
    }
    
    
}
