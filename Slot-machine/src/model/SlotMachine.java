package model;

public class SlotMachine {
	private int[] numeri;
	private int monete;
	private int jackpot;
	
	public SlotMachine() {
		this.numeri = new int[3];
		this.monete = 100;
		this.jackpot = 200;
	}
	
	public void generaNumeri() {
		for (int i = 0; i < numeri.length; i++) {
			numeri[i] = (int) (Math.random() * 10);
		}
	}
	
	public int[] getNumeri() {
		return numeri;
	}
	
	public int getMonete() {
		return monete;
	}
	
	public int getJackpot() {
		return jackpot;
	}
	
	public void gioca() {
		monete -= 1;
		jackpot += 1;
	}
	
	public int getNumeriUguali() {
		if (numeri[0] == numeri[1] && numeri[1] == numeri[2]) {
			return 3;
		} else if (numeri[0] == numeri[1] || numeri[0] == numeri[2] || numeri[1] == numeri[2]) {
			return 2;
		}
		return 0;
	}
	public void aggiornaValori() {
		int n = getNumeriUguali();
		switch(n) {
			case 2:{
				jackpot -= 3;
				monete += 3;
			}break;
			case 3:{
				monete += jackpot;
				jackpot=0;
			}break;
			default: break;
		}
	}
	public boolean isGiocoFinito() {
		return (jackpot == 0 || monete ==0) ? true : false;
	}
}
