package controller;
import java.util.List;

import model.entities.Mobile;

public interface MobileManager {
	// them 1 san pham vao kho
	public boolean addMobile(Mobile m);
	// sua 1 san pham
	public boolean editMobile(Mobile m); 
	// xoa 1 san pham khoi kho
	public boolean delMobile(Mobile m);
	// tim kiem san pham 
	public List<Mobile> searchMobile(String name);
	// sap xep theo gia tang hoac giam
	public List<Mobile> sortedMobile(double price);
}
