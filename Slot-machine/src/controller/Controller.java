package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

import model.SlotMachine;
import view.GameWindow;

public class Controller implements ActionListener {
    private SlotMachine slot;
    private GameWindow window;

    public Controller() {
	window = new GameWindow();
	slot = new SlotMachine();
	window.getLblMonete()
		.setText("<html><center>MONETE<br>" + Integer.toString(slot.getMonete()) + "</center></html>");
	window.setVisible(true);
	window.getBtnGioca().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
	window.getBtnGioca().setEnabled(false);
	slot.gioca();
	new Thread(()-> {
	    for(int i=0;i<10;i++) {
		for(int j=0;j<10;j++) {
		    int c = j;
		    try {
			Thread.sleep(10);
		    }catch(InterruptedException ex) {
			ex.printStackTrace();
		    }
		    SwingUtilities.invokeLater(()->{
			window.getBox1().setText(Integer.toString(c));
			window.getBox2().setText(Integer.toString(c));
			window.getBox3().setText(Integer.toString(c));
		    });
		}
	    }	
	    	slot.generaNumeri();
		int[] n = slot.getNumeri();
		SwingUtilities.invokeLater(()->{
		    	window.getBox1().setText(Integer.toString(n[0]));
			window.getBox2().setText(Integer.toString(n[1]));
			window.getBox3().setText(Integer.toString(n[2]));
		    });
		int nu = slot.getNumeriUguali();
		if (nu == 0) {
		    window.getLblVincita().setText("hai perso");
		} else if (nu == 2) {
		    window.getLblVincita().setText("hai vinto 3 monete");
		} else {
		    window.getLblVincita().setText("<html><center>JACKPOT</center><br>hai vinto " + slot.getJackpot() + " monete</html>");
		}
		window.getLblMonete().setText("<html><center>MONETE<br>" + Integer.toString(slot.getMonete()) + "</center></html>");
		window.getBtnGioca().setEnabled(true);
	}).start();
	
    }

}
