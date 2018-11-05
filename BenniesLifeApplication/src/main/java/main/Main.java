package main;

import connectionToDatabase.PreFillDatabase;
import login.MainLoginApp;

public class Main {

	public static void main(String[] args) {
		
			new PreFillDatabase();
			
			MainLoginApp mLA = new MainLoginApp();
			mLA.Load();
			
		
	}

}
