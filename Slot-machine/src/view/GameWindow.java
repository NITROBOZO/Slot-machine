package view;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Component;
import java.awt.Font;

public class GameWindow extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField box1;
    private JTextField box3;
    private JTextField box2;
    private JLabel lblVincita;
    private JLabel lblMonete;
    private JButton btnGioca;
    

    
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



    public GameWindow() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 450, 300);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

	setContentPane(contentPane);
	contentPane.setLayout(new GridLayout(3, 4, 5, 0));
	contentPane.add(Box.createRigidArea(new Dimension(0, 0)));
	contentPane.add(Box.createRigidArea(new Dimension(0, 0)));
	contentPane.add(Box.createRigidArea(new Dimension(0, 0)));
	contentPane.add(Box.createRigidArea(new Dimension(0, 0)));
	
	box1 = new JTextField();
	box1.setFont(new Font("Tahoma", Font.PLAIN, 30));
	box1.setHorizontalAlignment(JLabel.CENTER);
	box1.setEditable(false);
	contentPane.add(box1);
	box1.setColumns(10);
	
	box2 = new JTextField();
	box2.setFont(new Font("Tahoma", Font.PLAIN, 30));
	box2.setHorizontalAlignment(JLabel.CENTER);
	box2.setEditable(false);
	contentPane.add(box2);
	box2.setColumns(10);
	
	box3 = new JTextField();
	box3.setFont(new Font("Tahoma", Font.PLAIN, 30));
	box3.setHorizontalAlignment(JLabel.CENTER);
	box3.setText("6");
	box3.setEditable(false);
	contentPane.add(box3);
	box3.setColumns(10);
	
	btnGioca = new JButton("GO!");
	btnGioca.setFont(new Font("Tahoma", Font.PLAIN, 30));
	contentPane.add(btnGioca);
	contentPane.add(Box.createRigidArea(new Dimension(0, 0)));
	
	lblVincita = new JLabel("");
	lblVincita.setFont(new Font("Tahoma", Font.PLAIN, 11));
	lblVincita.setHorizontalAlignment(JLabel.CENTER);
	contentPane.add(lblVincita);
	
	
	contentPane.add(Box.createRigidArea(new Dimension(0, 0)));
	
	lblMonete = new JLabel("Monete: ");
	lblMonete.setFont(new Font("Tahoma", Font.PLAIN, 11));
	lblMonete.setHorizontalAlignment(JLabel.CENTER);
	contentPane.add(lblMonete);
    }

}
