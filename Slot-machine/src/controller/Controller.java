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
		window.getLblMonete().setText("<html><center>MONETE<br>" + Integer.toString(slot.getMonete())
				+ "</center></html>");
		window.setVisible(true);
		window.getBtnGioca().addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		window.getLblGif().setVisible(false);
		window.getLblPng().setVisible(false);
		window.getLblPng2().setVisible(false);
		window.getBtnGioca().setEnabled(false);
		window.updateImg1();
		slot.gioca();
		new Thread(() -> {//cosi chiamando la sleep non vado a toccare il thread della gui
			for (int i = 0; i < 11; i++) {
				int cc = i % 4;
				String txt = "GIOCANDO";
				SwingUtilities.invokeLater(() -> {//invokelater per andare a chiamare il prima possibile questo codice
					if (cc == 0) {
						window.getLblVincita().setText(txt);
					} else if (cc == 1) {
						window.getLblVincita().setText(txt + ".");
					} else if (cc == 2) {
						window.getLblVincita().setText(txt + "..");
					} else if (cc == 3) {
						window.getLblVincita().setText(txt + "...");
					}
				});
				for (int j = 0; j < 10; j++) {
					int c = j;
					try {
						Thread.sleep(10);
					} catch (InterruptedException ex) {
						ex.printStackTrace();
					}
					SwingUtilities.invokeLater(() -> {
						window.getBox1().setText(Integer.toString(c));
						window.getBox2().setText(Integer.toString(c));
						window.getBox3().setText(Integer.toString(c));
					});
				}
			}
			slot.generaNumeri();
			int[] n = slot.getNumeri();
			SwingUtilities.invokeLater(() -> {
				window.getBox1().setText(Integer.toString(n[0]));
				window.getBox2().setText(Integer.toString(n[1]));
				window.getBox3().setText(Integer.toString(n[2]));
			});
			int nu = slot.getNumeriUguali();
			if (nu == 0) {
				window.getLblVincita().setText("Hai perso");
			} else if (nu == 2) {
				window.getLblPng().setVisible(true);
				window.getLblVincita().setText("<html><center>HAI<br> VINTO 3 MONETE!</center></html>");
			} else {
				window.resetImg1();
				window.getLblPng().setVisible(true);
				window.getLblPng2().setVisible(true);
				window.getLblGif().setVisible(true);
				window.getLblVincita().setText("<html><center>JACKPOT<br>HAI VINTO " + slot.getJackpot()
						+ " MONETE!</center></html>");
			}
			window.getLblMonete().setText("<html><center>MONETE<br>" + Integer.toString(slot.getMonete())
					+ "</center></html>");
			window.getBtnGioca().setEnabled(true);
		}).start();
		
	}
	
}
