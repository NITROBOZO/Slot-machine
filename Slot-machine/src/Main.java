import java.awt.EventQueue;

import controller.Controller;

public class Main {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Controller frame = new Controller();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}
	
}
