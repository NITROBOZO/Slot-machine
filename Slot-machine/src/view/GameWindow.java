package view;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class GameWindow extends JFrame {
	public static final ImageIcon[] IMG = {new ImageIcon(GameWindow.class.getResource("/images/OK1.png")),
										new ImageIcon(GameWindow.class.getResource("/images/OK2.png")),
										new ImageIcon(GameWindow.class.getResource("/images/OK3.gif")),
										new ImageIcon(GameWindow.class.getResource("/images/LOSE1.png")),
										new ImageIcon(GameWindow.class.getResource("/images/LOSE2.gif")),
										new ImageIcon(GameWindow.class.getResource("/images/LOSE3.png"))};
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
	private ImageIcon updatingImg;
	
	public ImageIcon getUpdatingImg() {
		return updatingImg;
	}

	public void setUpdatingImg(ImageIcon updatingImg) {
		this.updatingImg = updatingImg;
	}
	
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
	    	updatingImg = IMG[0];
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 4, 5, 0));
		
		
		contentPane.add(new JLabel());
		
		
		lblPng = new JLabel();
		Image scaledImage = IMG[0].getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
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
		Image scaledGif = IMG[2].getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
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
		Image scaledImage2 = IMG[1].getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
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
				fontSet(lblPng,updatingImg);
				fontSet(lblPng2,IMG[1]);
				fontSet(lblGif,IMG[2]);
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
		Image scaledImage = scalaImg(i);
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
	
	public Image scalaImg(ImageIcon i) {
	    return i.getImage().getScaledInstance((int) (contentPane.getWidth() / 4.5), contentPane.getHeight()
			/ 3, Image.SCALE_DEFAULT);
	}
	
}
