package Ventanas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Inicio extends JFrame {
	//--------------------------------------
	
	private JButton  bt_user, bt_register;
	private JLabel   lb_title, lb_employ, lb_superuser;
	private Inicio   mainframe = this;
	
	//--------------------------------------
	
	public Inicio() {
		setTitle("SW Prestamo - Inversion");
		setSize(581,400);
		setLocationRelativeTo(null);
		setupWidgets();
		setupEvents();
		setVisible(true);
	}
	//--------------------------------------
	
	private void setupWidgets() {
		
		bt_user = new JButton("USUARIO");
		bt_user.setFont(new Font("Tahoma", Font.ITALIC, 13));
		
		bt_register = new JButton("REGISTRAR USUARIO");
		bt_register.setFont(new Font("Tahoma", Font.ITALIC, 13));
		
		lb_title = new JLabel("BANK LOAN AND FUTURE");
		lb_title.setFont(new Font("Sitka Subheading", Font.BOLD, 24));
		
		lb_employ = new JLabel("*Trabajador");
		lb_employ.setForeground(Color.RED);
		
		lb_superuser = new JLabel("*Super usuario del sistema");
		lb_superuser.setForeground(Color.RED);
		
		
		setLayout(null);
		
		add(bt_register); bt_register.setBounds(322, 150, 159, 45);
		add(bt_user); bt_user.setBounds(98, 150, 113, 45);
		
		add(lb_title); lb_title.setBounds(142, 36, 298, 16);
		add(lb_employ);lb_employ.setBounds(98, 197, 72, 16);
		add(lb_superuser);lb_superuser.setBounds(322, 197, 159, 16);
			
	}
	//--------------------------------------
	
	private void setupEvents() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		bt_user.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mainframe.setVisible(false);
				add(new menu_rol());
				
			}
		});
		
		bt_register.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			add(new validacion_inge(mainframe));
				
			}
		});
	}
    //---------------------------------
	public static void main(String[] args) {
		new Inicio();
	}
}
