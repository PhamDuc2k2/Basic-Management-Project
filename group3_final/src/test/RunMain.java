package test;

import java.io.IOException;

import view.LoginGUI;

public class RunMain {
	public static void main(String[] args) {
		try {
			LoginGUI login = new LoginGUI();
			login.setResizable(false);
			login.setLocationRelativeTo(null);
			login.setVisible(true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
