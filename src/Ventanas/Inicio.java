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
	
	private JButton  bt_user, bt_register, bt_actualizarusu, bt_consultarusu;
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
		bt_user.setFont(new Font("Tahoma", Font.ITALIC, 28));
		
		bt_register = new JButton("REGISTRAR USUARIO");
		bt_register.setFont(new Font("Tahoma", Font.ITALIC, 13));
		
		bt_actualizarusu = new JButton("ACTUALIZAR USUARIO");
		bt_actualizarusu.setFont(new Font("Tahoma", Font.ITALIC, 13));
		
		bt_consultarusu = new JButton("CONSULTAR USUARIO");
		bt_consultarusu.setFont(new Font("Tahoma", Font.ITALIC, 13));
		
		lb_title = new JLabel("BANK LOAN AND FUTURE");
		lb_title.setFont(new Font("Sitka Subheading", Font.BOLD, 24));
		
		lb_employ = new JLabel("*Trabajador");
		lb_employ.setForeground(Color.RED);
		
		lb_superuser = new JLabel("*Super usuario del sistema");
		lb_superuser.setForeground(Color.RED);
		
		
		getContentPane().setLayout(null);
		
		getContentPane().add(bt_register); bt_register.setBounds(319, 130, 180, 45);
		getContentPane().add(bt_actualizarusu); bt_actualizarusu.setBounds(319, 240, 180, 45);
		getContentPane().add(bt_consultarusu); bt_consultarusu.setBounds(319, 185, 180, 45);
		
		getContentPane().add(bt_user); bt_user.setBounds(104, 130, 159, 96);
		
		getContentPane().add(lb_title); lb_title.setBounds(142, 28, 298, 24);
		getContentPane().add(lb_employ);lb_employ.setBounds(104, 229, 72, 16);
		getContentPane().add(lb_superuser);lb_superuser.setBounds(319, 295, 159, 16);
			
	}
	//--------------------------------------
	
	private void setupEvents() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		bt_user.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mainframe.setVisible(false);
				getContentPane().add(new menu_rol());
				
			}
		});
		
		bt_register.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			getContentPane().add(new validacion_inge(mainframe));
				
			}
		});
		
		bt_actualizarusu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				getContentPane().add(new validacion_inge1(mainframe));
				
			}
		});
		
		bt_consultarusu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				getContentPane().add(new validacion_inge2(mainframe));
				
			}
		});
	}
    //---------------------------------
	public static void main(String[] args) {
		new Inicio();
	}
}
