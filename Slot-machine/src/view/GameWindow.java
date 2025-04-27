package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.Component;

public class GameWindow extends JFrame {
	private static final String[] IMAGES = {"/view/OK1.png","/view/OK2.png","/view/OK3.gif"};
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField box1;
	private JTextField box3;
	private JTextField box2;
	private JLabel lblVincita;
	private JLabel lblMonete;
	private JButton btnGioca;
	private JLabel lblPng;
	private JLabel lblPng2;
	private JLabel lblGif;
	private ImageIcon image;
	
	public JTextField getBox1() {
		return box1;
	}
	
	public JTextField getBox3() {
		return box3;
	}
	
	public JTextField getBox2() {
		return box2;
	}
	
	public JLabel getLblVincita() {
		return lblVincita;
	}
	
	public JLabel getLblMonete() {
		return lblMonete;
	}
	
	public JButton getBtnGioca() {
		return btnGioca;
	}
	
	public JLabel getLblPng() {
		return lblPng;
	}
	
	public JLabel getLblPng2() {
		return lblPng2;
	}
	
	public JLabel getLblGif() {
		return lblGif;
	}
	
	
	public GameWindow() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 4, 5, 0));
		
		
		contentPane.add(new JLabel());
		
		
		lblPng = new JLabel();
		image = new ImageIcon(GameWindow.class.getResource(IMAGES[0]));
		Image scaledImage = image.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		lblPng.setIcon(new ImageIcon(scaledImage));
		lblPng.setVisible(false);
		lblPng.setHorizontalAlignment(JLabel.CENTER);
		contentPane.add(lblPng);
		
		
		contentPane.add(new JLabel());
		contentPane.add(new JLabel());
		
		
		box1 = new JTextField();
		box1.setEnabled(false);
		box1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		box1.setHorizontalAlignment(JLabel.CENTER);
		box1.setBackground(Color.WHITE);
		box1.setDisabledTextColor(Color.BLACK);
		contentPane.add(box1);
		box1.setColumns(10);
		
		box2 = new JTextField();
		box2.setEnabled(false);
		box2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		box2.setHorizontalAlignment(JLabel.CENTER);
		box2.setBackground(Color.WHITE);
		box2.setDisabledTextColor(Color.BLACK);
		contentPane.add(box2);
		box2.setColumns(10);
		
		box3 = new JTextField();
		box3.setEnabled(false);
		box3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		box3.setHorizontalAlignment(JLabel.CENTER);
		box3.setBackground(Color.WHITE);
		box3.setDisabledTextColor(Color.BLACK);
		contentPane.add(box3);
		box3.setColumns(10);
		
		btnGioca = new JButton("GO!");
		btnGioca.setBackground(new Color(255, 255, 255));
		btnGioca.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnGioca.setFocusPainted(false);
		contentPane.add(btnGioca);
		
		lblGif = new JLabel();
		ImageIcon gif = new ImageIcon(GameWindow.class.getResource(IMAGES[2]));
		Image scaledGif = gif.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		lblGif.setIcon(new ImageIcon(scaledGif));
		lblGif.setVisible(false);
		lblGif.setHorizontalAlignment(JLabel.CENTER);
		contentPane.add(lblGif);
		
		lblVincita = new JLabel("");
		lblVincita.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblVincita.setHorizontalAlignment(JLabel.CENTER);
		lblVincita.setForeground(Color.WHITE);
		contentPane.add(lblVincita);
		
		lblPng2 = new JLabel();
		ImageIcon image2 = new ImageIcon(GameWindow.class.getResource(IMAGES[1]));
		Image scaledImage2 = image2.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		lblPng2.setIcon(new ImageIcon(scaledImage2));
		lblPng2.setVisible(false);
		lblPng2.setHorizontalAlignment(JLabel.CENTER);
		contentPane.add(lblPng2);
		
		lblMonete = new JLabel("Monete: ");
		lblMonete.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMonete.setHorizontalAlignment(JLabel.CENTER);
		lblMonete.setForeground(Color.WHITE);
		contentPane.add(lblMonete);
		setBackground(Color.BLACK);
		setMinimumSize(new Dimension(450,300));
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				fontSet(lblPng,image);
				fontSet(lblPng2,image2);
				fontSet(lblGif,gif);
				fontSet(box1);
				fontSet(box2);
				fontSet(box3);
				fontSet(lblMonete);
				fontSet(lblVincita);
				fontSet(btnGioca);
			}
		});
	}
	private void fontSet(JLabel lbl, ImageIcon i) {
		Image scaledImage = i.getImage().getScaledInstance((int) (contentPane.getWidth() / 4.5), contentPane.getHeight()
				/ 3, Image.SCALE_DEFAULT);
		lbl.setIcon(new ImageIcon(scaledImage));
		}
	private void fontSet(Object i) {
		int w = contentPane.getWidth();
		if(i.getClass()==JLabel.class) {
			 JLabel j = (JLabel) i;
			 j.setFont(new Font("Tahoma", Font.PLAIN, Math.min(41, w / 40)));
		}
		else if(i.getClass()==JButton.class) {
			JButton j = (JButton) i;
			j.setFont(new Font("Tahoma", Font.PLAIN, Math.min(100, w / 15)));
		}
		else if(i.getClass()==JTextField.class) {
			JTextField j = (JTextField) i;
			j.setFont(new Font("Tahoma", Font.PLAIN, Math.min(98, w / 20)));
		}
	}
	public void resetImg1() {
		image = new ImageIcon(GameWindow.class.getResource(IMAGES[0]));
		Image scaledImage = image.getImage().getScaledInstance((int) (contentPane.getWidth() / 4.5), contentPane.getHeight()
				/ 3, Image.SCALE_DEFAULT);
		lblPng.setIcon(new ImageIcon(scaledImage));
	}
	public void updateImg1() {
		Double n;
			n = Math.random();
			if(n<=0.333) {
				image = new ImageIcon(GameWindow.class.getResource(IMAGES[0]));
			}
			else if(n<=0.666) {
				image = new ImageIcon(GameWindow.class.getResource(IMAGES[1]));
			}
			else {
				image = new ImageIcon(GameWindow.class.getResource(IMAGES[2]));
			}
			Image scaledImage = image.getImage().getScaledInstance((int) (contentPane.getWidth() / 4.5), contentPane.getHeight()
					/ 3, Image.SCALE_DEFAULT);
			lblPng.setIcon(new ImageIcon(scaledImage));
	}
	
}
