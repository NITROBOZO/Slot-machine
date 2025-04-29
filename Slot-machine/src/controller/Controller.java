package controller;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

import model.SlotMachine;
import view.*;

public class Controller implements ActionListener {
	private SlotMachine slot;
	private GameWindow window;
	private AudioPlayer bgm;
	private AudioPlayer loseSfx;
	private AudioPlayer winSfx;
	private AudioPlayer jackpotSfx;
	
	public Controller() {
		bgm = new AudioPlayer("/sounds/bgm.wav");
		loseSfx = new AudioPlayer("/sounds/lose.wav");
		winSfx = new AudioPlayer("/sounds/win.wav");
		jackpotSfx = new AudioPlayer("/sounds/bigwin.wav");
		bgm.loop();
		window = new GameWindow();
		slot = new SlotMachine();
		window.getLblMonete().setText("<html><center>MONETE<br>" + slot.getMonete()
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
		slot.gioca();
		window.getLblMonete().setText("<html><center>MONETE<br>" + slot.getMonete()
		+ "</center></html>");
		new Thread(() -> {
			for (int i = 0; i < 11; i++) {
				int cc = i % 4;
				String txt = "GIOCANDO";
				SwingUtilities.invokeLater(() -> {
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
				updateImg1ForLose();
				window.getLblPng().setVisible(true);
				loseSfx.play();
				window.getLblVincita().setText("Hai perso");
			} else if (nu == 2) {
				updateImg1();
				window.getLblPng().setVisible(true);
				winSfx.play();
				window.getLblVincita().setText("<html><center>HAI<br> VINTO 3 MONETE!</center></html>");
			} else {
				resetImg1();
				window.getLblPng().setVisible(true);
				window.getLblPng2().setVisible(true);
				window.getLblGif().setVisible(true);
				jackpotSfx.play();
				window.getLblVincita().setText("<html><center>JACKPOT<br>HAI VINTO " + slot.getJackpot()
						+ " MONETE!</center></html>");
			}
			slot.aggiornaValori();
			window.getLblMonete().setText("<html><center>MONETE<br>" + slot.getMonete()
					+ "</center></html>");
			if(!slot.isGiocoFinito()) {
				window.getBtnGioca().setEnabled(true);
			}
			
		}).start();
		
	}
	private void resetImg1() {
	    window.setUpdatingImg(GameWindow.IMG[0]);
	    Image scaledImage = window.scalaImg(window.getUpdatingImg());
	    window.getLblPng().setIcon(new ImageIcon(scaledImage));
	}
	private void updateImg1() {
		Double n;
			n = Math.random();
			if(n<=0.333) {
				window.setUpdatingImg(GameWindow.IMG[0]);
			}
			else if(n<=0.666) {
				window.setUpdatingImg(GameWindow.IMG[1]);
			}
			else {
				window.setUpdatingImg(GameWindow.IMG[2]);
			}
			Image scaledImage = window.scalaImg(window.getUpdatingImg());
			window.getLblPng().setIcon(new ImageIcon(scaledImage));
	}
	private void updateImg1ForLose() {
		Double n;
			n = Math.random();
			if(n<=0.333) {
				window.setUpdatingImg(GameWindow.IMG[3]);
			}
			else if(n<=0.666) {
				window.setUpdatingImg(GameWindow.IMG[4]);
			}
			else {
				window.setUpdatingImg(GameWindow.IMG[5]);
			}
			Image scaledImage = window.scalaImg(window.getUpdatingImg());
			window.getLblPng().setIcon(new ImageIcon(scaledImage));
	}
	
}
