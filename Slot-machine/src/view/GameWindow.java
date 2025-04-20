package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

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
    	addComponentListener(new ComponentAdapter() {
    		@Override
    		public void componentResized(ComponentEvent e) {
    		lblMonete.setFont(new Font("Tahoma", Font.PLAIN, Math.max(8, contentPane.getWidth() / 40)));
    		lblVincita.setFont(new Font("Tahoma", Font.PLAIN, Math.max(8, contentPane.getWidth() / 40)));
    		box1.setFont(new Font("Tahoma", Font.PLAIN, Math.max(8, contentPane.getWidth() / 15)));
    		box2.setFont(new Font("Tahoma", Font.PLAIN, Math.max(8, contentPane.getWidth() / 15)));
    		box3.setFont(new Font("Tahoma", Font.PLAIN, Math.max(8, contentPane.getWidth() / 15)));
    		btnGioca.setFont(new Font("Tahoma", Font.PLAIN, Math.max(8, contentPane.getWidth() / 20)));
    		}
    	});
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 450, 300);
	contentPane = new JPanel();
	contentPane.setBackground(new Color(0, 0, 0));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(new GridLayout(3, 4, 5, 0));
	contentPane.add(Box.createRigidArea(new Dimension(0, 0)));
	contentPane.add(Box.createRigidArea(new Dimension(0, 0)));
	contentPane.add(Box.createRigidArea(new Dimension(0, 0)));
	contentPane.add(Box.createRigidArea(new Dimension(0, 0)));
	
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
	contentPane.add(btnGioca);
	contentPane.add(Box.createRigidArea(new Dimension(0, 0)));
	
	lblVincita = new JLabel("");
	lblVincita.setFont(new Font("Tahoma", Font.PLAIN, 11));
	lblVincita.setHorizontalAlignment(JLabel.CENTER);
	lblVincita.setForeground(Color.WHITE);
	contentPane.add(lblVincita);
	
	
	contentPane.add(Box.createRigidArea(new Dimension(0, 0)));
	
	lblMonete = new JLabel("Monete: ");
	lblMonete.setFont(new Font("Tahoma", Font.PLAIN, 11));
	lblMonete.setHorizontalAlignment(JLabel.CENTER);
	lblMonete.setForeground(Color.WHITE);
	contentPane.add(lblMonete);
	setBackground(Color.BLACK);
    }

}
