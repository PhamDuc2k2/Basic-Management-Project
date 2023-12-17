package model.lists;

import java.util.LinkedList;
import java.util.List;

import controller.TourManager;
import model.entities.Tour;


public class ListTours {
    private List<Tour> tour = new LinkedList<>();
    
    private String initName() {
    	String[] names = {
    		"Sinh thái", "Văn hóa", "Nghỉ dưỡng", "Giải trí", "Thể thao",
    		"Khám phá","Mạo hiểm","Biển", "Núi", "Quốc tế", "Trong nước","Ẩm thực"
    	};
    	return names[(int)(Math.random() * names.length )];
    }
    
    private double initPrice() {
    	return (double)Math.round(((Math.random() * (200 - 10 + 1)) + 10 ) * 10) / 10 ;
    }
    
    private long initTotal() {
		return (long)(Math.random() * 50);
	}
    
    private String initPlace() {
    	String[] places = {
    		"Hà Nội", "Hà Nam", "Hà Tĩnh", "Hưng Yên", "Thanh Hóa", "Nam Định", "Hải Dương",
    		"Đà Nẵng", "Đà Lạt", "TP. HCM", "Nha Trang", "Khánh Hòa", "Ninh Bình", "Thái Nguyên"
    	};
    	return places[(int)(Math.random() * places.length )];
    }
    
    private int initTime() {
		return (int)(Math.random() * 30);
	}
    
    public void init(int n) {
    	for(int i = 1; i<= n; i++)
    		getTour().add(new Tour(String.valueOf(i), initName(), initPrice(), initTotal(), initPlace(), initTime()));
    }
    
    
    
    public List<Tour> getTour() {
		return tour;
	}

    public void setTour(List<Tour> tour) {
    	this.tour = tour;
    }

	public TourManager getM() {
		return m;
	}

	public void setM(TourManager m) {
		this.m = m;
	}



	private TourManager m = new TourManager() {
        @Override
        public boolean addTour(Tour t) {
            getTour().add(t);
            return true;
        }

        @Override
        public boolean editTour(Tour t) {
            for (int i = 0; i < getTour().size(); i++) {
                if (getTour().get(i).getProduct_id().equals(t.getProduct_id())) {
                    getTour().set(i, t);
                    return true;
                }
            }
            return false;
        }

        @Override
        public boolean delTour(Tour t) {
            int pos = -1;
            for (int i = 0; i < getTour().size(); i++) {
                if (getTour().get(i).isEqual(t)) {
                    pos = i;
                }
            }
            if (pos != -1) {
                getTour().remove(pos);
                return true;
            }
            return false;
        }

        @Override
        public List<Tour> searchTourByName(String name) {
            List<Tour> listTour = new LinkedList<>();
            for (Tour i : getTour()) {
                if (i.getProduct_name().equals(name)) {
                    listTour.add(i);
                }
            }
            return listTour;
        }

        @Override
        public List<Tour> searchTourByPrice(double price) {
            List<Tour> listTour = new LinkedList<>();
            for (Tour i : getTour()) {
                if (i.getProduct_price()==price) {
                    listTour.add(i);
                }
            }
            return listTour;
        }

        @Override
        public List<Tour> searchTourByTime(int time) {
            List<Tour> listTour = new LinkedList<>();
            for (Tour i : getTour()) {
                if (i.getTour_time()==time) {
                    listTour.add(i);
                }
            }
            return listTour;
        }

        @Override
        public List<Tour> sortedTour(double price) {
            List<Tour> listTour = new LinkedList<>();
            for (Tour i : getTour()) {
                listTour.add(i);
            }
            for (int i = 0; i < listTour.size() - 1; i++) {
                for (int j = i + 1; j < listTour.size(); j++) {
                    if (listTour.get(i).getProduct_price() > listTour.get(j).getProduct_price()) {
                        Tour temp = listTour.get(i);
                        listTour.set(i, listTour.get(j));
                        listTour.set(j, temp);
                    }
                }
            }
            return listTour;
        }
    };
}
